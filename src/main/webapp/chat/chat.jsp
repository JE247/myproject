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
	$("input").on("click", function(){
		console.log("test");
		
		$.ajax({
			type : "post",
			url:"MyProjectChatAjax.do",
			success : function(data){
				
				var result = JSON.parse(data);
				
				for(var i=0; i<result.length; i++){
					if(i != result.length -1){
						var txt = `<li>\${result[i].send} : \${result[i].cont} </li>`;
						$("ul").append(txt);
					} else if (i == result.length -1){
						$("ul").append(`<li>\${result[i].last}</li>`);
					}
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
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>채팅방</h2>
			<br><br><br>
			<input type="button" value="출력" />
			<ul class="text">
			</ui>
		</div>
	</div>
</body>
</html>