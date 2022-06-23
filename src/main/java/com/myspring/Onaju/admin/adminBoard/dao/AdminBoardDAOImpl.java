package com.myspring.Onaju.admin.adminBoard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

@Repository("adminBoardDAO")
public class AdminBoardDAOImpl implements AdminBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//==========================공지사항==========================
	
	// 공지사항 목록
	@Override
	public List<Map<String,Object>> selectAllNoticeList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.board.selectAllNoticeList", cri);
	}
	
	// 공지사항 게시글 상세
	@Override
	public Map<String, Object> selectNoticeDetail(String notice_code) {
		return sqlSession.selectOne("mapper.admin.board.selectNoticeDetail", notice_code);
	}
	
	// 공지사항 게시글 
	@Override
	public String selectImgFile(Map<String, Object> imgInfoMap) {
		return sqlSession.selectOne("mapper.admin.board.selectImgFile", imgInfoMap);
	}
	
	// 공지사항 게시글 개수
	@Override
	public int selectAllNoticeListTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.board.selectAllNoticeTotal", cri);
	}
	
	// 공지사항 게시글 등록
	@Override
	public int insertNotice(AdminNoticeVO noticeVO) {
		return sqlSession.insert("mapper.admin.board.insertNotice", noticeVO);
	}

	// 공지사항 게시글 등록 시 이미지 등록
	@Override
	public int insertImgFile(Map<String, Object> imgFile) {
		return sqlSession.insert("mapper.admin.board.insertImgFile", imgFile);
	}

	// 공지사항 게시글 수정 시 이미지 등록
	@Override
	public void selectUpdateImgFile(Map<String, Object> imgFile) {
		sqlSession.update("mapper.admin.board.selectUpdateImgFile", imgFile);
	}

	// 공지사항 게시글 수정
	@Override
	public void selectUpdateNotice(Map<String, Object> noticeMap) {
		sqlSession.update("mapper.admin.board.selectUpdateNotice", noticeMap);
		
	}
	
	// 공지사항 게시글 수정 시 이미지 삭제
	@Override
	public int selectDeleteNoticeImg(String img_code) {
		return sqlSession.delete("mapper.admin.board.selectDeleteNoticeImg", img_code);
	}
	
	// 공지사항 게시글 삭제
	@Override
	public int selectDeleteNotice(String notice_code) {
		return sqlSession.update("mapper.admin.board.selectDeleteNotice", notice_code);
	}

	
	//==========================1대1 게시판==========================
	
	
	// 1대1 게시판 목록
	@Override
	public List<Map<String, Object>> selectAllEnquireList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.board.selectAllEnquireList", cri);
	}

	// 1대1 게시판 상세
	@Override
	public List<Map<String, Object>> selectEnquireDetail(String enquire_NO) {
		return sqlSession.selectList("mapper.admin.board.selectEnquireDetail", enquire_NO);
	}

	// 1대1 게시판 조회수 계산
	@Override
	public void updateHit(String enquire_NO) {
		sqlSession.update("mapper.admin.board.updateHit", enquire_NO);	
	}
	
	// 1대1 게시판 게시글 개수
	@Override
	public int selectAllEnquireListTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.board.selectAllEnquireListTotal", cri);
	}
	


	//==========================1대1 게시판 댓글==========================
	
	
	// 1대1 게시판 댓글 등록
	@Override
	public int insertEnquireReply(AdminEnquireReplyVO replyVO) {
		return sqlSession.insert("mapper.admin.board.insertEnquireReply", replyVO);
	}
	
	
	// 1대1 게시판 댓글 목록 
	@Override
	public List<Map<String, Object>> selectEnquireReplyDetail(AdminEnquireReplyVO replyVO) {
		return sqlSession.selectList("mapper.admin.board.selectEnquireReplyDetail", replyVO);	
	}

	// 1대1 게시판 댓글 존재 유무
	@Override
	public int updateReplyCheck(AdminEnquireReplyVO replyVO) {
		return sqlSession.update("mapper.admin.board.updateReplyCheck", replyVO);
	}

	// 1대1 게시판 댓글 수정
	@Override
	public int updateReply(AdminEnquireReplyVO replyVO) {
		return sqlSession.update("mapper.admin.board.selectUpdateReply", replyVO);
	}

	// 1대1 게시판 댓글 삭제
	@Override
	public int deleteReply(String re_NO) {
		return sqlSession.delete("mapper.admin.board.selectDeleteReply", re_NO);
	}

	

  
}
