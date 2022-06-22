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
    var flag = false;
    $(function(){


        $("#checkTime").on("click", function(){
        	
        	var queryString = $("#frm").serialize() ;
 
        	var time1 = parseInt($("#time1").val());
            var time2 = parseInt($("#time2").val());
            
            
        	if($("input[name='rezDate']").val()==""){
                alert("예약일자를 확인해주세요");
                return;
            } else if (time1 >= time2) {
                alert("예약시간을 확인해주세요");
                return;
            }
            
            $.ajax({
            	url:"TimeCheck.do",
            	type:"POST",
            	data:queryString,
            	success:function(data){
            		if(data == "1"){
            			var txt = "다른 시간대를 선택해주세요"
            			$("#msg").css("vertical-align", "middle").css("color", "red").css("font-size", "12px");
            			$("#msg").html(txt);
            			flag = false;
            		} else {
            			var txt = "예약이 가능합니다"
               			$("#msg").css("vertical-align", "middle").css("color", "green").css("font-size", "12px");
               			$("#msg").html(txt);
               			flag = true;
            		}
            	}
            });
        });

        
        $("#add").on("click", function(){
            var time1 = parseInt($("#time1").val());
            var time2 = parseInt($("#time2").val());
            
            if($("input[name='rezDate']").val()==""){
                alert("예약일자를 확인해주세요");
                return;
            } else if (time1 >= time2) {
                alert("예약시간을 확인해주세요");
                return;
            } else if (!flag){
            	alert("예약시간 중복체크를 확인해주세요");
            	return;
            }
            $("form").submit();
        });
    });

</script>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');

    * {
        margin: 0px;
        padding: 0px;
    }

    .container {
        margin: 10px auto;
    }

    .contents {
        margin: 20px auto;
        text-align: center;
        width: 400px;
    }

    .inputTag {
        padding: 5px;
        resize: none;
        border: 1px solid rgba(0, 0, 0, 0.25);
        filter: drop-shadow(0px 4px 10px rgba(0, 0, 0, 0.08)) drop-shadow(0px 1px 1px rgba(0, 0, 0, 0.12));
        border-radius: 12px;
        outline-color: green;
        font-family: 'Noto Sans KR', sans-serif;
        font-style: normal;
        font-weight: 500;
        width: 170px;
        height: 32px;
        font-size: 13px;
    }
    #memo{
        padding: 5px;
        resize: none;
        border: 1px solid rgba(0, 0, 0, 0.25);
        filter: drop-shadow(0px 4px 10px rgba(0, 0, 0, 0.08)) drop-shadow(0px 1px 1px rgba(0, 0, 0, 0.12));
        border-radius: 12px;
        font-family: 'Noto Sans KR', sans-serif;
        font-style: normal;
        font-weight: 500;
        width: 170px;
        height: 60px;
        font-size: 13px;
    }
    #checkTime{
        width: 100px;
        height: 35px;
        font-size: 13px;
    }
    .buttons{
        text-align: right;
    }
</style>
</head>
<body>
	<div class="container">
        <div class="contents">
        <form action="MyProjectRez.do" id="frm">
        <input type="hidden" name="cmd" value="addOk" />
        <input type="hidden" name="eno" value="${logindto.eno }" />
            <table class="table">
                <tr>
                    <th>회의실</th>
                    <td>
                        <select class="inputTag" name="roomno">
                            <c:forEach var="vo" items="${list }">
                            	<option value="${vo.roomNo }">${vo.roomName }</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>예약 일자</th>
                    <td>
                        <input class="inputTag" type="date" name="rezDate">
                    </td>
                </tr>
                <tr>
                    <th>시작시간</th>
                    <td>
                        <select class="inputTag" name="startTime" id="time1">
                        	<c:forEach var="i" begin="9" end="20" step="1">
                            	<option value="${i }">${i}시</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>종료시간</th>
                    <td>
                        <select class="inputTag" name="endTime" id="time2">
                        	<c:forEach var="i" begin="9" end="20" step="1">
                            	<option value="${i}">${i}시</option>
                            </c:forEach>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td><input class="btn btn-outline-danger" id="checkTime" type="button" value="시간중복체크"></td>
                    <td id="msg"></td>
                </tr>
                <tr>
                    <th>예약인원</th>
                    <td>
                        <select class="inputTag" name="people">
                           <c:forEach var="i" begin="2" end="10" step="1">
                            	<option value="${i }">${i}명</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>예약목적</th>
                    <td>
                        <textarea name="memo" id="memo"></textarea>
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <input type="button" id="add" class="btn btn-primary" value="예약하기">
            </div>
            </form>
        </div>
    </div>
</body>
</html>