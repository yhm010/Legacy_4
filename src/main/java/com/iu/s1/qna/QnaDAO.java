package com.iu.s1.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.qna.QnaDAO.";
	
	public List<QnaDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
	}

}
