package com.myspring.Onaju.admin.adminBoard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminBoard.dao.AdminBoardDAO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

@Service("adminBoardService")
public class AdminBoardServiceImpl implements AdminBoardService {
	
	@Autowired
	private AdminBoardDAO adminBoardDAO;
	
	
	// ==================== 공지사항 게시판 ====================
	
	
	// 공지사항 목록
	@Override
	public List<Map<String,Object>> noticeList(Criteria cri) throws Exception {
		return  adminBoardDAO.selectAllNoticeList(cri);
	}
	
	// 공지사항 게시글 상세
	@Override
	public Map<String, Object> noticeDetail(String notice_code) throws Exception {
		return adminBoardDAO.selectNoticeDetail(notice_code);
	}
	
	// 공지사항 게시글 상세 이미지 호출
	@Override
	public String getImgFile(Map<String, Object> imgInfoMap) throws Exception {
		return adminBoardDAO.selectImgFile(imgInfoMap);
	}
	
	// 공지사항 게시글 개수
	@Override
	public int noticeListTotal(Criteria cri) {
		return adminBoardDAO.selectAllNoticeListTotal(cri);
	}
	
	// 공지사항 게시글 등록
	@Override
	public int insertNotice(AdminNoticeVO noticeVO) throws Exception {		
		return adminBoardDAO.insertNotice(noticeVO);
	}

	// 공지사항 게시글 등록 시 이미지 등록
	@Override
	public int insertImgFile(Map<String, Object> imgFile) throws Exception {
		return adminBoardDAO.insertImgFile(imgFile);
	}
	
	// 공지사항 상세 이미지 삭제
	@Override
	public int deleteNoticeImg(String img_code) {
		return adminBoardDAO.selectDeleteNoticeImg(img_code);
	}

	// 공지사항 게시글 수정
	@Override
	public void updateNotice(Map<String, Object> noticeMap) {
		adminBoardDAO.selectUpdateNotice(noticeMap);	
	}
	
	// 공지사항 게시글 상세 이미지 수정
	@Override
	public void updateImgFile(Map<String, Object> imgFile) {
		adminBoardDAO.selectUpdateImgFile(imgFile);	
	}
	
	// 공지사항 게시글 삭제
	@Override
	public int deleteNotice(String noticeMap) {
		return adminBoardDAO.selectDeleteNotice(noticeMap);
	}
	
	
	
	// ==================== 1대1 게시판 ====================
	
	
	// 1대1 게시판 목록
	@Override
	public List<Map<String, Object>> enquireBoardList(Criteria cri) {
		return adminBoardDAO.selectAllEnquireList(cri);
	}
	
	// 1대1 게시판 상세
	@Override
	public List<Map<String, Object>> enquireBoardDetail(String enquire_NO) {
		return adminBoardDAO.selectEnquireDetail(enquire_NO);
	}
	
	// 1대1 게시판 상세 조회수 계산
	@Override
	public void updateHit(String enquire_NO) {
		adminBoardDAO.updateHit(enquire_NO);	
	}
	
	// 1대1 게시판 게시글 개수
	@Override
	public int enquireListTotal(Criteria cri) {
		return adminBoardDAO.selectAllEnquireListTotal(cri);
	}
	
	// 1대1 게시판 상세글 댓글 등록
	@Override
	public int insertEnquireReply(AdminEnquireReplyVO replyVO) {
		return adminBoardDAO.insertEnquireReply(replyVO);
	}
	
	// 1대1 게시판 상세글 댓글 목록
	@Override
	public List<Map<String, Object>> enquireReplyDetail(AdminEnquireReplyVO replyVO) {
		return adminBoardDAO.selectEnquireReplyDetail(replyVO);
	}
	
	// 1대1 게시판 댓글 유무
	@Override
	public int updateReplyCheck(AdminEnquireReplyVO replyVO) {
		return adminBoardDAO.updateReplyCheck(replyVO);
	}
	
	// 1대1 게사판 상세글 댓글 수정
	@Override
	public int updateReply(AdminEnquireReplyVO replyVO) {
		return adminBoardDAO.updateReply(replyVO);
	}
	
	// 1대1 게시판 상세글 댓글 삭제
	@Override
	public int deleteReply(String re_NO) {
		return adminBoardDAO.deleteReply(re_NO);
	}


}
