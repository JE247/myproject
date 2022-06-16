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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var t = e.target.result;
                $(".profile").attr('src', t);
            };
            reader.readAsDataURL(input.files[0]);
        } else {
            document.getElementById('preview').src = "";
        }
    }

    function active() {
        $("#repw").removeAttr("disabled");
    }
    
	
    function openKaKaoPostcode() {
		new daum.Postcode({
			oncomplete : function(data) { // 팝업에서 검색결과를 클릭했을 때 실행내용
				$("#addrsresult").val(data.address);
			}
		}).open();
    }
    $(function(){
        $("#insub").on("click", function(){
            if($("#orinpw").val() != '${logindto.password}'){ 
                alert("비밀번호가 올바르지 않습니다.")
                return
            }
            $("form").submit();
        });
        
        
        $("#addrs").on("click", openKaKaoPostcode);
    });
</script>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

    * {
        margin: 0px;
        padding: 0px;
    }
    
    .container {
        margin: 10px auto;
    }

    .picture {
        border-radius: 100%;
        width: 200px;
        height: 200px;
        border: 1px solid grey;
        overflow: hidden;
        margin: auto;
    }

    .picture>img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }

    .contents {
        margin: 100px auto;
        display: flex;
    }

    .edit {
        margin-left: 120px;
    }

    .edit>label {
        font-family: 'Noto Sans KR', sans-serif;
        font-style: normal;
        font-weight: 500;
        font-size: 14px;
    }

    table{

        font-family: 'Noto Sans KR', sans-serif;
        font-style: normal;
        font-weight: 700;
        font-size: 20px;
        margin-top: 10px;
    }

    table tr {
        height: 40px;
    }

    .inputtag {
        margin: 10px auto;
        width: 350px;
        height: 40px;
        padding: 5px;
        border: 1px solid rgba(0, 0, 0, 0.25);
        filter: drop-shadow(0px 4px 10px rgba(0, 0, 0, 0.25));
        border-radius: 12px;
        font-weight: 500;
    }

    .phonetag {
        margin: 10px auto;
        width: 200px;
        height: 35px;
        padding: 5px;
        border: 1px solid rgba(0, 0, 0, 0.25);
        filter: drop-shadow(0px 4px 10px rgba(0, 0, 0, 0.25));
        border-radius: 12px;
        font-weight: 500;
    }

    .rev {
        border: 0;
        outline: 0;
        background: green;
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
        border-radius: 12px;
        color: #FFFFFF;
        margin-left: 20px;
        width: 150px;
        height: 41px;
    }

    #insub {
        border: 0;
        outline: 0;
        background: green;
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
        border-radius: 12px;
        color: #FFFFFF;
        margin-left: 20px;
        width: 100px;
        height: 45px;
        position: relative;
        top: 30px;
        left: 600px;
    }
</style>
<title>MyProject</title>
</head>
<body>
    <div class="container">
        <jsp:include page="../tag/header.jsp"></jsp:include>
        <form action="MyProject.do?cmd=infoeditOk" method="post" enctype="multipart/form-data">
            <div class="contents">
                <div class="mypicture" style="width:230px; height:230px; position: relative; top: 20px;">
                    <div class="picture">
	                    <c:if test="${myinfo.photoname eq null }">
	                		<img class="profile" src="images/myinfo/basic.gif" alt="" />
	                	</c:if>
	                	<c:if test="${myinfo.photoname ne null }">
	                		<img class="profile" src="images/myinfo/${myinfo.photoname}" alt="" />
	                	</c:if>
                    </div>
                    <input type="file" name="photo" id="choose" style="display:none;" onchange="readURL(this);">
                    <label for="choose">
                        <img src="images/camera.png" alt=""
                            style="position: absolute; bottom:0px; right:20px;width:30px;height:30px;">
                    </label>
                    <br><br>
                    <div class="info" style="text-align: center;">
                        <table>
                            <tr>
                                <th style="width: 50%;">사번</th>
                                <td>${myinfo.eno }</td>
                            </tr>
                            <tr>
                                <th>부서</th>
                                <td>${mydept.dname }</td>
                            </tr>
                            <tr>
                                <th>직무</th>
                                <td>${myinfo.job }</td>
                            </tr>
                            <tr>
                                <th>직급</th>
                                <td>${myinfo.position }</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="edit">
                    <input type="hidden" name="eno" value="${myinfo.eno }">
                    
                    <label for="">이름</label><br>
                    <input class="inputtag" type="text" name="name" value="${myinfo.name }"><br>
                    
                    <label for="">현재 비밀번호</label><br>
                    <input class="inputtag" type="password" name="orinpw" id="orinpw">
                    <input type="button" onclick="active();" value="비밀번호 변경" class="rev" id="rev"><br>
                    
                    <label for="">변경할 비밀번호</label><br>
                    <input class="inputtag" type="password" name="repw" id="repw" disabled><br>
                    
                    <label for="">주소</label><br>
                    <input class="inputtag" type="text" id="addrsresult" name="addrs1" value="${myinfo.addrs }"> 
                    <input type="button" value="주소찾기" class="rev" id="addrs"><br>
                    <input class="inputtag" type="text" name="addrs2"><br>
                    
                    <label for="">휴대폰 번호</label><br>
                    <input class="inputtag" type="text" name="phone" value="${myinfo.phone }"><br>
                    
                    <label for="">이메일 주소</label><br>
                    <input class="inputtag" type="text" name="email" value="${myinfo.mail }"><br>

                    <input id="insub" type="button" value="수정">
                </div>
        </form>
    </div>
</div>
</body>
</html>