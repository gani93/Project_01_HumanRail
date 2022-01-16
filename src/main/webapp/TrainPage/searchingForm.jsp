<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.rail.dto.MemberVO"%>
<%@page import="com.rail.dto.TrainVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<TrainVO> startList = (List) request.getAttribute("TrainStartPlace");
List<TrainVO> endList = (List) request.getAttribute("TrainEndPlace");
MemberVO user = (MemberVO) session.getAttribute("loginUser");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Calendar c1 = Calendar.getInstance();
String strToday = sdf.format(c1.getTime());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HumanRail</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Train.css">
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div class="content" style="background-image:url('./Image/TrainButton/trainbackground.jpg'); opacity: 0.9; /* background-size: cover; */">
		<img >
		<div id="outerbox">
			<div class="searchBanner">
					<div id="rv_h2"><h2>BOOK YOUR<br> TRAIN<br> TICKET</h2></div>
					<!-- <h4>편안한 좌석과 최상의 서비를 휴먼레일에서 함께 해보세요.</h4> -->
			</div>
			<div class="searchBanner">
				<form action="RailServlet?command=TrainSearch" method="post" id="train_form">
						<div class="from">
							<div >출발역
								<select name="Train_start_place" id="Train_start_place" class="from_info"
									size="1">
										<option value="total">출발역을 선택하세요.</option>
										<%
										for (int i = 0; i < startList.size(); i++) {
										%>
										<option value="<%=startList.get(i).getTrain_start_place()%>"><%=startList.get(i).getTrain_start_place()%></option>
										<%
										}
										%>
								</select>
							</div>
						</div>
						<div class="from">
							<div>도착역
								<select name="Train_end_place" id="Train_end_place" class="from_info"
									size="1">
										<option value="total">도착역을 선택하세요.</option>
										<%
										for (int i = 0; i < endList.size(); i++) {
										%>
										<option value="<%=endList.get(i).getTrain_end_place()%>"><%=endList.get(i).getTrain_end_place()%></option>
										<%
										}
										%>
								</select>
							</div>
						</div>
						<div class="from" id="ab">
							<div id="train_date">출발날짜
								<input name="Train_date" type="date" value="<%=strToday %>">
							</div>
						<div id="train_button">
							<button onclick="submit();">SHOW TRAIN</button>
						</div>	
						</div>
				</form>
		</div>
		</div>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>

</body>
</html>