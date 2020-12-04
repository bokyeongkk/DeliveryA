<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>delivery-A | 회원가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">
	
<!-- 다음 주소찾기 API -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	

<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
body {
	background-color: #adadad;
}

* {
	font-family: 'Noto Sans KR';
}

.content-all-wrap {
	width: 800px;
	margin: 0 auto;
	padding-bottom: 200px;
	background-color: white;
}

.join-header {
	height: 200px;
}

.join-header>h1 {
	padding: 0;
	margin: 0;
	text-align: center;
}

.join-table {
	margin: 0 auto;
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

#cancel {
	background-color: white;
	border: 1px solid #383a3f;
	color: #383a3f
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

.prev {
	/*            background-color: pink;*/
	display: inline-block;
	width: 100px;
	height: 100px;
	text-align: center;
}

.prev>a {
	text-decoration: none;
	font-size: 50px;
	font-weight: 200;
	color: #383a3f;
}

.check-td>a {
	text-decoration: none;
	color: #a0a0a0;
	margin: 0px 10px 20px 10px;
	display: inline-block;
	/*            border: 1px solid red;*/
}

input[type=checkbox] {
	-ms-transform: scale(1.5)
}

#all+label {
	font-weight: bold;
}

.p-checkId {
	padding: 0;
	margin: 0;
	display: inline;
	margin-left: 10px;
	font-size: 15px;
	font-weight: 400;
}

