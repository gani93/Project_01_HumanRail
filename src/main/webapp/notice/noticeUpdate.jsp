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
	<link rel="stylesheet" type="text/css" href="./css/notice.css" >
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<div id="content">
	<form name = "noticeform" id = "noticeform" action="RailServlet?command=noticeupdate&seq=${noticeVO.seq }" method = "post">
		<table id = "noticetable">
			<tr align = "center" valign = "middle">
				<td colspan = "2"><div id= "noticetitle"><p>공지사항 수정</p></div></td>
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
				<td height = "16"><input type="text" name="title" size="50" value="${noticeVO.title}"></td>
			</tr>
			<tr>
			    <td colspan="5" align="center"><hr></td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">작성자&nbsp;&nbsp;</div></th>
				<td height = "16"><input type = "text" name = "writer" size = "10" value="${noticeVO.writer }"></td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "250"><div align = "center">내 용&nbsp;&nbsp;</div></th>
				<td height = "250"><textarea cols = "80" rows = "15" name = "content">${noticeVO.content }</textarea></td>
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