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
	<div class="joinsuccess">
		<div class="show">
			<div class="findh1">
				<h1 class="showinfo_h1">JOIN SUCESS</h1>
			</div>
			<div class="showinfo_wrap">
				<div class="showinfo">
					<img src="./Image/join/okcheck.png" id="findok_img"><br>
					회원 가입이 완료되었습니다.
					<h4 id="joinok_h4">
						지금부터 휴먼 레일의 다양한 혜택들을<br> 이용하실 수 있습니다.
					</h4>
				</div>
				<div class="joinokbox">
					<div class="test1">
						성명<br>아이디<br>이메일
					</div>
					<div class="test2">${name }<br>${id }<br>${email }</div>
				</div>
				<div class="showbutton">
					<input type="button" value="확인"
						onclick="location.href='RailServlet?command=login_form'">
				</div>
			</div>
		</div>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>


</body>
</html>