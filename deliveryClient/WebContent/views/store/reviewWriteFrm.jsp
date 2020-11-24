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
	
<title>Insert title here</title>

<style>
.review-modal-wrap {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	display: none;
	justify-content: center;
	align-items: center;
}

.review-modal {
	background-color: #ffffff;
	width: 30vw;
	max-height: 900px;
	min-width: 300px;
	min-height: 340px;
	padding: 35px;
}

.review-modal-btn {
	text-align: center;
	padding-top: 40px;
	padding-bottom: 15px;
}

.review-modal-btn input {
	width: 40%;
	height: 50px;
}

#star {
	color: #f6b352;
	width: 28px;
	height: 28px;
}
</style>
</head>
<body>

	<div class="review-modal-wrap">
		<div class="review-modal">
			<form action="/reviewWriteFrm" method="post">

				<h1>리뷰 작성하기</h1>
				<hr>
				<h4>고객님 오늘 음식은 어떠셨어요?</h4>
				<i class="far fa-star grade-mark" id="star"></i> 
				<i class="far fa-star grade-mark" id="star"></i> 
				<i class="far fa-star grade-mark" id="star"></i> 
				<i class="far fa-star grade-mark" id="star"></i> 
				<i class="far fa-star grade-mark" id="star"></i> 
				<input type="hidden" class="grade" name="" value="리뷰점수"> 
				
				<input type="hidden" name="" value="회원아이디"> 
				<input type="hidden" name="" value="가게아이디"> 
				
				<br><br>
				<textarea class="form-control" name="reviewContent" cols="40"
					rows="8" style="resize: none"></textarea>
				<div class="review-modal-btn">
					<input type="button" class="btn btn-dark" value="취소"> 
					<input type="submit" class="btn btn-outline-dark" value="작성완료">
				</div>

			</form>
		</div>
	</div>

	<script>
		function reviewWriteFrm() {
			$(".reveiw-modal-wrap").css("display", "flex");
		}

		//모달 창 닫기 버튼
		$("input[type=button]").click(function() {
			$(".review-modal-wrap").css("display", "none");
			$(".grade-mark").removeClass("fas fa-star")
			$(".grade-mark").addClass("far fa-star");
		});

		$(function() {

			//리뷰 작성 시 별점 이벤트
			$(".grade-mark").click(function() {
				mark = $(".grade-mark");
				idx = $(".grade-mark").index(this);

				mark.removeClass('fas fa-star')
				mark.removeClass('far fa-star')

				mark.each(function(index, item) {
					if (index <= idx) {
						$(item).addClass('fas fa-star');
					} else {
						$(item).addClass('far fa-star');
					}
				});

				//별점 숫자 확인용
				$(".grade").val((idx + 1));
				console.log($(".grade").val());
			});

		});
	</script>




</body>
</html>