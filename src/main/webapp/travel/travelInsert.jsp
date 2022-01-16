<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form name = "travelform" id = "travelform" action="RailServlet?command=travelinsert" method = "post">
		<table id = "traveltable">
			<tr align = "center" valign = "middle">
				<td colspan="2"><div id= "traveltitle"><p> 여행지 등록</p></div></td>
			</tr>
			<tr>
				<td colspan = "2">&nbsp;</td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">글쓴이</div></th>
				<td><input type = "text" name = "writer" size = "10" value="관리자"></td>
			</tr>
			<tr>
			    <td colspan="2" align="center"><hr></td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">제 목</div></th>
				<td><input type="text" name="title" size="50" ></td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
				<th width = "100" height = "16"><div align = "center">내 용</div></th>
				<td><textarea cols = "80" rows = "15" name = "content"></textarea></td>
			</tr>
			<tr bgcolor = "AAAAAA">
				<td colspan="2" style = "height : 1px">
				</td>
			</tr>
			<tr>
		        <th>사 진 </th>
			    <td><input type = "file" name = "pictureUrl" ></td>
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
					<input type = "reset" value ="다시입력" class = "button">&nbsp;&nbsp;&nbsp; 
					<input type = "submit" value ="등록" class = "button">&nbsp;&nbsp;&nbsp; 
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