#ok, #no {
	display: none;
}
</style>
</head>
<body>
	<div class="content-all-wrap">
		<div class="join-header">
			<div class="prev">
				<a href="/">&lt;</a>
			</div>
			<h1>회원가입</h1>
		</div>
		<form name="checkIdFrm">
			<input type="hidden" name="checkId">
		</form>
		<form action="/join" method="post">
			<table class="join-table">
				<tr>
					<th colspan="3">아이디<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="cliId" id="cliId"
						class="join-input"></td>
					<td style="width: 10px;">
						<p class="p-checkId">

							<svg width="2em" height="2em" viewBox="0 0 16 16"
								class="bi bi-check-circle" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg" color="green" id="ok">
							<path fill-rule="evenodd"
								d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
							<path fill-rule="evenodd"
								d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z" />
							</svg>

							<svg width="2em" height="2em" viewBox="0 0 16 16"
								class="bi bi-x-circle" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg" color="red" id="no"> <path
								fill-rule="evenodd"
								d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
							<path fill-rule="evenodd"
								d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
							</svg>

						</p>
					</td>
				</tr>
				<tr>
					<th colspan="3">비밀번호<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="password" name="cliPw" id="cliPw"
						class="join-input"></td>
				</tr>
				<tr>
					<th colspan="3">비밀번호 확인<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="password" name="cliPw_re"
						id="cliPw_re" class="join-input"></td>
				</tr>
				<tr>
					<th colspan="3">이메일<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="cliEmail"
						id="cliEmail" class="join-input"></td>
				</tr>
				<tr>
					<th colspan="3">우편번호<span></span></th>
				</tr>
				<tr>
					<td colspan="2">
					<input type="text" id="postCode" class="join-input" placeholder="우편번호" readonly>
					</td>
					<td style="text-align: right;">
					<button type="button" id="addrSearchBtn" onclick="addrSearch();">우편번호 찾기</button>
					</td>
				</tr>
				<tr>
					<th colspan="3">주소<span></span></th>
				</tr>
				<tr>
					<td colspan="3">
					<input type="text" name="cliAddr" id="roadAddr" class="join-input" placeholder="도로명주소" readonly>
					</td>
				</tr>
				<tr>
					<th colspan="3">상세주소<span></span></th>
				</tr>
				<tr>
					<td colspan="3">
					<input type="text" name="cliAddrDet" id="detailAddr" class="join-input">
					</td>
				</tr>
				<tr>
					<th colspan="3">이름<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="cliName" id="cliName"
						class="join-input"></td>
				</tr>
				<tr>
					<th colspan="3">전화번호<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="cliTel" id="cliTel"
						class="join-input"></td>
				</tr>
				<tr>
					<th colspan="3">닉네임<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="cliNickname" id="cliNick"
						class="join-input"></td>
				</tr>
				<!--추가정보-->
				<tr>
					<th colspan="3">성별<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="radio" name="cliGender" id="m"
						value="m" class="join-input"><label for="m"
						class="radio-label">남자</label> <input type="radio"
						name="cliGender" id="f" value="f" class="join-input"><label
						for="f" class="radio-label">여자</label></td>
				</tr>
				<tr>
					<th colspan="3">생일<span></span></th>
				</tr>
				<tr>
					<td colspan="3"><input type="date" name="cliBirth"
						id="cliBirth" class="join-input" style="width: 100%;"></td>
				</tr>
				<tr>
					<td colspan="3" class="check-td" style="height: 300px;"><input
						type="checkbox" id="all"><label for="all">&nbsp;전체
							약관에 동의합니다.</label> <br> <input type="checkbox" id="check1"><label
						for="check1">&nbsp;필수 항목에 동의합니다.</label><br> <a href="#">이용약관</a>
						<a href="#">개인정보 수집이용 동의</a> <br> <input type="checkbox"
						id="check2"><label for="check2">&nbsp;광고성 정보 수신
							동의(선택)</label><br> <a href="#">회원에게 제공하는 서비스의 광고성 정보를 수신합니다.</a> <br>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<!--<button type="submit">회원가입</button>
                        <button type="button" onclick="goIndex();" id="cancel">취소</button>-->
						<button type="submit"
							style="width: 350px; height: 70px; font-size: 1.5em;"
							id="joinBtn">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script>
        $(function() {
            var check = [false, false, false, false, false, false, false, false, false];
            $("#cliId").keyup(function(){
            	$("#ok").css('display','none');
            	$("#no").css('display','none');
            });
            //아이디 확인 및 중복체크
            $("#cliId").change(function() {
                var cliId = $(this).val();
                var reg = /^[a-zA-Z][A-Za-z0-9_-]{2,12}$/;
                if (reg.test(cliId)) {
                    check[0] = true;
                    $("span").eq(0).text("");
                    $("#cliId").css('border', '1px solid #64de40');
                } else {
                    check[0] = false;
                    $("span").eq(0).text("영어 대소문자+숫자 3~12자리(시작은 영어로)");
                    $("span").eq(0).css('color', 'red');
                    $("#cliId").css('border', '1px solid red');
                }
                if(check[0]){
                    $.ajax({
                        url: "/ajaxCheckId",
                        type: "get",
                        data: {cliId: cliId},
                        success: function(data) {
                            var msg = $("#idchkMsg");
                            if (data==1) {	//중복 회원 없음
                                $("#ok").css('display','block');
                                $("#no").css('display','none');
                                $("#cliId").css('border', '1px solid #64de40');
                            } else {		//중복 회원 있음
                                $("#no").css('display','block');
                                $("#ok").css('display','none');
                                $("#cliId").css('border', '1px solid red');
                                check[0]=false;
                            }
                        },
        				error : function(data){
        					alert("ajax 오류");
        				}
                    });
                }
                
            });

            //비밀번호 확인
            $("#cliPw").change(function() {
                var reg = /^[A-Za-z0-9_-]{6,18}$/;
                if (reg.test($(this).val())) {
                    check[1] = true;
                    $("span").eq(1).text("");
                    $("#cliPw").css('border', '1px solid #64de40');
                } else {
                    check[1] = false;
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
                        check[2] = true;
                        $("span").eq(2).text("");
                        $("#cliPw_re").css('border', '1px solid #64de40');
                    } else {
                        check[2] = false;
                        $("span").eq(2).text("비밀번호가 일치하지 않습니다.");
                        $("span").eq(2).css('color', 'red');
                        $("#cliPw_re").css('border', '1px solid red');
                    }
                }
            });

            //이메일 확인
            $("#cliEmail").change(function() {
                var reg = /^[a-z][a-z0-9_-]{3,12}@([a-z\d\.]+)\.([a-z]{2,6})$/;
                if (reg.test($(this).val())) {
                    check[3] = true;
                    $("span").eq(3).text("");
                    $("#cliEmail").css('border', '1px solid #64de40');
                } else {
                    check[3] = false;
                    $("span").eq(3).text("올바르지 않은 이메일 형식입니다.");
                    $("span").eq(3).css('color', 'red');
                    $("#cliEmail").css('border', '1px solid red');
                }
            });

            //이름 확인
            $("#cliName").change(function() {
                var reg = /^[가-힣]{2,6}$/;
                if (reg.test($(this).val())) {
                    check[4] = true;
                    $("span").eq(7).text("");
                    $("#cliName").css('border', '1px solid #64de40');
                } else {
                    check[4] = false;
                    $("span").eq(7).text("한글 2~6글자");
                    $("span").eq(7).css('color', 'red');
                    $("#cliName").css('border', '1px solid red');
                }
            });

            //전화번호 확인
            $("#cliTel").change(function() {
                var reg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
                if (reg.test($(this).val())) {
                    check[5] = true;
                    $("span").eq(8).text("");
                    $("#cliTel").css('border', '1px solid #64de40');
                } else {
                    check[5] = false;
                    $("span").eq(8).text("전화번호 형식 : 000-000(0)-0000 / 00-000(0)-0000");
                    $("span").eq(8).css('color', 'red');
                    $("#cliTel").css('border', '1px solid red');
                }
            });

            //닉네임 확인
            $("#cliNick").change(function() {
                var reg = /^[0-9A-Za-z가-힣]{2,6}$/;
                if (reg.test($(this).val())) {
                    check[6] = true;
                    $("span").eq(9).text("");
                    $("#cliNick").css('border', '1px solid #64de40');
                } else {
                    check[6] = false;
                    $("span").eq(9).text("2~6글자");
                    $("span").eq(9).css('color', 'red');
                    $("#cliNick").css('border', '1px solid red');
                }
            });
            //생일 입력 확인
            $("#cliBirth").change(function(){
                if($(this).val()!=""){
                    check[7] = true;
                } else {
                    check[7] = false;
                }
            });

            //성별 선택
            $("input[type=radio]").click(function(){
               if($('input[type=radio]:checked').val() != "") {
                   check[8] = true;
               }
            });
            
            // 체크박스 전체 선택
            $("#all").click(function() {
                if ($("#all").is(":checked")) {
                    $("#check1").prop('checked', true);
                    $("#check2").prop('checked', true);
                }
            });

            //체크박스 선택
            $("input:checkbox").click(function() {
                if (!$(this).is(":checked")) {
                    $("#all").prop('checked', false);
                } else {
                    if ($("#check1").is(":checked") && $("#check2").is(":checked")) {
                        $("#all").prop('checked', true);
                    }
                }
            });
            
            

            //Submit 버튼
            $("#joinBtn").click(function(event) {
                if ($("#check1").is(":checked")) {
                    var regChk = 0;
                    for (var i = 0; i < check.length; i++) {
                        if (check[i] == true) {
                            regChk++;
                        }
                    }
                    if (regChk < 9) {
                        alert("입력한 정보를 확인해주세요.");
                        event.preventDefault();
                    }
                } else {
                    alert("필수 약관에 동의해주세요.");
                    event.preventDefault();
                }
            });
        });
        
        //주소찾기 API
        function addrSearch() { 
        	new daum.Postcode({ 
        		oncomplete : function(data) { 
        			$("#postCode").val(data.zonecode); //우편번호
        			$("#roadAddr").val(data.roadAddress); //도로명주소 
					$("#detailAddr").focus(); //상세주소로 포커스 이동 
				} 
        	}).open(); 
        }

    </script>
</body>
</html>