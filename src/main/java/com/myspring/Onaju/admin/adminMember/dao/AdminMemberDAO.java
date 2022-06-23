package com.myspring.Onaju.admin.adminMember.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.member.vo.MemberVO;

public interface AdminMemberDAO {
	
	// 회원 목록
	public List<Map<String, Object>> selectAllMemberList(Criteria cri) throws DataAccessException;
	// 회원 수
	public int selectAllMemberListTotal(Criteria cri);
	// 회원 상세
	public MemberVO selectMemberDetail(String u_id) throws DataAccessException;
	// 회원 정보 수정
	public int memberUpdate(MemberVO vo) throws DataAccessException;
	// 삭제할 것
	public List<Map<String, Object>> selectSearchMember(Map<String,Object> searchMap);
	// 회원 삭제
	public int selectMemberDelete(String u_id);
}
