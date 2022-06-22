package com.myspring.Onaju.board.cs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.Onaju.admin.adminCommon.paging.Criteria;

@Service("csService")
public class CSDAOImpl implements CSDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Map<String, Object>> userNoticeList(Criteria cri) {
		return sqlSession.selectList("mapper.board.userNoticeList", cri);
	}

	@Override
	public int userNoticeTotal(Criteria cri) {
		return sqlSession.selectOne("mapper.board.userNoticeTotal", cri);
	}

	@Override
	public Map<String, Object> userNoticeDetail(String notice_code) {
		return sqlSession.selectOne("mapper.board.userNoticeDetail", notice_code);
	}

}
