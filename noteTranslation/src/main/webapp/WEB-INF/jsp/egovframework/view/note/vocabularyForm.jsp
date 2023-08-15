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
	                            <div class="mb-3 pos-table">
	                            	<table>
	                            		<tbody>
	                            			<tr style="cursor:pointer;">
	                            				<td>명사 </td>
	                            				<td>형용사 </td>
	                            				<td>동사 </td>
	                            				<td>부사 </td>
	                            				<td>대명사 </td>
	                            				<td>전치사 </td>
	                            				<td>접속사 </td>
	                            				<td>감탄사 </td>
	                            				<td>숙어 </td>
	                            			</tr>
	                            		</tbody>
	                            	</table>
	                            </div>
	                            <div class="mb-3">
	                              <label class="form-label">뜻  <!-- <span class="form-label-description">56/100</span> --></label>
	                              <textarea class="form-control" name="voca_meaning" rows="2" placeholder="뜻을 입력해주세요. "></textarea>
	                            </div>
	                            <div class="mb-3 ex-div blur">
	                              <label class="form-label">예문  <!-- <span class="form-label-description">56/100</span> --></label>
	                              <ul class="ex-ul">
	                              	<li class="ex-li"><input type="text" class="ex-sentence"></li>
	                              	<li class="ex-li"><input type="text" class="ex-sentence"></li>
	                              	<li class="ex-li"><input type="text" class="ex-sentence"></li>
	                              </ul>
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
document.addEventListener('DOMContentLoaded', function() {
	var tdList = document.querySelectorAll('.pos-table td');
    var prevClickedTd = null; // 이전에 클릭된 td 요소를 저장하는 변수

    for (var i = 0; i < tdList.length; i++) {
        tdList[i].addEventListener('click', function() {
            if (prevClickedTd) {
                prevClickedTd.classList.remove('clicked-td');
            }

            this.classList.add('clicked-td');
            prevClickedTd = this;
            
        });
    }
    
    
    
    var ex_inputs = document.querySelectorAll('.ex-sentence');
    var parentDiv = document.querySelector('.ex-div');
    for(var i = 0; i < ex_inputs.length; i++){
    	ex_inputs[i].addEventListener('focus', function() {
    		this.classList.add('on');
    		parentDiv.classList.remove('blur');
    		parentDiv.classList.add('focus');
    	})
    	
    	ex_inputs[i].addEventListener('blur', function() {
    		this.classList.remove('on');
    		parentDiv.classList.remove('focus');
    		parentDiv.classList.add('blur');
    	})
    }
    
});

</script>
<script src="/js/note/voca.js"></script>	


<%@include file="/WEB-INF/jsp/egovframework/view/cmmn/partial/open_footer.jsp" %>	