package com.myspring.Onaju.admin.adminHost.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;


@Repository("adminHostDAO")
public class AdminHostDAOImpl implements AdminHostDAO{
	@Autowired
	private SqlSession sqlSession;
	
	
	//==========================================호스트 관련 메서드==========================================
	
	// 판매자 목록
	@Override
	public List<Map<String, Object>> selectAllHostList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.host.selectAllHostList", cri);	
	}

	// 판매자 수
	@Override
	public int selectAllHostListTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.host.selectAllHostTotal",cri);
	}

	// 판매자 상세
	@Override
	public AdminHostVO selectHostDetail(String h_id) {
		return sqlSession.selectOne("mapper.admin.host.selectHostDetail", h_id);
	}

	// 판매자 수정
	@Override
	public int selectUpdateHost(AdminHostVO hostVO) {
		return sqlSession.update("mapper.admin.host.selectUpdateHost", hostVO);
	}

	// 판매자 삭제
	@Override
	public int selectDeleteHost(String h_id) {
		return sqlSession.update("mapper.admin.host.selectDeleteHost", h_id);
	}

	
	//==========================================사업장 관련 메서드==========================================
	
	// 사업장 목록
	@Override
	public List<Map<String, Object>> selectAllHostInfoList(Criteria cri) {
		return sqlSession.selectList("mapper.admin.host.selectAllHostInfoList", cri);
	}
	
	// 사업장 개수
	@Override
	public int selectAllHostInfoListTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.admin.host.selectAllHostInfoTotal", cri);
	}
	
	// 사업장 상세
	@Override
	public AdminHostInfoVO selectHostInfoDetail(String h_code) {
		return sqlSession.selectOne("mapper.admin.host.selectHostInfoDetail", h_code);
	}

	// 사업장 수정
	@Override
	public int selectUpdateHostInfo(AdminHostInfoVO hostInfoVO) {
		return sqlSession.update("mapper.admin.host.selectUpdateHostInfo", hostInfoVO);
	}

	//사업장 삭제
	@Override
	public int selectDeleteHostInfo(String h_code) {
		return sqlSession.update("mapper.admin.host.selectDeleteHostInfo", h_code);
	}
	
	
}
