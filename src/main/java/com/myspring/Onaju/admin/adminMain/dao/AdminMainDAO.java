package com.myspring.Onaju.admin.adminMain.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Onaju.admin.admin.vo.AdminVO;

/* 
 * 5조 오나주 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022.05.18 
 * 관리자 메인 DAO
 */

public interface AdminMainDAO {
	
	// 관리자 로그인
	public AdminVO adminLogin(Map<String, String> loginMap) throws DataAccessException;
	// 관리자 아이디 중복검사
	public String selectAdminOverlappedID(String id) throws DataAccessException;
	// 관리자 로그인 시 아이디 일치 유무
	public int resultLoginId(String a_id);
	// 관리자 로그인 시 비밀번호 일치 유무
	public int resultLoginPw(Map<String, String> loginMap);
	// 관리자 회원가입
	public int selectAdminJoin(Map<String, Object> joinMap);
}
