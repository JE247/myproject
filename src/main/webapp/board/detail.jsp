<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>MyProject</title>
<style>
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
    
    .table th {
    	text-align: left;
    }
    .detail {
    	width:700px;
    	height: 250px;
    	text-align: left;
    	padding:10px;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		
		<div class="contents">
			<table class="table">
				<tr>
					<th width="20%">게시물번호</th>
					<td>${detaildto.bno }</td>
					<th width="20%">조회수</th>
					<td>${detaildto.hits }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${detaildto.title }</td>
					<th>작성일시</th>
					<td>${detaildto.regdate }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${detaildto.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="2">
						<pre class="detail">${detaildto.contents }</pre>
					
					<%-- <textarea name="" id="" cols="90" rows="10" readonly>${detaildto.contents }</textarea></td> --%>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="2" style="text-align: left;">
						<c:forEach var="vo" items="${file }">
							<a href="MyProjectBoard.do?cmd=download&filename=${vo.filename }&bno=${detaildto.bno}">${vo.filename }</a><br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: right;">
						<a href="MyProjectBoard.do?cmd=board"><input class="btn btn-outline-primary" type="button" value="목록" /></a>
						<a href="MyProjectBoard.do?cmd=modify&bno=${dto.bno}"><input class="btn btn-outline-success" type="button" value="수정" /></a>
						<a href="MyProjectBoard.do?cmd=delete&bno=${dto.bno}"><input class="btn btn-outline-danger" type="button" value="삭제" /></a>
					</td>
				</tr>
				
			</table>
		</div>
	</div>
</body>
</html>