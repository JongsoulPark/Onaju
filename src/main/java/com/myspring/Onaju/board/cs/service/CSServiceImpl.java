package com.myspring.Onaju.board.cs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.board.cs.dao.CSDAO;

@Component("csDAO")
public class CSServiceImpl implements CSService{
	@Autowired
	private CSDAO csDAO;
	
	@Override
	public List<Map<String, Object>> userNotice(Criteria cri) {
		return csDAO.userNoticeList(cri);
	}

	@Override
	public int userNoticeTotal(Criteria cri) {
		return csDAO.userNoticeTotal(cri);
	}

	@Override
	public Map<String, Object> userNoticeDetail(String notice_code) {
		return csDAO.userNoticeDetail(notice_code);
	}
	

}
