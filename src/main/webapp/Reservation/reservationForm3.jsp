<%@page import="com.rail.dto.ReservationVO"%>
<%@page import="java.util.List"%>
<%@page import="com.rail.dto.TrainVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
TrainVO tvo = (TrainVO) request.getAttribute("getTrain");
int seq = Integer.parseInt(request.getParameter("seq"));
List<String> reservationList = (List<String>) request.getAttribute("getReservation");
String[] allSeat = null;
String seat = "0";
int select = Integer.parseInt(request.getParameter("select"));
int max = 200;
int min = 1;
/* String seat=null;
String seat_Num = list.get(i).getSeat().trim();
int start = seat_Num.indexOf("["); */
%>
<%-- <div><%for(int i=0; i<list.size(); i++){
		%>
		<h1>리스트 갑니다</h1>
		<%for(int j=0; j<1;j++){
			String seat=null;
			String seat_Num = list.get(i).getSeat().trim();
			int start = seat_Num.indexOf("[");
			if(start!=-1){
				int end = seat_Num.indexOf("]",start+1);
				if(end!=-1){
					seat = seat_Num.substring(start+1,end);
				}
			}
			for(int k= 0; k<seat.split(",").length;k++){
				String[] allSeat = seat.split(",");
			%>
			<p><%=allSeat[k]%></p>
			<%}
		}
			%>
		
		<%
	}
		%></div> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HumanRail</title>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/Reservation.css?after">
<script src="./Reservation/reservation.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
window.history.forward();
function noBack(){window.history.forward();}
$(function(){
	var money = $("#money").text().replace("원","");
	money = money.replace(",","");
	money=Number(money);
    $("input:checkbox").click(function(){
		if($(this).is(':checked')){
			var price = 0;
			var check_num = $("input:checkbox:checked").length;			
			
			price = money*check_num;
			
			if(price==0){
				$("#money").text(price+"원");
			}else{
				$("#money").text(price/1000+",000원");
			}
			
		}else{
			var price = 0;
			var check_num = $("input:checkbox:checked").length;			
			
			price = money*check_num;
			console.log(price);
			
			if(price==0){
				$("#money").text(price+"원");
			}else{
				$("#money").text(price/1000+",000원");
			}
		}
	});
    var check_box_num = $("input:checkbox").length;
    var non_check_box = $("input:checkbox:disabled").length;
    var seat=check_box_num-non_check_box;
    $("#nonseat").text("남은좌석: "+seat);
    console.log(check_box_num);
    console.log(non_check_box);

     
 });
