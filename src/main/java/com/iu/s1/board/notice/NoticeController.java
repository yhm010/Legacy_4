package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.qna.QnaDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		List<BoardDTO> ar = noticeService.list(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}

	// detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}

	// DB에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.add(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

	// insert form 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}

	// update 폼으로 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/update";
	}

	// DB에 update 처리 String 방법
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public String update(NoticeDTO noticeDTO) throws Exception {
//		System.out.println(noticeDTO.getContents());
//		System.out.println(noticeDTO.getNum());
//		int result = noticeService.update(noticeDTO);
//		return "redirect:./list";
//	}
	
	// DB에 update 처리 modelandview 방법
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public ModelAndView update(NoticeDTO noticeDTO) throws Exception {
			ModelAndView mv = new ModelAndView();
			int result = noticeService.update(noticeDTO);
			mv.setViewName("redirect:./list");
			return mv;
		}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.delete(noticeDTO);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("redirect:./list");
		return mv;
	}

}
