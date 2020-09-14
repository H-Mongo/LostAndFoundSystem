<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
</head>
<body>


	<div>
		<h1 style="text-align: center;">用户登录</h1>
			<form action="../loginServlet" method="post" style="text-align: center;">
				用户名：<input type="text" name="username"/>
				<br><br>
				密&nbsp;&nbsp;码：<input type="password" name="password"/>
				<br><br>
				<select name="identify">
					<option value="0" selected>普通用户</option>
					<option value="1">管理员</option>
				</select>
				<br><br>
				<input type="submit" value="登录" />
				<input type="reset" value="取消" />
			</form>
	</div>

</body>
</html>