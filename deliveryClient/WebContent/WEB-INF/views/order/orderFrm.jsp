<%@page import="java.util.ArrayList"%>
<%@page import="order.model.vo.OrderDet"%>
<%@page import="order.model.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Order order = (Order)request.getAttribute("order");
    	ArrayList<OrderDet> listDet = (ArrayList<OrderDet>)request.getAttribute("orderDet");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<section>
	
	<div style="width: 1300px; margin: 0 auto;">	

		<h1>배달정보</h1>
		<h5>회원아이디 : <%=order.getOrdCliId() %></h5>
		<h5>회원주소: <%=order.getOrdAddr() %></h5>
		<br>
	
		<h1>주문하는 메뉴</h1>

		<% for(OrderDet d : listDet) {%>
			<h5>메뉴번호 : <%=d.getOrdDetMenuNo()%></h5>
			<h5>수량 : <%=d.getOrdDetCnt() %></h5>
		<%} %>
		<br>
	
		<h5>총 결제금액 : <%=order.getOrdTPrice() %></h5>
		<h5>쿠폰 : <%=order.getOrdCpId() %></h5>
	
	</div>
	
	</section>	
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>