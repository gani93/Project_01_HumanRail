<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/Member.css">
<script type="text/javascript">
	function idok() {
		opener.form.id.value="${id}"; 
		opener.form.reid.value="${id}";
		self.close()
	}
</script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="RailServlet?command=id_check" method="post" name="form">

		아이디 <input type="text" name="id"> <input type="submit"
			value="중복체크">
		<div id="idchk_space">
			<c:if test="${result == 1 }">
				${id}는 이미 사용 중인 아이디 입니다.
			</c:if>
			<c:if test="${result == -1 }">
				${id }는 사용 가능한 아이디 입니다.&nbsp;
				<input type="button" value="사용" onclick="idok()">
			</c:if>
		</div>
	</form>
</body>
</html>