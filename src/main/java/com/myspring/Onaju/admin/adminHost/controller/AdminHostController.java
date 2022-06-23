package com.myspring.Onaju.admin.adminHost.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 판매자 및 사업장
 */

public interface AdminHostController {
	
	
	//==========================================호스트 관련 메서드==========================================
	
	// 판매자 목록
	public ModelAndView hostList(Criteria cri) throws Exception;
	// 판매자 상세
	public ModelAndView hostDetail(@RequestParam("h_id")String h_id, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 판매자 수정 화면
	public ModelAndView hostModifyForm(@RequestParam("h_id") String h_id, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 판매자 수정
	public String updateHost(AdminHostVO hostVO, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr);
	// 판매자 매출( **미구현** )
	public ModelAndView hostCalculate(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 판매자 삭제
	public ModelAndView deletHost(String h_id, @ModelAttribute("cri") Criteria cri) throws Exception;
	
	
	//==========================================사업장 관련 메서드==========================================
	
	// 사업장 목록
	public ModelAndView hostInfoList(Criteria cri) throws Exception;
	// 사업장 상세
	public ModelAndView hostInfoDetail(String h_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 사업장 수정 화면
	public ModelAndView hostInfoModifyForm(String h_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 사업장 수정
	public ModelAndView updateHostInfo(AdminHostInfoVO hostInfoVO, @ModelAttribute("cri") Criteria cri) throws Exception;
	//사업장 삭제
	public ModelAndView deleteHostInfo(String h_code, @ModelAttribute("cri") Criteria cri) throws Exception;;
}
