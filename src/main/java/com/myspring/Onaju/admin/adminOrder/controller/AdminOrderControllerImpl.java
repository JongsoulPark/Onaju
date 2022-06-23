package com.myspring.Onaju.admin.adminOrder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminCommon.paging.PageVO;
import com.myspring.Onaju.admin.adminOrder.service.AdminOrderService;
import com.myspring.Onaju.admin.adminOrder.vo.AdminOrderVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 회원 주문 관리
 */

@Controller("adminOrderController")
public class AdminOrderControllerImpl implements AdminOrderController {

	@Autowired
	AdminOrderService adminOrderService;
	
	// 전체 회원 주문 목록
	@Override
	@RequestMapping(value = "/admin/orderList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ordersList(Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int total = adminOrderService.orderListTotal(cri);
		
		List<Map<String, Object>> ordersList = adminOrderService.ordersList(cri);
		
		mav.addObject("ordersList", ordersList);
		mav.addObject("pageMaker", new PageVO(cri, total));
		return mav;
	}
	
	// 회원 주문 상세
	@Override
	@RequestMapping(value = "/admin/orderDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderDetail(@RequestParam("order_code")String order_code, @ModelAttribute("cri") Criteria cri) {
		ModelAndView mav = new ModelAndView();
		AdminOrderVO orderVO = adminOrderService.orderDetail(order_code);
		mav.addObject("orderVO", orderVO );
		return mav;
	}
	
	// 회원 주문 수정 화면
	@Override
	@RequestMapping(value = "/admin/orderModify.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView orderModify(@RequestParam("order_code") String order_code, @ModelAttribute("cri") Criteria cri)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		AdminOrderVO orderVO = adminOrderService.orderDetail(order_code);
		mav.addObject("orderVO", orderVO );
		return mav;
	}
	
	// 회원 주문 수정
	@Override
	@RequestMapping(value = "/admin/orderUpdate.do", method = RequestMethod.POST)
	public String orderUpdate(AdminOrderVO orderVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		int update_order = adminOrderService.orderUpdate(orderVO);
		
		if(update_order == 1) {
			rttr.addAttribute("order_code", orderVO.getOrder_code());
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("join_startDate", cri.getJoin_startDate());
		rttr.addAttribute("join_endDate", cri.getJoin_endDate());
		rttr.addAttribute("pay_state2", cri.getPay_state2());
		rttr.addAttribute("u_name2", cri.getU_name2());
		rttr.addAttribute("u_id2", cri.getU_id2());
		rttr.addAttribute("order_code2", cri.getOrder_code2());
		return "redirect:/admin/orderDetail.do";
	}
	
	// 회원 주문 취소
	@Override
	@RequestMapping(value = "/admin/orderDelete.do", method = RequestMethod.POST)
	public ModelAndView orderDelete(String order_code, @ModelAttribute("cri") Criteria cri) {
		ModelAndView mav = new ModelAndView();
		
		int update_del_yn = adminOrderService.orderDelete(order_code);
		
		if(update_del_yn == 1) {
			String message = "주문 취소 처리가 완료 되었습니다.";
			mav.addObject("orderVO", adminOrderService.orderDetail(order_code));
			mav.addObject("message", message);
		}else {
			String message = "주문 취소 처리가 실패하였습니다.";
			mav.addObject("orderVO", adminOrderService.orderDetail(order_code));
			mav.addObject("message", message);
		}
		mav.setViewName("/admin/orderDetail");
		return mav;
	}
	
	
}
