package com.iu.s1.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.qna.QnaDAO.";
	
	public List<QnaDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	//insert-add
	public int add(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", qnaDTO);
	}
	
	//detail
	public QnaDTO detail(QnaDTO qnaDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail", qnaDTO);
	}
	
	//delete
	public int delete(QnaDTO qnaDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", qnaDTO);
	}
	
	//update
	public int update(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update", qnaDTO);
	}
	
	public Long total(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total", pager);
	}
}
