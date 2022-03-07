package com.iu.s1.qna;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class QnaDAOTest extends MyJunitTest{
	
	@Autowired
	private QnaDAO qnaDAO;
	private Object result;
	
	//@Test
	public void check() {
		assertNotNull(qnaDAO);
	}
	
	//@Test
	public void listTest() throws Exception {
		List<QnaDTO> ar = qnaDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void addTest()throws Exception{
		for(int i=0; i<200; i++) {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("t2"+i);
		qnaDTO.setContents("c2"+i);
		qnaDTO.setWriter("w2"+i);
		int result = qnaDAO.add(qnaDTO);
	}
		System.out.println("인서트 성공");
		assertEquals(1, result);
	}
	
	@Test
	public void detailTest()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(21L);
		qnaDTO = qnaDAO.detail(qnaDTO);
		assertNotNull(qnaDTO);
	}

}
