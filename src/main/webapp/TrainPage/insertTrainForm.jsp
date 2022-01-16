<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
Calendar c1 = Calendar.getInstance();
String strToday = sdf.format(c1.getTime());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HumanRail</title>

<script src="./TrainPage/train.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function(){
    $("#Train_sub").on("change",function(){
        var select = $(this).val();
        console.log(select);
        if(select=="KTX"){
            $("#Train_member").val(300);
        }else if(select=="무궁화"){
            $("#Train_member").val(200);
        }else if(select=="새마을"){
            $("#Train_member").val(240);
        }
    });
 });
 </script>
 <style type="text/css">
    table {
        text-align: center;
        margin: auto;
    }
    
    th {
        background-color: darkblue;
        width: 90px;
        height: 35px;
        color: white;
        border-bottom: 1px solid darkblue;
    }
    
    td {
    padding-left:25px;
        text-align: left;
        
    }
    #buttons input{
        width: 120px;
        height: 30px;
        background-color: darkblue;
        color: white;
    }
    </style>
</head>
<body >
    <div style="text-align: center;">
        <h1>기차 등록</h1>
    </div>
	<form action="RailServlet?command=TrainInsert" method="post" name="form">
		<table>	
			<tr>
				<th>열차 종류</th>
				<td style="border-bottom: 1px solid darkblue;"><select name="Train_sub" id="Train_sub" >
						<option value="무궁화">무궁화</option>
						<option value="새마을">새마을</option>
                        <option value="KTX">KTX</option>
				</select></td>
			</tr>
			<tr>
				<th>열차번호</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_id" size="8" ></td>
			</tr>
			<tr>
				<th>인원수</th>

				<td style="border-bottom: 1px solid darkblue;"><select name="Train_member" id="Train_member" >
						<option value="200">200</option>
						<option value="240">240</option>
						<option value="300">300</option>
				</select></td>
			</tr>
			<tr>
				<th>출발시간</th>
				<td style="border-bottom: 1px solid darkblue;"><select name="Train_start_time" id="Train_start_time" size="1">
				<%for(int i =1; i<25; i++){ %>
						<option value="<%=i%>"><%=i%></option>
						<%} %>
				</select></td>
			</tr>
			<tr>
				<th>도착시간</th>
				<td style="border-bottom: 1px solid darkblue;"><select name="Train_end_time" id="Train_end_time" size="1">
				<%for(int i =1; i<25; i++){ %>
						<option value="<%=i%>" ><%=i%></option>
						<%} %>
				</select></td>
			</tr>
			<tr>
				<th>출발역</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_start_place" size="8"></td>
			</tr>
			<tr>
				<th>도착역</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_end_place" size="8"></td>
			</tr>
			<tr>
				<th>타는곳</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_form" size="8"></td>
			</tr>
			<tr>
				<th>출발날짜</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_date" type="date" value="<%=strToday %>" size="8"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td style="border-bottom: 1px solid darkblue;"><input name="Train_money" size="8"> 원</td>
			</tr>
			<tr id="buttons">
                <td colspan="2"><input type="reset" value="다시쓰기"><input type="button" value="등록" onclick="insertCheck()" style="margin-left: 20px;"></td>
			
			</tr>
		</table>
	</form>
</body>
</html>