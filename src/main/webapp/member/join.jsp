<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String birthday = request.getParameter("birthday");
if (name == null && email == null && birthday == null) {
	name = "";
	email = "";
}
int kakao = 0;
if (birthday != null) {
	kakao = 1;
} else {
	kakao = 0;
}
%>
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
			<h1 class="user_h1">회원가입</h1>
			<p id="p">
				휴먼레일 회원이 아닌 경우, 온라인 회원으로 가입하시면 휴먼레일 회원으로도 별도 가입됩니다.<br> 오프라인 회원
				및 온라인 회원 자격을 각각 유지하는 동안 회원의 개인정보는 별도의 개인정보처리시스템에 저장되어 관리 됩니다.<br>
				<span style="color: red">* [ 전체 항목 필수 입력 사항입니다. ]</span>
			<p>
		</div>
		<div class="jointall" id="sidebox">
			<h2 class="user_h2">회원정보 입력</h2>
		</div>
		<div class="jointall" id="formbox">
			<form method="post" name="form" class="joinform">
				<input type="hidden" name="kakao" value=<%=kakao%>>
				<ul>
					<li><label>이름<br>
						<input type="text" name="name" value="<%=name%>"></label></li>
					<li><label>아이디<br>
						<input type="text" name="id" placeholder="아이디를 입력하고 중복확인을 체크해주세요.">
							<input type="hidden" name="reid"> <input type="button"
							name="id_chk" value="중복확인" onclick="idCheck()"></label>
					<li><label>비밀번호<br>
						<input type="password" name="password"></label>
					<li><label>비밀번호 확인<br>
						<input type="password" name="password_chk"></label>
					<li><label>이메일<br>
						<input type="text" name="email" placeholder="예)홍길동@humanrail.com"
							value="<%=email%>"></label>
					<li><label>생 년 월 일<br>
						<input type="text" name="birth" placeholder="출생년도(6자)"></label>
					<li><label>휴대전화<br>
						<input type="text" name="phone" placeholder="전화번호 입력"></label>
				</ul>
			</form>
			<div class="updatebtnzone">
				<div class="joinbutton" id="cancelbutton">
					<%
					if (birthday != null) {
					%>
					<input type="button" value="이전" onclick="goback()">
					<%
					} else {
					%>
					<input type="button" value="이전"
						onclick="javascript:history.go(-1);">
					<%
					}
					%>
				</div>
				<div class="joinbutton" id="savebutton">
					<input type="button" value="가입" onclick="join()">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>