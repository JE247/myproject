<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
<style>
* {
	margin: 0px;
	padding: 0px;
}

.container {
	margin: 10px auto;
}

.header {
	width : 1320px;
	margin: auto;
}

.nav-link{
	color:green;
}

</style>
<title>Insert title here</title>
</head>
<body>
		<div class="header">
			<nav class="nav justify-content-end" style="position: relative;">
				<a href="MyProject.do?cmd=main" style="position: absolute; left: 0px;"> 
				<img src="images/building.png" alt="" width="50px" height="50px">
				</a> 
				<a class="nav-link" href="MyProject.do?cmd=myinfo">내 정보</a> 
				<a class="nav-link" href="MyProject.do?cmd=allemp">사원 정보</a> 
				<a class="nav-link" href="MyProjectBoard.do?cmd=board">게시판</a>
				<a class="nav-link" href="MyProjectRez.do?cmd=rez">회의실 예약</a> 
				<a class="nav-link" href="MyProjectChatting.do?cmd=chat">채팅</a>
				<a class="nav-link" href="MyProjectCalendar.do?cmd=cal">일정(Calendar)</a> 
				<a class="nav-link" href="MyProjectDoc.do?cmd=doc">전자결제</a>
			</nav>
		</div>
</body>
</html>