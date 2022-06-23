package com.myspring.Onaju.admin.adminCommon.scheduler.dao;

import java.util.List;

import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;

public interface ScheduleDAO {
	
	// 탈퇴 회원 조회 및 삭제
	public List<MemberVO> selectRetireMembers() throws Exception;
	public int deleteRetireMember(String u_id) throws Exception;
	
	// 탈퇴 판매자 조회 및 삭제
	public List<AdminHostVO> selectRetireHost() throws Exception;
	public int deleteRetireHost(String h_id) throws Exception;
	
	// 등록 해지 사업장 조회 및 삭제
	public List<AdminHostInfoVO> selectRetireHostInfo() throws Exception;
	public int deleteRetireHostInfo(String h_code) throws Exception;
	
	// 등록 해지 상품 조회 및 삭제
	public List<AdminHostRoomVO> selectRetireRoom() throws Exception;
	public int deleteRetireRoom(String room_code) throws Exception;
}
