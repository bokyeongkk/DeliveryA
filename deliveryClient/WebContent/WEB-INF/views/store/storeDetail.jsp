<%@page import="order.model.vo.OrderDetData"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="store.model.vo.Cart"%>
<%@page import="store.model.vo.ReviewData"%>
<%@page import="store.model.vo.Review"%>
<%@page import="store.model.vo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="store.model.vo.Store"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Store s = (Store) request.getAttribute("s");
	ArrayList<Menu> listMenu = (ArrayList<Menu>) request.getAttribute("listMenu");
	ReviewData srd = (ReviewData) request.getAttribute("srd");

	//장바구니 세션
	ArrayList<Cart> listCart = (ArrayList) session.getAttribute("listCart");

	//별 갯수 표현을 위해 소수점 반올림된 변수 생성
	int storeStar = (int) Math.round(srd.getAvgRev());

	//가격 콤마 표시을 위한 클래스 활용
	DecimalFormat formatter = new DecimalFormat("#,###");

	//가격 콤마 표시 제거
	//str.replaceAll(",", "");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<!-- 부트스트랩 사용 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- fontawesome 아이콘 -->
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<!-- googlefont -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<!-- storeDetail.css 가져오기 -->
<link href="/css/store/storeDetail.css" rel="stylesheet" type="text/css">

