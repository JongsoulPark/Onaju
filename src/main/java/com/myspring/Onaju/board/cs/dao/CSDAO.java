package com.myspring.Onaju.board.cs.dao;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

public interface CSDAO {
	public List<Map<String, Object>> userNoticeList(Criteria cri);
	public int userNoticeTotal(Criteria cri);
	public Map<String, Object> userNoticeDetail(String notice_code);

}
