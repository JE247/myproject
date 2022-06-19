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
<script type="text/javascript">
	$(function(){
		$(".scrap").on("click", function(){
			$.ajax({
				url:"MyProjectBoard.do?cmd=scrap",
				type:"GET",
				data:"eno=${logindto.eno}&bno=${detaildto.bno}&scrap=${scrap}",
				success: function(data){
					console.log("성공");
					console.log(data);
					if(data.scrap){
						$(".scrap").attr("src", "images/star.png");
						window.location.reload();
					} else {
						$(".scrap").attr("src", "images/full_star.png");
						window.location.reload();
					}
				}
			});
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
        margin: 50px 0px;
        text-align: center;
    }
    .table th, .table td {
    	vertical-align: middle;
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
    .center {
    	vertical-align: middle;
    }
    table a{
    	text-decoration: none;
    }
    p>a{
    	font-size: 3em;
    }
    .scrap{
    	width:50px;
    	height:50px;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<table class="table">
				<tr>
					<th width="15%">게시물번호</th>
					<td width="40%">${detaildto.bno }</td>
					<th width="10%" class="center" style="text-align: center;">조회수</th>
					<td width="5%">${detaildto.hits }</td>
					<th width="15%" class="center" style="text-align: center;">작성일시</th>
					<td width="15%">${detaildto.regdate }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${detaildto.title }</td>
					<th rowspan="2" class="center" style="text-align: center;">스크랩</th>
					<td colspan="3" rowspan="2" class="center">
						<c:if test="${scrap}">
							<img class="scrap" src="images/full_star.png" alt="" />
						</c:if>
						<c:if test="${!scrap}">
							<img class="scrap" src="images/star.png" alt="" />
						</c:if>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${detaildto.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="6">
						<pre class="detail">${detaildto.contents }</pre>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="6" style="text-align: left;">
						<c:forEach var="vo" items="${file }">
							<a href="MyProjectBoard.do?cmd=download&filename=${vo.filename }&bno=${detaildto.bno}">${vo.filename }</a><br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: right;">
						<a href="MyProjectBoard.do?cmd=board"><input class="btn btn-outline-primary" type="button" value="목록" /></a>
						<c:if test="${my}">
							<a href="MyProjectBoard.do?cmd=modify&bno=${detaildto.bno}"><input class="btn btn-outline-success" type="button" value="수정" /></a>
							<a href="MyProjectBoard.do?cmd=delete&bno=${detaildto.bno}"><input class="btn btn-outline-danger" type="button" value="삭제" /></a>
						</c:if>
					</td>
				</tr>
				
			</table>
		</div>
	</div>
</body>
</html>