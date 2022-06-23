package com.myspring.Onaju.admin.adminMember.service;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.member.vo.MemberVO;

public interface AdminMemberService {
	
	// 회원 목록
	public List<Map<String, Object>> listMembers(Criteria cri);
	// 회원 수
	public int memberListTotal(Criteria cri) throws Exception;
	// 회원 상세
	public MemberVO memberDetail(String u_id) throws Exception;
	// 회원 정보 수정
	public int memberUpdate(MemberVO vo) throws Exception;
	// 삭제할 것
	public List<Map<String, Object>> searchMember(Map<String, Object> searchMap);
	// 회원 삭제
	public int deleteMember(String u_id);
}
