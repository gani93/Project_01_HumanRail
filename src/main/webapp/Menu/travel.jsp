<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="./css/all.css">
<link rel="stylesheet" type="text/css" href="./css/travel.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<div class="p-3 mb-2 text-white text-center"
	style="background-color: #20c997;">지금 떠나기 좋은 여행지</div>
<div class="travelwrap">
	<!--  <button class = "roll_left"></button>
	 <button class = "roll_right"></button> -->
	<div class="travelwrap banner_wraper">
		<ul>
			<li><img
				onclick="javascript:location.href='RailServlet?command=TrainSearchForm';"
				alt="train" src="Image/travel/train.png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=2';"
				alt="jungdongjin" src="Image/travel/jungdongjin.png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=3';"
				alt="sunchun" src="Image/travel/sunchun.jpg"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=4';"
				alt="Pyeongchang" src="Image/travel/pyeongchang.jpg"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=5';"
				alt="tongyoung" src="Image/travel/tongyoung.jpg"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=travellist';"
				alt="ktx" src="Image/travel/ktx.jpg"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=TrainSearchForm';"
				alt="train1" src="Image/travel/train (1).png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=8';"
				alt="okcheon" src="Image/travel/okcheon.jpg"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=1';"
				alt="busan" src="Image/travel/busan.png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=6';"
				alt="mokpo" src="Image/travel/mokpo.png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=traveldetail&seq=7';"
				alt="kyunju" src="Image/travel/kyunju.png"></li>
			<li><img
				onclick="javascript:location.href='RailServlet?command=travellist';"
				alt="ktx" src="Image/travel/ktx.jpg"></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
	//client rolling banner
	window.onload = function() {
		var bannerLeft = 0;
		var first = 1;
		var last;
		var imgCnt = 0;
		var $img = $(".banner_wraper img");
		var $first;
		var $last;

		$img.each(function() { // 5px 간격으로 배너 처음 위치 시킴
			$(this).css("left", bannerLeft);
			bannerLeft += $(this).width() + 5;
			$(this).attr("id", "banner" + (++imgCnt)); // img에 id 속성 추가
		});

		if (imgCnt > 5) { //배너 9개 이상이면 이동시킴

			last = imgCnt;

			setInterval(function() {
				$img.each(function() {
					$(this).css("left", $(this).position().left - 1); // 1px씩 왼쪽으로 이동
				});
				$first = $("#banner" + first);
				$last = $("#banner" + last);
				if ($first.position().left < -200) { // 제일 앞에 배너 제일 뒤로 옮김
					$first.css("left", $last.position().left + $last.width()
							+ 5);
					first++;
					last++;
					if (last > imgCnt) {
						last = 1;
					}
					if (first > imgCnt) {
						first = 1;
					}
				}
			}, 50); //여기 값을 조정하면 속도를 조정할 수 있다.(위에 1px 이동하는 부분도 조정하면 

			//깔끔하게 변경가능하다           

		}

	};
</script>