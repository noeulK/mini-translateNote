package egovframework.noteTranslate.controller;


import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.service.LoginService;
import egovframework.noteTranslate.util.MimeAttachNotifier;

@Controller
@RequestMapping("/login/")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	
	@Autowired
	private MimeAttachNotifier notifier;
	
	@RequestMapping(value="/loginForm.do")
	public String getLoginForm() throws Exception{
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView loginGo(MemberVO member, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView("jsonView");
		logger.info("member :"+member);
		MemberVO memberInfo = loginService.loginMember(member);
		logger.info("loginGo", memberInfo);
		if(memberInfo != null && (memberInfo.getUse_yn().equals("Y"))) {
			logger.info("not null");
			HttpSession sess = req.getSession();
			sess.setAttribute("member", memberInfo);
			
			mav.addObject("status", HttpStatus.OK);
		}else {
			mav.addObject("status", HttpStatus.NO_CONTENT);
			mav.addObject("msg", "이메일 혹은 비밀번호가 틀립니다. 정확히 확인 후 입력해주세요.");
		}
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
	
	@RequestMapping(value="/findPasswordForm.do")
	public String getPasswordForm() throws Exception{
		return "/login/findPasswordForm";
	}
	
	@RequestMapping(value="/settingPassword.do")
	public String settingPassword(MemberVO member, RedirectAttributes rttr, HttpServletResponse res) throws Exception{
		String url = "redirect:/login/findPasswordForm.do";
		logger.info("setting password : "+member.getUser_email());
		MemberVO memberInfo = loginService.getMember(member);
		if(memberInfo.getNickname() != null && !(memberInfo.getNickname()).equals("")) {
			String key = UUID.randomUUID().toString();
			
			Cookie cookie = new Cookie(key, memberInfo.getUser_email());
			cookie.setMaxAge(24*60*60);
			res.addCookie(cookie);
			
			String text = memberInfo.getNickname()+"님께,<br>"
						 +"<a href='http://localhost:8080/login/settingPasswordForm.do?key="+key+"'target='_blank'>암호 재설정하기</a>를 클릭하여 암호를 재설정해주세요. <br>"
						 +"이 링크는 24시간 후 만료되며 한번만 사용할 수 있습니다.<br>"
						 +"암호 변경을 원하지 않거나 변경 요청을 하지 않으신 경우 이 메일을 무시하고 삭제해주세요. <br>"
						 +"<br>"
						 +"감사합니다.<br> 번역노트 고객 지원팀 ";
			String subject = "[번역노트] 사용자 계정 암호 재설정 ";
			
			notifier.sendMail(member.getUser_email(), subject, text);
			
			rttr.addFlashAttribute("chk", true);
			rttr.addFlashAttribute("message", "가입하신 이메일로 암호 재설정 링크를 발송하였습니다.");
		}else {
			logger.info("member is null");
			rttr.addFlashAttribute("chk", false);
			rttr.addFlashAttribute("message", "가입된 계정이 없습니다.");
		}
		return url;
	}
	
	@RequestMapping(value="/settingPasswordForm.do")
	public String settingPasswordForm() {
		String url = "/login/settingPasswordForm";
		return url;
	}
	
	
}
