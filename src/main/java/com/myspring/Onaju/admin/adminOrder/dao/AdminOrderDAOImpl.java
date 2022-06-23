package com.myspring.Onaju.admin.adminOrder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminOrder.vo.AdminOrderVO;

@Repository("adminOrderDAO")
public class AdminOrderDAOImpl implements AdminOrderDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 전체 회원 주문 목록
	@Override
	public List<Map<String, Object>> selectAllOrderList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.order.selectAllOrderList", cri);
	}
	
	// 삭제할 것 (이전 페이징 관련 메서드)
	@Override
	public List<Map<String, Object>> selectAllOrderList(String u_id) {
		return sqlSession.selectList("mapper.admin.order.selectOneOrderList", u_id);
	}
	
	// 전체 회원 주문 수
	@Override
	public int selectOrderListTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.order.selectOrderListTotal", cri);
	}

	// 회원 주문 상세
	@Override
	public AdminOrderVO selectOrderDetail(String order_code) {
		return sqlSession.selectOne("mapper.admin.order.selectOrderDetail", order_code);
	}
	
	// 회원 주문 수정
	@Override
	public int selectOrderUpdate(AdminOrderVO orderVO) {
		return sqlSession.update("mapper.admin.order.selectOrderUpdate", orderVO);
	}
	
	// 회원 주문 취소
	@Override
	public int selectOrderDelete(String order_code) {
		return sqlSession.update("mapper.admin.order.selectOrderDelete", order_code);
	}

	

}
