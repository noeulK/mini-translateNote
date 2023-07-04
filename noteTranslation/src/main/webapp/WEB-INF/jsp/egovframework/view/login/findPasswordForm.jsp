<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_header.jsp" %>

<div class="page page-center note-back">
      <div class="container-tight py-4">
        <div class="text-center mb-4">
          <a href="/login/loginForm.do" class="navbar-brand navbar-brand-autodark"><img src="/images/egovframework/logo/noteLogoNName.png" height="50" alt=""></a>
        </div>
        <form class="card card-md" action="settingPassword.do" method="post" role="findPwdForm">
          <div class="card-body">
            <h2 class="card-title text-center mb-4">비밀번호 찾기 </h2>
            <p class="text-muted mb-4">비밀번호를 찾고자하는 이메일을 입력해주세요. </p>
            <div class="mb-3">
              <label class="form-label">이메일 </label>
              <input type="email" class="form-control" name="user_email" placeholder="Enter email">
            </div>
            <div class="form-footer">
              <a href="javascript:sendMailLink()" class="btn btn-primary w-100">
                <!-- Download SVG icon from http://tabler-icons.io/i/mail -->
                <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="3" y="5" width="18" height="14" rx="2"></rect><polyline points="3 7 12 13 21 7"></polyline></svg>
                새로운 비밀번호 보내기 
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
console.log('yeah', ${chk})
if(${chk eq 'true'}){
	alert('${message}');
}else{
	console.log('${message}');
}
</script>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/login_footer.jsp" %>