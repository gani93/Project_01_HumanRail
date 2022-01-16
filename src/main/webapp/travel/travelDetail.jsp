<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="com.rail.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HumanRail</title>
	<link rel="stylesheet" type="text/css" href="./css/all.css">
	<link rel="stylesheet" type="text/css" href="./css/travel.css" >
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<div id="content">
	<form name = "travelform" id = "travelform" method = "post">
		<div id= "traveltitle"><p><img src="./Image/travel/travel.png" class = "traveltitle" />&nbsp;&nbsp;여행지</p>| 기차 여행하기 좋은 여행지를 추천합니다. |</div><br>
		<table id = "traveltable">
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "170" height = "280"><div align = "center">사 진&nbsp;&nbsp;</div></th>
				<td height = "280">
				    <c:choose>
				    <c:when test = "${empty travelVO.pictureUrl }">
					    <img src="Image/travel/noimage.gif">
				    </c:when>
				    <c:otherwise>
					    <img src="Image/travel/${travelVO.pictureUrl }">
				    </c:otherwise>
				    </c:choose>
				</td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">제 목&nbsp;&nbsp;</div></th>
				<td height = "16">${travelVO.title } </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><hr></td>
				</tr>
			<tr>
				<th width = "100"  height = "16"><div align = "center">작성자&nbsp;&nbsp;</div></th>
				<td height = "20">${travelVO.writer}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><hr></td>
			</tr>
			<tr>
				<th width = "100"  height = "16"><div align = "center">날 짜&nbsp;&nbsp;</div></th>
				<td height = "20">${travelVO.write_date }</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100"  height = "250"><div align = "center">내 용&nbsp;&nbsp;</div></th>
				<td height = "250">${travelVO.content }</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan = "2" align = "center" valign = "middle">
					<c:if test="${loginUser.adminnum == 1}">
						<input type="button" value="삭제" onclick="location.href='RailServlet?command=ntraveldelete&seq=${travelVO.seq }';" class = "button">
						&nbsp;&nbsp;&nbsp; 
						<input type="button" value="수정" onclick="location.href='RailServlet?command=travelupdateform&seq=${travelVO.seq }';" class = "button">
						&nbsp;&nbsp;&nbsp; 
					</c:if>
					<input type="button" value="리스트로" onclick="location.href='RailServlet?command=travellist';" class = "button">
				</td>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>