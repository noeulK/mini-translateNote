
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
				words += '<span class="word_span" onclick="clickSpan(this)">'+content+' </span>';
			}
      	});
		note_content.innerHTML = '<p>'+words+'</p>';
	
    })
    .catch(function(err) {
		alert('클립보드가 비어있습니다.');      
		//console.error("클립보드 내용을 가져오는데 실패했습니다:", err);
    });
}

function clickSpan(e){
	let selectedWord = e.innerText.trim();
	console.log(selectedWord);
	openNewWindow('/note/vocabularyForm.do', '단어장 등록 ');
}






