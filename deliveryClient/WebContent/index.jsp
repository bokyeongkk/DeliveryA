<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delivery-A</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <!-- Link Swiper-->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <!-- Link Swiper-->


    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	    <style>
        .content-all-wrap {
/*            border: 1px solid red;*/
        }

        html,
        body {
            position: relative;
            height: 100%;
        }

        .swiper-container {
            width: 100%;
            height: 100%;
        }

        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            height: 500px;
            /* Center slide text vertically */
            display: -webkit-box;
            display: -ms-flexbox;
            display: -webkit-flex;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            -webkit-box-align: center;
            -ms-flex-align: center;
            -webkit-align-items: center;
            align-items: center;
        }
        .swiper-pagination{
            position: absolute;
            top: 0;
        }
        
        /*  slide end      */

        .search-addr {
            width: 900px;
            height: 200px;
            display: block;
            box-shadow: 0px 0px 5px gray;
            margin: 0 auto;
            position: absolute;
            background-color: white;
            top: 55%;
            left: 50%;
            transform: translateX(-50%);
            z-index: 10;
            text-align: center;
        }

        .search-addr>h3 {
            margin-top: 40px;
            text-align: center;
        }

        .search-addr>input {
            outline: none;
            width: 800px;
            height: 60px;
            border: none;
            border-radius: 40px;
            margin-top: 30px;
            background-color: #e8e8e8;
            text-align: center;
        }

        .category-box-wrap {
            width: 1300px;
/*             border : 1px solid #cccccc; */
            padding-top: 250px;
            margin: 0 auto;

        }

        .category-box-list {
            margin: 0 auto;
            padding-right: 160px;
            padding-left: 160px;
            display: flex;
            justify-content: space-between;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        .category-box {
/*            border: 1px solid black;*/
            width: 300px;
            height: 340px;
        }
        
        .category-img{
            width: 100%;
            height: 80%;
            //background-color: pink;
            padding-left: 20px;
            padding-right: 20px;
        }
        
        .category-text{
            width: 100%;
            height: 20%;
/*            background-color: aquamarine;*/
            text-align: center;
        }
        
        .category-text>p{
            font-size: 1.5em;
            margin: 0;
            padding: 0;
            line-height: 60px;
        }
        .category-img>a>img{
            width: 100%;
            height: 100%;
        }
        
        .content-recommend{
            width: 1300px;
            padding-top: 100px;
            background-color: white;
            margin: 0 auto;
        }
        
        .swiper-slide>img{
        	width:100%;
        	height:100%;
        }
        
        
                .slide-wrap{
            position: relative;
        }
        .slide-text{
            position: absolute;
/*            border: 1px solid red;*/
            text-align: left;
            top: 25%;
            left: 20%;
        }
        .slide-text>p{
            margin: 0;
            text-indent: 8px;
            font-weight: 100;
        }
        .slide-text>h1{
            font-size: 60px;
            margin: 0;
            margin-top: -10px;
            margin-bottom:10px;
            padding: 0;
        }
        .light{
            font-size: 40px;
            margin-bottom: -10px;
        }
        
		.slide-text2{
            position: absolute;
/*            border: 1px solid red;*/
            text-align: left;
            top: 10%;
            right: 20%;
        }
        
        .slide-text2>h1{
            font-size: 70px;
            text-align: right;
            color: white;
            text-shadow: -1px 0 black, 0 3px black, 3px 0 black, 0 -1px black;    
        }
        
        .bold{
            font-weight: bold;    
            color: #ffce00; 
        }
    </style>

    <div class="content-all-wrap">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide slide-wrap">
                   <div class="slide-text">
                       <p class="light">오늘 첫 만남,</p>
                       <h1>신규가입 웰컴쿠폰 혜택</h1>
                       <p>delivery-A 신규가입을 하신 고객님과의 소중한 첫 만남을 위해,</p>
                       <p>가입 즉시 사용 가능한 웰컴쿠폰을 준비하였습니다.</p>
                   </div>
                    <img src="/upload/slide1.png">
                </div>
				<div class="swiper-slide slide-wrap">
                   <div class="slide-text2">
                       <h1>너는 지금</h1>
                       <h1><span class="bold">치킨</span>이</h1>
                       <h1>땡긴다.</h1>
                   </div>
                    <img src="/upload/slide2.png">
                </div>                

                <div class="swiper-slide slide-wrap">
                    <img src="/upload/slide3.png">
                </div>                
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
        <div class="search-addr">
            <h3>어디로 배달해드릴까요?</h3>
            <%if(c!=null) {%>
            	<input type="text" name="cliAddr" value='<%=c.getCliAddr() %>' readonly>
            <%} else { %>
            	<input type="text" name="cliAddr" readonly>
            <%} %>
            
        </div>
        <div class="category-box-wrap">
            <div class="category-box-list">
				<div class="category-box">
					<div class="category-img">
						<a href="/searchCategory?categoryNo=1"> 
							<!--여기에 img 넣기-->
							<img src="/upload/chicken.png">
						</a>
					</div>
					<div class="category-text">
						<p>치킨</p>
					</div>
				</div>
				<div class="category-box">
                    <div class="category-img">
                    	<a href="/searchCategory?categoryNo=2"> 
							<img src="/upload/pizza.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>피자</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=3"> 
							<img src="/upload/rice.png">
						</a>                    
                    </div>
                    <div class="category-text">
                        <p>한식</p>
                    </div>
                </div>
            </div>
            <div class="category-box-list">
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=4"> 
							<img src="/upload/china.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>중식</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=5"> 
							<img src="/upload/japan.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>일식</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=6"> 
							<img src="/upload/brunch.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>양식</p>
                    </div>
                </div>
            </div>
            <div class="category-box-list">
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=7"> 
							<img src="/upload/meat.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>분식</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
						<a href="/searchCategory?categoryNo=8"> 
							<img src="/upload/dessert.png">
						</a>
                    </div>
                    <div class="category-text">
                        <p>디저트</p>
                    </div>
                </div>
				<div class="category-box">
					<div class="category-img">
						<a href="/searchCategory?categoryNo=9">
							<img src="/upload/bread.png">
						</a>
					</div>
					<div class="category-text">
						<p>패스트푸드</p>
					</div>
				</div>
			</div>
        </div>
        <div class="content-recommend">
            
        </div>
    </div>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
	<script>
        var swiper = new Swiper('.swiper-container', {
            slidesPerView: 1,
            spaceBetween: 30,
            loop: true,
            autoplay: {
                delay: 4000,    //슬라이드 딜레이
                disableOnInteraction: false,
            },
            speed : 1000,   //슬라이드 속도
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
            },
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
        });
    </script>
</body>
</html>