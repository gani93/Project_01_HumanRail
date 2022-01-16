<%@page import="com.rail.dto.MemberVO"%>
<%@page import="com.rail.dto.TrainVO"%>
<%@page import="com.rail.dao.TrainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%
TrainVO tvo = (TrainVO) request.getAttribute("getTrain");
MemberVO user = (MemberVO)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HumanRail</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
</head>
<body>
<jsp:include page="../Menu/header.jsp"></jsp:include>
<!--여기서 수정 시작 -->
<div class="content">
<table >
		<tr>
			<th>열차</th>
			<td><%=tvo.getTrain_sub()%></td>
		</tr>
		<tr>
			<th>열차번호</th>
			<td><%=tvo.getTrain_id()%></td>
		</tr>
		<tr>
			<th>인원수</th>
			<td><%=tvo.getTrain_member()%></td>
		</tr>
		<tr>
			<th>출발시간</th>
			<td><%=tvo.getTrain_start_time()%></td>
		</tr>
		<tr>
			<th>도착시간</th>
			<td><%=tvo.getTrain_end_time()%></td>
		</tr>
		<tr>
			<th>출발역</th>
			<td><%=tvo.getTrain_start_place()%></td>
		</tr>
		<tr>
			<th>도착역</th>
			<td><%=tvo.getTrain_end_place()%></td>
		</tr>
		<tr>
			<th>타는곳</th>
			<td><%=tvo.getTrain_form()%></td>
		</tr>
		<tr>
			<th>출발날짜</th>
			<td><%=tvo.getTrain_date()%></td>
		</tr>
		<tr>
			<th>금액</th>
			<td><%=tvo.getTrain_money()%></td>
		</tr>
		<tr>		<%-- <tr><%if(user!=null && user.getAdminnum().equals("1")){ %>
			<td><a href="RailServlet?command=TrainDeleteForm&seq=<%=tvo.getTrain_seq()%>">차량삭제하기</a></td>
			<%} %> --%>
			<td><input type="button" onclick="history.go(-1)"value="이전"></td>
		</tr>
	</table>
</div>
<!--여기서 수정 끝  -->
<jsp:include page="../Menu/footer.jsp"></jsp:include>

</body>
</html>