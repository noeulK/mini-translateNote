/**
 * 
 */

let phrase_var = false;
let bracket_var = false;
let toolFlag = false;
document.addEventListener('DOMContentLoaded', function() {
    var checkboxes = document.querySelectorAll('[name="icons"]');

    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            if (this.checked) {
            	console.log(this.value);
				toolFlag = true;
            	clickedBtn(this.value);
                checkboxes.forEach(function(otherCheckbox) {
                    if (otherCheckbox !== checkbox) {
                        otherCheckbox.checked = false;
                    }
                });
            }else{
	console.log('why is here?')
            	toolFlag = false;
            }
        });
    });
});

function clickSpan(e){
	let selectedWord = e.innerText.trim();
	
	let noteId = document.querySelector('[name="note_id"]').value;
	console.log(selectedWord);
	openNewWindow('/note/vocabularyForm.do?word='+encodeURIComponent(selectedWord)+'&noteId='+encodeURIComponent(noteId), '단어장 등록 ');
}

function putInBracket(e){
	bracket_var = !bracket_var;
	if(bracket_var){
		let newspan = document.createElement('span');
		newspan.classList.add('bracket');
		newspan.classList.add('note-mark');
		newspan.innerText = '( ';
		e.before(newspan);
	}else{
		let newspan = document.createElement('span');
		newspan.classList.add('bracket');
		newspan.innerText = ')';
		e.after(newspan);
	}
	
}

function slashed(e){
	console.log(e);
	let newspan = document.createElement('span');
	newspan.classList.add('slash');
	newspan.classList.add('note-mark');
	newspan.innerText = '/';
	e.before(newspan);
}

function drawTriangle(e){
	console.log(e);
	e.classList.add('triangle');
	e.classList.add('note-mark');
	
}

function drawCircle(e){
	console.log(e);
	e.classList.add('circle');
	e.classList.add('note-mark');
}

function drawRectangle(e){
	e.classList.add('rectangle');
	e.classList.add('note-mark');
}

function clickedBtn(n){
	console.log(n);
	console.log(toolFlag);

	var spans = document.getElementsByClassName('word_span');
	if(toolFlag){
		for(var span of spans){
			span.classList.add('hover_on');
			span.onclick = function() {
				switch(parseInt(n)){
					case 1: clickSpan(this); break;
					case 2: putInBracket(this); break;
					case 3: slashed(this); break;
					case 4: drawTriangle(this); break;
					case 5: drawCircle(this); break;
					case 6: drawRectangle(this); break;
				}
	        }
		}
	}else{
		for(var span of spans){
			span.classList.remove('hover_on');
			span.onclick = function() {
	        	
	        }
		}
	}
	
}

