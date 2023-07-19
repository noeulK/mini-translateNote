package egovframework.noteTranslate.controller;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.service.LoginService;
import egovframework.noteTranslate.util.ApiProfileAccess;
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
	
	@RequestMapping(value="/naverLogin.do")
	public ResponseEntity<?> loginByNaverAPI(HttpServletRequest req) throws Exception{
		String clientId = "Wa9BnzBoVbYT6Vy1bBDh";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "jtNeArW0Ff";//애플리케이션 클라이언트 시크릿값";
	    String code = req.getParameter("code");
	    String state = req.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8080/note/noteTranslateMain.do", "UTF-8");
	    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	        + "&client_id=" + clientId
	        + "&client_secret=" + clientSecret
	        + "&redirect_uri=" + redirectURI
	        + "&code=" + code
	        + "&state=" + state;
	    
	    
	    Map<String, String> resMap = loginService.figureoutResponse(apiURL);
	    logger.info(resMap+"");
	    String token = resMap.get("access_token"); // 네이버 로그인 접근 토큰;
        String header = "Bearer " + token; // Bearer 다음에 공백 추가


        String apiURL2 = "https://openapi.naver.com/v1/nid/me";


        ApiProfileAccess naverProfileAccess = new ApiProfileAccess(token, header, apiURL2);
        Map<String, String>requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
        Map<String, Object> responseBody = naverProfileAccess.get(requestHeaders);
        if(responseBody != null && !responseBody.isEmpty()) {
        	MemberVO member = new MemberVO();
        	member.setNickname((String) responseBody.get("nickname"));
        	member.setUser_email((String)responseBody.get("email"));
        	
        	MemberVO memberRes = loginService.getMember(member);
        	if(memberRes != null && !memberRes.getSns_join().equals("")) {
        		logger.info("member not null");
        		req.getSession().setAttribute("member", memberRes);
        	}else {
        		logger.info("member null");
        		int res = loginService.signUpMemberBySNS(member);
        		logger.info("sign sns : "+res);
        		if(res > 0) {
        			memberRes = loginService.getMember(member);
        			(req.getSession()).setAttribute("member", memberRes);
        			logger.info("done");
        		}
        	}
        }
        System.out.println(responseBody);
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header("Location", "/note/noteTranslateMain.do").build();
       
        
	}
	
	@RequestMapping(value="/kakaoLogin.do")
	public void loginByKakaoApi(String code, HttpServletRequest req) throws Exception{
		logger.info("enter the kakaoLogin.do : "+code);
		String clientId = "c8a6eafea2757a1f0e26ed382c83b215";//애플리케이션 클라이언트 아이디값";
	    String state = req.getParameter("status");
		String clientSecret = "mqKGpUgJqnoBmewf4Yoi3fq6Cq0QHxpt";
	    String redirectURI = URLEncoder.encode("http://localhost:8080/login/kakaoLogin.do","UTF-8");
	    String apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code"
	        + "&client_id=" + clientId
	        + "&client_secret=" + clientSecret
	        + "&redirect_uri=" + redirectURI
	        + "&code=" + code
	        + "&state=" + state;
	    
	    String accessToken = loginService.getKakaoLoginToken(apiURL);
	    logger.info("kakao login service : "+accessToken);
	    
	    
	     // 네이버 로그인 접근 토큰;
        String header = "Bearer " +accessToken; // Bearer 다음에 공백 추가
        String apiURL2 = "https://kapi.kakao.com/v2/user/me";
        
        ApiProfileAccess profileAccess = new ApiProfileAccess(accessToken, header, apiURL2);
        Map<String, String>requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
        Map<String, Object> responseBody = profileAccess.getResponseByKakao(requestHeaders);
        logger.info("response kakao : "+responseBody);
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
			logger.info("쿠키 만료 설정 : "+cookie.getMaxAge());
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
	
	@RequestMapping(value="/modifyPassword.do")
	public ModelAndView modifyPassword(MemberVO member, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		Cookie[] cookies = req.getCookies();
		logger.info("cookie");
		if(cookies != null) {
			logger.info("cookies are not expired");
			for(int i = 0; i < cookies.length; i++) {
				if((cookies[i].getValue()).indexOf("@") > 0) {
					System.out.println("key: "+cookies[i].getName()+ "/ value: "+ cookies[i].getValue());
					member.setUser_email(cookies[i].getValue());
					loginService.modifyPassword(member);
					mav.addObject("status", HttpStatus.OK);
					mav.addObject("url", "loginForm.do");
					mav.addObject("msg", "비밀번호가 성공적으로 변경되었습니다.");
					break;
				}else {
					System.out.println("have not value");
					mav.addObject("status", HttpStatus.BAD_REQUEST);
					mav.addObject("msg", "해당 링크는 만료되었습니다.");
				}
			}
		}
		
		
		
		return mav;
	}
	
	
}
