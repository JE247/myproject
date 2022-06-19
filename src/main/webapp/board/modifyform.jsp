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
        const fileInput = $("#file_input"); // jquery로 파일을 가져올 경우 앞에 [0]으로 정확한 선택자를 기입해준다.
        var preview = $(".preview");
        var removeFile = $(".fileRemove");

        fileInput.on("change", function(){
		    var list = "";
            var files = Array.from(fileInput[0].files);
            files.forEach(function(file){
            	list += `<p id = "\${file.lastModified}">\${file.name}
                            <button data-index="\${file.lastModified}" class="fileRemove" 
                                onclick = "removeFile(this);"></button> </p>`;
                preview.html(list);
            });
        });
    });
    
    function deleteFile(num){
    	$("#id"+num).remove();
    	
    	let input = document.createElement('input');
    	
    	input.setAttribute('type', 'hidden');
    	input.setAttribute('name', 'deletefile');
    	input.setAttribute('value', num);
    	
    	$(".delete").append(input);
    }

    function removeFile(m){
        var removeTargetId = m.dataset.index;
        var removeTarget = $("#"+removeTargetId);

        var files = $("#file_input")[0].files;

        var dataTranster = new DataTransfer();

        Array.from(files).filter(function(file){
            return file.lastModified != removeTargetId
        }).forEach(function(file){
            dataTranster.items.add(file);
        });
        
        document.querySelector("#file_input").files = dataTranster.files;
        removeTarget.remove();
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
    .preview, .originfile{
    	text-align: left;
    }
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../tag/header.jsp"></jsp:include>
		<div class="contents">
			<form action="MyProjectBoard.do?cmd=modifyOk" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bno" value="${detaildto.bno }" />
				<table class="table">
					<tr>
						<th>작성자</th>
						<td><div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  									aria-describedby="basic-addon1" placehorder="작성자" name = "writer" value="${detaildto.writer }" readonly>
							</div>
						</td>
					</tr>
					<tr>
				
						<th>제목</th>
						<td>	
							<div class="input-group mb-3">
					  			<input type="text" class="form-control" aria-label="Username" 
					  																aria-describedby="basic-addon1" name = "title" value="${detaildto.title }">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><div class="input-group">
				 			 <textarea class="form-control" aria-label="With textarea" rows="5" name="contents">${detaildto.contents }</textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td style="text-align: left;">
							<div class="add" >
							    <input type="file" name="files" id="file_input" multiple > <!--style="display: none;"  -->
								    <label for="file_input">
								        <img src="images/documents.png" alt="">
								    </label>
							</div>

						</td>
					</tr>
					<tr>
						<th></th>
						<td>
							<div class="preview"></div>
							<div class="originfile">
								<c:if test="${file ne null}">
	 								<c:forEach var="vo" items="${file }">
										<p id = "id${vo.fno }"> ${vo.filename}
										<input type="button" value="" class="fileRemove" onclick = "deleteFile(${vo.fno});"/>
	                            		</p>
									</c:forEach>
								</c:if>
    						</div> 
    						<div class="delete">
    						</div>   
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a href="MyProjectBoard.do?cmd=board"><input class="btn btn-outline-primary" type="button" value="목록" /></a>
							<input class="btn btn-primary" type="submit" value="저장" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>