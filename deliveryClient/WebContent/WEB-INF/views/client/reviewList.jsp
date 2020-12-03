<%@page import="store.model.vo.Review"%>
<%@page import="order.model.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="coupon.model.vo.Coupon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		ArrayList<Review> revList = (ArrayList<Review>)session.getAttribute("revList");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	font-family: 'Noto Sans KR';
}

.review-modal-wrap {
	/*원랜 상위 요소에 relative를 줘야하는데 얘는 브라우저 전체를 채울거라서 굳이 안써도 됨*/
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100vw;
	height: 100vh;
	background-color: rgba(0, 0, 0, 0.5);
	display: none;
	/*            display: flex;*/
	/*메인축*/
	justify-content: center;
	/*반대축*/
	align-items: center;
}

.review-modal {
	background-color: #fff;
	width: 70vw;
	height: 50vh;
	/*화면이 너무 작아도 비율이 이상하므로 max와 min을 걸어준다.*/
	max-width: 500px;
	min-width: 500px;
	min-height: 400px;
}

.review-modal-top>h1 {
	text-align: center;
	margin-top : 15px;
	margin-bottom: 15px;
}

.review-modal-content {
	text-align: center;
}

.review-list {
	border: 1px solid #383a3f;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="review-modal-wrap">
		<div class="review-modal">
			<div class="review-modal-top">
				<h1>리뷰 내역</h1> 
			</div>
			<div class="review-modal-content">
				<div class="review-list"
					style="overflow-y: scroll; width: 400px; height: 250px; overflow-x: hidden;">
					<ul class="cp-list">
						<%for(Review r : revList) {%>
								<li>
									<div class="cp-text">
										<p><%=r.getRevContentBr() %></p>
										<p><%=r.getRevEnrollDate() %></p>
									</div>
								</li>
						<%} %>
					</ul>
				</div>
				<input type="button" value="닫기" id="cancel">
			</div>
		</div>
	</div>
	<script>
        $(function(){
			$("#review-img").click(function(){
              $(".review-modal-wrap").css('display','flex');
              $('body').css("overflow", "hidden");	//body 스크롤 막기	
           	});
            
            //닫기 버튼
            $("input[type=button]").click(function(){
                $(".review-modal-wrap").css('display','none');
            });
            
            $(".review-modal-wrap").click(function(){
                $(".review-modal-wrap").css('display','none');
            });
            
            $(".review-modal-wrap>*").click(function(event){
                event.stopPropagation();
            });
        });
    </script>
</body>
</html>