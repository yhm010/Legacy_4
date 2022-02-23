package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void JoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO(); // 가짜데이터
		memberDTO.setId("id5");
		memberDTO.setPw("pw5");
		memberDTO.setName("name5");
		memberDTO.setPhone("010-5555-5555");
		memberDTO.setEmail("id5@naver.com");
		int result = memberDAO.join(memberDTO); 
		assertEquals(1, result);
	}
	//@Test
	public void loginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ID1");
		memberDTO.setPw("PW1");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}

	@Test
	public void mypageTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO = memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);
	}
	
}