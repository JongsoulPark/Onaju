package com.myspring.Onaju.admin.adminOrder.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminOrder.vo.AdminOrderVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 회원 주문 관리
 */

public interface AdminOrderController {
	
	// 전체 회원 주문 목록
	public ModelAndView ordersList(Criteria cri) throws Exception;
	// 회원 주문 상세
	public ModelAndView orderDetail(@RequestParam("order_code")String order_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 회원 주문 수정 화면
	public ModelAndView orderModify(@RequestParam("order_code")String order_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 회원 주문 수정
	public String orderUpdate(AdminOrderVO orderVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	// 회원 주문 취소
	public ModelAndView orderDelete(String order_code, @ModelAttribute Criteria cri);
}
