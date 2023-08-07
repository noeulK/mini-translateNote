
// 가져오기 버튼
// 클립보드 내에 복사된 텍스트 붙여넣기 기능 
function pasteText(){
	navigator.clipboard.readText()
    .then(function(clipboardText) {
    	const note_content = document.querySelector('#note_content');
	  	note_content.innerHTML = '';
		const contents = clipboardText.split(' ');
	  	let words = "";
	  	contents.forEach(content => {
			if(typeof content == "undefined" || content == null || content == ""){
	        	words += '';
			}else{
				words += '<span class="word_span" >'+content+' </span>';
			}
      	});
		note_content.innerHTML = '<p class="translate_p">'+words+'</p>';
		insertEmptyInputTags();
		saveDraft(clipboardText);
    })
    .catch(function(err) {
		alert('클립보드가 비어있습니다.');      
		//console.error("클립보드 내용을 가져오는데 실패했습니다:", err);
    });
}

function saveDraft(draft){
	console.log(draft);
	if(draft){
		$.ajax({
			url : "saveDraft.do",
			data : {"draft": draft},
			type : "post",
			dataType : "json",
			success : function(data){
				document.querySelector('[name="note_id"]').value = data.note_id;
			},
			error : function(xhr){
				
			}
		})
	}
}



function clickedPharase(){
	phrase_var = wordHoverFlad(phrase_var);
	var note_content = document.querySelector('#note_content');
	var phrases = note_content.querySelectorAll('p');
	if(phrase_var){
		phrases.forEach((phrase, index) => {
	    	phrase.classList.add('p_hover');
			phrase.setAttribute('data-index', index);
			phrase.onclick = function(){
				
				openAskingForm(this);
				phrases.forEach(phrase => {
			    	phrase.classList.remove('p_hover');
					phrase.onclick = function(){}
			    });
				phrase_var = false;
			}
	    });
	}/*else{
		console.log('remove')
		phrases.forEach(phrase => {
	    	phrase.classList.remove('p_hover');
			phrase.onclick = function(){}
	    });
	}*/
	
}

function openAskingForm(e){
	const index = e.getAttribute('data-index');
	const note_id = document.querySelector('[name="note_id"]').value;
	openNewWindow('/note/askingForm.do?sentence='+encodeURIComponent(e.innerText)+'&noteId='+encodeURIComponent(note_id)+'&pIndex='+encodeURIComponent(index), '물어보기 ', 1000, 550);
}





function insertEmptyInputTags() {
	const noteContent = document.querySelector('.note_content');
	const paragraphs = noteContent.innerHTML.split('\n');
	const modifiedContent = paragraphs.map(p => `<p class="translate_p">${p.trim()}</p><input type="text" class="input_custom" >`).join('\n');
    noteContent.innerHTML = modifiedContent;
}

function saveNote(){
	let note_title = document.querySelector("[name='note_title']").value;
	let note_content = document.querySelector("#note_content").innerHTML;
	
	if(!note_title){
		alert('제목을 입력해주세요. ');
		return;
	}else{
		
	}
}

function handleAskingWindowData(data){
	console.log('전달 받은 데이터 ', data);
	if(data > 0){
		var note_content = document.querySelector('#note_content');
		var phrases = note_content.querySelectorAll('p');
		phrases.forEach(function(phrase){
			var index = phrase.getAttribute('data-index');
			console.log('index ',index)
			if(index == data){
				phrase.classList.add('asked-p');
				/*console.log('same');
				var clipSpan = document.createElement('p');
				console.log('#')
				clipSpan.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-pin" width="15" height="15" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M15 4.5l-4 4l-4 1.5l-1.5 1.5l7 7l1.5 -1.5l1.5 -4l4 -4"></path><path d="M9 15l-4.5 4.5"></path><path d="M14.5 4l5.5 5.5"></path></svg>'
				console.log('2')
				var firstChild = phrase.firstChild;
				phrase.insertBefore(clipSpan, firstChild);
				console.log('3')*/
			}
		});
	}
}


