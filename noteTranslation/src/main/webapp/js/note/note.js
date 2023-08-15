
// 가져오기 버튼
// 클립보드 내에 복사된 텍스트 붙여넣기 기능 
function pasteText(){
	navigator.clipboard.readText()
    .then(function(clipboardText) {
    	const note_content = document.querySelector('#note_content');
	  	note_content.innerHTML = '';
		const contents = clipboardText.split(' ');
	  	let words = "";
	  	contents.forEach((content) => {
			if(typeof content == "undefined" || content == null || content == ""){
	        	//words += '';
			}else{
				words += '<span class="word_span" >'+content+' </span>';
			}
      	});
console.log(' ee',words)
		note_content.innerHTML = '<p class="translate_p">'+words+'</p>';
		insertEmptyInputTags();
		countIndex();
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

function wordHoverFlad(flag){
	return !flag;
}

function clickedPharase(){
	phrase_var = wordHoverFlad(phrase_var);
	var note_content = document.querySelector('#note_content');
	var phrases = note_content.querySelectorAll('p');
	if(phrase_var){
		phrases.forEach((phrase) => {
			phrase.classList.add('p_hover');
			phrase.onclick = function(){
				openAskingForm(this);
				phrases.forEach(phrase => {
			    	phrase.classList.remove('p_hover');
					phrase.onclick = function(){}
			    });
				phrase_var = false;
			}
	    });
	}else{
		console.log('remove');
		phrases.forEach(phrase => {
	    	phrase.classList.remove('p_hover');
			phrase.onclick = function(){}
	    });
	}
}

function openAskingForm(e){
	const index = e.getAttribute('data-index');
	const note_id = document.querySelector('[name="note_id"]').value;
	openNewWindow('/note/askingForm.do?sentence='+encodeURIComponent(e.innerText)+'&noteId='+encodeURIComponent(note_id)+'&pIndex='+encodeURIComponent(index), '물어보기 ', 1000, 550);
}



function countIndex(){
	var note_content = document.querySelector('#note_content');
	var phrases = note_content.querySelectorAll('p');
	console.log('index')
	phrases.forEach((phrase, index) => {
		if(phrase.innerText.length > 0){
			
			phrase.setAttribute('data-index', index);
		}else{
			note_content.removeChild(phrase);
		}
	})
			
}

function insertEmptyInputTags() {
	const noteContent = document.querySelector('.note_content');
	const paragraphs = noteContent.innerHTML.split('\n');
	const modifiedContent = paragraphs.map((p, index) => `<p class="translate_p">${p.trim()}</p><input type="text" class="input_custom" data-index=${index+1} >`).join('\n');
    noteContent.innerHTML = modifiedContent;
}

function saveNote(){
	let parameterObjects = [];
	let note_title = document.querySelector("[name='note_title']").value;
	let note_content = document.querySelector("#note_content");
	let phrases = note_content.querySelectorAll('p');
	let inputs = note_content.querySelectorAll('input');
	console.log('save note');
	for(var i = 0; i < inputs.length-1; i++){
		
		var p_id = phrases[i].getAttribute('data-index');
		var original = phrases[i].innerHTML;
		var translate_v = inputs[i].value;
		var object = {"phrase_no" : p_id, "original" :original , "translate_version" :translate_v};
		parameterObjects.push(object);
	}
	console.log(parameterObjects);
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
			}
		});
	}
}


