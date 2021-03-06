package com.myspring.Onaju.admin.adminMain.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.admin.vo.AdminVO;

/* 
 * 5조 오나주 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022.05.18 
 */

@Repository("adminMainDAO")
public class AdminMainDAOImpl implements AdminMainDAO {
	@Autowired
	private SqlSession sqlSession;
	
	// 관리자 로그인을 위한 DB접근 DAO
	@Override
	public AdminVO adminLogin(Map<String, String> loginMap) throws DataAccessException {
		return sqlSession.selectOne("mapper.admin.login",loginMap);	 
	}
	
	// 회원가입 시 아이디 중복검사를 위한 DB 접근 DAO 
	@Override
	public String selectAdminOverlappedID(String id) throws DataAccessException {
		String result =  sqlSession.selectOne("mapper.admin.selectOverlappedID",id);
		return result;
	}
	
	// 관리자 로그인 시 아이디 일치 유무
	@Override
	public int resultLoginId(String a_id) {
		return sqlSession.selectOne("mapper.admin.selectLoginId", a_id);
	}

	// 관리자 로그인 시 비밀번호 일치 유무
	@Override
	public int resultLoginPw(Map<String, String> loginMap) {
		return sqlSession.selectOne("mapper.admin.selectLoginPw", loginMap);
	}

	@Override
	public int selectAdminJoin(Map<String, Object> joinMap) {
		return  sqlSession.insert("mapper.admin.insertNewAdmin", joinMap);
	}
}
