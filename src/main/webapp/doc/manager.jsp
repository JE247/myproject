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
	$(".table tr").click(function(){
		var tr = $(this); 
		var td = tr.children();
		
		var eno = td.eq(0).text();
		var name = td.eq(1).text();
		
		opener.setChildValue(eno, name);
		window.close();
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
		<table class="table table-hover">
			<tr>
				<th width="50%">사원번호</th>
				<th width="50%">사원명</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.eno }</td>
					<td>${vo.name }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>