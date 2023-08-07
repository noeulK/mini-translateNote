package egovframework.noteTranslate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.noteTranslate.dto.AskVO;
import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;
import egovframework.noteTranslate.service.NoteService;

@Controller
@RequestMapping("/note/")
public class NoteController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="noteService")
	private NoteService noteService;
	
	@RequestMapping(value="/writeNoteForm.do")
	public String getWriteNoteForm() {
		return "/note/noteForm";
	}
	
	@RequestMapping(value="/vocabularyForm.do")
	public String getVocabularyForm() {
		return "/note/vocabularyForm";
	}
	
	@RequestMapping(value="/askingForm.do")
	public String getAskingForm() {
		logger.info("why can not work this url");
		return "/note/askingSentenceForm";
	}
	
	@RequestMapping(value="/saveDraft.do")
	public ModelAndView saveDraft(HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		NoteVO note = new NoteVO();
		logger.info("save draft");
		MemberVO member = (MemberVO) req.getSession().getAttribute("member");
		note.setNote_content(req.getParameter("draft"));
		note.setNote_writer(member.getUser_email());
		
		int note_no = noteService.saveDraft(note);
		logger.info("no "+note_no);
		
		if(note_no > 0) {
			mav.addObject("status", HttpStatus.OK);
			mav.addObject("note_id", note_no);
		}else {
			mav.addObject("status", HttpStatus.BAD_REQUEST);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/saveVoca.do")
	public ModelAndView saveVoca(VocaVO voca) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		logger.info("yeah");
		
		logger.info("voca : "+voca);
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/askSentence.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveAskingSentence(AskVO param, HttpServletRequest req) throws Exception {
	    ModelAndView mav = new ModelAndView("jsonView");
	    
	    int res = noteService.askSentence(param);
	    logger.info("pass service");
	    if (res != 0) {
	        mav.addObject("status", HttpStatus.OK);
	        mav.addObject("message", "등록되었습니다.");
	    } else {
	        mav.addObject("status", HttpStatus.BAD_REQUEST);
	        mav.addObject("message", "일시적으로 오류가 발생했습니다. ");
	    }
	    
	    return mav;
	}
	
	
	
}
