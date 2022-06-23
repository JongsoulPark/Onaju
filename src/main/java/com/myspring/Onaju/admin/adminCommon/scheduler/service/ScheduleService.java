package com.myspring.Onaju.admin.adminCommon.scheduler.service;

import java.util.List;

import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;



public interface ScheduleService{
	
	// 탈퇴 회원 조회 및 삭제
	public List<MemberVO> listMemberScheduler() throws Exception;
	public void deleteMemberScheduler(String u_id) throws Exception;
	
	// 탈퇴 판매자 조회 및 삭제
	public List<AdminHostVO> listHostScheduler() throws Exception;
	public void deleteHostScheduler(String h_id) throws Exception;
	
	// 등록 해지 사업장 조회 및 삭제
	public List<AdminHostInfoVO> listHostInfoScheduler()throws Exception;
	public void deleteHostInfoScheduler(String h_code) throws Exception;
	
	// 등록 해지 상품 조회 및 삭제
	public List<AdminHostRoomVO> listRoomScheduler() throws Exception;
	public void deleleteRoomScheduler(String room_code) throws Exception;
}
