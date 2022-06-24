<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>MyProject</title>
<script>
$(function(){
	$("#add").on('click', function(){
		var popupWidth = 500;
    	var popupHeight = 500;
    	var popupX = (window.screen.width / 2) - (popupWidth / 2);
    	var popupY= (window.screen.height / 2) - (popupHeight / 2);
    	var url = "MyProjectChatting.do?cmd=addChatRoom";
    	var name = "addChatRoom";
    	var option = "width = 500px, height = 500px, top = "+popupY+", left = "+popupX+", resizable=no, location = no";
    	
    	window.open(url, name, option);
	});
	
	$(".table tr").on('click', function(){
		
		var tr = $(this); 
		var td = tr.children();
		
		var cno = td.eq(0).text();
		
		/* 팝업창 만들기 */
		
		var popupWidth = 540;
    	var popupHeight = 600;
    	var popupX = (window.screen.width / 2) - (popupWidth / 2);
    	var popupY= (window.screen.height / 2) - (popupHeight / 2);
    	var url = "MyProjectChatting.do?cmd=chatInter&cno="+cno;
    	var name = "chatInter";
    	var option = "width = 540px, height = 600px, top = "+popupY+", left = "+popupX+", resizable=no, location = no";
    	
    	window.open(url, name, option);
	})
})
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
    
h2{
	font-family: 'Jua', sans-serif;
}
* {
	margin: 0px;
	padding: 0px;
}

.container {
	margin: 10px auto;
}

.contents {
	margin: 50px 0px;
	text-align: center;
}
.button{
	text-align: right;
}
.button > input{
	border: 0;
    outline: 0;
    background: green;
    filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
    border-radius: 7px;
    color: #FFFFFF;
    margin-left: 20px;
    width: 100px;
    height: 40px;
    font-size: 14px;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>채팅방</h2>
			<br><br><br>
			<div class="button"><input type="button" value="채팅방 생성" id="add" /></div>
			<br>
			<table id="chatTable" class="table table-striped table-bordered  table-hover">
				<tr class="table-dark">
					<th colspan="5">나의 채팅방</th>
				</tr>
				<tr>
					<th width="10%">채팅번호</th>
					<th width="10%">인원수</th>
					<th width="25%">채팅방이름</th>
					<th width="30%">마지막메시지</th>
					<th width="25%">마지막 전송시간</th>
				</tr>
				<c:forEach var="vo" items="${chatMain}">
					<tr>
						<td>${vo.cno }</td>
						<td>${vo.person }</td>
						<td>${vo.chatName }</td>
						<td>${vo.chatMessage }</td>
						<td style="position: relative;">${vo.chatTime } 
							<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
									${vo.noread }
									<span class="visually-hidden">unread messages</span>
							</span>
						</td>
					</tr>
				</c:forEach>
            </table>
		</div>
	</div>
</body>
</html>