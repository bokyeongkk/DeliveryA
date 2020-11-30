<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
    <style>
        .content-all-wrap {
            width: 1300px;
            margin: 0 auto;
        }

        .content-navi {
            width: 1300px;
            background-color: lightgray;
            overflow: hidden;
        }

        .user-info {
            width: 900px;
            padding-left: 150px;
            display: flex;
            align-items: center;
            float: left;
            height: 170px;
        }

        .user-text {
            box-sizing: border-box;
            padding-left: 10px;
        }

        .user-text>h1 {
            margin: 0;
            padding: 0;
            margin-top: 5px;
            margin-right: 5px;
            display: inline-block;
        }

        .user-menu {
            height: 170px;
            width: 400px;
            float: left;
            display: flex;
            justify-content: center;
            align-items: center;
            padding-right: 30px;
            overflow: hidden;
        }

        .profile-img {
/*            background: ;-color: aquamarine;*/
            width: 90px;
            height: 90px;
            border-radius: 50%;
            text-align: center;
            float: left;
        }
    
        .profile-img>img{
            width: 100%;
            height: 100%;
        }
        .menu-img {
            background-color: aqua;
            width: 80px;
            height: 80px;
            border-radius: 50%;
            text-align: center;
            float: left;
            margin: 10px 10px 0px 10px;
        }

        .menu-text {
            text-align: center;
        }

        .content-wrap {
            background-color: white;
            width: 1300px;
        }

        .join-table {
            margin: 0 auto;
            margin-top: 30px;
        }

        .join-table>tbody>tr>th {
            height: 70px;
            font-size: 1.5em;
            vertical-align: bottom;
        }

        .join-table>tbody>tr>th>span {
            margin-left: 10px;
            font-size: 15px;
            font-weight: 400;
        }

        .join-table>tbody>tr>td {
            width: 250px;
            height: 50px;
        }

        .join-table>tbody>tr>td:last-child {
            width: 180px;
            text-align: center;
        }

        .join-input {
            width: 100%;
            height: 50px;
            outline: none;
            border: none;
            border: 1px solid #cccccc;
            text-align: center;
        }

        .join-table button {
            width: 150px;
            height: 50px;
            outline: none;
            border: none;
            background-color: #383a3f;
            color: white;
        }

        input[type=radio] {
            display: none;

        }

        .radio-label {
            width: 150px;
            height: 50px;
            line-height: 50px;
            outline: none;
            border: none;
            color: white;
            background-color: white;
            border: 1px solid #383a3f;
            color: #383a3f;
            margin-left: 10px;
            margin-right: 10px;
        }

        input[type=radio]:checked+label {
            font-weight: bold;
            width: 150px;
            height: 50px;
            outline: none;
            border: none;
            background-color: #383a3f;
            border: 1px solid #383a3f;
            color: white;
        }

        button[type=submit] {
            margin-top: 50px;
            margin-bottom: 30px;
        }
    </style>
</head>

