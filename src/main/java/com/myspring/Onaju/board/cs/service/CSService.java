package com.myspring.Onaju.board.cs.service;

import java.util.List;
import java.util.Map;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

public interface CSService {
	public List<Map<String, Object>> userNotice(Criteria cri);
	public int userNoticeTotal(Criteria cri);
	public Map<String, Object> userNoticeDetail(String notice_code);
}
