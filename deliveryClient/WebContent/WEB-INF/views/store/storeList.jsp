<%@page import="store.model.vo.Store"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<%
		ArrayList<Store> listStore = (ArrayList<Store>)request.getAttribute("listStore");
	%>
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
<title>delivery-A | 가게 목록</title>
</head>
<body>
	
	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<section>

	<div class="content-wrap">
	
		<div class="category-navi">
			<ul>
				<li><a href="/searchCategory?categoryNo=1">치킨</a></li>
				<li><a href="/searchCategory?categoryNo=2">피자</a></li>
				<li><a href="/searchCategory?categoryNo=3">한식</a></li>
				<li><a href="/searchCategory?categoryNo=4">중식</a></li>
				<li><a href="/searchCategory?categoryNo=5">일식</a></li>
				<li><a href="/searchCategory?categoryNo=6">양식</a></li>
				<li><a href="/searchCategory?categoryNo=7">분식</a></li>
				<li><a href="/searchCategory?categoryNo=8">족발·보쌈</a></li>
				<li><a href="/searchCategory?categoryNo=9">패스트푸드</a></li>
			</ul>
		</div>

		<div class="store-box-wrap">

		<%for(Store s : listStore) {%>
			<div class="store-box">
				<div class="store-box-img">
					<img src="/upload/ready.jpg" style="width: 100%; height: 100%;">
					<!-- <img src="/filepath/01_store/<%=s.getStoreFilepath()%>" style="width: 100%; height: 100%;"> -->
				</div>
				<div class="store-box-text">
					<ul>
						<li class="store-name"><a href="/storeDetailView?storeNo=<%=s.getStoreNo() %>" id="store-name"><%=s.getStoreName() %></a></li>
						<li class="store-etc">매주 <%=s.getStoreRest() %> 휴무</li>
						<li class="store-etc">운영시간  : <%=s.getStoreStartT() %> ~ <%=s.getStoreEndT() %></li>
						<br>
						<li id="coupon">쿠폰사용가능</li>
					</ul>
				</div>
			</div>
		<%} %>	
		
		</div>
		
	</div><!--전체content를 감싸는 div--> 
	
	</section>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

	<script>
		
		//div를 클릭해도 내부 a태그의 링크로 이동
    	$(".store-box").click(function() {
        	location.href=$(this).children().find("a").attr("href");
    	});
    
		//a태그 이벤트 버블링 제거
     	$(".store-box a").click(function(event){
         	event.stopPropagation();
     	});

	</script>

</body>
</html>