package com.myspring.Onaju.admin.adminGoods.service;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;

public interface AdminGoodsService {
	
	// 상품 목록 조회
	public List<Map<String, Object>> roomsList(Criteria cri);
	// 상품 개수
	public int roomTotal(Criteria cri);
	// 상품 상세, 수정 화면
	public AdminHostRoomVO roomDetail(String room_code);
	// 상품 정보 수정
	public int roomUpdate(AdminHostRoomVO roomVO);
	// 상품 삭제
	public int roomDelete(String room_code);
}
