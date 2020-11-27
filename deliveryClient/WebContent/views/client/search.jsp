<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 / 비밀번호 찾기</title>
	
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

        .search-content>ul{
            padding: 0;
            margin: 0;
            list-style-type: none;
            overflow: hidden;
        }
        .search-content>ul>li>a{
            text-decoration: none;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            box-sizing: border-box;
            border-top: 1px solid #c7c7c7;
        }
        
        .in{
            color: #383a3f;
            display: inline-block;
            width: 649px;
            height: 10    0px;
            float: left;
            background-color: white;
            font-size: 30px;
            line-height: 100px;
            text-align: center;
            box-sizing: border-box;
        }
        
        .in:hover{
            color: #383a3f;
        }
        
        .out{
            color: #383a3f;
            display: inline-block;
            width: 649px;
            height: 10    0px;
            float: left;
            background-color: #c7c7c7;
            font-size: 30px;
            line-height: 100px;
            text-align: center;
            box-sizing: border-box;
        }
        
        .out:hover{
            color: white;
        }
        
        .search{
            height: 500px;
            padding-top: 40px;
            border: 0px 1px 1px 1px solid #c7c7c7;
        }
        .search-table{
            margin: 0 auto;
        }
        .search-table>tbody>tr>td{
            width: 500px;
            height: 60px;
        }
        .search-table>tbody>tr>th{
            height: 80px;
            vertical-align: bottom;
            font-size: 1.5em;
        }
        .search-table>tbody>tr>td>input{
            width: 100%;
            height: 100%;
            border: none;
            outline: none;
            border: 1px solid #cccccc;
            text-align: center;
        }
        button{
            height: 60px;
            width: 400px;
            background-color: #383a3f;
            color: white;
            margin-top: 60px;
            text-align: center;
        }
        
        .search-table>tbody>tr:last-child{
            text-align: center;
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="content-all-wrap">
        <div class="search-header">
            <h1>아이디 / 비밀번호 찾기</h1>
        </div>
        <div class="search-content-wrap">
            <div class="search-content">
                <ul>
                    <li><a href="javascript:void(0)" id="id">아이디</a></li>
                    <li><a href="javascript:void(0)" id="pw">비밀번호</a></li>
                </ul>
                <div class="search">
                    <form action="/searchId" method="post" id="idFrm">
                        <table class="search-table">
                            <tr>
                                <th>이름</th>
                            </tr>
                            <tr>
                                <td><input type="text" id="cliName" name="cliName"></td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                            </tr>
                            <tr>
                                <td><input type="text" id="cliTel1" name="cliTel1"></td>
                            </tr>
                            <tr>
                                <td><button type="submit">찾기</button></td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="search">
                    <form action="/searchPw" method="post" id="pwFrm">
                        <table class="search-table">
                            <tr>
                                <th>아이디</th>
                            </tr>
                            <tr>
                                <td><input type="text" id="cliId" name="cliId"></td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                            </tr>
                            <tr>
                                <td><input type="text" id="cliTel2" name="cliTel2"></td>
                            </tr>
                            <tr>
                                <td><button type="submit">찾기</button></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
        $(function() {
            $("#id").addClass('in');
            $("#pw").addClass('out');
            $(".search").eq(0).css('display', 'block');
            $(".search").eq(1).css('display', 'none');
        });
        $(".search-content").children("ul").children().click(function() {
            var idx = $(this).index();

            //0 -> id찾기, //1 -> pw찾기
            if (idx == 0) {
                $("#id").removeClass('out');
                $("#pw").removeClass('in');
                $("#id").addClass('in');
                $("#pw").addClass('out');
                $(".search").eq(0).css('display', 'block');
                $(".search").eq(1).css('display', 'none');
            } else {
                $("#id").addClass('out');
                $("#pw").addClass('in');
                $("#pw").removeClass('out');
                $("#id").removeClass('in');
                $(".search").eq(1).css('display', 'block');
                $(".search").eq(0).css('display', 'none');
            }
        });
    </script>
</body>
</html>