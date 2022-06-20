<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 객실 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<style>
@charset "utf-8";

table {
	border-collapse: collapse;
	border-spacing: 0;
}

section.host_notice {
	width: 900px;
	padding: 0 auto;
	margin-left: 50px;
}

.page-title {
	margin-bottom: 60px;
}

.host-title h3 {
	font-size: 30px;
	color: #7f9b75;
	font-weight: 570;
	text-align: center;
}

#noticeBoard-search .noticeSearch-window {
	padding: 15px 0;
	background-color: #f9f7f9;
}

#noticeBoard-search .noticeSearch-window .noticeSearch-wrap {
	position: relative;
	/*   padding-right: 124px; */
	margin: 0 auto;
	width: 80%;
	max-width: 564px;
}

#noticeBoard-search .noticeSearch-window .noticeSearch-wrap input {
	height: 28px;
	width: 100%;
	font-size: 14px;
	padding: 7px 14px;
	border: 1px solid #cbdea6;
}

#noticeBoard-search .noticeSearch-window .noticeSearch-wrap input:focus
	{
	border-color: #333;
	outline: 0;
	border-width: 1px;
}

#noticeBoard-search .noticeSearch-window .noticeSearch-wrap .noticeBtn {
	position: absolute;
	right: -30px;
	top: 0;
	bottom: 0;
	width: 108px;
	padding: 0;
	font-size: 16px;
}

.board-table {
	color: #403e3f;
	font-size: 14px;
	width: 100%;
	border-top: 1px solid #cbdea6;;
	border-bottom: 1px solid #cbdea6;;
}

.board-table a {
	color: #403e3f;
	display: inline-block;
	line-height: 1.4;
	word-break: break-all;
	vertical-align: middle;
}

.board-table a:hover {
	text-decoration: underline;
}

.board-table th {
	text-align: center;
}

.board-table .th-num {
	/* width: 100px; */
	text-align: center;
}

.board-table th, .board-table td {
	padding: 10px 0;
	border-top: 1px solid #cbdea6;
	text-align: center;
	color: #403e3f;
}

.board-table tbody td {
	border-top: 1px solid #cbdea6;
	text-align: center;
	color: #403e3f;
}

.board-table tbody th {
	padding-left: 28px;
	padding-right: 14px;
	border-top: 1px solid #cbdea6;
	text-align: left;
}

.board-table tbody th p {
	display: none;
}

.noticeBtn {
	display: inline-block;
	padding: 0 30px;
	font-size: 15px;
	font-weight: 400;
	background: transparent;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	border: 1px solid transparent;
	text-transform: uppercase;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	-ms-transition: all 0.3s;
	-o-transition: all 0.3s;
	transition: all 0.3s;
}

.btn-dark {
	background: #7f9b75;
	color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
	background: #cbdea6;
	border-color: #cbdea6;
	color: #fff;
}

.noticeBtn2 {
	width: 108px;
	padding: 0;
	font-weight: 400;
}

.noticeBtn2 {
	display: inline-block;
	padding: 5px 10px;
	margin: 30px 0 30px 0px;
	float: right;
	font-size: 16px;
	font-weight: 400;
	background: transparent;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	border: 1px solid transparent;
	text-transform: uppercase;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border-radius: 0;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	-ms-transition: all 0.3s;
	-o-transition: all 0.3s;
	transition: all 0.3s;
}

.btn-dark2 {
	background: #7f9b75;
	color: #fff;
}

.btn-dark2:hover, .btn-dark2:focus {
	background: #cbdea6;
	border-color: #cbdea6;
	color: #fff;
}

.clearfix:after {
	content: '';
	display: block;
	clear: both;
}

.host_contai {
	width: 850px;
	margin: 0 auto;
	margin: 50px 0px 50px 0px;
}

.blind {
	position: absolute;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	margin: -1px;
	width: 1px;
	height: 1px;
}

.markSelect {
	border: 1px solid #7f9b75;
	font-size: 14px;
	height: 25px;
	padding: 1px;
	width: 250px;
	float: left;
	text-align: left;
}

.host_title {
	text-align: left;
}

