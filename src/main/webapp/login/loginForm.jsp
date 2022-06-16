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
        $("input[type='button']").on("click", function () {
            if ($("#id").val() == '') {
                alert("사번을 입력하세요");
                $("#id").focus();
                return
            } else if ($("#pw").val() == '') {
                alert("비밀번호를 입력하세요");
                $("#pw").focus();
                return
            }
            $("form").submit();
        });
        
        
     // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
        var key = getCookie("key");
        $("#id").val(key); 
         
        if($("#id").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
            $("#checkId").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
        }
         
        $("#checkId").change(function(){ // 체크박스에 변화가 있다면,
            if($("#checkId").is(":checked")){ // ID 저장하기 체크했을 때,
                setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
            }else{ // ID 저장하기 체크 해제 시,
                deleteCookie("key");
            }
        });
         
        // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
        $("#id").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
            if($("#checkId").is(":checked")){ // ID 저장하기를 체크한 상태라면,
                setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
            }
        });
    });
    
    function getCookie(cookieName) {
        cookieName = cookieName + '=';
        var cookieData = document.cookie;
        var start = cookieData.indexOf(cookieName);
        var cookieValue = '';
        if(start != -1){
            start += cookieName.length;
            var end = cookieData.indexOf(';', start);
            if(end == -1)end = cookieData.length;
            cookieValue = cookieData.substring(start, end);
        }
        return unescape(cookieValue);
    }
    
    function setCookie(cookieName, value, exdays){
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
        document.cookie = cookieName + "=" + cookieValue;
    }
     
    function deleteCookie(cookieName){
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() - 1);
        document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    }
    
</script>
<style>
    .loginBox {
        width: 500px;
        margin: 100px auto;
    }
    #id, #pw {
        width: 300px;
        height: 40px;
        border-radius: 12px;
        padding: 0px 10px;
        margin-top: 30px;
    }
    form>input[type="button"]{
    	width: 300px;
        height: 40px;
        border-radius: 12px;
        padding: 0px 10px;
        margin-top: 30px;
        background-color: darkgreen;
        border: none;
        color: white;
    }
</style>
</head>
<body>
	<c:if test="${login eq 'false'}" >
	<script>
		alert("아이디 비밀번호가 올바르지 않습니다.");
	</script>
	</c:if>
    <div class="container">
        <div class="loginBox">
            <img src="images/building.png" alt="" width="300px" height="300px" />
            <form action="MyProjectLogin.do" method="post">
                <input type="hidden" name="cmd" value="loginOk">
                <input type="text" name="id" id="id" placeholder="사번을 입력하세요"> <br>
                <input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요"> <br>
                <input type="checkbox" name="check" id="checkId" style="margin-top:30px;"/> 사원정보를 기억합니다.<br>
                <input type="button" value="로그인">
            </form>
        </div>
    </div>
</body>
</html>