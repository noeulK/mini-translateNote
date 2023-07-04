package egovframework.noteTranslate.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.noteTranslate.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
@RequestMapping("/note/")
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="mainService")
	private MainService mainService;
	
	@RequestMapping(value="/noteTranslateMain.do")
	public String getMain(HttpServletRequest req) throws Exception{
		EgovMap res = mainService.selectMain();
		logger.info("____________"+res);
		return "/main/noteTranslateMain";
	}
}
