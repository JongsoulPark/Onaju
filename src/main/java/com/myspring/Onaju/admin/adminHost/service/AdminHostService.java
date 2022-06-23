package com.myspring.Onaju.admin.adminHost.service;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;

public interface AdminHostService {
	//==========================================호스트 관련 메서드==========================================
	
	// 판매자 목록
	public List<Map<String, Object>> listAllHost(Criteria cri);
	// 판매자 수
	public int hostListTotal(Criteria cri);
	// 판매자 상세
	public AdminHostVO hostDetail(String h_id);
	// 판매자 수정
	public int updateHost (AdminHostVO hostVO);
	// 판매자 삭제
	public int deleteHost (String h_id);
	
	//==========================================사업장 관련 메서드==========================================
	
	// 사업장 목록
	public List<Map<String, Object>> listAllHostInfo(Criteria cri);	
	// 사업장 개수
	public int hostInfoListTotal(Criteria cri);
	// 사업장 상세
	public AdminHostInfoVO hostInfoDetail(String h_code);
	// 사업장 수정
	public int updateHostInfo (AdminHostInfoVO hostInfoVO);
	//사업장 삭제
	public int deleteHostInfo (String h_code);
	
}
