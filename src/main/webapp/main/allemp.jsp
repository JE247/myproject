<%@page import="kr.co.jhta.project.dto.OfficeWorkerDTO"%>
<%@page import="kr.co.jhta.project.dao.OfficeWorkerDAO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jhta.project.dto.DepartmentDTO"%>
<%@page import="kr.co.jhta.project.dao.DepartmentDAO"%>
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
        $("#dname").on('change', function(){
            $("form").attr("action", "");
            $("form").submit();
        });
        $("#rank").on('change', function(){
            $("form").attr("action", "");
            $("form").submit();
        });
        $("#addOne").on('click', function(){
        	$("#cmd").val("insertemp");
            $("form").attr("action", "MyProject.do");
            $("form").submit();
        });
        $("#modifyOne").on('click', function(){
        	var target = $("input:radio[name='selectone']").is(":checked");
			if(!target){
				alert("사원을 선택해주세요!");
				return
            }
        	$("#cmd").val("editemp");
            $("form").attr("action", "MyProject.do");
            $("form").submit();
        });
        $("#deleteOne").on('click', function(){
        	var target = $("input:radio[name='selectone']").is(":checked");
			if(!target){
				alert("사원을 선택해주세요!");
				return
            }
        	$("#cmd").val("deleteemp");
            $("form").attr("action", "MyProject.do");
            $("form").submit();
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
    .formbutton{
        border: 0;
        outline: 0;
        background: green;
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
        border-radius: 7px;
        color: #FFFFFF;
        margin-left: 20px;
        width: 100px;
        height: 25px;
        font-size: 14px;
    }
    .seldein{
        border-radius: 10px;
    }
</style>
</head>
<body>
<div class="container">
	<jsp:include page="../tag/header.jsp"></jsp:include>
	<div class="contents" >
        <form action="">
        	<input type="hidden" id="cmd" name="cmd" value="allemp" />
            <h2>사원 정보 조회</h2>
            <br><br>
            <div class="tablewrap" style="width:100%; height:650px; overflow:auto">
            <table class="table">
                <tr>
                    <td colspan="7" style="text-align: right;">
                        <input class="formbutton" id="addOne" type="button" value="신규사원 등록">
                        <input class="formbutton" id="modifyOne" type="button" value="상세 조회">
                        <input class="formbutton" id="deleteOne" type="button" value="사원 삭제">
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <th>
                   		<select class="seldein" name="dname" id="dname">
                            <option value="">부서명</option>
                          	    <c:forEach var="vo" items="${deptlist}">
                          	    	<c:choose>
	                          	    	<c:when test="${dname eq vo.dname }">
		                            	<option value="${vo.dno}" selected>${vo.dname}</option>
	                          	    	</c:when>
	                          	    	<c:otherwise>
		                            	<option value="${vo.dno}">${vo.dname}</option>
		                            	</c:otherwise>
                          	    	</c:choose>
	                            </c:forEach>
                        </select>
                        
                    </th>
                    <th>
                        <select class="seldein" name="rank" id="rank">
                            <option value="">직급명</option>
	                            <c:forEach var="vo" items="${positionlist}">
                          	    	<c:choose>
	                          	    	<c:when test="${rank eq vo }">
		                            	<option value="${vo}" selected>${vo}</option>
	                          	    	</c:when>
	                          	    	<c:otherwise>
		                            	<option value="${vo}">${vo}</option>
		                            	</c:otherwise>
                          	    	</c:choose>
	                            </c:forEach>
                        </select>
                    </th>
                    <th>사번</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
                <%
                DepartmentDAO dao = new DepartmentDAO();
                  
                Object obj = request.getAttribute("emplist");
                
                List<OfficeWorkerDTO> list = (List)obj;  
                for(OfficeWorkerDTO dto : list){  
                %>
                <tr>
                	<td><input type="radio" name="selectone" value="<%=dto.getEno()%>"></td>
                	<td><%=dao.getOne(dto.getDno()).getDname() %></td>
                	<td><%=dto.getPosition() %></td>
                	<td><%=dto.getEno() %></td>
                	<td><%=dto.getName() %></td>
                	<td><%=dto.getPhone() %></td>
                	<td><%=dto.getMail() %></td>
                </tr>    
                <%} %>

            </table>
            </div>
        </form>
    </div>
</div>
</body>
</html>