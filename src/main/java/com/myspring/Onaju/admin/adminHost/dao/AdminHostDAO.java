package com.myspring.Onaju.admin.adminHost.dao;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;



public interface AdminHostDAO {
	
	
	//==========================================호스트 관련 메서드==========================================
	
	// 판매자 목록
	public List<Map<String, Object>> selectAllHostList(Criteria cri);
	// 판매자 수
	public int selectAllHostListTotal(Criteria cri);
	// 판매자 상세
	public AdminHostVO selectHostDetail(String h_id);
	// 판매자 수정
	public int selectUpdateHost(AdminHostVO hostVO);
	// 판매자 삭제
	public int selectDeleteHost(String h_id);
	
	
	//==========================================사업장 관련 메서드==========================================
	
	// 사업장 목록
	public List<Map<String, Object>> selectAllHostInfoList(Criteria cri);
	// 사업장 개수
	public int selectAllHostInfoListTotal(Criteria cri);
	// 사업장 상세
	public AdminHostInfoVO selectHostInfoDetail(String h_id);
	// 사업장 수정
	public int selectUpdateHostInfo(AdminHostInfoVO hostInfoVO);
	//사업장 삭제
	public int selectDeleteHostInfo(String h_code);
	
}
