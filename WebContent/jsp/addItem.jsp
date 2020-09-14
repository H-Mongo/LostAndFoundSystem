<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style type="text/css">
	
	.form{
	align-items: center;
	text-align: center;
	margin-top: 50px;

}

</style>


</head>
<body>
	<% 
		User user = (User)request.getAttribute("user");
			if(user != null){
	%>
<div>
	<h3 style="text-align: center;">请填写要发布的物品信息</h3>
</div>


	<div>
		<form action="../itemServlet" method="post" enctype="multipart/form-data" class="form">
			<label>物品名称：</label>
				<input type="text" name="name"/>
				<br>
				<br>
			<label>物品类别：</label>
				<select name="ClassId">
					<option>请选择物品分类</option>
					<option value="1">钱包</option>
					<option value="2">钥匙</option>
					<option value="3">卡类/证件</option>
					<option value="4">数码产品</option>
					<option value="5">手袋/挎包</option>
					<option value="6">首饰/挂饰</option>
					<option value="7">书籍/文件</option>
					<option value="8">其他</option>
				</select>
				<br>
				<br>
				<label>请上传物品的图片：</label>
				<input type="file" name="img"/>
				<br>
				<br>
			<label>物品的描述信息：</label>
				<input type="text" name="describe"/>
				<br>
				<br>
			<label>发布日期：</label>
				<input type="date" name="date"/>
				<br>
				<br>
			<!--发布者ID -->
				<input type="hidden" name="userId" value="${user.getUser_id()}"/>
				<br>
				<br>
			<!--  物品状态 -->
				<input type="hidden" name="status" value="未领取"/>
				<br>
				<br>
			<input type="submit" value="注册" />
			<input type="reset" value="取消" />
		</form>
	</div>
	<%
		}else{
	%>
			<script type="text/javascript">
				alert("您还没有登录，请登录...");
			</script>
			
	<% 
			response.sendRedirect("http://www.baidu.com"); 
		}
	%>
</body>
</html>