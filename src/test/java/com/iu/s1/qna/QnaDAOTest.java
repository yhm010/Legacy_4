package com.iu.s1.qna;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class QnaDAOTest extends MyJunitTest{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void check() {
		assertNotNull(qnaDAO);
	}
	
	@Test
	public void listTest() throws Exception {
		List<QnaDTO> ar = qnaDAO.list();
		assertNotEquals(0, ar.size());
	}

}
