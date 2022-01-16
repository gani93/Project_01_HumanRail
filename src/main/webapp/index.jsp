<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu/header.jsp"></jsp:include>
<!--여기서 수정 시작 -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" >
  <div class="carousel-indicators" >
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active" style = "height : 500px !important; ">
      <img src="https://cdn.pixabay.com/photo/2017/01/11/04/37/train-1970852_960_720.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Human Rail에서 즐거운 여행을 해보세요.</h5>
        <p>더 나은 서비스를 보여드리겠습니다.</p>
      </div>
    </div>
    <div class="carousel-item" style = "height : 500px !important; ">
      <img src="https://cdn.pixabay.com/photo/2017/06/24/23/03/railway-2439189_960_720.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item" style = "height : 500px !important; ">
      <img src="https://cdn.pixabay.com/photo/2021/01/26/16/00/train-5952026_960_720.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<div style= "background-color:#D8FF6D; text-decoration: none;">
	<a href="RailServlet?command=TrainSearchForm"> 
	    <img src="./Image/logo/index0.png" alt="index0" width="200" height="65" style="margin-left: 750px; margin-top:20px">
		<h4 style="text-align:center;">승차권 예매 바로가기</h4>
		<p>&nbsp</p>
	</a>
</div>
<jsp:include page="Menu/travel.jsp"></jsp:include>
<jsp:include page="Menu/indexcard.jsp"></jsp:include>
<jsp:include page="Menu/footer.jsp"></jsp:include>

</body>
</html>