<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Member.css">
<script type="text/javascript" src="member/member.js"></script>
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div id="joinarea">
		<div id="joinguide">
			<h1>나의정보</h1>
		</div>
		<div class="jointall" id="sidebox">
			<h2>회원정보 수정</h2>
		</div>
		<div class="jointall" id="formbox">
			<form method="post" name="form" class="joinform">
				<ul>
					<li><label>이름<br>
						<input type="text" name="name" value="${name} "></label></li>
					<li><label>아이디 &nbsp;&nbsp;<span
							style="color: red; font-size: 13px;">*&nbsp;수정이 불가합니다.</span><br>
						<input type="text" name="id" value="${id }" readonly="readonly"></label>
					</li>
					<li><label>비밀번호<br>
						<input type="password" name="password"></label></li>
					<li><label>비밀번호 확인<br>
						<input type="password" name="password_chk"></label></li>
					<li><label>이메일<br>
						<input type="text" name="email" value="${email }"
							placeholder="예)홍길동@humanrail.com"></label></li>
					<li><label>생 년 월 일<br>
						<input type="text" name="birth" value="${birth }"
							placeholder="출생년도(6자)"></label></li>
					<li><label>휴대전화<br>
						<input type="text" name="phone" value="${phone }"
							placeholder="전화번호 입력"></label></li>
				</ul>
			</form>
			<div class="updatebtnzone">
				<div class="joinbutton" id="cancelbutton">
					<input type="button" value="이전" onclick="goback(-1)">
				</div>
				<div class="joinbutton" id="savebutton">
					<input type="button" value="수정" onclick="update()">
					<!-- member.js 로 이동 -->
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>