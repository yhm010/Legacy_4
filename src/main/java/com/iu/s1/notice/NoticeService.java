package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	//서비스는 DAO로 데이터 보내기 전에 전처리 작업
	// DAO에서 리턴 받은 데이터를 컨트롤러로 보내기 전 후처리 작업
	
	@Autowired
	private NoticeDAO noticeDAO;

	//list
	public List<NoticeDTO> list() throws Exception{
		return noticeDAO.list();
	}
	
	//deteil
	public NoticeDTO deteil(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	//add
	public int add(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
		
	}
}