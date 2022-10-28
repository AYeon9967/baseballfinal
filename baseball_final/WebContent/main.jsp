<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구볼래? 홈 화면</title>
<link rel="stylesheet" href="resource/css/main.css">
</head>
<header><%@ include file="header.jsp" %></header>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js"></script>
<!-- Slick 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css">
<body>

<script>
$(function(){
	$('#slider-div').slick({
		slide: 'div',		//슬라이드 되어야 할 태그 ex) div, li 
		infinite : true, 	//무한 반복 옵션	 
		slidesToShow : 1,		// 한 화면에 보여질 컨텐츠 개수
		slidesToScroll : 1,		//스크롤 한번에 움직일 컨텐츠 개수
		speed : 100,	 // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
		arrows : true, 		// 옆으로 이동하는 화살표 표시 여부
		dots : true, 		// 스크롤바 아래 점으로 페이지네이션 여부
		autoplay : true,			// 자동 스크롤 사용 여부
		autoplaySpeed : 3000, 		// 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
		pauseOnHover : true,		// 슬라이드 이동	시 마우스 호버하면 슬라이더 멈추게 설정
		vertical : false,		// 세로 방향 슬라이드 옵션
		prevArrow : "<button type='button' class='slick-prev'>Previous</button>",		// 이전 화살표 모양 설정
		nextArrow : "<button type='button' class='slick-next'>Next</button>",		// 다음 화살표 모양 설정
		dotsClass : "slick-dots", 	//아래 나오는 페이지네이션(점) css class 지정
		draggable : true, 	//드래그 가능 여부 
	});
})
</script>
<!-- https://macaronics.net/index.php/m04/jquery/view/1678 -->
<!-- http://kenwheeler.github.io/slick/ -->
<!-- https://m.blog.naver.com/okay1028/222027750559 --> <!-- 제일 괜찮은 듯 -->

<div class="container">
	<div class="slider">
		<div id="slider-div">
			<div><img src="resource/image/simg1.png"></div>
			<div><img src="resource/image/simg2.png"></div>
			<div><img src="resource/image/simg3.png"></div>
		</div>
	</div>
	
	<div id="teams">
		<div onclick="location.href ='teamlist.do?team=lg'">
			<img src="resource/image/teamlogo/lg.png"/><p>LG TWINS<br><br><b>엘지 트윈스</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=kt'">
			<img src="resource/image/teamlogo/kt.png"/><p>KT WIZ<br><br><b>케이티 위즈</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=kia'">
			<img src="resource/image/teamlogo/kia.png"/><p>KIA TIGERS<br><br><b>기아 타이거즈</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=samsung'">
			<img src="resource/image/teamlogo/samsung.png"/><p>SAMSUNG LIONS<br><br><b>삼성 라이온즈</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=nc'">
			<img src="resource/image/teamlogo/nc.png"/><p>NC DINOS<br><br><b>엔씨 다이노스</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=lotte'">
			<img src="resource/image/teamlogo/lotte.png"/><p>LOTTE GIANTS<br><br><b>롯데 자이언츠</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=doosan'">
			<img src="resource/image/teamlogo/doosan.png"/><p>DOOSAN BEARS<br><br><b>두산 베어스</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=ssg'">
			<img src="resource/image/teamlogo/ssg.png"/><p>SSG LANDERS<br><br><b>에스에스지 랜더스</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=kiwoom'">
			<img src="resource/image/teamlogo/kiwoom.png"/><p>KIWOOM HEROES<br><br><b>키움 히어로즈</b></p>
		</div>
		<div onclick="location.href ='teamlist.do?team=hanhwa'">
			<img src="resource/image/teamlogo/hanhwa.png"/><p>HANHWA EAGLES<br><br><b>한화 이글스</b></p>
		</div>
	</div>
	
	<div class="rankingbox">
		<div class="ranking" onclick="window.open('https://sports.news.naver.com/kbaseball/record/index?category=kbo', '_blank');">
			실시간 구단 순위 확인하기
		</div>
	</div>
</div>
</body>
<footer><%@ include file="footer.jsp" %></footer>
</html>