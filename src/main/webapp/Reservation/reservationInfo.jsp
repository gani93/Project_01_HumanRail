
<%@page import="com.rail.dto.ReservationVO"%>
<%@page import="com.rail.dto.TrainVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
TrainVO tVo = (TrainVO) request.getAttribute("trainVO");
ReservationVO rVo = (ReservationVO) request.getAttribute("reservationVO");
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
<!--여기서 수정 시작 -->
<form action="RailServlet?command=reservationUpdate" method="post">
	<input type="hidden" value="<%=tVo.getTrain_seq() %>"name ="seq">
	<div>
		
		<div id="reservation_topbox">예매취소</div>
		<div id="topbox">
		<div id="boxing">
			<div id="reservation_innerbox">
				<div id="date"><%=tVo.getTrain_date() %>&nbsp;<%=tVo.getTrain_start_time()%>:00</div> <!-- 출발일 /출발시간-->
				<div class="reservation_innerbox2">
					<div class="reservation_font" >출발</div><div class="info"><%=tVo.getTrain_start_place()%></div>
					<div class="reservation_font" >도착</div><div class="info"><%=tVo.getTrain_end_place()%></div>
				</div>
				<div class="reservation_innerbox2">
					<div class="reservation_font">열차</div><div class="info2"><%=tVo.getTrain_sub()%></div>
					<div class="reservation_font">열차번호</div><div class="info2"><%=tVo.getTrain_id()%></div>
					<div class="reservation_font">예약좌석</div><div class="info2"><%=rVo.getSeat().toString() %></div>
				</div>
			
				<div class="reservation_innerbox3">
					<div class="reservation_font">결제일시</div><div class="info2">2021.09.25</div>
				</div>
				<div class="reservation_innerbox3">
					<div class="reservation_font">결제수단</div><div class="info2">카드</div>
				</div>
				<div id="reservation_cancel">
					<div style="font-size: 20px">취소시 유의사항</div><hr>
					<ul id="reservation_cancelinfo">
						<li>사용하지 않은 모든 승차권은 지정차 출발 후 도착 예정시간이 지나면 환불하실 수 없습니다.</li>
						<li>할인승차권 취소시 원요금(할인전) 기준으로 취소 수수료가 부과됩니다.</li>
						<li>취소 수수료는 취소가 완료되는 시점을 기준으로 발행하니 유의하시기 바랍니다.</li>
						<li>신용(체크)카드 환불은 카드사 정책에 따라 평일(은행영업일)기준 3~5일 소요될 수 있습니다.</li>
					</ul><br><br>
				</div>
			</div>
		</div>
	</div>
</div>
	
	
	<div class="reservationbnt" >
	<input type="button" onclick="javascript:self.close();"value="닫기">
		<input type="button" onclick="location.href='RailServlet?command=reservationDelete&seq=<%=rVo.getReservation_seq()%>'"value="예매취소">
	</div>	
	</form>



<!--여기서 수정 끝  -->

</body>
</html>