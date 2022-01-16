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
	<div class="show">
		<div class="findh1">
			<h1 class="showinfo_h1">PASSWORD SEARCH</h1>
		</div>
		<div class="showinfo_wrap">
			<div class="showinfo">
				<img src="./Image/join/okcheck.png" id="findok_img"><br>
				입력하신 정보와 일치하는 회원 비밀번호는 아래와 같습니다.
			</div>
			<div class="joinokbox">
				<div class="test1">비밀번호</div>
				<div class="test2">${password}</div>
			</div>
			<div class="showbutton">
				<input type="submit" value="로그인"
					onclick="location.href='RailServlet?command=login_form'"> <input
					type="submit" value="아이디찾기"
					onclick="location.href='RailServlet?command=find_id'">
			</div>
		</div>
	</div>
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>