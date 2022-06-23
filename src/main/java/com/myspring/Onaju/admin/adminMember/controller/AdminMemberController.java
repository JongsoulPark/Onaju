package com.myspring.Onaju.admin.adminMember.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.member.vo.MemberVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 회원 관리
 */

public interface AdminMemberController {
	
	// 회원 목록
	public ModelAndView listMembers(Criteria cri) throws Exception;
	// 회원 상세
	public ModelAndView memberDetail(@RequestParam("u_id")String u_id, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 회원 수정 화면
	public ModelAndView memberModifyForm(@RequestParam("u_id")String u_id, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 회원 정보 수정
	public ModelAndView memberUpdate(MemberVO vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) throws Exception;
	// 회원 삭제
	public ModelAndView memberDelete(String u_id, @ModelAttribute("cri") Criteria cri) throws Exception;
}
