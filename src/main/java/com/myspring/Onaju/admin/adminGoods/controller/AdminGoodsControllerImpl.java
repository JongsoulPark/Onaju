package com.myspring.Onaju.admin.adminGoods.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
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
import com.myspring.Onaju.admin.adminGoods.service.AdminGoodsService;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 상품 관리
 */

@Controller("adminGoodsController")
public class AdminGoodsControllerImpl implements AdminGoodsController {
	
	@Autowired
	private AdminGoodsService adminGoodsService;
	@Autowired
	private AdminHostRoomVO adminHostRoomVO;
	
	
	// 상품 목록 조회
	@Override
	@RequestMapping(value = "/admin/goodsList.do", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView roomsList(Criteria cri) throws Exception {
		
		if(cri.getJoin_endDate() != "" && cri.getJoin_endDate() != null) {
			String endDate = cri.getJoin_endDate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(endDate);
			Date plus_date = new Date(date.getTime() + (1000*60*60*24));
			String join_endDate = DateFormatUtils.format(plus_date, "yyyy-MM-dd");
		
			cri.setJoin_endDate(join_endDate);
		}
		
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> roomsList = adminGoodsService.roomsList(cri);
		
		int total = adminGoodsService.roomTotal(cri);
		
		mav.addObject("roomsList", roomsList);
		mav.addObject("pageMaker", new PageVO(cri, total));
		return mav;
	}

	
	// 상품 상세
	@Override
	@RequestMapping(value = "/admin/goodsDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView roomDetail(@RequestParam("room_code")String room_code, @ModelAttribute("cri") Criteria cri) throws Exception {
		adminHostRoomVO = adminGoodsService.roomDetail(room_code);
		ModelAndView mav = new ModelAndView();
		mav.addObject("roomDetail", adminHostRoomVO);
		return mav;
	}

	// 상품 정보 수정 화면
	@Override
	@RequestMapping(value = "/admin/goodsModify.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView roomModify(@RequestParam("room_code")String room_code, @ModelAttribute("cri") Criteria cri) throws Exception {
		adminHostRoomVO = adminGoodsService.roomDetail(room_code);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("roomDetail", adminHostRoomVO);
		return mav;
	}

	
	// 상품 정보
	@Override
	@RequestMapping(value = "/admin/goodsUpdate.do", method = RequestMethod.POST)
	public String roomUpdate(AdminHostRoomVO roomVO, @ModelAttribute Criteria cri, RedirectAttributes rttr) {
		int update_room = adminGoodsService.roomUpdate(roomVO);
		if(update_room == 3) {
			rttr.addAttribute("room_code", roomVO.getRoom_code());
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("join_startDate", cri.getJoin_startDate());
		rttr.addAttribute("join_endDate", cri.getJoin_endDate());
		rttr.addAttribute("h_id2", cri.getH_id2());
		rttr.addAttribute("h_name2", cri.getH_name2());
		rttr.addAttribute("h_sellerNum2", cri.getH_sellerNum2());
		rttr.addAttribute("roadAddress2", cri.getRoadAddress2());
		rttr.addAttribute("hostInfo_name2", cri.getHostInfo_name2());
		rttr.addAttribute("r_del_yn", cri.getR_del_yn());
		
		return "redirect:/admin/goodsDetail.do";
	}

	
	// 상품 삭제
	@Override
	@RequestMapping(value = "/admin/goodsDelete.do", method = RequestMethod.POST)
	public ModelAndView roomDelete(@RequestParam String room_code, @ModelAttribute("cri") Criteria cri) {
		ModelAndView mav = new ModelAndView();
		
		int update_del_yn = adminGoodsService.roomDelete(room_code);
		if(update_del_yn == 1) {
			String message = "해치 처리가 완료되었습니다.";
			mav.addObject("roomDetail", adminGoodsService.roomDetail(room_code));
			mav.addObject("message", message);
		}else {
			String message = "해치 처리가 실패하였습니다.";
			mav.addObject("roomDetail", adminGoodsService.roomDetail(room_code));
			mav.addObject("message", message);
		}
		mav.setViewName("/admin/goodsDetail");
		return mav;
	}


}
