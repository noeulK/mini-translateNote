<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/header.jsp" %>

<div class="page-wrapper page-wrapping" >
<div class="page-body wrapping-page">
	<div class="container-xl">
		<div class="page-header d-print-none">
            <div class="row align-items-center">
              <div class="col">
                <h4 class="page-title">
                  노트 쓰기 
                </h4>
              </div>
            </div>
        </div>
	</div>
	
	<div class="container-xl">
		<div class="row justify-content-center">
			<div class="col-lg-10 col-xl-9">
				<div class="card card-lg">
					<form class="card">
						<div class="card-header">
							<div class="col-6 form-selectgroup">
								<label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="home" class="form-selectgroup-input" checked="">
                                <span class="form-selectgroup-label" onclick="pasteText()">
                                <!-- Download SVG icon from http://tabler-icons.io/i/file-import -->
								<svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M14 3v4a1 1 0 0 0 1 1h4" /><path d="M5 13v-8a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-5.5m-9.5 -2h7m-3 -3l3 3l-3 3" /></svg>
                                 가져오기 </span>
                              </label>	
								<label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="home" class="form-selectgroup-input" checked="">
                                <span class="form-selectgroup-label">
                                <!-- Download SVG icon from http://tabler-icons.io/i/letter-case -->
								<svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><circle cx="17.5" cy="15.5" r="3.5" /><path d="M3 19v-10.5a3.5 3.5 0 0 1 7 0v10.5" /><path d="M3 13h7" /><path d="M21 12v7" /></svg>
                                 단어 등록 </span>
                              </label>	
                            </div>  					
	                    	<div class=" col-6 form-selectgroup">
                              <label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="home" class="form-selectgroup-input" checked="">
                                <span class="form-selectgroup-label">
                                 <!-- Download SVG icon from http://tabler-icons.io/i/parentheses -->
								<svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M7 4a12.25 12.25 0 0 0 0 16" /><path d="M17 4a12.25 12.25 0 0 1 0 16" /></svg>
                                 괄호 </span>
                              </label>
                              <label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="home" class="form-selectgroup-input" checked="">
                                <span class="form-selectgroup-label">
								 <i class="fa-solid fa-slash fa-rotate-90"></i>
                                 빗금  </span>
                              </label>
                              <label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="user" class="form-selectgroup-input">
                                <span class="form-selectgroup-label">
                                <!-- Download SVG icon from http://tabler-icons.io/i/triangle -->
								<svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M5 19h14a2 2 0 0 0 1.84 -2.75l-7.1 -12.25a2 2 0 0 0 -3.5 0l-7.1 12.25a2 2 0 0 0 1.75 2.75" /></svg>
                                세모 </span>
                              </label>
                              <label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="circle" class="form-selectgroup-input">
                                <span class="form-selectgroup-label"><!-- Download SVG icon from http://tabler-icons.io/i/circle -->
                                  <svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="9"></circle></svg>
                                  동그라미 </span>
                              </label>
                              <label class="form-selectgroup-item">
                                <input type="radio" name="icons" value="square" class="form-selectgroup-input">
                                <span class="form-selectgroup-label"><!-- Download SVG icon from http://tabler-icons.io/i/square -->
                                  <svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="4" width="16" height="16" rx="2"></rect></svg>
                                  네모 </span>
                              </label>
                            </div>
	                  	</div>
	                  	<div class="card-body">
	                  		<div class="col-12">
	                  			<div class="ti title_div">
								    <input class="ti title_input" name="note_title" type="text" required>
								    <label class="ti title_label">제목 </label>
								    <span class="ti title_span"></span>
								</div>
	                  		
			                    <div class="card note_content" id="note_content">
			                      <div class="empty" >
			                        <p class="empty-title">번역할 글이 없습니다. </p>
			                        <p class="empty-subtitle text-muted">
			                          가져오기 버튼을 클릭하여 클립보드에 복사된 텍스트를 가져옵니다. 
			                        </p>
			                        <div class="empty-action">
			                          <a href="javascript:pasteText()" class="btn btn-primary">
			                            <!-- Download SVG icon from http://tabler-icons.io/i/file-import -->
								<svg xmlns="http://www.w3.org/2000/svg" class="icon me-1" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M14 3v4a1 1 0 0 0 1 1h4" /><path d="M5 13v-8a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-5.5m-9.5 -2h7m-3 -3l3 3l-3 3" /></svg>
			                            가져오기 
			                          </a>
			                        </div>
			                      </div>
			                    </div>
			                  </div>
	                  	</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	



		




</div>
</div>


<script src="/js/note.js"></script>

<%@ include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/footer.jsp" %>