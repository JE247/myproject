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
	function paging(page){
		$("input:hidden[name='cp']").val(page);
		$("form").submit();
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
    
    #selection {
        border-radius: 7px;
        width: 100px;
        height: 35px;
    }

    #search {
        margin: 10px auto;
        width: 300px;
        height: 35px;
        padding: 5px;
        border: 1px solid rgba(0, 0, 0, 0.25);
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.1));
        border-radius: 12px;
        font-weight: 500;
        margin-left: 20px;
    }

    #textsearch {
        border: 0;
        outline: 0;
        background: green;
        filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
        border-radius: 12px;
        color: #FFFFFF;
        margin-left: 20px;
        width: 100px;
        height: 35px;
    }
    
    table a{
    	text-decoration: none;
    	color: black;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
		<h2>자유게시판</h2>
            <br><br><br>
            <table class="table">
                <tr>
                    <th width="10%">No</th>
                    <th width="40%">제목</th>
                    <th width="20%">작성자</th>
                    <th wdith="15%">작성일</th>
                    <th width="15%">조회수</th>
                </tr>
				<c:forEach var="vo" items="${boardlist }">
	                <tr>
	                    <td>${vo.bno }</td>
	                    <td style="text-align: left;"><a href="MyProjectBoard.do?cmd=detail&bno=${vo.bno }">${vo.title }</a></td>
	                    <td>${vo.writer }</td>
	                    <td>${vo.regdate }</td>
	                    <td>${vo.hits }</td>
	                </tr>
                </c:forEach>
                <tr>
                	<td colspan="5" style="text-align: right;">
                		<a href="MyProjectBoard.do?cmd=write"><input type="button" value="글쓰기" class="btn btn-outline-success"/></a>
                	</td>
                </tr>
            </table>
			<div id="things">
	            <div class="paging">
		               <nav aria-label="Page navigation example" style="display: inline-block;">
						  <ul class="pagination">
						  	<c:if test="${isPre}">
						    	<li class="page-item"><a class="page-link" href="#" onclick="paging(${cp-1});">Previous</a></li>
						    </c:if>
				               <c:forEach begin="${startPage}" end="${endPage}" var="i" step="1">
								    <li class="page-item"><a class="page-link" onclick="paging(${i});" href="#">${i}</a></li>
				               </c:forEach>
				            <c:if test="${isNext }">
						    	<li class="page-item"><a class="page-link" href="#">Next</a></li>
						    </c:if>
						  </ul>
						</nav>
	            </div>
	            <div class="search">
		            <form action="MyProjectBoard.do">
		            	<input type="hidden" name="cp" value="" />
		            	<input type="hidden" name="cmd" value="board" />
		                <select name="type" id="selection">
		                    <option value="title">제목</option>
		                    <option value="writer">작성자</option>
		                    <option value="contents">내용</option>
		                </select>
		                <input type="text" name="keyword" id="search">
		                <input type="submit" value="검색" id="textsearch">
		            </form>
	            </div>
            </div>
		</div>
	</div>
</body>
</html>