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
    .fileRemove{
        width: 20px;
        height: 20px;
        background-size: 100% 100%;
        background-image: url("images/remove.png");
        background-color: none;
        border: none;
    }

    label>img{
        width: 30px;
        height: 30px;
    }
    .preview{
    	text-align: left;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>${dtitle }</h2>
			<br><br><br>
				<input type="hidden" name="cmd" value="writeOk" />
				<table class="table">
					<tr>
						<th>결제자</th>
						<td><div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  									aria-describedby="basic-addon1" placehorder="결제자" value=${manager } readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  									aria-describedby="basic-addon1" placehorder="작성자" name = "writer" value="${myname }" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><div class="input-group">
				 			 <textarea class="form-control" aria-label="With textarea" rows="5" name="contents" readonly>${dto.dcontents }</textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a href="MyProjectDoc.do?cmd=doc"><input class="btn btn-outline-primary" type="button" value="결제목록" /></a>
							<a href="MyProjectDoc.do?cmd=delete&dcno=${dto.dcno }"><input class="btn btn-danger" type="button" value="신청 취소" id="apply" /></a>
						</td>
					</tr>
				</table>
		</div>
	</div>
</body>
</html>