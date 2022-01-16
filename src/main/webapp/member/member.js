function login() {
 if(document.form.id.value == "") {
		form.id.focus();
		alert("아이디를 입력하세요.");
	}else if(document.form.password.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		form.password.focus();
	} else {
		document.form.action = "RailServlet?command=login";
		document.form.submit();
	}
}

function join() {
	if(document.form.name.value == "") {
		form.name.focus();
		alert("이름을 입력하세요.");
	}else if(document.form.id.value == "") {
		form.id.focus();
		alert("아이디를 입력하세요.");
	}else if (document.form.id.value != document.form.reid.value) {
   	 	alert("중복확인을 클릭하여 주세요.");
  		document.formm.id.focus();
 	 }else if(document.form.password.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		form.password.focus();
	}else if(document.form.password.value.length == 0) {
		alert("비밀번호 확인을 입력하세요.");
		form.password.focus();
	}else if(document.form.password.value != document.form.password_chk.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.password.focus();
	}else if(document.form.email.value == "") {
		form.email.focus();
		alert("이메일을 입력하세요.");
	}else if(document.form.birth.value == "") {
		alert("생년월일을 입력하세요.");
		form.birth.focus();
	}else if(document.form.phone.value == "") {
		alert("휴대폰 번호를 입력하세요.");
		form.phone.focus();
	}else {
	document.form.action = "RailServlet?command=join";
	document.form.submit();
	}
}

function idCheck() {
	var PoPurl = "RailServlet?command=id_check&id=" + document.form.id.value;
	window.open(PoPurl, "_blank_1",
		"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=250");
}

function update() {
	if(document.form.name.value == "") {
		form.name.focus();
		alert("이름을 입력하세요.");
 	 }else if(document.form.password.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		form.password.focus();
	}else if(document.form.password.value.length == 0) {
		alert("비밀번호 확인을 입력하세요.");
		form.password.focus();
	}else if(document.form.password.value != document.form.password_chk.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.password.focus();
	}else if(document.form.email.value == "") {
		form.email.focus();
		alert("이메일을 입력하세요.");
	}else if(document.form.birth.value == "") {
		alert("생년월일을 입력하세요.");
		form.birth.focus();
	}else if(document.form.phone.value == "") {
		alert("휴대폰 번호를 입력하세요.");
		form.phone.focus();
	}else {
	document.form.action = "RailServlet?command=update";
	document.form.submit();
	}
}


Kakao.init("d55b38845c2bf5bee56bf835e25ac3df");
console.log(Kakao.isInitialized());
function goback() {
    if (Kakao.Auth.getAccessToken()) {
      //토큰이 있으면
      Kakao.API.request({
        //로그아웃하고
        url: '/v1/user/unlink',
        success: function (response) {
          //console.log(response)
		location.replace("RailServlet?command=login_form");
        },
        fail: function (error) {
          console.log(error);
        },
      })
      
      
    }
  }
//토큰도 삭제
      //Kakao.Auth.setAccessToken(undefined)
