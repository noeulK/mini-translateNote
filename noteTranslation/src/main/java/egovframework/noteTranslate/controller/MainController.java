package egovframework.noteTranslate.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;
import egovframework.noteTranslate.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
@RequestMapping("/note/")
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="mainService")
	private MainService mainService;
	
	@RequestMapping(value="/noteTranslateMain.do")
	public ModelAndView getMain(HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView("json");
		
		MemberVO member = (MemberVO) req.getSession().getAttribute("member");
		if(member == null) {
			if(req.getSession().getAttribute("state") != null) {
				logger.info(req.getSession().getAttribute("state")+"");
			}
		}
		logger.info("sign in : "+member);
		List<NoteVO> noteList = mainService.getNoteList(member);
		List<VocaVO> vocaList =  mainService.getVocaList(member);
		
		mav.addObject("vocaList", vocaList);
		mav.addObject("noteList", noteList);
		
		mav.setViewName("/main/noteTranslateMain");
		return mav;
	}
	
	
}
