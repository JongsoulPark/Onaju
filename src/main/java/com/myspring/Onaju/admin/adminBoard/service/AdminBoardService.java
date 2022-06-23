package com.myspring.Onaju.admin.adminBoard.service;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

public interface AdminBoardService {
	
	//  ============================== 공지사항 게시판  ============================== 
	
	// 공지사항 목록
	public List<Map<String,Object>> noticeList(Criteria cri) throws Exception;
	// 공지사항 게시글 상세
	public  Map<String, Object> noticeDetail(String notice_code) throws Exception;
	// 공지사항 게시글 상세 이미지 호출
	public String getImgFile(Map<String, Object> imgInfoMap) throws Exception;
	// 공지사항 게시글 개수
	public int noticeListTotal(Criteria cri);
	// 공지사항 게시글 등록
	public int insertNotice(AdminNoticeVO noticeVO) throws Exception;
	// 공지사항 게시글 등록 시 이미지 등록
	public int insertImgFile(Map<String, Object> imgFile) throws Exception;
	// 공지사항 상세 이미지 삭제
	public int deleteNoticeImg(String img_code);
	// 공지사항 게시글 상세 이미지 수정
	public void updateImgFile(Map<String,Object> imgFile);
	// 공지사항 게시글 수정
	public void updateNotice(Map<String, Object> noticeMap);
	// 공지사항 게시글 삭제
	public int deleteNotice(String noticeMap);
	
	
	
	//  ============================== 1대1 게시판  ============================== 
	
	// 1대1 게시판 목록
	public List<Map<String, Object>> enquireBoardList(Criteria cri);
	// 1대1 게시판 상세
	public List<Map<String, Object>> enquireBoardDetail(String enquire_NO);
	// 1대1 게시판 상세 조회수 계산
	public void updateHit(String enquire_NO);
	// 1대1 게시판 게시글 개수
	public int enquireListTotal(Criteria cri);
	
	// 1대1 게시판 상세글 댓글 등록
	public int insertEnquireReply(AdminEnquireReplyVO replyVO);
	// 1대1 게시판 상세글 댓글 목록
	public List<Map<String, Object>> enquireReplyDetail(AdminEnquireReplyVO replyVO);
	// 1대1 게시판 댓글 유무
	public int updateReplyCheck(AdminEnquireReplyVO replyVO);
	
	// 1대1 게사판 상세글 댓글 수정
	public int updateReply(AdminEnquireReplyVO replyVO);
	// 1대1 게시판 상세글 댓글 삭제
	public int deleteReply(String re_NO);
}
