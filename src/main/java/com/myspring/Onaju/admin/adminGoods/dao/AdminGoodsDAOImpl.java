package com.myspring.Onaju.admin.adminGoods.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;

@Repository("adminGoodsDAO")
public class AdminGoodsDAOImpl implements AdminGoodsDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 상품 목록 조회
	@Override
	public List<Map<String, Object>> selectAllRoomList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.goods.selectAllRoomList", cri);
	}
	
	// 상품 개수
	@Override
	public int selectAllRoomTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.goods.selectAllRoomTotal",cri);
	}

	// 상품 상세, 수정 화면
	@Override
	public AdminHostRoomVO selectOneRoomDetail(String room_code) {
		return sqlSession.selectOne("mapper.admin.goods.selectOneRoomDetail", room_code);
	}

	// 상품 정보 수정
	@Override
	public int selectRoomUpdate(AdminHostRoomVO roomVO) {
		return sqlSession.update("mapper.admin.goods.selectOneRoomUpdate", roomVO);
	}

	// 상품 삭제
	@Override
	public int selectRoomDelete(String room_code) {
		return sqlSession.update("mapper.admin.goods.selectOneRoomDelete", room_code);
	}

}
