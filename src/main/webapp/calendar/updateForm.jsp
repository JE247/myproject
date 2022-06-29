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
	$(function(){
		
		$("input:button").on("click", function(){
			
			var start = new Date($("input[name='startdate']").val());
			var end = new Date($("input[name='enddate']").val());
			
			if($("input[name='title']").val() == ""){
				alert("일정명을 입력하세요");
				return;
			} else if($("input[name='startdate']").val() == ""){
				alert("시작일자를 확인하세요");
				return;
			} else if($("input[name='enddate']").val() == ""){
				alert("마지막일자를 확인하세요");
				return;
			} else if(start > end){
				alert("일자를 확인하세요");
				return;
			} else if($("select[name='type']").val() == ""){
				alert("종류를 확인하세요");
				return;
			}
			$("form").submit();
		});
	});
</script>
<style>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

	.inputTag{
		padding: 5px;
		resize: none;
		border: 1px solid rgba(0, 0, 0, 0.25);
		filter: drop-shadow(0px 4px 10px rgba(0, 0, 0, 0.08))
				drop-shadow(0px 1px 1px rgba(0, 0, 0, 0.12));
		border-radius: 12px;
		outline-color: green;
		font-family: 'Noto Sans KR', sans-serif;
		font-style: normal;
		font-weight: 500;
		width:200px;
		height:35px;
		font-size: 13px;
	}
	.memo {
		height:150px;
		font-size: 12px;
	}
	.table{
		vertical-align: middle;
	}
</style>
</head>
<body>
<div class="container">
	<form action="MyProjectCalendar.do?cmd=updateOk" method="post">
		<input type="hidden" name="cno" value="${cal.cno}" />
		<input type="hidden" name="eno" value="${logindto.eno}" />
		<table class="table">
			<tr>
				<th>일정명</th>
				<td><input class="inputTag" type="text" name="title" id="" value="${cal.title }"/></td>
			</tr>
			<tr>
				<th>StartDate</th>
				<td><input class="inputTag" type="date" name="startdate" id="" value="${cal.startDate }"/></td>
			</tr>
			<tr>
				<th>EndDate</th>
				<td><input class="inputTag" type="date" name="enddate" id="" value="${cal.endDate }"/></td>
			</tr>
			<tr>
				<th>위치</th>
				<td><input class="inputTag" type="text" name="loc" id="" value="${cal.loc }"/></td>
			</tr>
			<tr>
				<th>Memo</th>
				<td><input class="inputTag memo" type="text" name="contents" id="" value="${cal.contents}"/></td>
			</tr>
			<tr>
				<th>종류</th>
				<td>
					<select name="type" id="" class="inputTag">
						<option value="1">회사일정</option>
						<option value="2">개인일정</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					<input type="button" class="btn btn-success" value="일정 변경" />			
				</td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>