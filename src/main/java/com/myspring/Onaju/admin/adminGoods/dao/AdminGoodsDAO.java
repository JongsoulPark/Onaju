package com.myspring.Onaju.admin.adminGoods.dao;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;

public interface AdminGoodsDAO {
	
	// 상품 목록 조회
	public List<Map<String, Object>> selectAllRoomList(Criteria cri);
	// 상품 개수
	public int selectAllRoomTotal(Criteria cri);
	// 상품 상세, 수정 화면
	public AdminHostRoomVO selectOneRoomDetail(String room_code);
	// 상품 정보 수정
	public int selectRoomUpdate(AdminHostRoomVO roomVO);
	// 상품 삭제
	public int selectRoomDelete(String room_code);
}
