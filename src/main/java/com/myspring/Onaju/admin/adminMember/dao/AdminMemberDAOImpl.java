package com.myspring.Onaju.admin.adminMember.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.member.vo.MemberVO;

@Repository("adminMemberDAO")
public class AdminMemberDAOImpl implements AdminMemberDAO {
	@Autowired
	private SqlSession sqlSession;	
	
	// 회원 목록
	@Override
	public List<Map<String, Object>> selectAllMemberList(Criteria cri) throws DataAccessException {
		return sqlSession.selectList("mapper.admin.member.selectAllMemberList", cri);	
	}

	// 회원 수
	@Override
	public int selectAllMemberListTotal(Criteria cri) {
		return (Integer)sqlSession.selectOne("mapper.admin.member.selectAllMemberTotal", cri);
	}
	
	// 회원 상세
	@Override
	public MemberVO selectMemberDetail(String u_id) throws DataAccessException {
		return sqlSession.selectOne("mapper.admin.member.selectMemberDetail", u_id);
	}

	// 회원 정보 수정
	@Override
	public int memberUpdate(MemberVO vo) throws DataAccessException {
		return sqlSession.update("mapper.admin.member.selectMemberUpdate", vo);
	}

	// 삭제할 것
	@Override
	public List<Map<String, Object>> selectSearchMember(Map<String, Object> searchMap) {
		return sqlSession.selectList("mapper.admin.member.selectSearchMember", searchMap);
	}

	// 회원 삭제
	@Override
	public int selectMemberDelete(String u_id) {
		return sqlSession.update("mapper.admin.member.selectMemberDelete", u_id);
	}

	
	
}
