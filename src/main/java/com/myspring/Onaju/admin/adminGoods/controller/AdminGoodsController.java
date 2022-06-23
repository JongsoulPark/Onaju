package com.myspring.Onaju.admin.adminGoods.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 상품 관리
 */

public interface AdminGoodsController {
	
	// 상품 목록 조회
	public ModelAndView roomsList(Criteria cri) throws Exception;
	// 상품 상세
	public ModelAndView roomDetail(@RequestParam("room_code")String room_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 상품 정보 수정 화면
	public ModelAndView roomModify(@RequestParam("room_code")String room_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 상품 정보 수정
	public String roomUpdate(AdminHostRoomVO roomVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	// 상품 삭제
	public ModelAndView roomDelete(String room_code, @ModelAttribute("cri") Criteria cri);
}
