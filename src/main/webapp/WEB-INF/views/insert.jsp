<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<!-- 추가 -->
<layoutTag:layout>
	<!-- 여는 태그 -->

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body>
	<div class="container">
		<div class="col-xs-12" style="margin: 15px auto;">
			<lable style="font-size:20px;">
			<span class="glyphicon glyphicon-edit">게시글 작성</span></lable>
		</div>
		
		<div class="col-xs-12">
			<form action="/insertProc" method="post" enctype="multipart/form-data"><!-- 추가 -->
				<div class="form-group">
					<label for="subject">제목</label> 
					<input type="text" class="form-control" id="subject" name="subject" placeholder="제목을 입력하세요">
				</div>
				<div class="form-group">
					<label for="writer">작성자</label> 
					<input type="text" class="form-control" id="writer" name="writer" placeholder="내용을 입력하세요">
				</div>
				<div class="form-group">
					<lable for="content">내용</lable>
					<textarea class="form-control" id="content" name="content" rows="3"></textarea>
				</div>
				<div class="form-group">
					<label for="file">파일 업로드</label>
					<input type="file" name="files">
				</div>

				<button type="submit" class="btn btn-primary">작성</button>
			</form>
		</div>
	</div>

</body>
	</html>
</layoutTag:layout>