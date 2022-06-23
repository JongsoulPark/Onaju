package com.myspring.Onaju.admin.adminBoard.dao;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

public interface AdminBoardDAO {
	
	
	// ==========================공지사항==========================
	
	
	// 공지사항 목록
	public List<Map<String,Object>> selectAllNoticeList(Criteria cri);
	// 공지사항 상세
	public Map<String, Object> selectNoticeDetail(String notice_code);
	// 공지사항 이미지 저장
	public String selectImgFile(Map<String, Object> imgInfoMap);
	// 공지사항 게시글 개수
	public int selectAllNoticeListTotal(Criteria cri);
	// 공지사항 상세 이미지 수정
	public void selectUpdateImgFile(Map<String, Object> imgFile);
	// 공지사항 상세 수정
	public void selectUpdateNotice(Map<String, Object> noticeMap);
	// 공지사항 등록
	public int insertNotice(AdminNoticeVO noticeVO);
	// 공지사항 이미지 등록
	public int insertImgFile(Map<String, Object> imgFile);
	// 공지사항 수정폼 이미지 삭제
	public int selectDeleteNoticeImg(String img_code);
	// 공지사항 게시글 삭제 
	public int selectDeleteNotice(String notice_code);

	
	
	// ==========================1대1 게시판==========================
	
	// 1대1 게시판 목록
	public List<Map<String, Object>> selectAllEnquireList(Criteria cri);
	// 1대1 게시글 상세
	public List<Map<String, Object>> selectEnquireDetail(String enquire_NO);
	// 1대1 게시글 개수
	public int selectAllEnquireListTotal(Criteria cri);
	// 1대1 게시글 조회수 계산
	public void updateHit(String enquire_NO);
	// 1대1 게시글 상세 댓글 유무 체크
	public int updateReplyCheck(AdminEnquireReplyVO replyVO);
	// 1대1 게시글 댓글 등록
	public int insertEnquireReply(AdminEnquireReplyVO replyVO);
	// 1대1 게시글 댓글 목록
	public List<Map<String, Object>> selectEnquireReplyDetail(AdminEnquireReplyVO replyVO);
	// 1대1 게시글 댓글 수정
	public int updateReply(AdminEnquireReplyVO replyVO);
	// 1대1 게시글 댓글 삭제
	public int deleteReply(String re_NO);
}
