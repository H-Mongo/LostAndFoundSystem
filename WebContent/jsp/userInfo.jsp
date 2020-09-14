<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  
  <title>历史发布信息页面</title>

</head>
<body>

<div>
<form action="../releaseInformationServlet" method="post">

	<b>上传图片</b>
<input type="file" name="img" id="file" accept="image/*" onchange="imgChange(this);"/> <!--文件上传选择按钮-->
	<br>
	<img id="imghead"src="F:\ComputerImages\cat.jpg"width="260"height="180" /> <!--图片显示位置-->
	<input type="submit" value="提交"/>
</form>

</div>


<script type="text/javascript">

	/*
		实现对选取的照片的动态更新显示
		 enctype="multipart/form-data"
	*/
	
	function imgChange(obj) {
		//获取点击的文本框
		var file = document.getElementById("file");
		var imgUrl = window.URL.createObjectURL(file.files[0]);
		var img = document.getElementById('imghead');
			img.setAttribute('src',imgUrl); // 修改img标签src属性值
	};
</script>

  

</body>
</html>        