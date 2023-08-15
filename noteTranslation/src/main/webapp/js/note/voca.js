/**
 * 
 */
const urlParams = new URLSearchParams(window.location.search);
	const receivedData = urlParams.get('word').trim();
	const noteId = urlParams.get('noteId');
	console.log(receivedData.replace("\"",''));
	
	if(receivedData){
		let word_input = document.querySelector('[name="voca_word"]');
		word_input.value = removeSpecialCharacters(receivedData);
	}
	
	function saveVoca(){
		var voca_word = document.querySelector('[name="voca_word"]').value;
		var voca_meaning = document.querySelector('[name="voca_meaning"]').value;
		var voca_pos = document.querySelector('.clicked-td').textContent;
		
		if(voca_word && voca_meaning){
			var voca_confirm = confirm('단어를 등록하시겠습니까? ');
			if(voca_confirm){
				console.log('pass');
				
				$.ajax({
					url : 'saveVoca.do',
					type : 'post',
					data : {'voca_word': voca_word,
						'voca_meaning' : voca_meaning,
						'note_id' : noteId,
						'pos' : voca_pos
					},
					dataType : 'json',
					success : function(data){
						console.log(data);
						if(data.status == 'OK'){
							cancel();
						}
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
	
	
	function removeSpecialCharacters(inputText) {
	    // 맨 앞과 맨 뒤에 있는 특수 문자를 검색하기 위한 정규 표현식
	    var regex = /^[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-/]+|[!@#$%^&*()_+{}\[\]:;<>,.?~\\/-]+$/g;

	    // 입력된 텍스트에서 맨 앞과 맨 뒤의 특수 문자를 제거
	    var cleanedText = inputText;
	    console.log(cleanedText);
		var firstChar = inputText[0];
		var lastChar = inputText[inputText.length -1];
		if(regex.test(firstChar)){
			console.log(firstChar);
			cleanedText = inputText.replace(firstChar,'');
		}else{
			console.log('첫번째 글자에 특수문자 없음 ');
			
		}
		
		if(regex.test(lastChar)){
			console.log(lastChar)
			cleanedText = inputText.replace(lastChar,'');
		}else{
			console.log('마지막 글자에 특수문자 없음 ');
		}
	    return cleanedText;
	}