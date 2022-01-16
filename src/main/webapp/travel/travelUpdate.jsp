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
	<form name = "travelform" id = "travelform" action="RailServlet?command=travelupdate&seq=${travelVO.seq }" method = "post">
		<table id = "traveltable">
			<tr align = "center" valign = "middle">
				<td colspan = "2"><div id= "traveltitle"><p>여행지 수정</p></div></td>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">제 목&nbsp;&nbsp;</div></th>
				<td height = "16"><input type="text" name="title" size="50" value="${travelVO.title}"></td>
			</tr>
			<tr>
			    <td colspan="5" align="center"><hr></td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">작성자&nbsp;&nbsp;</div></th>
				<td height = "16"><input type = "text" name = "writer" size = "10" value="${travelVO.writer }"></td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "250"><div align = "center">내 용&nbsp;&nbsp;</div></th>
				<td height = "250"><textarea cols = "80" rows = "15" name = "content">${travelVO.content }</textarea></td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
					<th>사 진 </th>
					<td><input type = "file" name = "pictureUrl" ><br>(주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align = "center" valign = "middle">
				    <input type = "reset" value ="다시입력" class = "button">  &nbsp;&nbsp;&nbsp; 
					<input type = "submit" value ="수정" class = "button"> &nbsp;&nbsp;&nbsp; 
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