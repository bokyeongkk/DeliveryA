<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	    <div class="content-all-wrap">
        <div class="search-header">
            <h1>주문 완료</h1>
            <p>주문이 성공적으로 접수되었습니다.</p>
            <hr>
        </div>
        <div class="search-content-wrap">
            <div class="search-content">
                   <p>주문번호 : </p>
                    <a href="/"><button>메인으로 돌아가기</button></a>
            </div>
        </div>
    </div>
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>