<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/open_header.jsp" %>
	
	<div class="page-body" style="margin:0px; padding-bottom:20px;">
		<div class="container-xl">
			<div class="row row-cards">
				<div class="col-12">
					<form role="askForm">
						<div class="card-header">
							<h4 class="card-title">물어보기  </h4>
						</div>
						<div class="card-body">
							<div class="col-xl-12">
								<input type="hidden" name="note_id">
								<input type="hidden" name="paragraph_id">
								<div class="mb-3">
	                              <label class="form-label required">문장 </label>
	                              <textarea class="form-control" rows="3" name="ask_phrase" ></textarea>
	                            </div>
	                            <div class="mb-3">
	                              <label class="form-label">코멘트  <!-- <span class="form-label-description">56/100</span> --></label>
	                              <textarea class="form-control" name="ask_comment" rows="6" placeholder="뜻을 입력해주세요. "></textarea>
	                            </div>
							</div>
						</div>
					</form>
					<div class="d-flex justify-content-end form-selectgroup form-selectgroup-pills">
	                    <label class="form-selectgroup-item">
	                      <input type="button" class="form-selectgroup-input" onclick="askSentence()">
	                      <span class="form-selectgroup-label">물어보기  </span>
	                    </label>
	                    <label class="form-selectgroup-item">
	                      <input type="button" class="form-selectgroup-input" onclick="cancel()">
	                      <span class="form-selectgroup-label">취소 </span>
	                    </label>
                    </div>
				</div>
			</div>
		</div>
	</div>
	
<script>
	const urlParams = new URLSearchParams(window.location.search);
	const receivedData = urlParams.get('sentence');
	const phraseIndex = urlParams.get('pIndex');
	const note_id = urlParams.get('noteId');
	console.log(receivedData);
	if(receivedData){
		let word_input = document.querySelector('[name="ask_phrase"]');
		word_input.value = receivedData;
		document.querySelector('[name="note_id"]').value = note_id;
		document.querySelector('[name="paragraph_id"]').value = phraseIndex;
		
	} 
	
	function askSentence() {
		var check = confirm('해당 내용을 저장할까요? ');
		if(check){
		    var askForm = $('[role="askForm"]').serialize();
		    
		    $.ajax({
		    	url : 'askSentence.do',
		    	type : 'post',
		    	data : askForm,
		    	dataType : 'json',
		    	success : function(data){
		    		if(data.status == "OK"){
			    		alert(data.message);
			    		cancel();
			    		window.opener.handleAskingWindowData(phraseIndex);
		    		}
		    	},
		    	error : function(xhr){
		    		console.log('error ', xhr);
		    	}
		    })
		}    
	}

	
	function cancel(){
		document.querySelector('[role="askForm"]').reset();
		window.open('','_self').close(); 
	}
</script>


<%@include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/open_footer.jsp" %>	