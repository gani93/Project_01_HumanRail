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
	<form name = "noticeform" id = "noticeform" method = "post">
		<div id= "noticetitle"><p><img src="./Image/notice/notice.png" class = "noticetitle" />&nbsp;&nbsp;공지사항</p>| 신규서비스 및 이벤트에 대한 공지 확인이 가능합니다. |</div><br>
		<table id = "noticetable">
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">제 목&nbsp;&nbsp;</div></th>
				<td height = "16">${noticeVO.title } </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><hr></td>
				</tr>
			<tr>
				<th width = "100"  height = "16"><div align = "center">작성자&nbsp;&nbsp;</div></th>
				<td height = "20">${noticeVO.writer}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><hr></td>
			</tr>
			<tr>
				<th width = "100"  height = "16"><div align = "center">날 짜&nbsp;&nbsp;</div></th>
				<td height = "20">${noticeVO.write_date }</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100"  height = "250"><div align = "center">내 용&nbsp;&nbsp;</div></th>
				<td height = "250">${noticeVO.content }</td>
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
						<input type="button" value="삭제" onclick="location.href='RailServlet?command=noticedelete&seq=${noticeVO.seq }';" class = "button">
						&nbsp;&nbsp;&nbsp; 
						<input type="button" value="수정" onclick="location.href='RailServlet?command=noticeupdateform&seq=${noticeVO.seq }';" class = "button">
						&nbsp;&nbsp;&nbsp; 
					</c:if>
					<input type="button" value="리스트로" onclick="location.href='RailServlet?command=noticelist';" class = "button">
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