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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>MyProject</title>
<script>
    $(function () {
        $("input[name='selectDate']").on("change", function () {
            $("#frm1").submit();
        });

        $("#addRez").on("click", function () {
            var popupWidth = 600;
            var popupHeight = 500;
            var popupX = (window.screen.width / 2) - (popupWidth / 2);
            var popupY = (window.screen.height / 2) - (popupHeight / 2);
            var url = "MyProjectRez.do?cmd=addRez"; 
            var name = "addRez";
            var option = "width = 600px, height = 500px, top = " + popupY + ", left = " + popupX + ", resizable=no, location = no";

            window.open(url, name, option);

        });

        $("#delete").on("click", function () {
            if (!$("input[name='rno']").is(":checked")) {
                alert("삭제하고 싶은 예약을 선택해주세요");
                return;
            }
            $("#rezModify").val("delete");
            $("#frm2").submit();
        });
    });
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
        margin: 50px auto;
        text-align: center;
        width: 1000px;
    }

    .table>td {
        border-left: 1px solid gray;
    }

    .date {
        font-size: 18px;
        font-family: 'Jua', sans-serif;
        margin-top: 30px;
    }

    input[type='date'] {
        border-radius: 10px;
        text-align: center;
        padding: 5px;
        height: 40px;

    }

    .buttons {
        text-align: right;
        margin-bottom: 30px;
    }

    .myrezInfo {
        margin-top: 40px;
        margin-bottom: 30px;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>회의실 예약</h2>
			<br>
			<form action="MyProjectRez.do" id="frm1">
			<input type="hidden" name="cmd" value="rez" />
			<div class="date">
				<label>날짜 : </label> <input type="date" name="selectDate" id="" value="${today}"/>
			</div>
			</form>
			<br>
			<table class="table">
			<tr>
				<th>회의실명</th>
				<c:forEach var="i" begin="9" end="20" step="1">
					<th>${i}</th>
				</c:forEach>
			</tr>
			
			<c:forEach var="i" begin="0" end="3" step="1">
				<tr>
					<td>${roomList[i].roomName }</td>
					<c:forEach var="j" begin="9" end="20" step="1">
						<c:set var="can" value="true"></c:set>
							<c:forEach var="vo" items="${rezAll[i]}">
								<c:if test="${j >= vo.startTime && j < vo.endTime}">
									<td style="background-color: #FBCFD0;border-left: 1px solid #cccccc;">X</td>
									<c:set var="can" value="false"></c:set>
								</c:if>
							</c:forEach>
						<c:if test="${can}">
							<td style="background-color: #C8EBFA;border-left: 1px solid #cccccc;">O</td>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
			</table>
			<div class="buttons">
				<input type="button" class="btn btn-outline-primary" id="addRez" value="예약하기" />
			</div>
			<div class="myrezInfo">
                <form action="MyProjectRez.do" id="frm2">
                    <input type="hidden" name="cmd" id="rezModify">
                    <h2>My Reservation</h2>
                    <div class="buttons myrez">
                        <input type="button" class="btn btn-outline-danger" id="delete" value="예약삭제" />
                    </div>
                    <table class="table">
                        <tr>
                            <th width="10%"></th>
                            <th width="10%">예약번호</th>
                            <th width="20%">예약일자</th>
                            <th width="10%">시작시간</th>
                            <th width="10%">종료시간</th>
                            <th width="40%">예약목적</th>
                        </tr>
                        <c:forEach var="vo" items="${myRez }">
	                        <tr>
	                            <td><input type="radio" name="rno" value="${vo.rezNo }"></td>
	                            <td>${vo.rezNo }</td>
	                            <td>${vo.rezDate }</td>
	                            <td>${vo.startTime }</td>
	                            <td>${vo.endTime }</td>
	                            <td>${vo.memo }</td>
	                        </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
			
		</div>
	</div>
</body>
</html>