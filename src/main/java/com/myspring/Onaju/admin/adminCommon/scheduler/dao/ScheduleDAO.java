package com.myspring.Onaju.admin.adminCommon.scheduler.dao;

import java.util.List;

import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;

public interface ScheduleDAO {
	public List<MemberVO> selectRetireMembers() throws Exception;
	public int deleteRetireMember(String u_id) throws Exception;
	public List<AdminHostVO> selectRetireHost() throws Exception;
	public int deleteRetireHost(String h_id) throws Exception;
	public List<AdminHostInfoVO> selectRetireHostInfo() throws Exception;
	public int deleteRetireHostInfo(String h_code) throws Exception;
	public List<AdminHostRoomVO> selectRetireRoom() throws Exception;
	public int deleteRetireRoom(String room_code) throws Exception;
}