</script>
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<!--여기서 수정 시작 -->
	<div>
		<form action="RailServlet?command=ReservationInsert&seq=<%=seq%>"
			method="post" name="form" onsubmit="return reservationCheck()">
			<!--  -->
			<input type="hidden" id="train_ho" value = <%=select %>>
			<h2 class="list_h2">열차 예매</h2>
			<div class="reservationTotal">
				<div class="reservationInfo">
				<p style="padding-top: 30px;padding-left: 50px;"><%=tvo.getTrain_date().replaceAll("-", ".")%></p>
				<div style="display: flex;height: 55px;margin-left: 30px;border: 3px solid;width: 200px;border-radius: 80px;box-sizing: border-box;">
				<p style="background-color: white;border-radius: 18px 0px 0px 18px;width: 50px;height: 50px;color: darkblue;line-height: 50px;text-align: center;float: left;">출발</p>
				<p style=" padding-left: 30px; height: 50px; line-height: 50px;clear: both;"><%=tvo.getTrain_start_place()%></p>
				</div>
				<div style="padding-left: 30px; ">
						<h1 style="padding-bottom: 5px;">↓</h1>
					</div>
				<div style="display: flex;height: 55px;margin-left: 30px;border: 3px solid;width: 200px;border-radius: 80px;box-sizing: border-box;">
				<p	style="background-color: white;border-radius: 18px 0px 0px 18px;width: 50px;height: 50px;color: darkblue;line-height: 50px;text-align: center;">도착</p>
				<p style="padding-left: 30px; height: 50px; line-height: 50px;"><%=tvo.getTrain_end_place()%></p>
				</div>
				<div style="border-bottom: 2px solid white; width: 300px; margin: auto; padding-top: 50px;">
						<p style="padding-left: 30px;">열차 정보</p>
					</div>
					<div
						style="border-bottom: 1px solid white; width: 300px; margin: auto; display: flex; padding-top: 10px;">
						<p style="padding-left: 30px; width: 100px;">열차 종류</p>
						<p style="padding-left: 80px;"><%=tvo.getTrain_sub()%></p>
					</div>
					<div
						style="border-bottom: 1px solid white; width: 300px; margin: auto; display: flex; padding-top: 10px;">
						<p style="padding-left: 30px; width: 100px;">열차 번호</p>
						<p style="padding-left: 80px;"><%=tvo.getTrain_id()%></p>
					</div>
					<div
						style="border-bottom: 1px solid white; width: 300px; margin: auto; display: flex; padding-top: 10px;">
						<p style="padding-left: 30px; width: 100px;">출발 시간</p>
						<p style="padding-left: 80px;"><%=tvo.getTrain_start_time()%>시
						</p>
					</div>
					<div
						style="border-bottom: 1px solid white; width: 300px; margin: auto; display: flex; padding-top: 10px;">
						<p style="padding-left: 30px; width: 100px;">도착 시간</p>
						<p style="padding-left: 80px;"><%=tvo.getTrain_end_time()%>시
						</p>
					</div>
					<div
						style="border-bottom: 1px solid white; width: 300px; margin: auto; display: flex; padding-top: 10px;">
						<p style="padding-left: 30px; width: 100px;">금액</p>
						<p style="padding-left: 80px;" id="money"><%=tvo.getTrain_money() / 1000%>,000원
						</p>
					</div>
					<div style="padding-top:10px; padding-left: 30px; display: flex;">
						<p>호차 선택</p>
						<select name="select" onchange="location.href=this.value"
							class="select">
							<option
								value="RailServlet?command=ReservationForm&seq=<%=seq%>&select=1"
								<%if (select == 1) {%> selected <%}%>>1호차</option>
							<option
								value="RailServlet?command=ReservationForm&seq=<%=seq%>&select=2"
								<%if (select == 2) {%> selected <%}%>>2호차</option>
							<option
								value="RailServlet?command=ReservationForm&seq=<%=seq%>&select=3"
								<%if (select == 3) {%> selected <%}%>>3호차</option>
							<option
								value="RailServlet?command=ReservationForm&seq=<%=seq%>&select=4"
								<%if (select == 4) {%> selected <%}%>>4호차</option>
							<option
								value="RailServlet?command=ReservationForm&seq=<%=seq%>&select=5"
								<%if (select == 5) {%> selected <%}%>>5호차</option>
						</select>
					</div>
					<div id = "nonseat">
					
					</div>
					<div id="reservationbnt">
						<input
							style="width:130px; margin-left: 10px;margin-right:10px; background-color: white; color: darkblue;"
							type="button" onclick="history.go(-1)" value="이전">
						<input
							style="width:130px; margin-left: 0; background-color: white; color: darkblue;"
							type="submit" value="예약하기">
					</div>

				</div>

				<!--  -->


					<div class="seat">
						<%
						if (reservationList != null) {
							//좌석구하기

							for (int i = 0; i < reservationList.size(); i++) {
									
								String seat_Num = reservationList.get(i);
								int start = seat_Num.indexOf("[");
								if (start != -1) {
							int end = seat_Num.indexOf("]", start + 1);
							if (end != -1) {
								seat += "," + seat_Num.substring(start + 1, end);
							}
								}
							}
						}
						%>
						<%
						if (seat != null) {
							switch (select) {
							case 1:
								max = tvo.getTrain_total_member()/5+1;
							
								break;
							case 2:
								min = tvo.getTrain_total_member()/5+1;
								max = min*2-1;
						
								break;
							case 3:
								min = tvo.getTrain_total_member()/5*2+1;
								max = min+tvo.getTrain_total_member()/5;
						
								break;
							case 4:
								min = tvo.getTrain_total_member()/5*3+1;
								max = min+tvo.getTrain_total_member()/5;
					
								break;
							case 5:
								min = tvo.getTrain_total_member()/5*4+1;
								max = min+tvo.getTrain_total_member()/5;
								break;
							}
							for (; min < max; min++) {

								boolean disable_check = false;
								if (seat != null) {
							for (int k = 0; k < seat.split(",").length; k++) {
								seat = seat.replaceAll(" ", "");
								allSeat = seat.split(",");
							}
							for (int j = 0; j < allSeat.length; j++) {
								if (min == Integer.parseInt(allSeat[j])) {
									disable_check = true;
								}
							}
								}
						%>
						<input type="checkbox" name="seat" id="seat<%=min%>"
							value="<%=min%>" <%if (disable_check) {%> disabled <%}%>>
						<label for="seat<%=min%>" <%if (min == 3 || min % 4 == 3) {%>
							style="margin-left: 70px;" <%}%>> <%=min%></label>
						<%
						}
						%>
					</div>
					<%
					}
					%>

				</div>





		</form>

	</div>
	<div style="clear: both;"></div>


	<!--여기서 수정 끝  -->
	<jsp:include page="../Menu/footer.jsp"></jsp:include>

</body>
</html>