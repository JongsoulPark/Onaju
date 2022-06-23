package com.myspring.Onaju.admin.adminCommon.scheduler.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;

@Repository("scheduleDAO")
public class ScheduleDAOImpl implements ScheduleDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	// 탈퇴 회원 조회 및 삭제
	@Override
	public List<MemberVO> selectRetireMembers() throws Exception {
		return sqlSession.selectList("mapper.admin.member.selectRetireMembers");
	}

	@Override
	public int deleteRetireMember(String u_id) throws Exception {
		return sqlSession.delete("mapper.admin.member.deleteRetireMember", u_id);
	}

	// 탈퇴 판매자 조회 및 삭제
	@Override
	public List<AdminHostVO> selectRetireHost() throws Exception {
		return sqlSession.selectList("mapper.admin.host.selectRetireHost");
	}

	@Override
	public int deleteRetireHost(String h_id) throws Exception {
		return sqlSession.delete("mapper.admin.host.deleteRetireHost", h_id);
	}

	// 등록 해지 사업장 조회 및 삭제
	@Override
	public List<AdminHostInfoVO> selectRetireHostInfo() throws Exception {
		return sqlSession.selectList("mapper.admin.host.selectRetireHostInfo");
	}

	@Override
	public int deleteRetireHostInfo(String h_code) throws Exception {
		return sqlSession.delete("mapper.admin.host.deleteRetireHostInfo", h_code);
	}

	// 등록 해지 상품 조회 및 삭제
	@Override
	public List<AdminHostRoomVO> selectRetireRoom() throws Exception {
		return sqlSession.selectList("mapper.admin.goods.selectRetireRoom");
	}

	@Override
	public int deleteRetireRoom(String room_code) throws Exception {
		return sqlSession.delete("mapper.admin.goods.deleteRetireRoom", room_code);
	}

}
