<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.0/main.css">
<script>
    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');
  
      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
        },
        navLinks: true, // can click day/week names to navigate views
        businessHours: true, // display business hours
        editable: true,
        selectable: true,
        events: ${myList}
      });
      calendar.render();
    });
    
    function addCal(){
    	var popupWidth = 500;
    	var popupHeight = 500;
    	var popupX = (window.screen.width / 2) - (popupWidth / 2);
    	var popupY= (window.screen.height / 2) - (popupHeight / 2);
    	var url = "MyProjectCalendar.do?cmd=addCal";
    	var name = "addCallendar";
    	var option = "width = 500px, height = 500px, top = "+popupY+", left = "+popupX+", resizable=no, location = no";
    	
    	window.open(url, name, option);
    }

    function modifyCal(){
    	var popupWidth = 800;
    	var popupHeight = 500;
    	var popupX = (window.screen.width / 2) - (popupWidth / 2);
    	var popupY= (window.screen.height / 2) - (popupHeight / 2);
    	var url = "MyProjectCalendar.do?cmd=modifyCal";
    	var name = "Callendar";
    	var option = "width = 800px, height = 500px, top = "+popupY+", left = "+popupX+", resizable=no, location = no";
    	
    	window.open(url, name, option);
    }
  </script>
<title>MyProject</title>
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
    #calendar {
      margin: 0 auto;
      width: 1000px;
      height: 800px;
    }
    .buttons{
    	margin: auto;
    	margin-bottom:40px;
    	text-align: right;
    	width:1000px;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>일정관리</h2>
			<br><br><br>
			<div class="buttons">
				<input type="button" class="btn btn-outline-primary" value="일정추가" onclick="addCal();"/>
				<input type="button" class="btn btn-outline-success" value="일정수정 및 삭제" onclick="modifyCal();" />
			</div>
			<div id='calendar'></div>

		</div>
	</div>
</body>
</html>