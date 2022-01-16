<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Member.css" >
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
	 	<h2>기본정보</h2>
	 </div>
	 <div class="jointall" id="formbox">
		<form method="post" name="form" class="joinform">
			<ul >
				<li>
					<label>이름<br><input type="text" name="name" value="${name }" readonly="readonly"></label>
				</li>
				<li>
					<label>아이디<br><input type="text" name="id" value="${id }" readonly="readonly"></label>
				</li>
				<li>
					<label>이메일<br><input type="text" name="email" value="${email }" readonly="readonly"></label>
				</li>
				<li>
					<label>생 년 월 일<br><input type="text" name="birth" value="${birth }" readonly="readonly"></label>
				</li>
				<li>
					<label>휴대전화<br><input type="text" name="phone" value="${phone }" readonly="readonly"></label>
				</li>
			</ul>
		</form>
		<div class="updatebtnzone">
			<div class="joinbutton" id="cancelbutton">
				<input type="button" value="이전" onclick="goback()"> 
			</div>
			<div class="joinbutton" id="savebutton">
				<input type="button" value="변경" onclick="location.href='RailServlet?command=updateform'">
			</div>	
		</div>
	</div>
</div>

<!--여기서 수정 끝  -->
<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>