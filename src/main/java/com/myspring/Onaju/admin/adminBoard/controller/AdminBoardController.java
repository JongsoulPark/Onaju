package com.myspring.Onaju.admin.adminBoard.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
	
public interface AdminBoardController {
	
	
	// 공지사항 게시판
	
	
	// 공지사항 목록
	public ModelAndView adminNoticeList(Criteria cri) throws Exception;
	
	// 공지사항 상세화면
	public ModelAndView adminNoticeDetail(@RequestParam("notice_code")String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 공지사항 이미지 호출
	public void imgFile(String a_id, String notice_code, HttpServletResponse response) throws Exception;
	
	// 공지사항 등록 화면 폼
	public ModelAndView adminNoticeForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 공지사항 등록 메서드
	public ModelAndView insertNotice(AdminNoticeVO noticeVO, MultipartFile file, HttpServletRequest request) throws Exception;
	
	// 공지사항 수정 화면 폼
	public ModelAndView noticeModify(String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	// 공지사항 수정 화면 내 이미지 삭제
	public ResponseEntity<String> imgDelete(Map<String, Object> deleteMap);
	// 공지사항 수정 메서드
	public ModelAndView updateNotice(Map<String, Object> map, MultipartFile file, Criteria cri) throws Exception;
	
	// 공지사항 삭제
	public ModelAndView deleteNotice(String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception;
	
	
	//1대1 게시판
	
	
	// 1대1 게시판 목록
	public ModelAndView enquireBoardList(Criteria cri) throws Exception;
	// 1대1 게시판 상세
	public ModelAndView enquireBoardDetail(@RequestParam("enquire_NO")String enquire_NO, @ModelAttribute("cri") Criteria cri) throws Exception;
	
	// 1대1 게시판 댓글 등록
	public ResponseEntity<String> insertEnquireReply(@ModelAttribute("replyVO") AdminEnquireReplyVO replyVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 1대1 게시판 댓글 목록 호출
	public ResponseEntity<List<Map<String, Object>>> ajaxcommentList(AdminEnquireReplyVO replyVO);
	// 1대1 게시판 댓글 삭제
	public ResponseEntity<Map<String, Object>> replydelete(Map<String, Object> reMap);
}
