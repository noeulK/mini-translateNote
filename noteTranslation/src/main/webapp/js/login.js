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
	console.log(checkEmail(email));
	if(checkEmail(email)){
		let loginForm = $('[role="loginForm"]').serialize();
		$.ajax({
			url : '/login/login.do',
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

function checkEmail(email){
	const emailRegex = new RegExp('^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$');
	return emailRegex.test(email);
}