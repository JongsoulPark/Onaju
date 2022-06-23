package com.myspring.Onaju.admin.adminMain.service;

import java.util.Map;

import com.myspring.Onaju.admin.admin.vo.AdminVO;

public interface AdminMainService {
	
	// 관리자 로그인
	public AdminVO adminLogin(Map<String, String> loginMap) throws Exception;
	// 관리자 아이디 중복검사
	public String adminOverlapped(String id) throws Exception;
	// 관리자 로그인 시 아이디 일치 유무
	public int resultLoginId(String a_id);
	// 관리자 로그인 시 비밀번호 일치 유무
	public int resultLoginPw(Map<String, String> loginMap);
	// 관리자 회원가입
	public int adminJoin(Map<String, Object> joinMap);
}
