<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_header.jsp" %>

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
        </form>
        <div class="text-center text-muted mt-3">
          계정이 없으신가요?  <a href="/login/signUpForm.do" tabindex="-1">가입하기 </a>
        </div>
      </div>
    </div>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_footer.jsp" %>