<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	    <div class="content-all-wrap">
        <div class="content-navi">
            <div class="user-info">
                <div class="profile-img">
                    <img src="user.png">
                </div>
                <div class="user-text">
                    <span>안녕하세요,<br></span>
                    <h1>닉네임</h1><span>님</span>
                </div>
            </div>
            <div class="user-menu">
                <div class="menu-wrap">
                    <div class="menu-img">

                    </div>
                    <div class="menu-text">
                        <span>주문 내역</span>
                    </div>
                </div>
                <div class="menu-wrap">
                    <div class="menu-img">

                    </div>
                    <div class="menu-text">
                        <span>리뷰 관리</span>
                    </div>
                </div>
                <div class="menu-wrap">
                    <div class="menu-img">

                    </div>
                    <div class="menu-text">
                        <span>쿠폰</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-wrap">
            <form action="/updateClient" method="post">
                <table class="join-table">
                    <tr>
                        <th colspan="3">아이디<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliId" id="cliId" class="join-input" value=<%=c.getCliId() %> readonly></td>
                    </tr>
                    <tr>
                        <th colspan="3">비밀번호<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="password" name="cliPw" id="cliPw" class="join-input"></td>
                    </tr>
                    <tr>
                        <th colspan="3">비밀번호 확인<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="password" name="cliPw_re" id="cliPw_re" class="join-input"></td>
                    </tr>
                    <tr>
                        <th colspan="3">이메일<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliEmail" id="cliEmail" class="join-input" <%=c.getCliEmail() %>readonly></td>
                    </tr>
                    <tr>
                        <th colspan="3">우편번호<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="text" id="cliPost" class="join-input"></td>
                        <td style="text-align: right;"><button type="button">우편번호 찾기</button></td>
                    </tr>
                    <tr>
                        <th colspan="3">주소<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliAddr" id="cliAddr" class="join-input" value=<%=c.getCliAddr() %>></td>
                    </tr>
                    <tr>
                        <th colspan="3">상세주소<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliAddrDet" id="cliAddrDet" class="join-input" value=<%=c.getCliAddrDet() %>></td>
                    </tr>
                    <tr>
                        <th colspan="3">이름<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliName" id="cliName" class="join-input" value=<%=c.getCliName() %> readonly></td>
                    </tr>
                    <tr>
                        <th colspan="3">전화번호<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliTel" id="cliTel" class="join-input" value=<%=c.getCliTel() %>></td>
                    </tr>
                    <tr>
                        <th colspan="3">닉네임<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="text" name="cliNick" id="cliNick" class="join-input" value=<%=c.getCliNickname() %>></td>
                    </tr>
                    <tr>
                        <th colspan="3">생일<span></span></th>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="date" name="cliBirth" id="cliBirth" class="join-input" style="width: 100%;" value=<%=c.getCliBirth() %> readonly>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <button type="submit" style="width: 350px; height: 70px; font-size: 1.5em;" id="UpdateBtn">정보 수정</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    
    <script>
        $(function() {
            var check = [false, false, false, false];
           
            //비밀번호 확인
            $("#cliPw").change(function() {
                var reg = /^[A-Za-z0-9_-]{6,18}$/;
                if (reg.test($(this).val())) {
                    check[0] = true;
                    $("span").eq(1).text("");
                    $("#cliPw").css('border', '1px solid #64de40');
                } else {
                    check[0] = false;
                    $("span").eq(1).text("영어 대소문자+숫자 6~18자리");
                    $("span").eq(1).css('color', 'red');
                    $("#cliPw").css('border', '1px solid red');
                }
            });

            //비밀번호 재입력
            $("#cliPw_re").change(function() {
                var reg = /^[A-Za-z0-9_-]{6,18}$/;
                if ($("#cliPw").val() != "") {
                    if ($(this).val() == $("#cliPw").val()) {
                        check[1] = true;
                        $("span").eq(2).text("");
                        $("#cliPw_re").css('border', '1px solid #64de40');
                    } else {
                        check[1] = false;
                        $("span").eq(2).text("비밀번호가 일치하지 않습니다.");
                        $("span").eq(2).css('color', 'red');
                        $("#cliPw_re").css('border', '1px solid red');
                    }
                }
            });
            //전화번호 확인
            $("#cliTel").change(function() {
                var reg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
                if (reg.test($(this).val())) {
                    check[2] = true;
                    $("span").eq(8).text("");
                    $("#cliTel").css('border', '1px solid #64de40');
                } else {
                    check[2] = false;
                    $("span").eq(8).text("전화번호 형식 : 000-000(0)-0000 / 00-000(0)-0000");
                    $("span").eq(8).css('color', 'red');
                    $("#cliTel").css('border', '1px solid red');
                }
            });

            //닉네임 확인
            $("#cliNick").change(function() {
                var reg = /^[0-9A-Za-z가-힣]{2,10}$/;
                if (reg.test($(this).val())) {
                    check[3] = true;
                    $("span").eq(9).text("");
                    $("#cliNick").css('border', '1px solid #64de40');
                } else {
                    check[3] = false;
                    $("span").eq(9).text("2~10글자");
                    $("span").eq(9).css('color', 'red');
                    $("#cliNick").css('border', '1px solid red');
                }
            });
            

            //Submit 버튼
            $("#UpdateBtn").click(function(event) {
            	for (var i = 0; i < check.length; i++) {
                    if (check[i] == true) {
                        regChk++;
                    }
                }
                if (regChk < 4) {
                    alert("입력한 정보를 확인해주세요.");
                    event.preventDefault();
                }
            });
        });

    </script>
</body>
</html>