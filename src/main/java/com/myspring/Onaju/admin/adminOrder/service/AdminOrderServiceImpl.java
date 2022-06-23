package com.myspring.Onaju.admin.adminOrder.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminOrder.dao.AdminOrderDAO;
import com.myspring.Onaju.admin.adminOrder.vo.AdminOrderVO;

@Service("adminOrderService")
public class AdminOrderServiceImpl implements AdminOrderService {

	@Autowired
	private AdminOrderDAO adminOrderDAO;
	
	// 전체 회원 주문 목록
	@Override
	public List<Map<String, Object>> ordersList(Criteria cri) {
		return adminOrderDAO.selectAllOrderList(cri);
	}
	
	// 삭제할 것 (이전 페이징 관련 메서드)
	@Override
	public List<Map<String, Object>> ordersList(String u_id) {
		return adminOrderDAO.selectAllOrderList(u_id);
	}
	
	// 전체 회원 주문 수
	@Override
	public int orderListTotal(Criteria cri) {
		return adminOrderDAO.selectOrderListTotal(cri);
	}

	// 회원 주문 상세
	@Override
	public AdminOrderVO orderDetail(String order_code) {
		return adminOrderDAO.selectOrderDetail(order_code);
	}
	
	// 회원 주문 수정
	@Override
	public int orderUpdate(AdminOrderVO orderVO) {
		return adminOrderDAO.selectOrderUpdate(orderVO);
	}

	// 회원 주문 취소
	@Override
	public int orderDelete(String order_code) {
		return adminOrderDAO.selectOrderDelete(order_code);
	}


}
