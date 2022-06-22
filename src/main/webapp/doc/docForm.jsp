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
		$("#choice").on("click", function(){
			var popupWidth = 400;
	    	var popupHeight = 400;
	    	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	    	var popupY= (window.screen.height / 2) - (popupHeight / 2);
	    	var url = "MyProjectDoc.do?cmd=myManager";
	    	var name = "myManager";
	    	var option = "width = 400px, height = 400px, top = "+popupY+", left = "+popupX+", resizable=no, location = no";
	    	
	    	window.open(url, name, option);
		});
		
		$("#apply").on("click", function(){
			console.log("test");
			if($("#manager").val() == ""){
				alert("결제자를 선택해주세요");
				return;
			}
			
			$("form").submit();
		});
    });
    
    function setChildValue(eno, name){
    	$("#meno").val(eno);
    	$("#manager").val(name);
    }

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
			<h2>${dtype.dtitle }</h2>
			<br><br><br>
			<form action="MyProjectDoc.do" method="get">
				<input type="hidden" name="cmd" value="writeOk" />
				<input type="hidden" name="meno" id="meno" />
				<input type="hidden" name="dtype" value="${dtype.dtype}" />
				<table class="table">
					<tr>
						<th>결제자</th>
						<td><div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  									aria-describedby="basic-addon1" placehorder="결제자" name = "manager" id="manager" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  									aria-describedby="basic-addon1" placehorder="작성자" name = "writer" value="${my.name }" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><div class="input-group">
				 			 <textarea class="form-control" aria-label="With textarea" rows="5" name="contents"></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a href="MyProjectDoc.do?cmd=doc"><input class="btn btn-outline-primary" type="button" value="결제목록" /></a>
							<input class="btn btn-success" id="choice" type="button" value="결제자 선택" />
							<input class="btn btn-primary" type="button" value="결제신청" id="apply" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>