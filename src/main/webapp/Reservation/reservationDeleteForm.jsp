<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.rail.dto.TrainVO"%>
<%@page import="com.rail.dto.ReservationVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<ReservationVO> list = (List) request.getAttribute("reservationList");
List<TrainVO> trainList = (List) request.getAttribute("trainList");
Calendar cal = Calendar.getInstance();
cal.setTime(new Date());
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
System.out.println("current: " + df.format(cal.getTime()));

cal.add(Calendar.MONTH, -1);
System.out.println("after: " + df.format(cal.getTime()));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HumanRail</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Reservation.css">
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div class="content">
	<div class="col-md-10 offset-md-1 form-1-box wow fadeInUp">
		<fieldset class="form-group border p-3">
			<legend class="w-auto px-2">예약 취소 내역</legend>

			<form action="RailServlet?command=ReservationList" method="post">
				<table style="text-align: center;" class="reservationbnt" >
					<tr>
						<td colspan="10" style="text-align: right;">
							<input type="button" onclick="location.href='RailServlet?command=ReservationListForm'"
							value = "예약 중인 내역"></td>
					</tr>
					<tr>
						<th width="50px"></th>
						<th width="120px">예약취소일</th>
						<th width="120px">출발일</th>
						<th width="120px">열차</th>
						<th width="120px">열차번호</th>
						<th width="120px">출발시간</th>
						<th width="120px">도착시간</th>
						<th width="120px">출발역</th>
						<th width="120px">도착역</th>
						<th width="120px">예약좌석</th>
						<th width="120px">금액</th>

					</tr>
					<%
					if (list.size()>0) {
						for (int i = 0; i < trainList.size(); i++) {
							if (list.get(i).getUseyn() == 0) {
					%>
					<tr>
						<td style="font-weight: bold;"><%=i + 1%></td>
						<td><%=list.get(i).getDate() %></td>
						<td><%=trainList.get(i).getTrain_date() %></td>
						<td><%=trainList.get(i).getTrain_sub()%></td>
						<td><%=trainList.get(i).getTrain_id()%></td>
						<td><%=trainList.get(i).getTrain_start_time()%>시</td>
						<td><%=trainList.get(i).getTrain_end_time()%>시</td>
						<td><%=trainList.get(i).getTrain_start_place()%></td>
						<td><%=trainList.get(i).getTrain_end_place()%></td>
						<td><%=list.get(i).getSeat().toString()%></td>
						<td><%=list.get(i).getQuantity() * trainList.get(i).getTrain_money()/1000%>,000원</td>
					</tr>
					<%
					}
					}
					} else {
					%>
					<tr style="text-align: center;">
						<td colspan="10">취소하신 내역이 없습니다.</td>
					</tr>
					<%
					}
					%>

				</table>
			</form>
		</fieldset>
	</div>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>