.markOption {
	font-size: 14px;
	height: 25px;
	color: #403e3f;
}

.file_input {
	margin: 5px;
	font-size: 13px;
}

/* 페이징 추가 css */

#page_wrap {
	margin: 10px auto 50px; 
	padding: 0px;
	width: 100%;
	font-size: 11px;
}

div#page_control {
	padding: 0px;
	font-size: 11px;
	padding: 0px 5px;
	float: left;
	color: #7f9b75;
}


div#page_control a {
	padding: 2px 5px;
	border: 1px solid rgb(204, 204, 204);
	border-radius: 3px;
	border-image: none;
	display: inline-block;
	color: #7f9b75;
}


div#page_control  a:hover {
	border: 1px solid #edbc40;
	border-image: none;
	color: #edbc40;
}


</style>
</head>

<body>
	<!-- 바디 시작 -->
	<section class="host_notice">
		<div class="host-title">
			<div class="host_contai">
				<h3>등록 객실 목록</h3>
			</div>
		</div>

		<!-- board seach area -->
		<div id="noticeBoard-search">
			<!-- board list area -->
			<div id="host_notice-list">
				<div class="host_contai">
					<table class="board-table">
						<colgroup>
							<col width="5%" />
							<col width="20%" />
							<col width="auto" />
							<col width="10%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col" class="">NO.</th>
								<th scope="col" class="">상호명</th>
								<th scope="col" class="">주소</th>
								<th scope="col" class="">타입</th>
								<th scope="col" class="">객실개수</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty hostInfoList}">
									<tr>
										<td colspan="7">
											<p>
												<b><span>작성한 사업장이 없습니다.</span></b>
											</p>
										</td>
									</tr>
								</c:when>
								<c:when test="${!empty hostInfoList}">
									<c:forEach var="list" items="${hostInfoList}">
										<tr class="move" value='<c:out value="${list.h_code }" />'>
											<td>${list.h_code}</td>
											<td>${list.hostInfo_name}</td>
											<td><a
												href="${pageContext.request.contextPath}/host/goods/modifyHostDetail.do?h_code=${list.h_code}">${list.roadAddress}</a></td>
											<td>${list.host_type}</td>
											<td>${list.room_count}</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</tbody>
					</table>
<section>
	<div class="pull-right">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li class="paginate_button previous"><a href="${pageMaker.startPage - 1 }">Previous</a></li>
			</c:if>
			
			<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
				<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }"><a href="${num }">${num }</a></li>
			</c:forEach>
			
			<c:if test="${pageMaker.next }">
				<li class="paginate_button next"><a href="${pageMaker.endPage + 1 }">Next</a></li>
			</c:if>
		</ul>
		<form id="actionForm" action="${contextPath }/host/goods/hostInfoList.do" method="get">
			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" />
			<input type="hidden" name="amount" value="${pageMaker.cri.amount }" />
			<input type="hidden" name="h_id2" value='<c:out value="${pageMaker.cri.h_id2 }"/>'>
		</form>
	</div>
</section>
<br>
<br>
<div>
	<button type="button" class="noticeBtn2 btn-dark2" onclick="location.href='${contextPath}/host/goods/hostInfoForm.do'">신규 등록</button>
</div>
</div>
</div>
</div>
</section>
<script type="text/javascript">
$(document).ready(function(){
	var actionForm = $("#actionForm");
$(".move").on("click",function(e){
	alert("zzzz");
	e.preventDefault();
	actionForm.append("<input type='hidden' name='h_code' value='"+$(this).attr("value")+"'>");
	actionForm.attr("action", "${contextPath}/host/goods/modifyHostDetail.do");
	actionForm.submit();
});
});

var searchVO = $("#searchVO");

$(".searchButton").on("click", function(e){
	alert("클릭");
	searchVO.find("input[name='pageNum']").val("1");
	
	searchVO.submit();
});
var actionForm = $("#actionForm");

$(".paginate_button a").on("click", function(e){
	e.preventDefault();
	console.log('click');
	
	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	actionForm.submit();
});
</script>

</body>
</html>