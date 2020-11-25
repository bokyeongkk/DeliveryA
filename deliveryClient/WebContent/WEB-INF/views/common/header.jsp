<%@page import="client.model.vo.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Client c = (Client) session.getAttribute("client");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
* {
	font-family: 'Noto Sans KR';
}

.header-all-wrap {
	display: flex;
	justify-content: center;
}

.header-wrap {
	width: 1300px;
	height: 60px;
	background-color: #383a3f;
	box-sizing: border-box;
	overflow: hidden;
	text-indent: 1.5em;
}

.header {
	float: left;
}

.col-md-3 {
	/*            border: 1px solid pink;*/
	display: inline-block;
	box-sizing: border-box;
	height: 60px;
}

.col-md-6 {
	display: inline-block;
	box-sizing: border-box;
	height: 60px;
}

.title {
	margin: 0;
	padding: 0;
}

.title>a{
	text-decoration: none;
	color: #f9a11b;
	line-height: 60px;
	font-size: 1.8em;
	font-weight: bold;
}

.nav-link {
	line-height: 60px;
	color: #f9a11b;
}
.header-nav-link{
	padding: 0;
	margin: 0;
	}

.nav-link:hover {
	color: white;
	font-weight: bold;
}
</style>
</head>

<body>

	<div class="header-all-wrap">
		<div class="header-wrap">
			<div class="col-md-3 header">
				<p class="title"><a href="/">모방의 민족</a></p>
			</div>
			<div class="col-md-6 header"></div>
			<div class="col-md-3 header">
				<ul class="nav justify-content-end">
					<%
						if (c == null) {
					%>
					<li class="nav-item"><a class="nav-link header-nav-link"
						href="javascript:void(0)" onclick="showLogin();">로그인</a></li>
					<li class="nav-item"><a class="nav-link header-nav-link" href="/views/client/join.jsp">회원가입</a></li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link header-nav-link" href="#">마이페이지</a></li>
					<li class="nav-item"><a class="nav-link header-nav-link" href="#">로그아웃</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="/views/client/login.jsp"%>
</body>
</html>