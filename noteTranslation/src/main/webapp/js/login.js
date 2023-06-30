function toggleEye(){
	const svgIcon = document.querySelector('svg.icon');
	let password = document.querySelector('[name="password"]');
  // 아이콘 변경 로직
  if (svgIcon.classList.contains('eye-on')) {
    svgIcon.outerHTML = '<svg xmlns="http://www.w3.org/2000/svg" class="icon eye-off"  width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><line x1="3" y1="3" x2="21" y2="21" /><path d="M10.584 10.587a2 2 0 0 0 2.828 2.83" /><path d="M9.363 5.365a9.466 9.466 0 0 1 2.637 -.365c4 0 7.333 2.333 10 7c-.778 1.361 -1.612 2.524 -2.503 3.488m-2.14 1.861c-1.631 1.1 -3.415 1.651 -5.357 1.651c-4 0 -7.333 -2.333 -10 -7c1.369 -2.395 2.913 -4.175 4.632 -5.341" /></svg>'
    showPassword(password);
  } else {
    svgIcon.outerHTML = '<svg xmlns="http://www.w3.org/2000/svg" class="icon eye-on" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="2"></circle><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333 -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7"></path></svg>';
    hidePassword(password);
  }
}

function showPassword(password){
	password.type="text";
}

function hidePassword(password){
	password.type="password";
}

function loginGo(){
	let email = document.querySelector('[name="user_email"]').value;
	//console.log(checkEmail(email));
	if(checkRexEmail(email)){
		let loginForm = $('[role="loginForm"]').serialize();
		$.ajax({
			url : 'login/login.do',
			data : loginForm,
			method: 'post',
			dataType : 'json',
			success : function(data){
				console.log('go to the main page')
			},
			error : function(xhr){
				
			}
		})
	}else{
		let email_input = document.querySelector('[name="user_email"]');
		email_input.classList.add('is-invalid');
		return;
	}
}

// 이메일 정규식 확인, 이메일 중복 확인 
function checkEmail(email){
	if(checkRexEmail(email.value)){
		let res = checkAccount(email.value);
		if(res.status == "OK"){
			email.classList.add('is-valid');
			return true;
		}else{
			document.querySelector('.email_msg').innerText = res.msg;
			email.classList.add('is-invalid');
			return false;
		}
	}else{
		email.classList.add('is-invalid');
		return false;
	}
}
function checkRexEmail(email){
	const emailRegex = new RegExp('^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$');
	return emailRegex.test(email);
}

//닉네임 정규식 확인, 중복 확인 
function checkNickname(nickname){
	console.log('nick name : ',checkRexNickname(nickname.value))
	if(checkRexNickname(nickname.value)){
		let res = checkDuplicateNickname(nickname.value);
		console.log('skdjalsdjs ', res)
		if(res.status == "OK"){
			nickname.classList.add('is-valid');
			return true;
		}else{
			document.querySelector('.name_msg').innerText = res.msg;
			nickname.classList.add('is-invalid');
			return false;
		}
	}else{
		mickname.classList.add('is-invalid');
		return false;
	}
}
function checkRexNickname(nickname){
	const nicknameRegex = new RegExp('^[가-힣a-zA-Z0-9]{2,10}$');
	return nicknameRegex.test(nickname);
}

function checkPassword(pass){
	if(checkRexPassword(pass.value)){
		pass.classList.add('is-valid');
		return true;
	}else{
		pass.classList.add('is-invalid');
		return false;
	}
}

function checkRexPassword(pass){
	const passwordRegex = new RegExp('^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$');
	return passwordRegex.test(pass);
}

function checkAccount(email){
	let res;
	$.ajax({
		url: "checkAccount.do",
		type:'post',
		data: {
			"user_email" : email
		},
		dataType : "json",
		async: false,
		success : function(data){
				res = data;
		},
		error : function(xhr){
			console.log('error ',xhr.status)
		}
		
	});
	return res;
}

function checkDuplicateNickname(nickname){
	let res;
	$.ajax({
		url: "checkDuplicateNickname.do",
		type: 'post',
		data: {
			"nickname" : nickname
		},
		dataType : "json",
		async: false,
		success : function(data){
			console.log('name ',data);
			res = data;
		},
		error : function(xhr){
			
		}
	});
	return res;
}

function signUp(){
	clearForm();
	let email = document.querySelector('[name="user_email"]');
	let nickname = document.querySelector('[name="nickname"]');
	let pass = document.querySelector('[name="password"]');
	
	
	if(checkEmail(email) && checkNickname(nickname) && checkPassword(pass)){
		let signForm = $('[role="signUpForm"]').serialize();
		console.log('sign form ', signForm);
		$.ajax({
			url : "signUp.do",
			data : signForm,
			type : 'post',
			dataType : 'json',
			success : function(data){
				console.log('sign up ', data)
				if(data.status == "OK"){
					alert(data.msg);
					location.href = "loginForm.do";
				}else{
					alert("현재 시스템이 정상적으로 동작하지않습니다.");
				}
			},
			error : function(xhr){
				
			}
		});
	}
}

function clearForm(){
	document.querySelector('[name="user_email"]').classList.remove('is-invalid');
	document.querySelector('[name="nickname"]').classList.remove('is-invalid');
	document.querySelector('[name="password"]').classList.remove('is-invalid');
	
	document.querySelector('.email_msg').innerText = "";
	document.querySelector('.name_msg').innerText = "";
}





