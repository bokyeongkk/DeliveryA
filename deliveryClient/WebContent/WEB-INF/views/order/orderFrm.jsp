<%@page import="coupon.model.vo.Coupon"%>
<%@page import="order.model.vo.OrderClient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="order.model.vo.OrderDet"%>
<%@page import="order.model.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	OrderClient oc = (OrderClient)request.getAttribute("orderClient");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문하기</title>
<style>
        .content-all-wrap {
            width: 1300px;
            padding-left: 100px;
            padding-right: 100px;
            margin: 0 auto;
            padding-top: 50px;
            padding-bottom: 50px;
            border: 1px solid #cccccc;
            overflow: hidden;
        }

        .delivery-div {
            background-color: lightgray;
            text-indent: 50px;
            margin-bottom: 30px;
        }

        .info-table>tbody>tr:first-child {
            height: 80px;
        }

        .info-table>tbody>tr:nth-child(2n) {
            height: 40px;
            vertical-align: bottom;
        }
        
        .info-table>tbody>tr:nth-child(3n)>td>input {
            height: 40px;
        }

        .info-table>tbody>tr:last-child {
            height: 60px;
            vertical-align: top;

        }

        .info-table h3 {
            margin: 0;
        }

        .info-table input {
            border: none;
            outline: none;
            font-size: 1.3em;
            width: 1000px;
            height: 30px;
        }

        input[readonly] {
            background-color: transparent;
        }

        .info-table>tbody>tr>td {
            width: 1000px;
            height: 50px;
            text-indent: 50px;
        }

        .delivery-table>tbody>tr>td>p {
            font-size: 1.3em;
        }

        .sub-table>tbody>tr:first-child {
            /*            border: 1px solid red;*/
            height: 80px;
        }

        .sub-table>tbody>tr:nth-child(2n) {
            /*            border: 1px solid red;*/
            height: 40px;
            vertical-align: bottom;
        }

        .sub-table>tbody>tr:last-child {
            /*            border: 1px solid red;*/
            height: 60px;
            vertical-align: top;

        }

        .sub-table h3 {
            margin: 0;
        }

        .sub-table input {
            border: none;
            outline: none;
            font-size: 1.3em;
            width: 1000px;
            height: 40px;
        }

        input[readonly] {
            background-color: transparent;
        }

        .sub-table>tbody>tr>td {
            width: 1000px;
            height: 50px;
            text-indent: 50px;
        }

        .sub-table>tbody>tr>td>p {
            font-size: 1.3em;
        }

        .half-all-wrap{
            display: flex;
            justify-content: space-between;
        }
        .half-wrap{
            width: 49%;
            overflow: hidden;
        }


        .result-div {
            background-color: lightgray;
            width: 100%;
            height: 100%;
            padding-left: 50px;
            padding-right: 50px;
            padding-bottom: 80px;
        }
        .result-div>h3{
            height: 80px;
            line-height: 80px;
        }
        
        .result-table{
            width: 100%;
            margin-bottom: 30px;
        }
        .result-table input{
            outline:none;
            border:none;
            background-color:transparent;
            text-align:right;
        }
        .result-table>tbody>tr>td{
            height: 65px;
            font-size: 1.3em;
        }
        .result-table>tbody>tr>td:first-child{
            width: 200px;
        }
        
        .result-table>tbody>tr>td:last-child{
            width: 240px;
            text-align: right;
        }
        
        
        #ok {
            width: 49%;
            height: 50px;
            outline: none;
            border: none;
            background-color: #383a3f;
            color: white;
            float: right;
        }

        #cancel {
            width: 49%;
            height: 50px;
            outline: none;sss아직안끈ㅌ겻어 ㅋ
            background-color: white;
            border: 1px solid #383a3f;
            color: #383a3f;
            float: left;
        }
        
        .result-table>tbody>tr:last-child{
            height: 80px;
            border-top: 1px solid black;
        }
        
        .coupon-div {
            background-color: lightgray;
            width: 100%;
            height: 170px;
            padding-left: 50px;
            padding-right: 50px;
        }
        .coupon-div>select{
            width: 100%;
            height: 40px;
            outline: none;
            margin-bottom: 30px;
        }
        .coupon-div>h3{
            height: 80px;
            line-height: 80px;
        }
        
        .notice-div>h6{
            margin: 0;
            height: 60px;
            line-height: 60px;
        }
        
        .notice-div {
            background-color: lightgray;
            width: 100%;
            margin-top: 10px;
            margin-bottom: 10px;
            height: 60px;
            padding-left: 50px;
        }
        
        .notice-text {
            background-color: white;
            width: 100%;
            margin-top: -10px;
            height: 168px;
            padding-left: 30px;
            padding-right: 30px;
        }
</style>	

