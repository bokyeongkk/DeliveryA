<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            height: 400px;
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
            border-radius: 15px;
            margin: 0 auto;
            position: absolute;
            background-color: #e8e8e8;
            top: 42%;
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
            background-color: lightgray;
        }

        .category-box-wrap {
            width: 1300px;
            background-color: lightblue;
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
            background-color: pink;
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
        .category-img>img{
            width: 100%;
            height: 100%;
        }
        
        .content-recommend{
            width: 1300px;
            padding-top: 100px;
            background-color: lightcyan;
            margin: 0 auto;
        }
    </style>

    <div class="content-all-wrap">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide">Slide 1</div>
                <div class="swiper-slide">Slide 2</div>
                <div class="swiper-slide">Slide 3</div>
                <div class="swiper-slide">Slide 4</div>
                <div class="swiper-slide">Slide 5</div>
            </div>
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
        </div>
        <div class="search-addr">
            <h3>어디로 배달해드릴까요?</h3>
            <input type="text" name="cliAddr">
        </div>
        <div class="category-box-wrap">
            <div class="category-box-list">
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
            </div>
            <div class="category-box-list">
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
            </div>
            <div class="category-box-list">
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
                    </div>
                </div>
                <div class="category-box">
                    <div class="category-img">
                    <!--여기에 img 넣기-->
                    </div>
                    <div class="category-text">
                        <p>text</p>
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