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
	<div id="findarea">
		<div id="findidguide">
			<h1 class="user_h1">회원 아이디 찾기</h1>
			<p>
				회원님의 개인정보 보호를 위해 개인정보 확인을 통해 찾으실 수 있습니다.<br> <span
					style="color: red">* [ 전체 항목 필수 입력 사항입니다. ]</span>
			</p>
		</div>
		<div>
			<!-- 아이디 알려주는 페이지로 이동 -->
			<form action="RailServlet?command=show_id" method="post"
				id="findidform">
				<div class="findid">
					이&nbsp;&nbsp;름 <input type="text" id="id" name="name">
				</div>
				<div class="findid">
					이메일 <input type="text" id="email" name="email">
				</div>
				<div class="find_button">
					<input type="submit" value="아이디 찾기">
				</div>
				<br>
				<div id="info_message">${ message}</div>
			</form>
		</div>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>


</body>
</html>