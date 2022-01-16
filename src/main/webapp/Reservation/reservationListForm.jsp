<%@page import="com.rail.dto.TrainVO"%>
<%@page import="com.rail.dto.ReservationVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<ReservationVO> list = (List) request.getAttribute("reservationList");
List<TrainVO> trainList = (List) request.getAttribute("trainList");
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
			<div class="list_h2">
				<h2>온라인 티켓</h2>
			</div>

			<form action="RailServlet?command=ReservationList" method="post">
			<div class="rvlist_cancelbtn">
				<div class="rvlist_topbtn">
					<input type="button" onclick="location.href='RailServlet?command=ReservationListForm'" value="예매 내역 확인">
					<input type="button" onclick="location.href='RailServlet?command=reservationDeleteForm'" value="예매 취소 내역">
				</div>
			</div>
			<%
					if (trainList.size() > 0) {
						for (int i = 0; i < trainList.size(); i++) {
							if (list.get(i).getUseyn() == 1) {
					%>
					<div id="rvlist_topbox">
					<div id="rvlist_boxing">
						<div id="rvlist_innerbox">
						<div id="rvlist_date">출발&nbsp;<%=trainList.get(i).getTrain_date()%>&nbsp;<%=trainList.get(i).getTrain_start_time()%>:00
							->&nbsp;도착&nbsp;
							<%=trainList.get(i).getTrain_date()%>&nbsp;<%=trainList.get(i).getTrain_end_time()%>:00
						</div>
						<!-- 출발일 /출발시간-->
						<div class="rvlist_innerbox2">
							<div class="rvlist_font">출발</div><div class="rvlist_info"><%=trainList.get(i).getTrain_start_place()%></div>
							<div class="rvlist_font">도착</div><div class="rvlist_info"><%=trainList.get(i).getTrain_end_place()%></div>
						</div>
						<div class="rvlist_innerbox2">
							<div class="rvlist_font">열차</div><div class="rvlist_info2"><%=trainList.get(i).getTrain_sub()%></div>
							<div class="rvlist_font">열차번호</div><div class="rvlist_info2"><%=trainList.get(i).getTrain_id()%></div>
							<div class="rvlist_font">예약좌석</div><div class="rvlist_info2"><%=list.get(i).getSeat().toString()%></div>
						</div>

						<div class="rvlist_innerbox3">
							<div class="rvlist_font">금액</div><div class="rvlist_info2"><%=list.get(i).getQuantity() * trainList.get(i).getTrain_money() / 1000%>,000원
							</div>
						</div>
						<div class="rvlist_innerbox3">
							<div class="rvlist_font">결제수단</div><div class="rvlist_info2">카드</div>
							<input type="button" value="예약취소"
							onclick="window.open('RailServlet?command=reservationUPForm&seq=<%=list.get(i).getReservation_seq()%>','delete','top = 200,left=140,width=680,height=800,status=no,menubar=no,toolbar=no,resizable=no,scorllbar=no');">
						</div>
						
					</div>
				</div>
			</div>
			<%-- <td style="width: 100px;"><input type="button" value="예약취소"
							onclick="javascript:openWindowPop('RailServlet?command=reservationUPForm&seq=<%=list.get(i).getReservation_seq()%>','delete')">
						</td> --%>
			<%
			}
			}
			} else {
			%>
			<div id="no_rv">예약 중인 내역이 없습니다.</div>
			<%
			}
			%>


		</form>
	</div>
	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>

</body>
</html>