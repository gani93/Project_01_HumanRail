<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="com.rail.dto.MemberVO"%>
<%@page import="com.rail.dto.TrainVO"%>
<%@page import="java.util.List"%>

<%
List<TrainVO> list = (List) request.getAttribute("TrainList");
MemberVO user = (MemberVO) session.getAttribute("loginUser");
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
<script src="./TrainPage/train.js"></script>
</head>
<body>
   <jsp:include page="../Menu/header.jsp"></jsp:include>
   <!--여기서 수정 시작 -->
   <div class="content">
      <div class="list_h2">
         <h2>열차예매</h2>
      </div>
      
      <table class="TrainListTable" style="text-align: center;">
         <tr style="border-bottom: 1px solid #DDE0E6;">
         <th style="width: 120px;">출발날짜</th>
            <th style="width: 80px;">열차</th>
            <th style="width: 120px;">열차번호</th>
            <th style="width: 120px;">출발시간</th>
            <th style="width: 120px;">도착시간</th>
            <th style="width: 90px;">출발역</th>
            <th style="width: 90px;">도착역</th>
            <th style="width: 120px;">타는곳</th>
            <th style="width: 120px;">남은 좌석</th>
            <th style="width: 120px;">금액</th>
            <th style="width: 120px;">예약하기</th>
         </tr>
         <%
         if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
         
         %>
         <tr class="Getbutton" height="50px" style="border-bottom: 1px solid #DDE0E6;">
         <td><%=list.get(i).getTrain_date()%></td>
            <td class="Getbutton"><a
               href="RailServlet?command=TrainGetForm&seq=<%=list.get(i).getTrain_seq()%>" style="text-decoration: none; color:black;"><%=list.get(i).getTrain_sub()%></a></td>
            <td class="Getbutton"><%=list.get(i).getTrain_id()%></td>
            <td class="Getbutton"><%=list.get(i).getTrain_start_time()%></td>
            <td class="Getbutton"><%=list.get(i).getTrain_end_time()%></td>
            <td class="Getbutton"><%=list.get(i).getTrain_start_place()%></td>
            <td class="Getbutton"><%=list.get(i).getTrain_end_place()%></td>
            <td class="Getbutton"><%=list.get(i).getTrain_form()%></td>
            <%if(list.get(i).getTrain_member()<=0){ %>
            <td class="Getbutton" style="color:red;">매진</td>
            <%}else{%>
            <td class="Getbutton"><%=list.get(i).getTrain_member()%>석</td>
            <%}%>
            <td class="Getbutton"><%=list.get(i).getTrain_money() / 1000%>,000</td>
            <%if(Integer.parseInt(list.get(i).getTrain_date().replaceAll("-", ""))<Integer.parseInt(strToday)){ %>
            <td class="reservation_start"></td>
               <%}else{%>
               <td class="reservation_start"><button onclick="location.href='RailServlet?command=ReservationForm&seq=<%=list.get(i).getTrain_seq()%>&select=1'"
               >선택 ></button></td>
               <%}%>
         </tr>
         <%
         }}
         %>
         <tr style="border-bottom: 1px solid #DDE0E6;">
          <%
            if (list != null) {
               if (user != null && user.getAdminnum().equals("1")) {
            %>
            <td colspan="11" align="right"><a href="javascript:openWindowPop('RailServlet?command=TrainInsertForm','insert');">차량 등록 하기</a></td>
            </tr><%
            }  
            }
          if(list.size()<=0){
            %>
         
         <tr>
            <td colspan="11">조회된 열차가 없습니다.</td>
         </tr>
     

		<%} %>
      </table>
      <div class="reservation_start button" id="list_btn" style="text-align: center;">
			<button onclick="history.go(-1)" style="height: 30px; font-size: 1em; ">이전</button>
		</div>

   </div>
   <!--여기서 수정 끝  -->
   <jsp:include page="../Menu/footer.jsp"></jsp:include>

</body>
</html>

