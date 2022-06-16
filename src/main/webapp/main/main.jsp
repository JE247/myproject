<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.css">
<link rel="stylesheet" href="css/main.css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.min.js"></script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth'
        });
        calendar.render();
    });
</script>
<title>MyProject</title>
<style>
@charset "UTF-8";

.contents {
	margin: 30px auto;
	display: flex;
}

.myinfo {
	width: 350px;
	padding-right: 10px;
	border-right: 1px solid gainsboro;
}

.my {
	height: 150px;
	display:flex;
}

.my>p{
    font-size: 20px;
    font-weight: bold;
    text-align: center;
    margin: auto;
}
.buttons input{
    margin-top: 10px;
    margin-left: 10px;
    margin-bottom : 20px;
    width: 120px;
    height: 40px;
    border: none;
    border-radius: 10px;
    background-color: #64C7F2;
}

.profile{
	width:120px;
	height:150px;
}

#calendar {
	width: 300px;
	margin: 10px auto;
	height: 340px;
	font-size: 10px;
}

.fc-view-month .fc-event, .fc-view-agendaWeek .fc-event, .fc-content {
	font-size: 0;
	overflow: hidden;
	height: 2px;
}

.fc-toolbar h2 {
	font-size: 12px;
	white-space: normal !important;
}

/* click +2 more for popup */
.fc-more-cell a {
	display: block;
	width: 85%;
	margin: 1px auto 0 auto;
	border-radius: 3px;
	background: grey;
	color: transparent;
	overflow: hidden;
	height: 4px;
}

.main {
	width: 100%;
}

.banner {
	width: 850px;
	margin: 30px auto;
	background-color: aqua;
	height: 200px;
}

.board {
	width: 850px;
	margin: 0px auto;
}

.table th {
	text-align: center;
	border: 1px solid black;
}

.table tr>th:nth-child(1) {
	width: 10%;
}

.table tr>th:nth-child(2) {
	width: 40%;
}

.table tr>th:nth-child(3) {
	width: 20%;
}

.table tr>th:nth-child(4) {
	width: 20%;
}

.table tr>th:nth-child(5) {
	width: 10%;
}
</style>
</head>
<body>
 <div class="container">
        <jsp:include page="../tag/header.jsp"></jsp:include>
        <div class="contents">
            <div class="myinfo">
                <div class="my">
                	<c:if test="${maindto.photoname eq null }">
                		<img class="profile" src="images/myinfo/basic.gif" alt="" />
                	</c:if>
                	<c:if test="${maindto.photoname ne null }">
                		<img class="profile" src="images/myinfo/${maindto.photoname}" alt="" />
                	</c:if>
                	<p>${maindto.name}님 <br> 환영합니다.</p>
                </div>
                <div class="buttons" style="text-align: center;">
                    <a href="MyProject.do?cmd=myinfo"><input type="button" value="내 정보확인"></a>
                    <a href="MyProject.do?cmd=logout"><input type="button" value="로그아웃"></a>
                </div>
                <div id="calendar"></div>
            </div>
            <div class="main">
                <div class="banner">
                </div>
                <div class="board">
                    <h4>공지사항</h4>
                    <table class="table">
                        <tr>
                            <th>게시번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>