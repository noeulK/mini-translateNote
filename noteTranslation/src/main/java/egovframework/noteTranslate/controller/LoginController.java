package egovframework.noteTranslate.controller;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
	
	@RequestMapping(value="/signUpForm.do")
	public String getSignUpForm() throws Exception{
		return "/login/signUpForm";
	}
	
	@RequestMapping(value="/signUp.do")
	public ModelAndView signUp(MemberVO member) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		logger.info("sign up member : "+member);
		int signUpres = loginService.signUpMember(member);
		if(signUpres > 0) {
			mav.addObject("status", HttpStatus.OK);
			mav.addObject("msg", "성공적으로 가입되었습니다.");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/checkAccount.do")
	public ModelAndView checkAccount(MemberVO member) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		
		String accountInfo = loginService.checkAccount(member);
		
		if(accountInfo != null && accountInfo != "") {
			mav.addObject("msg", "이미 존재하는 계정입니다.");
			mav.addObject("status", HttpStatus.CONFLICT);
		}else {
			mav.addObject("msg", "사용할 수 있는 계정입니다.");
			mav.addObject("status", HttpStatus.OK);
		}
		return mav;
	}
	
	@RequestMapping(value="/checkDuplicateNickname.do")
	public ModelAndView checkName(MemberVO member) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		String memberInfo = loginService.checkDuplicatedNickname(member);
		if(memberInfo != null  && memberInfo != "") {
			mav.addObject("msg", "이미 사용중입니다.");
			mav.addObject("status", HttpStatus.CONFLICT);
		}else {
			mav.addObject("status", HttpStatus.OK);
		}
		
		return mav;
	}
}
