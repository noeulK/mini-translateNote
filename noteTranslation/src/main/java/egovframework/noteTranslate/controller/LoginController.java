package egovframework.noteTranslate.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.service.LoginService;

@Controller
@RequestMapping("/login/")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value="/loginForm.do")
	public String getLoginForm() throws Exception{
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView loginGo(MemberVO member) throws Exception{
		ModelAndView mav = new ModelAndView();
		MemberVO memberInfo = loginService.loginMember(member);
		logger.info("member: "+memberInfo);
		return mav;
	}
	
	@RequestMapping(value="/signUp.do")
	public String getSignUpForm() throws Exception{
		return "/login/signUpForm";
	}
}
