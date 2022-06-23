package com.myspring.Onaju.admin.adminOrder.dao;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminOrder.vo.AdminOrderVO;

public interface AdminOrderDAO {
	
	// 전체 회원 주문 목록
	public List<Map<String, Object>> selectAllOrderList(Criteria cri);
	// 삭제할 것 (이전 페이징 관련 메서드)
	public List<Map<String, Object>> selectAllOrderList(String u_id);
	// 전체 회원 주문 수
	public int selectOrderListTotal(Criteria cri);
	// 회원 주문 상세
	public AdminOrderVO selectOrderDetail(String order_code);
	// 회원 주문 수정
	public int selectOrderUpdate(AdminOrderVO orderVO);
	// 회원 주문 취소
	public int selectOrderDelete(String order_code);

}
