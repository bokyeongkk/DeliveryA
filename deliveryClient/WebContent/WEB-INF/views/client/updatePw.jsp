<%@page import="client.model.vo.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   		String id = (String) request.getAttribute("id");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delivery-A | 비밀번호 변경</title>
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

        .search-table {
            margin: 0 auto;
        }

        .search-table>tbody>tr>td {
            width: 400px;
            height: 40px;
            font-size: 17px;
        }

        .search-table>tbody>tr>th {
            height: 60px;
            text-align: left;
            font-size: 20px;
            vertical-align: bottom;
        }

        .search-table>tbody>tr>td>input {
            height: 50px;
            width: 100%;
            outline: none;
            border: 1px solid #cccccc;
        }

        .update-btn {
            font-size: 1em;
            height: 60px;
            width: 400px;
            background-color: #383a3f;
            color: white;
            margin-top: 60px;
            text-align: center;
        }
        
        .update-span {
            margin-left: 10px;
            font-size: 15px;
            font-weight: 400;
        }
    </style>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="content-all-wrap">
        <div class="search-header">
            <h1>비밀번호 변경</h1>
        </div>
        <div class="search-content-wrap">
            <div class="search-content">
                <form action="/updatePw" type="post">
                	<input type="hidden" name="cliId" value="<%=id %>">
                    <table class="search-table">
                        <tr>
                            <th>비밀번호<span class="update-span"></span></th>
                        </tr>
                        <tr>
                            <td><input type="password" id="cliPw" name="cliPw"></td>
                        </tr>
                        <tr>
                            <th>비밀번호 확인<span class="update-span"></span></th>
                        </tr>
                        <tr>
                            <td><input type="password" id="cliPw_re" name="cliPw_re"></td>
                        </tr>
                    </table>
                    <button class="update-btn">변경하기</button>
                </form>
            </div>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
        var check = [false, false];
         //비밀번호 확인
            $("#cliPw").change(function() {
                var reg = /^[A-Za-z0-9_-]{6,18}$/;
                if (reg.test($(this).val())) {
                    check[0] = true;
                    $("span").eq(0).text("");
                    $("#cliPw").css('border', '1px solid #64de40');
                } else {
                    check[0] = false;
                    $("span").eq(0).text("영어 대소문자+숫자 6~18자리");
                    $("span").eq(0).css('color', 'red');
                    $("#cliPw").css('border', '1px solid red');
                }
            });

            //비밀번호 재입력
            $("#cliPw_re").change(function() {
                var reg = /^[A-Za-z0-9_-]{6,18}$/;
                if ($("#cliPw").val() != "") {
                    if ($(this).val() == $("#cliPw").val()) {
                        check[1] = true;
                        $("span").eq(1).text("");
                        $("#cliPw_re").css('border', '1px solid #64de40');
                    } else {
                        check[1] = false;
                        $("span").eq(1).text("비밀번호가 일치하지 않습니다.");
                        $("span").eq(1).css('color', 'red');
                        $("#cliPw_re").css('border', '1px solid red');
                    }
                }
            });
    </script>
</body>
</html>