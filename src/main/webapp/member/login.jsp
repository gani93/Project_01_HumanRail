<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>

 <%
    String clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("YOUR_CALLBACK_URL", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Member.css">

<!-- 카카오톡아디디로로그인 초기화 Script -->
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript"
	src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div>
		<form method="post" name="form" id="loginform">
			<fieldset>
				<div id="box">
					<div id="box_inner">
						<h1 class="tall" id="login_h1">로그인</h1>
						<div class="tall" id="login">
							<label>회원 아이디</label><br> <input type="text" name="id"
								size=""><br>
							<br> <label>비밀번호</label><br> <input type="password"
								name="password">
						</div>
						<div class="tall" id="login_button">
							<input type="button" value="로그인" onclick="login()">

							<!--카카오 로그인 버튼-->
							<!--  dc3f322d2ca26630b58c70dd95f62c69 카카오로그인key -->
							<a href="javascript:kakaoLogin();"><img
								src="./Image/login/kakaoLogin.png"
								style="width: 400px; height: 65px;"></a><br>
						</div>
						<div id="find_info_button">
							<input type="button" name="find_info" value="아이디 찾기>>"
								onclick="location.href='RailServlet?command=find_id'">&nbsp;
							<input type="button" name="find_info" value="비밀번호 찾기>>"
								onclick="location.href='RailServlet?command=find_pwd'">
						</div>
						<div id="message">${message}</div>
						<!-- 아이디/비밀번호 불일치시 메세지 띄움 -->
					</div>
					<div id="join_area">
						<input type="button" name="join" value="회원가입"
							onclick="location.href='RailServlet?command=join_form'">
					</div>
				</div>
			</fieldset>


		</form>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>


</body>
</html>