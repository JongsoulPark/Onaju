<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
body, html{
	width: 100%;
	height: 100%;
	font-weight: 400;
}
section{
	margin: 0 auto;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}
.loginForm-con{
	display: flex; 
	width: 960px; 
	height: 600px; 
	border: 1px solid #E6E6E6; 
	border-radius: 5px;
}
.loginForm-con-chil{
	width: 480px; 
	height: 600px; 
	border-right: 1px solid #E6E6E6;
}
.loginForm-con-chil div img{
	max-width: 100%; 
}
.loginForm-con-chil-box1{
	display: flex; 
	height: 100px; 
	justify-content: center; 
	align-items: center;
}
.loginForm-con-chil-box1 div h2{
	color: #666666;
}
.loginForm-con-chil-box2{
	display: flex; 
	height: 70px; 
	justify-content: center; 
	align-items: center;
}
.loginForm-con-chil-box3{
	display: flex; 
	height: 80px; 
	justify-content: center; 
	align-items: center;
}
.loginForm-item1{
	width: 150px;
}
.loginForm-item1 div{
	margin-left: 40px;
}
.loginForm-item1 div h4{
	color: #666666;
}
.loginForm-item2{
	width: 330px;
	display: flex;
}
.loginForm-item3{
	width: 330px;
	display: flex;
}
.loginForm-item3 div input{
	width: 115px; 
	height: 35px; 
	border:1px solid #E6E6E6; 
	border-radius: 5px;
}
.loginForm-item3 div select{
	width: 110px; 
	height: 39px; 
	border:1px solid #E6E6E6; 
	border-radius: 5px;
}
.loginForm-item2 div input{
	width: 210px; 
	height: 35px; 
	border:1px solid #E6E6E6; 
	border-radius: 5px;
}
.loginForm-item2 div button{
	width: 70px; 
	height: 35px;
	color: white;
	background-color: #000033; 
	border: none; 
	border-radius: 5px;
	margin-left: 10px;
}
.loginForm-item2 div button:hover{
	background-color: #000099;
	cursor: pointer;
}
.loginForm-con-chil-box3 div div input{
	width: 100px; 
	height: 40px; 
	background-color: #000033; 
	color: white; 
	border: none; 
	border-radius: 5px; 
	margin: 3px 3px 3px 3px;
}
.loginForm-con-chil-box3 div div a{
	display:block; 
	width:100px; 
	line-height:40px; 
	text-align:center; 
	border: none;
	border-radius: 5px; 
	background-color: #FF3333;
	color: white;
	text-decoration: none;
	margin: 3px 3px 3px 3px;
}

.onajulogo{
	width: 480px;
	height: 600px;
	display: flex;
	align-items:center;
}	
</style>
</head>
<body>
	<section>
	<form name="joinAdminForm" action="${contextPath }/admin/joinAdmin.do" method="post">
		<div class="loginForm-con">
			<div class="loginForm-con-chil">
				<div class="onajulogo"><img src="../resources/image/onajulogo.png" alt="??????"></div>
			</div>
			<div class="loginForm-con-chil">
				<div class="loginForm-con-chil-box1"><div><h2>????????? ?????? ??????</h2></div></div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>?????????</h4></div></div>
					<div class="loginForm-item2"><div><input type="text" name="a_id" id="_id" placeholder="????????? ??????" maxlength="16" required /></div><div><button type="button" id="id_check" onclick="fn_overlapped()">??????</button></div></div>
					
				</div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>????????????</h4></div></div>
					<div class="loginForm-item2"><div><input type="password" name="a_pw" id="_pw" placeholder="???????????? ??????" required /></div></div>
				</div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>??????</h4></div></div>
					<div class="loginForm-item2"><div><input type="text" name="a_name" id="_name" placeholder="?????? ??????" required /></div></div>
				</div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>????????????</h4></div></div>
					<div class="loginForm-item2"><div><input type="date" name="a_birth" id="_birth" value="" placeholder="???????????? ??????" /></div></div>
				</div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>????????????</h4></div></div>
					<div class="loginForm-item2"><div><input type="text" name="a_phone" id="_phone" placeholder="???????????? ??????" required /></div></div>
				</div>
				<div class="loginForm-con-chil-box2">
					<div class="loginForm-item1"><div><h4>?????????</h4></div></div>
					<div class="loginForm-item3">
						<div><input type="text" name="a_email1" id="_email1" placeholder="????????? ??????" required /></div>&nbsp;@ &nbsp;
						<div>
						 	<select name="a_email2">
								<option value="">????????? ??????</option>
								<option value="@naver.com">?????????</option>
								<option value="@daum.net">??????</option>
								<option value="@gmail.com">??????</option>
							</select>
						</div>						
					</div>
				</div>
				<div class="loginForm-con-chil-box3">
					<div><div><input type="submit"  value="????????????"/></div></div>
					<div><div><a href="${contextPath }/admin/loginForm.do">????????????</a></div></div>
				</div>
			</div>
		</div>
	</form>
	</section>
<script>
function fn_overlapped() {
	var id = $("#_id").val();
	if (id == '') {
		alert("ID??? ???????????????");
		return;
	}
	var idCheck = /^[a-zA-Z0-9]{6,12}$/;
	
	if (!idCheck.test(id)) {
			alert("???????????? 6~12?????? ??????????????? ???????????? ?????? ???????????????.");
			id.focus();
			return;
    }
	$.ajax({
		type : "post",
		async : false,
		url : "${contextPath}/admin.overlapped.do",
		dataType : "text",
		data : {id : id},
		success : function(data, textStatus) {
			if (data == 'false') {
				alert("????????? ??? ?????? ID?????????.");
				$('#btnOverlapped').prop("did_check", true);
				$('#_id').prop("id_check", true);
				$('#_id').val(id);
			} else {
				alert("????????? ??? ?????? ID?????????.");
			}
		},
		error : function(data, textStatus) {
			alert("????????? ??????????????????.");
			???
		},
		complete : function(data, textStatus) {
			//alert("??????????????? ????????????");
		}
	});	 
}
</script>


</body>
</html>