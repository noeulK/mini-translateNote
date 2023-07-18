<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_header.jsp" %>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.3.0/kakao.min.js"
  integrity="sha384-70k0rrouSYPWJt7q9rSTKpiTfX6USlMYjZUtr1Du+9o4cGvhPAWxngdtVZDdErlh" crossorigin="anonymous"></script>

<%
    String clientId = "Wa9BnzBoVbYT6Vy1bBDh";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8080/login/naverLogin.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
         + "&client_id=" + clientId
         + "&redirect_uri=" + redirectURI
         + "&state=" + state;
    session.setAttribute("state", state);
 %>
 <%
 	String kakaoClient = "c8a6eafea2757a1f0e26ed382c83b215";
 	String kakaoRedirect = URLEncoder.encode("http://localhost:8080/login/kakaoLogin.do", "UTF-8");
 	SecureRandom kakoRandom = new SecureRandom();
 	String status = new BigInteger(130, kakoRandom).toString();
 	String kakaoApiURL = "https://kauth.kakao.com/oauth/authorize?response_type=code"
 			+ "&client_id=" + kakaoClient
 			+ "&redirect_uri=" + kakaoRedirect
 			+ "&status=" + status;
 	session.setAttribute("status", status);
 %>
<div class="page page-center note-back">
      <div class="container-tight py-4">
        <div class="text-center mb-4">
          <a href="." class="navbar-brand navbar-brand-autodark"><img src="/images/egovframework/logo/noteLogoNName.png" height="50" alt=""></a>
        </div>
        <form class="card card-md" action="login/login.do" method="post" role="loginForm" autocomplete="on">
          <div class="card-body">
            <h2 class="card-title text-center mb-4" style="font-size:20px;">로그인 </h2>
            <div class="mb-3">
              <label class="form-label">이메일 </label>
              <input type="email" name="user_email" class="form-control" placeholder="abcd234translationNote.com">
            </div>
            <div class="mb-2">
              <label class="form-label">
                비밀번호 
                <span class="form-label-description">
                  <a href="/login/findPasswordForm.do">비밀번호 찾기 </a>
                </span>
              </label>
              <div class="input-group input-group-flat">
                <input type="password" class="form-control" name="password" placeholder="" autocomplete="on">
                <span class="input-group-text">
                  <a href="javascript:toggleEye()" class="link-secondary" title="" data-bs-toggle="tooltip" data-bs-original-title="Show password"><!-- Download SVG icon from http://tabler-icons.io/i/eye -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon eye-on" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="2"></circle><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333 -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7"></path></svg>
                  </a>
                </span>
              </div>
            </div>
            <div class="form-footer">
              <button type="button" onclick="loginGo()" class="btn btn-primary w-100">로그인 </button>
            </div>
          </div>
          <div class="hr-text">혹은 </div>
          <div class="card-body">
            <div class="row">
              <div class="col">
                 SNS 간편 로그인 해보세요 
              </div>
              <div class="col">
              	&nbsp;
              </div>
              <div class="col row">
              	<div class="col">
	              	<a href=<%=apiURL%>>
	              		<img src="/images/egovframework/button/btnG_아이콘원형.png" class="rounded-circle" style="height:35px;" alt="...">
	              	</a>
	            </div>
	            <div class="col">
	            	<a href=<%=kakaoApiURL %>>
	              		<img src="/images/egovframework/button/btnG_kakao.png" class="rounded-circle" style="height:35px;" alt="...">
	              	</a>
	            </div>  	
              </div>
            </div>
          </div>
        </form>
        <div class="text-center text-muted mt-3">
          계정이 없으신가요?  <a href="/login/signUpForm.do" tabindex="-1">가입하기 </a>
          <p id="token-result"></p>
        </div>
      </div>
    </div>
    

<script>
function loginWithKakao() {
	console.log('kakao click');
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8080/login/kakaoLogin.do',
      state: 'userme'
    });
  }


  

</script>
<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_footer.jsp" %>