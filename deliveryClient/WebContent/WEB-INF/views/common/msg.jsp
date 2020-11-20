<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//String으로 형변환
	String msg = (String) request.getAttribute("msg");
	String loc = (String) request.getAttribute("loc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Msg JSP</title>
</head>
<body>
	<script>
		alert("<%=msg%>");
		location.href="<%=loc%>";
	</script>
</body>
</html>