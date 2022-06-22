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
		$("select").on("change", function(){
			$("form").submit();
		});
	});
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
* {
	margin: 0px;
	padding: 0px;
}

.container {
	margin: 10px auto;
}

.contents {
	margin: 40px 0px;
	text-align: center;
}

.seldein {
	border-radius: 6px;
	font-size:15px;
	width: 100px;
}

.table {
	font-size: 13px;
}

.formbutton {
	border: 0;
	outline: 0;
	background: green;
	filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
	border-radius: 7px;
	color: #FFFFFF;
	width: 80px;
	height: 35px;
	font-size: 14px;
	margin-right: 10px;
}
.name{
	text-align: left;
	font-family: font-family: 'Jua', sans-serif;
	margin-bottom: 20px;
}
.filter{
	text-align: right;
}
.inputText {
	padding: 5px;
	resize: none;
	border: 1px solid rgba(0, 0, 0, 0.25);
	filter: drop-shadow(0px 1px 1px rgba(0, 0, 0, 0.12));
	border-radius: 12px;
	outline-color: green;
	font-family: 'Noto Sans KR', sans-serif;
	font-style: normal;
	font-weight: 500;
	width: 250px;
	height: 35px;
	font-size: 13px;
}
.findMember{
	margin-top: 30px;
	height: 270px;
	overflow: auto;
}
.position{
	margin-top: 20px;
	text-align: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="contents">
			<form action="MyProjectChatting.do">
				<input type="hidden" name="cmd" value="addChatRoom" />
				<div class="name">
					채팅방 이름 : 
					<input type="text" name="room" class="inputText" />
				</div>
				<div class="filter">
					<select class="seldein" name="dept" id="dept">
						<c:forEach var="vo" items="${deptList}">
							<c:choose>
								<c:when test="${dept eq vo.dno }">
									<option value="${vo.dno}" selected>${vo.dname}팀</option>
								</c:when>
								<c:otherwise>
									<option value="${vo.dno}">${vo.dname}팀</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="findMember">
					
					<table class="table">
						<tr>
							<th width="10%"></th>
							<th width="45%">부서명</th>
							<th width="45%">사원명</th>
						</tr>
						<c:forEach var="vo" items="${memberList }">
							<tr>
								<td>
									<input type="checkbox" name="eno" id="" value="${vo.eno}" />
								</td>
								<td>${vo.dname }</td>
								<td>${vo.name }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="position">
				<input class="formbutton" type="button" value="채팅방 추가" id="add" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>