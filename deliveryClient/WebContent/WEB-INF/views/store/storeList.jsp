<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<!-- fontawesome 아이콘 -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<!-- googlefont -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<!-- storeLis.css 가져오기 -->	
<link href="/css/store/storeList.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<section>
	<div class="content-wrap" style="width: 1300px; margin: 0 auto;">
		<div class="category-navi">
			<ul>
				<li><a href="#">치킨</a></li>
				<li><a href="#">피자</a></li>
				<li><a href="#">한식</a></li>
				<li><a href="#">중식</a></li>
				<li><a href="#">일식</a></li>
				<li><a href="#">양식</a></li>
				<li><a href="#">분식</a></li>
				<li><a href="#">족발·보쌈</a></li>
				<li><a href="#">패스트푸드</a></li>
			</ul>
		</div>

		<div class="store-box-wrap">

			<div class="store-box">
				<div class="store-box-img">
					<img src="bhc.png" style="width: 100%; height: 100%;">
				</div>
				<div class="store-box-text">
					<ul>
						<li><a href="/StoreDetail" class="store-name">BHC
								당산역점</a></li>
						<li class="store-etc"><i class="fas fa-star" id="star"></i> (<span>4.5</span>)
							/ 리뷰 (<span>13</span>)</li>
						<li class="store-etc">매일 11:00 - 23:00</li>
						<br>
						<li id="coupon">쿠폰사용가능</li>
					</ul>
				</div>
			</div>

			<div class="store-box" name="">
				<div class="store-box-img">
					<img src="unnamed.png" style="width: 100%; height: 100%;">
				</div>
				<div class="store-box-text">
					<ul>
						<li class="store-name">Store Name</li>
						<li class="store-etc"><i class="fas fa-star" id="star"></i> (<span>4.5</span>)
							/ 리뷰 (<span>13</span>)</li>
						<li class="store-etc">매일 11:00 - 23:00</li>
						<br>
						<li id="coupon">쿠폰사용가능</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--전체content를 감싸는 div--> </section>

	<script>
		
	</script>


</body>
</html>