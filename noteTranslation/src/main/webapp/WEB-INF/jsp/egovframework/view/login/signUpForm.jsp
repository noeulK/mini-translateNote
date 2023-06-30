<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_header.jsp" %>

<div class="page page-center note-back">
      <div class="container-tight py-4">
        <div class="text-center mb-4">
          <a href="loginForm.do" class="navbar-brand navbar-brand-autodark"><img src="/images/egovframework/logo/noteLogoNName.png" height="50" alt=""></a>
        </div>
        <form class="card card-md" action="login/signUp.do" method="post" role="signUpForm" autocomplete="on">
          <div class="card-body">
            <h2 class="card-title text-center mb-4" style="font-size:20px;">회원가입 </h2>
            <div class="mb-3">
              <label class="form-label">이메일 </label>
              <input type="email" name="user_email" class="form-control" placeholder="abcd234translationNote.com">
              <span class="email_msg text-warning"></span>
            </div>
             <div class="mb-3">
              <label class="form-label">이름 </label>
              <input type="text" name="nickname" class="form-control" placeholder="2~10자의 한글, 영어, 숫자만 입력해주세요.">
              <span class="name_msg text-warning"></span>
            </div>
            <div class="mb-2">
              <label class="form-label">
                비밀번호 
              </label>
              <div class="input-group input-group-flat">
                <input type="password" class="form-control" name="password" placeholder="최소 8글자 이상 영어,숫자,특수문자 중 2가지를 포함하여 입력해주세요." >
                <span class="input-group-text">
                  <a href="javascript:toggleEye()" class="link-secondary" title="" data-bs-toggle="tooltip" data-bs-original-title="Show password"><!-- Download SVG icon from http://tabler-icons.io/i/eye -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon eye-on" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="2"></circle><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333 -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7"></path></svg>
                  </a>
                </span>
              </div>
            </div>
            <div class="form-footer">
              <button type="button" onclick="signUp()" class="btn btn-primary w-100">가입하기 </button>
            </div>
          </div>
        </form>
        <div class="text-center text-muted mt-3">
          계정이 있습니다.  <a href="login/loginForm.do" tabindex="-1">로그인하기 </a>
        </div>
      </div>
    </div>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_footer.jsp" %>