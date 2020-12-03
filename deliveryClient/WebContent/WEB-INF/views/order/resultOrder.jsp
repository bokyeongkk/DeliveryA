<%@page import="order.model.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Order order =  (Order)request.getAttribute("order");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delivery-A | 주문 완료</title>
<style>
        .content-all-wrap {
            width: 1300px;
            margin: 0 auto;
            overflow: hidden;
            border: 1px solid #c7c7c7;
            box-sizing: border-box;
        }

        .search-header {
            height: 200px;
            padding-top: 100px;
            text-align: center;
            margin-bottom: 100px;
        }
        
        .search-header>hr{
            margin-top: 60px;
            width: 800px;
        }
        
        .search-content-wrap {
            margin-top: 50px;
            margin-bottom: 50px;
        }

        .search-content {
            text-align: center;
        }

        .search-content>h3 {
            margin-top: 50px;
        }

        button {
            font-size: 1em;
            height: 60px;
            width: 250px;
            background-color: #383a3f;
            color: white;
            margin-top: 10px;
            text-align: center;
        }
    </style>
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
                   <p>주문번호 : <%=order.getOrdDate() %>-<%=order.getOrdNo() %></p>
                    <a href="/"><button>메인으로 돌아가기</button></a>
            </div>
        </div>
    </div>
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>