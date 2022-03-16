package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.board.notice.NoticeFileDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaSevice qnaSevice;
	
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	
	//filedown
	@RequestMapping(value = "fileDown", method = RequestMethod.GET)
	public ModelAndView fileDown(QnaFileDTO qnaFileDTO)throws Exception{
	ModelAndView mv = new ModelAndView();
	mv.setViewName("fileDown");
	qnaFileDTO = qnaSevice.detailFile(qnaFileDTO);
	mv.addObject("file", qnaFileDTO);
	return mv;
	}
	
	//댓글 폼 이동
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO, ModelAndView mv) throws Exception{
		mv.addObject("dto", qnaDTO); //부모글번호
		mv.setViewName("board/reply");
		return mv;
	}
	
	// 댓글 db로 이동
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaSevice.reply(qnaDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model)throws Exception{
		BoardDTO boardDTO = qnaSevice.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager, Model model)throws Exception{
		
		List<BoardDTO> ar = qnaSevice.list(pager);
		model.addAttribute("list", ar);
		return "board/list";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(QnaDTO qnaDTO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaSevice.add(qnaDTO, files);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	// update 폼으로 이동
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaSevice.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO)throws Exception{
		System.out.println(qnaDTO.getContents());
		System.out.println(qnaDTO.getNum());
		int result = qnaSevice.update(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO)throws Exception{
		int result = qnaSevice.delete(qnaDTO);
		return "redirect:./list";
	}
	


}
