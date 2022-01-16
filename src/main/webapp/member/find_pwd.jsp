<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Member.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/emailjs-com@3/dist/email.min.js"></script>
<script type="text/javascript">
	var i = 0;
	$(document).ready(function() {
		emailjs.init("user_W7dHxd47cdTpViuPmuXCL");
		//"user_xxxxx"이 부분은 사용자마다 다르니 반드시 emailJS의 installation 화면을 확인
		$('input[name=take]').click(function() {

			var templateParams = {
				//각 요소는 emailJS에서 설정한 템플릿과 동일한 명으로 작성
				to_email : $('input[name=to_email]').val(),
				message : $('input[name=message]').val(),
			};
			var to_email = $('input[name=to_email]').val().toString().trim();
			var email = $('input[name=email]').val().toString().trim();
			console.log('입력한 이메일=' + to_email);
			console.log('회원가입시 이메일=' + email);

			if (to_email == email) {

				alert('임시 비밀번호가 발송되었습니다.');

				emailjs.send('gmail', 'template_njmzdr1', templateParams)
				//emailjs.send('service ID', 'template ID', 보낼 내용이 담긴 객체)
				.then(function(response) {
					console.log('메일보내기 성공!', response.status, response.text);
					//var email = $('input[name=email]').val();	

					var random = $('input[name=message]').val();
					var id = $('input[name=id]').val();
					document.form2.submit();

				}, function(error) {
					console.log('FAILED...', error);
				});
			} else {
				alert('이메일이 일치하지 않습니다.');
				console.log('입력한 이메일=' + to_email);
				console.log('회원가입시 이메일=' + email);
			}
		});
	});
</script>
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div id="findarea">
		<div id="findidguide">
			<h1 class="user_h1">회원 비밀번호 찾기</h1>
			<p>
				회원님의 개인정보 보호를 위해 개인정보 확인을 통해 찾으실 수 있습니다.<br> <span
					style="color: red">* [ 전체 항목 필수 입력 사항입니다. ]</span>
			</p>
			<%!int getRandom() {
		int random = 0;
		random = (int) Math.floor((Math.random() * (99999 - 10000 + 1))) + 10000;
		return random;
	}%>
			<c:if test="${result==-1 }">
				<form action="RailServlet?command=show_pwd" method="post"
					class="findpwdform" name="form1">
					<div>
						<div class="findid">
							아이디<input type="text" name="id" value="${id }">
						</div>
						<div class="findid">
							이름<input type="text" name="name" value="${name }">
						</div>
						<div class="find_button">
							<input type="hidden" name="email" value="${email}"> <input
								type="submit" value="비밀번호 찾기"><br>
							<div id="message">${message}</div>
						</div>
					</div>
				</form>
			</c:if>
			<c:if test="${result==1 }">
				<form action="RailServlet?command=send_email" method="post"
					class="findpwdform" name="form2">
					<div>
						<div class="findid">
							아이디<input type="text" name="id" value="${id }">
						</div>
						<div class="findid">
							이름<input type="text" name="name" value="${name }">
						</div>
						<div class="find_button">
							<input type="submit" value="비밀번호 찾기"><br>
							<div id="message">${message}</div>
						</div>
					</div>
					<input type="hidden" name="message" value="<%=getRandom()%>" /> <input
						type="hidden" name="email" value="${email}"> 회원가입 시 입력한
					이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>

					<div class="findid">
						이메일<input type="text" name="to_email">
					</div>
					<div class="find_button">
						<input type="button" name="take" id="btn" value="인증번호 받기" />
					</div>
				</form>
			</c:if>
		</div>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>





