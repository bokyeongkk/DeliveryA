<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <style>
        * {
            font-family: 'Noto Sans KR';
        }
        .login-modal-wrap {
            /*원랜 상위 요소에 relative를 줘야하는데 얘는 브라우저 전체를 채울거라서 굳이 안써도 됨*/
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100vw;
            height: 100vh;
            display:none;
            background-color: rgba(0, 0, 0, 0.5);
            /*메인축*/
            justify-content: center;
            /*반대축*/
            align-items: center;
            z-index : 100;
        }

        .login-modal {
            background-color: #fff;
            width: 70vw;
            height: 50vh;
            /*화면이 너무 작아도 비율이 이상하므로 max와 min을 걸어준다.*/
            max-width: 500px;
            min-width: 500px;
            min-height: 400px;
            z-index : 101;
        }
        
        .login-modal-top>h1{
        	margin-top: 30px;
            text-align: center;
        }
        
        .login-modal-content>form>p{
            margin: 0;
            padding: 0;
        }
        
        .login-modal-content>form>input{
            display: block;
            /*무조건 넣기!*/
            outline: none;
            margin: 20px auto;
            width: 80%;
            height: 30px;
            border: 1px solid #ccc;
        }
        
        .login-modal-content>form>p{
            margin-right: 48px;
            margin-left: 48px;
            margin-bottom: -10px;
        }
        
        .login-menu{
            margin-top: -15px;
            margin-right: 50px;
            margin-left: 50px;
            display: flex;
            justify-content: space-between;
        }
        .login-menu>*{
            font-size: 10px;
        }
        .login-menu>p{
            margin: 0;
            display: inline-block;
        }
        
        .login-menu>p>a{
            text-decoration: none;
            color: #383a3f;
        }
        
        .login-btn{
            display: flex;
            justify-content: center;
        }
        
        .login-btn>input,.login-btn>button{
            height: 50px;
            width: 200px;
            margin-left: 20px;
            background-color: #383a3f;
            color: white;
        }
        #join{
            color: red;
        }
        
    </style>

	<div class="login-modal-wrap">
        <div class="login-modal">
            <div class="login-modal-top">
                <h1>로그인</h1>
            </div>
            <div class="login-modal-content">
                <form action="/login" method="post">
                   <p>아이디</p>
                    <input type="text" name="id" placeholder="아이디를 입력하세요">
                    <p>비밀번호</p>
                    <input type="password" name="pw" placeholder="비밀번호를 입력하세요">
                    <div class="login-menu">
                        <p><a href="#">아이디 / 비밀번호 찾기</a></p>
                        <p>아직 회원이 아니신가요? <a href="#" id="join">회원가입</a></p>
                    </div>
                    <br>
                    <br>
                    <div class="login-btn">
                        <button>로그인</button>	
                    	<input type="button" value="닫기">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
		function showLogin() {
			$(".login-modal-wrap").css('display', 'flex');
		}
		 //닫기 버튼
        $("input[type=button]").click(function(){
            $(".login-modal-wrap").css('display','none');
        });
        
        //이렇게 할 경우 자식을 클릭해도 사라지므로 버블링 걸어줘야 함
        $(".login-modal-wrap").click(function(){
            $(".login-modal-wrap").css('display','none');
        });
        
        //이벤트 버블링 막기
        $(".login-modal-wrap>*").click(function(event){
        	event.stopPropagation();
        });
	</script>