</head>
<body>

	<%@include file ="/WEB-INF/views/common/header.jsp" %>
	
	<%-- <section>
	
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
	
	</section>	 --%>
	
	
	<div class="content-all-wrap">
        <form action="/order" method="post">
            <div class="delivery-div">
            <input type="hidden" name="ordStoreNo" value=<%=oc.getOrder().getOrdStoreNo() %>>
                <table class="info-table">
                    <tr>
                        <td>
                            <h3>배달 정보</h3>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text" name="ordAddr" id="ordAddr" value=<%=oc.getOrder().getOrdAddr() %> readonly></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="ordAddrDet" id="ordAddrDet" value="이레빌딩 19F A강의실" placeholder="상세주소">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="ordTel" id="ordTel" value=<%=oc.getClient().getCliTel() %> readonly>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="delivery-div">
                <table class="sub-table">
                    <tr>
                        <td>
                            <h3>요청 사항</h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>가게 요청사항</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" name="ordSub" id="ordSub" placeholder="">
                        </td>
                    </tr>
                </table>
            </div>
            
            <div class="half-all-wrap">
                <div class="half-wrap">
                <div class="coupon-div">
                    <h3>쿠폰</h3>
                    <select id="coupon" name="coupon">
                    <option value="no" selected>쿠폰 적용 안함</option>
                        <%for(Coupon cp : oc.getCpList()) {%>
                        	<%if(cp.getCpListUse().equals("FALSE ")){ %>
                        		<%-- <option value=<%=cp.getCpListPk() %>/<%=cp.getCpPrice() %>><%=cp.getCpName() %>(<%=cp.getCpPrice() %>원)</option> --%>
                        		<option value=<%=cp.getCpListPk() %>/<%=cp.getCpPrice() %>><%=cp.getCpName() %>(<%=cp.getCpPrice() %>원)</option>
                        	<%} %>
                        <%} %>
                    </select>
                </div>
                <div class="notice-div"><h6>개인정보 제 3자 제공</h6></div>
                <div class="notice-text" style="overflow-y:scroll;overflow-x:hidden;">
                    <b>1. 총칙</b><br>
                    (주)우아한형제들(이하 ‘회사’)은 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 개인정보보호법 등 관련 법령에 따라 이용자의 개인정보를 보호하고, 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 다음과 같이 개인정보 처리방침을 수립하여 공개합니다.<br><br>


                    <b>2. 개인정보의 수집</b><br>
                    이용자는 구독신청을 통해 회사가 제공하는 뉴스레터를 수신할 수 있으며, 뉴스레터 구독 서비스 제공을 위하여 수집하는 필요한 최소한의 개인정보는 아래와 같습니다.<br>
                    (1) 이름, 전자우편주소를 필수로 수집합니다.<br>
                    (2) 서비스 이용과정에서 아래와 같은 정보들이 자동으로 생성되어 수집·저장·조합·분석될 수 있습니다.<br>
                    - IP Address, 방문 기록, 서비스 이용 기록, 기기정보(기기고유번호, OS, 버전, 모델명) 등<br><br><br>


                    <b>3. 개인정보의 이용</b><br>
                    (1) 회사는 다음의 목적을 위하여 이용자의 개인정보를 처리하고 있으며, 명시된 목적 이외의 용도로는 처리하지 않습니다. 이용자의 개인정보는 처리 목적이 달성되면 지체없이 파기하며, 목적이 변경되는 경우에는 별도의 동의를 받는 등 필요한 조치를 이행하겠습니다.<br>
                    - 서비스 제공, 서비스 개선, 신규 서비스 개발<br>
                    - 민원처리 및 고객상담, 제휴/제안<br>
                    - 고지사항 전달<br>
                    - 서비스 방문 및 이용기록 통계 및 분석<br>
                    - 서비스 만족도 조사 및 관리<br><br>
                    
                    <b>4. 개인정보의 제3자 제공</b><br>
                    회사는 이용자의 개인정보를 명시한 목적의 범위 내에서 처리하며, 이용자의 사전 동의 없이 범위를 초과하여 처리하거나 제 3자에게 제공하지 않습니다. 다만, 다음의 경우에는 예외로 합니다.<br>
                    (1) 이용자가 사전에 동의 한 경우<br>
                    (2) 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우<br>
                </div>
            </div>
            <div class="half-wrap">
                <div class="result-div">
                    <h3>결제 금액</h3>
                    <table class="result-table">
                    	<tr>
                            <td>주문금액</td>
                            <td><input type="text" id="ordPrice" name="ordPrice" value=<%=oc.getOrder().getOrdTPrice() %> readonly></td>
                        </tr>
                        <tr>
                            <td>쿠폰할인</td>
                            <td><input type="text" id="couponPrice" name="couponPrice" value="0" readonly></td>
                        </tr>
                        <tr>
                            <td>총 금액</td>
                            <td><input type="text" id="ordTPrice" name="ordTPrice" value=<%=oc.getOrder().getOrdTPrice() %> readonly></td>
                        </tr>
                    </table>
                    <button id="cancel">취소</button>
                    <button id="ok">결제하기</button>
                </div>
            </div>
            </div>
            
           
        </form>
    </div>
	
	<%@include file ="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$("#coupon").change(function(){
			var coupon = $(this).val();
			var plus = coupon.indexOf("/")+1;
			var price = coupon.substr(plus,coupon.length);
			var ordPrice = $("#ordPrice").val();
			
			if(coupon == "no"){
				$("#couponPrice").val(0);
				$("#ordTPrice").val(ordPrice);
			} else {
				$("#couponPrice").val(price);
				var total = ordPrice-price;
				
				if(Number(ordPrice) < Number(price)){
					total = 0;
				}
				$("#ordTPrice").val(total);
			}
		});
	</script>
</body>
</html>