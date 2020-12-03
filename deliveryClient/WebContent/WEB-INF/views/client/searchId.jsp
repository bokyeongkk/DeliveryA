<%@page import="client.model.vo.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Client> list = (ArrayList<Client>) request.getAttribute("searchId");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delivery-A | 아이디 찾기</title>
</head>
<body>
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
        }

        .search-header>h1 {
            margin: 0;
        }
        .search-content-wrap{
            margin-top: 50px;
            margin-bottom: 50px;
        }

        .search-content {
            text-align: center;
        }
        
        .search-content>h3{
            margin-top: 50px;
            margin-bottom: 50px;
        }
        
        .search-table{
            margin: 0 auto;
        }
        
        .search-table>tbody>tr>td{
            width: 400px;
            height: 60px;
            font-size: 17px;
            background-color: #c7c7c7;
        }
        .search-table>tbody>tr>th{
            height: 40px;
            text-align: left;
            font-size: 20px;
        }
        .btn-main{
            font-size: 1em;
            height: 60px;
            width: 400px;
            background-color: #383a3f;
            color: white;
            margin-top: 60px;
            text-align: center;
        }
    </style>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="content-all-wrap">
        <div class="search-header">
            <h1>아이디 찾기</h1>
        </div>
        <div class="search-content-wrap">
            <div class="search-content">
                <h3><%=list.size() %>개의 아이디를 찾았습니다.</h3>
                    <table class="search-table">
                    	<tr>
                           <th>아이디 목록</th>
                       </tr>
                        <%for(Client client : list){%>
                        	<tr>
                        		<td><%=client.getCliId() %></td>
                        	</tr>
                        <%} %>
                    </table>
                <a href="/"><button class="btn-main">메인으로</button></a>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>