package com.iu.s1.NoticeTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;
import com.iu.s1.notice.NoticeDAO;
import com.iu.s1.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void check() {
		assertNotNull(noticeDAO);
	}

	// list
	//@Test
	public void listTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		assertNotEquals(0, ar.size());
	}

	// add
	//@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t2");
		noticeDTO.setContents("c2");
		noticeDTO.setWrier("w1");
		noticeDTO.setHit(1L);
		int result = noticeDAO.add(noticeDTO);
		assertEquals(1, result);
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

}
