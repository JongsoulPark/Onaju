package com.myspring.Onaju.admin.adminMember.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminMember.dao.AdminMemberDAO;
import com.myspring.Onaju.member.vo.MemberVO;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{
	@Autowired
	private AdminMemberDAO adminMemberDAO;
	
	// 회원 목록
	@Override
	public List<Map<String, Object>> listMembers(Criteria cri) {
		return adminMemberDAO.selectAllMemberList(cri);
	}

	// 회원 수
	@Override
	public int memberListTotal(Criteria cri) throws Exception {
		return adminMemberDAO.selectAllMemberListTotal(cri);
	}
	
	// 회원 상세
	@Override
	public MemberVO memberDetail(String u_id) throws Exception {
		return adminMemberDAO.selectMemberDetail(u_id);	 
	}

	// 회원 정보 수정
	@Override
	public int memberUpdate(MemberVO vo) throws Exception {
		return adminMemberDAO.memberUpdate(vo);
	}

	// 삭제할 것
	@Override
	public List<Map<String, Object>> searchMember(Map<String, Object> searchMap) {
		return adminMemberDAO.selectSearchMember(searchMap);
	}

	// 회원 삭제
	@Override
	public int deleteMember(String u_id) {
		return adminMemberDAO.selectMemberDelete(u_id);
	}

	
}
