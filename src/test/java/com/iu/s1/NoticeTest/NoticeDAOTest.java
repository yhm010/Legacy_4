package com.iu.s1.NoticeTest;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;
import com.iu.s1.notice.NoticeDAO;
import com.iu.s1.notice.NoticeDTO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void check() {
		assertNotNull(noticeDAO);
	}

	// list
		@Test
		public void listTest() throws Exception {
			Pager pager = new Pager();
			pager.setPerPage(5L);
			pager.makeRow();
			List<NoticeDTO> ar = noticeDAO.list(pager);
			System.out.println(ar.get(0).getNum());
			System.out.println(ar.get(4 ).getNum());
			assertEquals(5, ar.size());
		}

	// add
	//@Test
	public void addTest() throws Exception {
		for(int i=0; i<200; i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title"+i);
		noticeDTO.setContents("contents"+i);
		noticeDTO.setWriter("writer"+i);
		int result = noticeDAO.add(noticeDTO);
		}
		System.out.println("인서트 성공");
		//assertEquals(1, result); 
	}

	// detail
	//@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(41L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//delete
	//@Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(22L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void updateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("title1");
		noticeDTO.setContents("contents1");
		int result = noticeDAO.update(noticeDTO);
		assertNotNull(noticeDTO);
	}

}
