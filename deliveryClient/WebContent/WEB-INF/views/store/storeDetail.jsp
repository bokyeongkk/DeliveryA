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
<link href="/css/store/storeDetail.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {

			//탭 설정
			$(".store-tap").eq(0).addClass("selectTab");
			$(".store-cont").hide();
			$(".store-cont").eq(0).show();

			//탭 메뉴 클릭 이벤트
			$(".store-tap").click(function() {
				$(".store-tap").removeClass("selectTab");
				$(this).addClass("selectTab");

				var idx = $(".store-tap").index(this);

				$(".store-cont").hide();
				$(".store-cont").eq(idx).show();
			});

			//장바구니 담기 버튼 클릭 이벤트
			$(".cart-in").click(function() {
				alert("장바구니에 담겼습니다.")
			});

			//리뷰 작성하기 버튼 클릭 이벤트 (모달창)
			$(".btn-review-write").click(function() {
				url: "mo"
				$(".review-modal-wrap").css("display", "flex");
			});

			//모달 창 닫기 버튼
			$("input[type=button]").click(function() {
				$(".review-modal-wrap").css("display", "none");
			});

			//장바구니 전체 삭제 이벤트
			$("#trashbox").click(function() {
				$("#trashbox").parent().siblings(".cart-menu-box").remove();

			});

			//장바구니 메뉴박스 삭제 이벤트
			$(".btn-delete").click(function() {
				$(this).parents(".cart-menu-box").remove();
			});

		});
	</script>


	<section>
        <div class="content-wrap" style="width: 1300px; margin: 0 auto;">

            <div class="store-wrap">

                <!--가게정보div-->
                <div class="store-info">
                    <div class="store-info-img">
                        <img src="" style="width:100%; height: 100%;">
                    </div>
                    <div class="store-info-text">
                        <ul>
                            <li>가게명</li><br>
                            <li>전화번호 : 02-1234-5678</li>
                            <li>주소 : 서울시 영등포구 선유로 이레빌딩 1층 </li>
                            <li>사랑하는 고객님 ~~^^!! 정성을 다해 만드는 BHC입니다~~ 지금 주문하세요 ♥</li>
                        </ul>
                    </div>
                </div>

                <!--가게네비div-->
                <div class="store-tap-wrap">
                    <ul>
                        <li class="store-tap"><a href="#">MENU</a></li>
                        <li class="store-tap"><a href="#">REVIEW</a></li>
                    </ul>
                </div>

                <!--가게메뉴div-->
                <div class="store-cont">
                    <div class="best-menu-wrap">
                        <div class="best-menu-title">추 천 메 뉴</div>
                        <div class="best-menus">
                            <div class="best-menu">
                                <div class="best-menu-img">
                                    <img src="" style="width:100%; height: 100%;">
                                </div>
                                <div class="best-menu-text">
                                    <p>메뉴이름</p>
                                    <p>메뉴가격</p>
                                </div>
                            </div>
                            <div class="best-menu">
                                <div class="best-menu-img">
                                    <img src="" style="width:100%; height: 100%;">
                                </div>
                                <div class="best-menu-text">
                                    <p>메뉴이름</p>
                                    <p>메뉴가격</p>
                                </div>
                            </div>
                            <div class="best-menu">
                                <div class="best-menu-img">
                                    <img src="" style="width:100%; height: 100%;">
                                </div>
                                <div class="best-menu-text">
                                    <p>메뉴이름</p>
                                    <p>메뉴가격</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="menu-wrap">
                        <ul class="menu-view">
                            <li> 우리 가게 메뉴</li>
                            <li>
                                <div class="menu-text">
                                    <input type="text" class="menu-name" value="메뉴이름"><br>
                                    <input type="text" class="menu-desc" value="메뉴설명"><br>
                                    <input type="text" class="menu-price" value="메뉴가격">
                                </div>
                                <div class="menu-cart">
                                    <button type="button" class="btn btn-outline-warning cart-in" id="cart-in">장바구니 담기</button>
                                </div>
                            </li>
                            <li>
                                <div class="menu-text">
                                    <input type="text" class="menu-name" value="메뉴이름"><br>
                                    <input type="text" class="menu-desc" value="메뉴설명"><br>
                                    <input type="text" class="menu-price" value="메뉴가격">
                                </div>
                                <div class="menu-cart">
                                    <button type="button" class="btn btn-outline-warning cart-in" id="cart-in">장바구니 담기</button>
                                </div>
                            </li>
                            <li>
                                <div class="menu-text">
                                    <input type="text" class="menu-name" value="메뉴이름"><br>
                                    <input type="text" class="menu-desc" value="메뉴설명"><br>
                                    <input type="text" class="menu-price" value="메뉴가격">
                                </div>
                                <div class="menu-cart">
                                    <button type="button" class="btn btn-outline-warning cart-in" id="cart-in">장바구니 담기</button>
                                </div>
                            </li>
                            <li>
                                <div class="menu-text">
                                    <input type="text" class="menu-name" value="메뉴이름"><br>
                                    <input type="text" class="menu-desc" value="메뉴설명"><br>
                                    <input type="text" class="menu-price" value="메뉴가격">
                                </div>
                                <div class="menu-cart">
                                    <button type="button" class="btn btn-outline-warning cart-in" id="cart-in">장바구니 담기</button>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="store-cont">
                    <div class="review-title">
                        <div class="review-title-left">
                            <h3>4.3</h3>
                            <span class="star">
                                <i class="fas fa-star" id="star-lg"></i>
                                <i class="fas fa-star" id="star-lg"></i>
                                <i class="fas fa-star" id="star-lg"></i>
                                <i class="fas fa-star" id="star-lg"></i>
                                <i class="far fa-star" id="star-lg"></i>
                            </span>
                        </div>
                        <div class="review-title-right">
                            <h3>최근 리뷰 43개</h3>
                            <p>사장님이 남긴 댓글 17개</p>
                        </div>
                    </div>
                    <div class="review-write">
                        <button type="button" class="btn btn-warning btn-review-write" onclick="reviewWriteFrm();">
                            리뷰 작성하기
                        </button>
                    </div>
                    <div class="review-view-wrap">
                        <div class="review-view">
                            <ul>
                                <li class="nickname">Nickname</li>
                                <li class="review-date">주문일자</li>
                                <li>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                </li>
                                <li class="review-cont">리뷰 내용</li>
                                <br>
                                <li class="review-menu">주문메뉴</li>
                            </ul>
                        </div>

                        <div class="review-view">
                            <ul>
                                <li class="nickname">Nickname</li>
                                <li class="review-date">주문일자</li>
                                <li>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                    <i class="fas fa-star" id="star-sm"></i>
                                </li>
                                <li class="review-cont">리뷰 내용</li>
                                <br>
                                <li class="review-menu">주문메뉴</li>
                            </ul>
                        </div>

                    </div>
                    <div class="reivew-more">
                        <button class="btn btn-dark" currentCount="0" value="" totalCount="" id="more-btn">더보기</button>
                    </div>
                </div>
                <br><br><br><br><br><br>
            </div><!-- store-wrap 닫는 div -->

            <!--장바구니div-->
            <div class="cart-wrap">
                <div class="cart-sticky">
                    <form action="#" method="post">
                        <div class="cart-title">내 장바구니
                            <button type="button" id="trashbox"><i class="fas fa-trash-alt"></i></button>
                        </div>
                        <div class="cart-menu-box">
                            <button type="button" class="btn-delete">
                                <i class="fas fa-times"></i>
                            </button>

                            <input type="text" name="orderName" class="cart-name" value="메뉴이름">

                            <button type="button" class="btn-cart-num" id="minus"><i class="fas fa-minus"></i></button>
                            <input type="text" name="orderConter" class="btn-cart-num" id="counter" value="1">
                            <button type="button" class="btn-cart-num" id="plus"><i class="fas fa-plus"></i></button>

                            <input type="text" name="orderPrice" class="cart-price" value="19,800"><span class="won"> 원</span>
                        </div>

                        <div class="total-price">
                            <span>합계</span><input type="text" name="orderTotalPrice" value="38,000"><span> 원</span>
                        </div>
                        <div class="cart-order-btn">
                            <input type="submit" class="btn btn-danger btn-order" value="주문하기">
                        </div>
                    </form>
                </div>
            </div>
        </div>
      </section>
      <%@ include file="/views/store/reviewWriteFrm.jsp"%>
      
</body>
</html>