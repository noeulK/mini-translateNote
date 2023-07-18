<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_header.jsp" %>

<div class="page page-center note-back">
      <div class="container-tight py-4">
        <div class="text-center mb-4">
          <a href="/login/loginForm.do" class="navbar-brand navbar-brand-autodark"><img src="/images/egovframework/logo/noteLogoNName.png" height="50" alt=""></a>
        </div>
        <form class="card card-md" action="." method="post">
          <div class="card-body">
            <h2 class="card-title text-center mb-4">암호 재설정 </h2>
            <p class="text-muted mb-4">변경할 비밀번호를 입력해주세요. </p>
            <div class="mb-3">
              <label class="form-label">비밀번호 </label>
              <div class="input-group input-group-flat">
	              <input type="password" class="form-control" name="password" placeholder="최소 8글자 이상 영어,숫자,특수문자 중 2가지를 포함하여 입력해주세요.">
	              <span class="input-group-text">
	                  <a href="javascript:toggleEye()" class="link-secondary" title="" data-bs-toggle="tooltip" data-bs-original-title="Show password"><!-- Download SVG icon from http://tabler-icons.io/i/eye -->
	                    <svg xmlns="http://www.w3.org/2000/svg" class="icon eye-on" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="2"></circle><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333 -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7"></path></svg>
	                  </a>
	              </span>
	          </div>      
            </div>
            <div class="mb-3">
              <label class="form-label">비밀번호 확인 </label>
              <div class="input-group input-group-flat">
              	<input type="password" class="form-control" name="doublecheck_password" placeholder="다시 한번 입력해주세요. ">
              	<span class="input-group-text">
	                  <a href="javascript:toggleEyeCheck()" class="link-secondary" title="" data-bs-toggle="tooltip" data-bs-original-title="Show password"><!-- Download SVG icon from http://tabler-icons.io/i/eye -->
	                    <svg xmlns="http://www.w3.org/2000/svg" class="icon eye-on check" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="2"></circle><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333 -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7"></path></svg>
	                  </a>
	            </span>
              </div>
            </div>
            <div class="form-footer">
              <a href="javascript:modifyPasswordGo()" class="btn btn-primary w-100">
                <!-- Download SVG icon from http://tabler-icons.io/i/mail -->
                <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="3" y="5" width="18" height="14" rx="2"></rect><polyline points="3 7 12 13 21 7"></polyline></svg>
                변경하기 
              </a>
            </div>
          </div>
        </form>
        <div class="text-center text-muted mt-3">
          <a href="loginForm.do">로그인</a> 화면으로 돌아가기 
        </div>
      </div>
</div>

<script>
	let key;
	window.onload = function(){
		const queryString = window.location.search;
		console.log(queryString);
		const params = new URLSearchParams(queryString);
		const paramVal = params.get('key');
		console.log(paramVal);
		key = paramVal;
	}
</script>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_footer.jsp" %>