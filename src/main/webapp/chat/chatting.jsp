<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/chat.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	var lastID = 0;
	
	$(function() {
		
		$("#send").on("click", sendMessage);
		$('input').keyup(function(e) {    
			if (e.keyCode == 13) sendMessage();
		});
		
		$("#exit").on("click", function(){
			window.location = "MyProjectChatting.do?cmd=exitchat&chatno="+${chatno};
		});
		
		receiveMessage('today');
		getInfiniteChat();
	});

	function sendKey(e) {
		if (e.keyCode == 13) {
			sendMessage();
		}
	}

	function sendMessage() {
		
		var msg = $("#msg");
		
		if (msg.val() != '') {
			
			var message = msg.val();
			var eno = ${logindto.eno};
			var chatno = ${chatno};
			
			$.ajax({
				type : "POST",
				url : "ChatSend.do",
				data : {
					"chatno" : chatno,
					"eno" : eno,
					"message" : message
				},
				success : function (data){
				}
			});
			msg.val("");
		}
	}
	
	function receiveMessage(type){
		
		var chatno = ${chatno};
		
		$.ajax({
			type : "POST",
			url : "ChatReceive.do",
			data : {
				"chatno" : chatno,
				"type" : type
			},
			success : function (data){
				
				if(data == "") return;
				
				var obj = JSON.parse(data);
				
				for(var i = 0; i < obj.length; i++){
					
					if(i != obj.length-1){
						addChat(obj[i].picture, obj[i].name, obj[i].date, obj[i].msg);
					} else {
						lastID = obj[i].mno;
					}
				}
			}
		});
	}
	
	function addChat(chatPhoto, chatName, chatDate, chatMsg){
		var msg = `<div class="row">
					<div class="col-lg-12">
						<div class="media">
							<div class="info" style="display: flex;">
								<img class="media-object img-circle img-chat" src="images/myinfo/\${chatPhoto}" alt="">
								<p class="media-heading">
									\${chatName} <span class="small pull-right">\${chatDate}</span>
								</p>
							</div>
							<div class="media-body">
								<p>\${chatMsg}</p>
							</div>
						</div>
					</div>
				</div>
				<hr>`;
		$("#chatMessage").append(msg);
		$("#chatMessage").scrollTop($("#chatMessage")[0].scrollHeight);
	}
	
	function getInfiniteChat(){
		setInterval(function(){
			receiveMessage(lastID);
		}, 1000);
	}
</script>
<title>MyProject</title>
</head>
<body>
	<div class="container">
		<div class="container bootstrap snippets bootdey">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="portlet portlet-default">
						<div class="portlet-heading">
							<div class="portlet-title">
								<h4>채팅방 이름</h4>
								<input id="exit" type="button" value="채팅방 나가기"
									class="btn btn-danger" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div id="chat" class="panel-collapse in">
							<div id="chatMessage" class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 400px;">
							</div>
							<div class="portlet-footer">
									<div class="form-group" style="display: flex;">
										<input type="hidden" name="" />
										<input type="text" id="msg" class="form-control" placeholder="메세지를 입력하세요"
											style="width: 380px;height: 60px;"></input>
										<button id="send" type="button"
											class="btn btn-primary pull-right">Send</button>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>