<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next',
        center: 'title',
        right: 'dayGridMonth,listMonth'
      },
      navLinks: true, 
      businessHours: true, 
      editable: true,
      selectable: true,
      events: ${myList}
    });
    calendar.render();
  });
</script>
<title>MyProject</title>
<style>
@charset "UTF-8";
*{
	margin: 0px;
	padding: 0px;
}
.container {
    margin: 10px auto;
}
.contents {
	margin: 80px auto;
	display: flex;
}

.myinfo {
	width: 350px;
	padding-right: 50px;
	border-right: 1px solid gainsboro;
}

.my {
	height: 150px;
	display:flex;
}

.picture {
    border-radius: 100%;
    width: 150px;
    height: 150px;
    border: 1px solid grey;
    overflow: hidden;
    margin: auto;
    text-align:center;
}

.picture>img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.my p{
    font-size: 20px;
    font-weight: bold;
    text-align: center;
    margin: auto;
}
.buttons input{
    margin-top: 30px;
    margin-left: 10px;
    margin-bottom : 20px;
    width: 120px;
    height: 40px;
}

.profile{
	width:120px;
	height:150px;
}

#calendar {
	width: 300px;
	margin: 40px auto;
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

.table{
	margin-top: 30px;
}

.table th {
	text-align: center;
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

li > a, td > a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
 <div class="container">
        <jsp:include page="../tag/header.jsp"></jsp:include>
        <div class="contents">
            <div class="myinfo">
                <div class="my">
                	<div class="picture">
	                	<c:if test="${maindto.photoname eq null }">
	                		<img class="profile" src="images/myinfo/basic.gif" alt="" />
	                	</c:if>
	                	<c:if test="${maindto.photoname ne null }">
	                		<img class="profile" src="images/myinfo/${maindto.photoname}" alt="" />
	                	</c:if>
                	</div>
                	<p>${maindto.name}님 <br> 환영합니다.</p>
                </div>
                <div class="buttons" style="text-align: center;">
                    <a href="MyProject.do?cmd=myinfo"><input class="btn btn-outline-success" type="button" value="내 정보확인"></a>
                    <a href="MyProject.do?cmd=logout"><input class="btn btn-outline-success" type="button" value="로그아웃"></a>
                </div>
                <div id="calendar"></div>
                <div class="scraplist">
                	<h6>스크랩 리스트</h6> <br>
						<ul class="list-group">
							<c:forEach var="vo" items="${scrap }">
							  <li class="list-group-item"><a href="MyProjectBoard.do?cmd=detail&bno=${vo.bno }">${vo.bno}) ${vo.title}</a></li>
							</c:forEach>
						</ul>
                </div>
            </div>
            <div class="main">
                <div class="banner">
                </div>
                <div class="board">
                <br><br>
                    <h4>최신 글 리스트</h4>
                    <table class="table">
                        <tr>
                            <th>게시번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                        <c:forEach var="vo" items="${board}">
                        	<tr>
                        		<td style="text-align: center;">${vo.bno }</td>
                        		<td><a href="MyProjectBoard.do?cmd=detail&bno=${vo.bno }">${vo.title }</a></td>
                        		<td style="text-align: center;">${vo.writer }</td>
                        		<td style="text-align: center;">${vo.regdate }</td>
                        		<td style="text-align: center;">${vo.hits }</td>
                        	</tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>