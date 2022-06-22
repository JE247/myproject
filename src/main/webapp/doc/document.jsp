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
        $("#add").on("click", function () {
            if (!$("input[name='type']").is(":checked")) {
                alert("작성할 문서를 선택해주세요");
                return;
            }
            $("#frm1").submit();
        });
        
        $("#selection").on("change", function(){
        	console.log($("#selection").val());
        	$("#frm3").submit();
        })
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
.button{
	text-align: right;
	height: 45px;
}
.button > input{
	border: 0;
    outline: 0;
    background: green;
    filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
    border-radius: 7px;
    color: #FFFFFF;
    margin-left: 20px;
    width: 100px;
    height: 40px;
    font-size: 14px;
}
.main{
	display:flex;
}
.insert{
	width: 40%;
}
.confirm{
	margin-left: 30px;
	width: 60%;
}
#selection{
	border-radius: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<h2>전자 결제 내역</h2>
			<br><br><br>
			
            <div class="main">
	            <div class="insert">
		            <div class="button"><input type="button" value="문서 작성" id="add" /></div>
					<br>
	            	<form action="MyProjectDoc.do" id="frm1">
						<input type="hidden" name="cmd" value="docForm" id="addcmd"  />
						<table id="chatTable" class="table table-striped table-bordered">
							<tr class="table-dark">
								<th colspan="3">결제문서 종류</th>
							</tr>
							<tr>
								<th width="10%"></th>
								<th width="20%">문서 번호</th>
								<th width="70%">문서 종류</th>
							</tr>
						 	<c:forEach var="vo" items="${docAll }">
								<tr>
									<td><input type="radio" name="type" value="${vo.dtype}"/></td>
									<td>${vo.dtype }</td>
									<td>${vo.dtitle }</td>
								</tr>
							</c:forEach>
			            </table>
		            </form>
	            </div>
	            <div class="confirm">
	            	<div class="button"></div>
					<br>
	            	<form action="MyProjectDoc.do" id="frm2">
						<input type="hidden" name="cmd" value="docForm" id="appDetail"  />
						<table id="chatTable" class="table table-striped table-bordered">
							<tr class="table-dark">
								<th width="25%">문서종류</th>
								<th width="25%">사원번호</th>
								<th width="20%">사원명</th>
								<th width="30%">작성일</th>
							</tr>
						 	<c:forEach var="vo" items="${docList }">
								<tr>
									<td><a href="MyProjectDoc.do?cmd=appDetail&dcno=${vo.dcno }">${vo.dtitle }</a></td>
									<td>${vo.eno }</td>
									<td>${vo.name }</td>
									<td>${vo.regdate }</td>
								</tr>
							</c:forEach>
			            </table>
		            </form>
	            </div>
            </div>
            <br><br><br>
            <div class="listTable">
	            <form action="MyProjectDoc.do" id="frm3">
	            	<input type="hidden" name="cmd" value="doc"/>
					<table class="table table-striped table-bordered">
						<tr class="table-dark">
							<th colspan="5">내 결제함</th>
						</tr>
						<tr>
							<th width="25%">
								<select name="status" id="selection">
									<option value="">결제진행상황</option>
									<c:forEach var="i" begin="1" end="3" step="1">
										<c:choose>
											<c:when test="${i-2 eq -1 }">
												<c:set var="s" value="반려"></c:set>
											</c:when>
											<c:when test="${i-2 eq 1 }">
												<c:set var="s" value="승인"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="s" value="대기"></c:set>
											</c:otherwise>
										</c:choose>
										<c:if test="${status eq i-2 }">
											<option value="${i-2 }" selected="selected">${s }</option>
										</c:if>
										<c:if test="${status ne i-2 }">
											<option value="${i-2 }">${s }</option>
										</c:if>
									</c:forEach>
								</select>
							</th>
							<th width="10%">문서번호</th>
							<th width="20%">문서종류</th>
							<th width="20%">결제자</th>
							<th width="25%">승인날짜</th>
						</tr>
					 	<c:forEach var="vo" items="${myList }">
							<tr>
								<td>
									<c:choose>
										<c:when test="${vo.stauts eq -1 }">
											<c:set var="s" value="반려"></c:set>
										</c:when>
										<c:when test="${vo.stauts eq 1 }">
											<c:set var="s" value="승인"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="s" value="대기"></c:set>
										</c:otherwise>
									</c:choose>
									<c:if test="${s eq '대기' }">
										<a href="MyProjectDoc.do?cmd=docDetail&dcno=${vo.dcno}">${s}</a>
									</c:if>
									<c:if test="${s ne '대기' }">
										${s}
									</c:if>
								</td>
								<td>${vo.dtitle }</td>
								<td>${vo.dtitle }</td>
								<td>${vo.manager }</td>
								<td>${vo.appDate }</td>
							</tr>
						</c:forEach>
		            </table>
		        </form>
            </div>
		</div>
	</div>
</body>
</html>