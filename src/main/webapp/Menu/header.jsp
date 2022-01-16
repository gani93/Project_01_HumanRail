<%@page import="com.rail.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberVO user = (MemberVO) session.getAttribute("loginUser");
%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script type="text/javascript"
	src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript" src="member/kakaolog.js"></script>
<nav class="navbar navbar-dark navbar-expand-lg"
	style="background-color: #96B5D9;">
	<div class="container-fluid">
		<div class="row text-center">
			<a href="RailServlet?command=index"> <img
				src="./Image/logo/logo.png" alt="logo" width="200" height="65"
				style="margin-left: 180px;">
			</a>
		</div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-center text-light"
			id="navbarSupportedContent">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="RailServlet?command=noticelist">공지사항</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="RailServlet?command=TrainSearchForm">기차 예매</a></li>
				<li class="nav-item"><a class="nav-link "
					href="RailServlet?command=ReservationListForm">승차권 확인</a></li>
				<li class="nav-item">
					<%
					if (user != null) {
					%> ${loginUser.name} <%if(user.getKakao()==1){ %><a href="javascript:kakaoLogout()"><%}else{ %><a href="RailServlet?command=logout"><%} %>(로그아웃)</a> 
					<a class="nav-link" href="RailServlet?command=mypage_form">마이페이지</a> <%
 } else {
 %> <a class="nav-link" href="RailServlet?command=login_form">로그인</a> <%
 }
 %> 
				</li>
			</ul>
		</div>
	</div>
</nav>