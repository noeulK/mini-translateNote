<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/open_header.jsp" %>
	
	<div class="page-body" style="margin:0px; padding-bottom:20px;">
		<div class="container-xl">
			<div class="row row-cards">
				<div class="col-12">
					<form role="vocaForm">
						<div class="card-header">
							<h4 class="card-title">단어장 </h4>
						</div>
						<div class="card-body">
							<div class="col-xl-12">
								<div class="mb-3">
	                              <label class="form-label required">단어 </label>
	                              <input type="text" class="form-control" name="voca_word" >
	                            </div>
	                            <div class="mb-3">
	                              <label class="form-label">뜻  <!-- <span class="form-label-description">56/100</span> --></label>
	                              <textarea class="form-control" name="voca_meaning" rows="6" placeholder="뜻을 입력해주세요. "></textarea>
	                            </div>
							</div>
						</div>
					</form>
					<div class="d-flex justify-content-end form-selectgroup form-selectgroup-pills">
	                    <label class="form-selectgroup-item">
	                      <input type="button" onclick="saveVoca()" class="form-selectgroup-input" >
	                      <span class="form-selectgroup-label">저장하기 </span>
	                    </label>
	                    <label class="form-selectgroup-item">
	                      <input type="button" onclick="cancel()" class="form-selectgroup-input">
	                      <span class="form-selectgroup-label">취소 </span>
	                    </label>
                    </div>
				</div>
			</div>
		</div>
	</div>
	
<script>
	const urlParams = new URLSearchParams(window.location.search);
	const receivedData = urlParams.get('word');
	const noteId = urlParams.get('noteId');
	console.log(receivedData);
	if(receivedData){
		let word_input = document.querySelector('[name="voca_word"]');
		word_input.value = receivedData;
	}
	
	function saveVoca(){
		var voca_word = document.querySelector('[name="voca_word"]').value;
		var voca_meaning = document.querySelector('[name="voca_meaning"]').value;
		
		if(voca_word && voca_meaning){
			var voca_confirm = confirm('단어를 등록하시겠습니까? ');
			if(voca_confirm){
				console.log('pass');
				
				$.ajax({
					url : 'saveVoca.do',
					type : 'post',
					data : {'voca_word': voca_word,
						'voca_meaning' : voca_meaning,
						'note_id' : noteId
					},
					dataType : 'json',
					success : function(data){
						console.log(data);
					},
					error : function(xhr){
						
					}
					
				})
			}
		}
	}
	
	function cancel(){
		document.querySelector('[role="vocaForm"]').reset();
		window.open('','_self').close(); 
	}
</script>


<%@include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/open_footer.jsp" %>	