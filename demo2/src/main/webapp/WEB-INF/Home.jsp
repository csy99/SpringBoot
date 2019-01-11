<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register</title>
</head>
<body>
	<h2>Register Page</h2> </br>
	<form action="<%=request.getContextPath() %>/login" method="POST"> </br>
		id:<input type="text" name="userId" id="uId"> </br>
		name:<input type="text" name="username" id="uname"> </br>
		password:<input type="password" name="password" id="pw"> </br>
		<input type="button" value="Register" onclick=javascript:register()> </br>
		<!-- <input type="reset" value="重置"> --> </br>
	</form>
	
	<script>
	function register(){
		var userId=document.getElementById("uID").value;
		var username=document.getElementById("uname").value;
		var password=document.getElementById("pw").value;
		var url = "localhost:8088/addUser?id="+userId+"name="+username+"password="+password;
		window.location.href=url;
	}
	</script>
</body>
</html>
