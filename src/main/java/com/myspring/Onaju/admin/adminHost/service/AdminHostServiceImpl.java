package com.myspring.Onaju.admin.adminHost.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminHost.dao.AdminHostDAO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;


@Service("adminHostService")
public class AdminHostServiceImpl implements AdminHostService {
	@Autowired
	private AdminHostDAO adminHostDAO;
	
	
	//==========================================호스트 관련 메서드==========================================
	
	// 판매자 목록
	@Override
	public List<Map<String, Object>> listAllHost(Criteria cri) {
		return adminHostDAO.selectAllHostList(cri);	 
	}
	
	// 판매자 수
	@Override
	public int hostListTotal(Criteria cri) {
		return adminHostDAO.selectAllHostListTotal(cri);
	}
	
	// 판매자 상세
	@Override
	public AdminHostVO hostDetail(String h_id) {
		return adminHostDAO.selectHostDetail(h_id);
	}
	
	// 판매자 수정
	@Override
	public int updateHost(AdminHostVO hostVO) {
		return adminHostDAO.selectUpdateHost(hostVO);
	}

	// 판매자 삭제
	@Override
	public int deleteHost(String h_id) {
		return adminHostDAO.selectDeleteHost(h_id);
	}
	
		
	
	//==========================================사업장 관련 메서드==========================================
	
	// 사업장 목록
	@Override
	public List<Map<String, Object>> listAllHostInfo(Criteria cri) {
		return  adminHostDAO.selectAllHostInfoList(cri);	 
	}
	
	// 사업장 개수
	@Override
	public int hostInfoListTotal(Criteria cri) {
		return adminHostDAO.selectAllHostInfoListTotal(cri);
	}
	
	// 사업장 상세
	@Override
	public AdminHostInfoVO hostInfoDetail(String h_code) {
		return adminHostDAO.selectHostInfoDetail(h_code);
	}

	// 사업장 수정
	@Override
	public int updateHostInfo(AdminHostInfoVO hostInfoVO) {
		return adminHostDAO.selectUpdateHostInfo(hostInfoVO);
	}

	//사업장 삭제
	@Override
	public int deleteHostInfo(String h_code) {
		return adminHostDAO.selectDeleteHostInfo(h_code);
	}
	
}
