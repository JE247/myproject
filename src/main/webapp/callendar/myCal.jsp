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
<script>
	$(function(){
		$("select").on("change", function(){
			$("form").submit();
		});
		
		$("#modify").on("click", function(){
			var target = $("input:radio[name='cno']").is(":checked");
			if(!target){
				alert("예약을 선택해주세요!");
				return
            }
        	$("#cmd").val("modifyCalForm");
            $("form").submit();
		});
		$("#delete").on("click", function(){
			var target = $("input:radio[name='cno']").is(":checked");
			if(!target){
				alert("예약을 선택해주세요!");
				return
            }
        	$("#cmd").val("deleteOne");
            $("form").submit();
		});
	});
</script>
<style>
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
    .seldein{
        border-radius: 6px;
    }
    .table{
    	font-size:13px;
    }
    .formbutton{
        border: 0;
        outline: 0;
        background: green;
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
        border-radius: 7px;
        color: #FFFFFF;
        margin-left: 20px;
        width: 80px;
        height: 25px;
        font-size: 14px;
    }
</style>
<title>MyProject</title>
</head>
<body>
<div class="container">
	<div class="contents">
		<form action="MyProjectCallendar.do">
		<input type="hidden" id="cmd" name="cmd" value="modifyCal" />
		<table class="table">
			<tr>
				<td>
					<select class="seldein" name="year" id="">
						<c:set var="yearNum" value="2022"></c:set>
						<c:forEach var="i" begin="2020" end="2022" step="1">
							<c:choose>
								<c:when test="${year eq yearNum }">
									<option value="${yearNum}" selected>${yearNum }년</option>
								</c:when>
								<c:otherwise>
									<option value="${yearNum}">${yearNum }년</option>
								</c:otherwise>
							</c:choose>
							<c:set var="yearNum" value="${2022-1}"></c:set>
						</c:forEach>
					</select>
				</td>
				<td>
					<select class="seldein" name="month" id="">
						<c:forEach var="i" begin="1" end="12" step="1">
							<c:choose>
								<c:when test="${month eq i }">
									<option value="${i }" selected>${i }월</option>
								</c:when>
								<c:otherwise>
									<option value="${i }">${i }월</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>

					</select>
				</td>
				<td colspan="3" style="text-align: right;">
					<input class="formbutton" type="button" value="수정" id="modify"/>
					<input class="formbutton" type="button" value="삭제" id="delete"/>
				</td>
			</tr>
			<tr>
				<th width="5%"></th>
				<th width="10%">일정번호</th>
				<th width="25%">일정명</th>
				<th width="30%">시작일자</th>
				<th width="30%">종료일자</th>
			</tr>
			<c:forEach var="vo" items="${myList }">
				<tr>
					<td>
						<input type="radio" name="cno" id="" value="${vo.cno}"/>
					</td>
					<td>${vo.cno }</td>
					<td>${vo.title }</td>
					<td>${vo.startDate }</td>
					<td>${vo.endDate }</td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
</div>
</body>
</html>