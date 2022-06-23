package com.myspring.Onaju.admin.adminCommon.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminCommon.scheduler.dao.ScheduleDAO;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;



@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleDAO scheduleDAO;
	

	// 탈퇴 회원 조회 및 삭제
	public List<MemberVO> listMemberScheduler() throws Exception {
		return scheduleDAO.selectRetireMembers();
		
	} 
	
	public void deleteMemberScheduler(String u_id) throws Exception{
		scheduleDAO.deleteRetireMember(u_id);
	}

	// 탈퇴 판매자 조회 및 삭제
	@Override
	public List<AdminHostVO> listHostScheduler() throws Exception {
		return scheduleDAO.selectRetireHost();
	}

	@Override
	public void deleteHostScheduler(String h_id) throws Exception {
		scheduleDAO.deleteRetireHost(h_id);
	}

	// 등록 해지 사업장 조회 및 삭제
	@Override
	public List<AdminHostInfoVO> listHostInfoScheduler() throws Exception {
		return scheduleDAO.selectRetireHostInfo();
	}

	@Override
	public void deleteHostInfoScheduler(String h_code) throws Exception {
		scheduleDAO.deleteRetireHostInfo(h_code);
	}

	// 등록 해지 상품 조회 및 삭제
	@Override
	public List<AdminHostRoomVO> listRoomScheduler() throws Exception {
		return scheduleDAO.selectRetireRoom();
	}

	@Override
	public void deleleteRoomScheduler(String room_code) throws Exception {
		scheduleDAO.deleteRetireRoom(room_code);		
	}
}