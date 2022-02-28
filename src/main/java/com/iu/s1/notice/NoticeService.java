package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class NoticeService {
	//서비스는 DAO로 데이터 보내기 전에 전처리 작업
	// DAO에서 리턴 받은 데이터를 컨트롤러로 보내기 전 후처리 작업
	
	@Autowired
	private NoticeDAO noticeDAO;

	//list
	public List<NoticeDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		Long totalConut = noticeDAO.total(pager);
		pager.makeNum(totalConut);
		return noticeDAO.list(pager);
	}
	
	//deteil
	public NoticeDTO deteil(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	//add
	public int add(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	//update
	public int update(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.update(noticeDTO);
	}
}