<title>delivery-A | 가게 상세</title>
</head>
<body>

	<script>
		$(function() {

			//로드 시 MENU탭으로 설정
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

			//장바구니 메뉴 수량 +(플러스) 버튼 클릭
			$(".plus").click(function() {

				var menuName = $(this).siblings(".cart-name").val();

				var n = $(".plus").index(this);
				var count = Number($(".plus").eq(n).prev().val()) + 1;

				$.ajax({
					url : "/countPlag",
					data : {
						menuName : menuName,
						count : count
					},
					type : "post",
					success : function() {
						location.reload();

					}
				})
			});

			//장바구니 메뉴 수량 -(마이너스) 버튼 클릭
			$(".minus").click(function() {

				var menuName = $(this).siblings(".cart-name").val();

				var n = $(".minus").index(this);

				if ($(".minus").eq(n).next().val() > 1) {

					count = Number($(".minus").eq(n).next().val()) - 1;

					$.ajax({
						url : "/countPlag",
						data : {
							menuName : menuName,
							count : count
						},
						type : "post",
						success : function() {
							location.reload();

						}
					})
				}
			});

			//장바구니 메뉴들 합계 구하기
			var sum = 0;
			//메뉴 가격들을 가져와서 sum 변수에 합치기
			$(".count-price").each(function() {
				sum += Number($(this).val());
			});

			//합계  input의 값으로  sum을 넣기
			$(".total-price").val(sum);

			//정규표현식으로 ,(콤마) 찍기
			sumStr = String(sum).replace(/\B(?=(\d{3})+(?!\d))/g, ",");

			$(".total-price-prt").html(sumStr);
		});

		//!함수는 $(function(){}); 밖에서 선언

		//리뷰 작성하는 모달창 생성
		function reviewWriteFrm(cliId, storeNo) {
			$.ajax({
				url : "/searchOrder",
				data : {
					cliId : cliId,
					storeNo : storeNo
				},
				type : "post",
				success : function(data) {
					if (data == "0") { //주문한 이력이 없을 때
						alert("오늘 주문하신 내역이 존재하지 않습니다.");
					} else if (data == "1") { //작성한 리뷰가 있을 때
						alert("이미 리뷰를 작성하셨습니다.");
					} else if (data == "2") { //
						$(".reveiw-modal-wrap").css("display", "flex");
					} else {
						alert("서비스 이용이 어렵습니다. 관리자에게 문의해주세요.");
					}
				}
			})
		}

		//리뷰 작성 모달창 취소 버튼
		function reviewWriteCancel() {
			//채워진 별모양 삭제
			$(".grade-mark").removeClass("fas fa-star");
			//안채워진 별 모양으로 추가
			$(".grade-mark").addClass("far fa-star");
			//리뷰 작성된 내용 초기화
			$(".modal-content").val("");
			//모달창 닫기
			$(".reveiw-modal-wrap").css('display', 'none');
		}

		//리뷰 작성 - 별 클릭하면 채워진 별 이미지로 변경하는 이벤트
		//한번만 클릭되고 다음부터는 안되는 문제가 있었음
		//-> $(document).on 페이지가 로드 될때 계속 새로운 클래스로 생성
		$(document).on("click", ".grade-mark", function() {

			mark = $(".grade-mark");
			idx = $(".grade-mark").index(this);

			mark.removeClass("fas fa-star");
			mark.removeClass("far fa-star");

			mark.each(function(index, item) {
				if (index <= idx) {
					$(item).addClass("fas fa-star");
				} else {
					$(item).addClass("far fa-star");
				}
			});

			//input val에 숫자로 값 넣어주기
			$(".grade").val((idx + 1));
			console.log($(".grade").val());

		});
	</script>


	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>
	<div class="content-wrap" style="width: 1300px; margin: 0 auto;">

		<div class="store-wrap">

			<!--가게정보div-->
			<div class="store-info">
				<div class="store-info-img">
					<!-- <img src="/upload/ready.jpg" style="width: 100%; height: 100%;"> -->
					<img src="/filepath/01_store/<%=s.getStoreFilepath()%>" style="width: 100%; height: 100%;">
				</div>
				<div class="store-info-text">
					<ul>
						<li><%=s.getStoreName()%></li>
						<br>
						<li>전화번호 : <%=s.getStoreTel()%></li>
						<li>주소 : <%=s.getStoreAddr()%>
						</li>
						<li><%=s.getStoreDet()%></li>
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
								<!-- <img src="/upload/ready.jpg" style="width: 100%; height: 100%;"> -->
								<img src="/filepath/02_menu/<%=listMenu.get(0).getMenuFilepath() %>" style="width: 100%; height: 100%;">
							</div>
							<div class="best-menu-text">
								<p><%=listMenu.get(0).getMenuName()%></p>
								<p><%=formatter.format(listMenu.get(0).getMenuPrice())%></p>
							</div>
						</div>
						<div class="best-menu">
							<div class="best-menu-img">
								<!-- <img src="/upload/ready.jpg" style="width: 100%; height: 100%;"> -->
								<img src="/filepath/02_menu/<%=listMenu.get(1).getMenuFilepath() %>" style="width: 100%; height: 100%;">
							</div>
							<div class="best-menu-text">
								<p><%=listMenu.get(1).getMenuName()%></p>
								<p><%=formatter.format(listMenu.get(1).getMenuPrice())%></p>
							</div>
						</div>
						<div class="best-menu">
							<div class="best-menu-img">
								<!-- <img src="/upload/ready.jpg" style="width: 100%; height: 100%;"> -->
								<img src="<%=listMenu.get(2).getMenuFilepath() %>" style="width: 100%; height: 100%;">
							</div>
							<div class="best-menu-text">
								<p><%=listMenu.get(2).getMenuName()%></p>
								<p><%=formatter.format(listMenu.get(0).getMenuPrice())%></p>
							</div>
						</div>
					</div>
				</div>

				<div class="menu-wrap">
					<ul class="menu-view">
						<li>우리 가게 메뉴</li>
						<%
							for (Menu m : listMenu) {
						%>
						<li>
							<form action="/insertCart" method="post">
								<div class="menu-text">

									<input type="hidden" name="storeNo" value="<%=s.getStoreNo()%>">
									<input type="hidden" name="menuNo" value="<%=m.getMenuNo()%>">
									<input type="text" name="menuName" class="menu-name"
										value="<%=m.getMenuName()%>"><br> <input
										type="text" name="menuDesc" class="menu-desc"
										value="<%=m.getMenuDet()%>"><br> <input
										type="hidden" name="menuPrice" value="<%=m.getMenuPrice()%>">
									<input type="text" class="menu-price"
										value="<%=formatter.format(m.getMenuPrice())%>">

								</div>
								<div class="menu-cart">
									<button type="submit" class="btn btn-outline-warning cart-in">장바구니
										담기</button>
								</div>
							</form>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			</div>

			<div class="store-cont">
				<div class="review-title">
					<div class="review-title-left">
						<h3><%=srd.getAvgRev()%></h3>
						<span class="star"> <!--스코어 점수 따라서 별 모양 for문 돌리기 --> 
						<% for (int i = 0; i < 5; i++) { %> 
						<% if (storeStar > i) { %> 
						<i class="fas fa-star" id="star-lg"></i> 
						<% } else { %> <i class="far fa-star" id="star-lg"></i> 
						<% } %> 
					<%} %>
						</span>
					</div>
					<div class="review-title-right">
						<h3>
							최근 리뷰
							<%=srd.getCntRev()%>개
						</h3>
						<p>사장님이 남긴 댓글 0개</p>
					</div>
				</div>

				<!-- 로그인 정보가 없을 때 리뷰 작성하기 버튼 안보이게 -->
				<%
					if (c != null) {
				%>
				<div class="review-write">
					<button type="button" class="btn btn-warning"
						onclick="reviewWriteFrm('<%=c.getCliId()%>', '<%=s.getStoreNo()%>');">
						리뷰 작성하기</button>
				</div>
				<%
					}
				%>

				<div class="review-view-wrap">
					<%
						for (Review r : srd.getListRev()) {
					%>
					<div class="review-view">
						<ul>
							<li class="nickname"><%=r.getRevCliId()%> <span
								id="review-date"> <%=r.getRevEnrollDate()%></span></li>
							<li>
								<!--스코어 점수 따라서 별 모양 for문 돌리기 --> 
								<%for (int i = 0; i < 5; i++) { %> 
									<%if (r.getRevScore() > i) { %> 
									<i class="fas fa-star" id="star-sm"></i> 
									<%} else { %> 
									<i class="far fa-star" id="star-sm"></i> 
									<%} %> 
								<%} %>
							</li>
							<li class="review-cont"><%=r.getRevContentBr()%></li>
							<br>
							<li>
								<%for (OrderDetData d : srd.getListOrdDet()) { %> 
									<%if (r.getRevOrdNo() == d.getOrdDetOrdNo()) { %> 
									<span class="review-menu"><%=d.getMenuName()%></span> 
									<% } %> 
								<% } %>
							</li>
						</ul>
					</div>
					<%} %>
				</div>
				<%
					if (srd.getListRev().size() > 5) {
				%>
				<div class="review-more">
					<button class="btn btn-dark" currentCount="0" value=""
						totalCount="" id="more-btn">더보기</button>
				</div>
				<%
					}
				%>
			</div>
		</div>
		<!-- store-wrap 닫는 div -->


		<!--모달div-->
		<%
			if (c != null) {
		%>
		<div class="reveiw-modal-wrap">
			<div class="review-modal">
				<form action="/insertReview" method="post">
					<h1>리뷰 작성하기</h1>
					<hr>
					<h4>고객님 오늘 음식은 어떠셨어요?</h4>
					<i class="far fa-star grade-mark" id="star"></i> <i
						class="far fa-star grade-mark" id="star"></i> <i
						class="far fa-star grade-mark" id="star"></i> <i
						class="far fa-star grade-mark" id="star"></i> <i
						class="far fa-star grade-mark" id="star"></i> 
						<input class="grade" name="reviewScore" type="hidden" value="0"> <br> <br>
					<textarea class="form-control modal-content" name="reviewContent"
						cols="40" rows="8" style="resize: none" required></textarea>

					<input type="hidden" name="cliId" value="<%=c.getCliId()%>">
					<input type="hidden" name="storeNo" value="<%=s.getStoreNo()%>">
					<div class="review-modal-btn">
						<input type="button" class="btn btn-dark"
							onclick="reviewWriteCancel();" value="취소"> <input
							type="submit" class="btn btn-outline-dark" value="작성완료">
					</div>
				</form>
			</div>
		</div>
		<%
			}
		%>

		<!--장바구니div-->
		<div class="cart-wrap">
			<div class="cart-sticky">
				<form action="/orderPage" method="post">
					<div class="cart-title">
						내 장바구니 <a href="/deleteCartAll?storeNo=<%=s.getStoreNo()%>"
							class="cart-trashbox"><i class="fas fa-trash-alt"></i></a>
					</div>
					<%
						if (listCart == null) {
					%>
					<br> <br>
					<h6>장바구니를 채워주세요( ღ'ᴗ'ღ )</h6>
					<%
						} else {
					%>

					<%
						for (Cart t : listCart) {
					%>
					<div class="cart-menu-box">

						<a
							href="/deleteCartOne?storeNo=<%=s.getStoreNo()%>&menuName=<%=t.getMenuName()%>"
							class="btn-delete"> <i class="fas fa-times"></i>
						</a> <input type="hidden" name="orderMenuNo"
							value="<%=t.getMenuNo()%>"> <input type="text"
							name="orderMenuName" class="cart-name"
							value="<%=t.getMenuName()%>"><br>

						<button type="button" class="btn-danger btn-cart-num minus">
							<i class="fas fa-minus"></i>
						</button>
						<input type="text" name="orderMenuCount"
							class="btn-cart-num count" value="<%=t.getMenuCount()%>">
						<button type="button" class="btn-danger btn-cart-num plus">
							<i class="fas fa-plus"></i>
						</button>
						<br> <input type="hidden" name="orderMenuPrice"
							class="count-price" value="<%=t.getCountPrice()%>">
						<div class="count-price"><%=formatter.format(t.getCountPrice())%>
							원
						</div>

					</div>
					<%} %>

					<%} %>

					<input type="hidden" name="orderStoreNo"
						value="<%=s.getStoreNo()%>">

					<div class="total-price-box">
						<input type="hidden" name="orderTotalPrice" class="total-price"
							value=""> <span>합계</span>
						<div class="total-price-prt"></div>
						<span> 원</span>
					</div>
					<div class="cart-order-btn">
						<p>
							<i class="fas fa-exclamation-circle"></i> 처음 주문이시면, 회원가입 하시고 쿠폰사용하세요.
						</p>
						<input type="submit" class="btn btn-danger btn-order" value="주문하기">
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

	<%@include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html>