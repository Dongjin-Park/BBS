<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>
</head>
<body>

<h2>게시글 상세</h2>

<br>

<div class="container">
	<form action="/insertProc" method="post">
		<div class="form-group">
			<label>제목</label>
			<p>${detail.subject}</p>
		</div>
		<div class="form-group">
			<label>작성자</label>
			<p>${detail.writer}</p>
		</div>
		<div class="form-group">
			<label>작성날짜</label>
			<p>${detail.created}</p>
		</div>
		<div class="form-group">
			<label>내용</label>
			<p>${detail.content}</p>
		</div>
	</form>
	<button class="btn btn-primary" onclick="location.href='/list'">목록으로</button>
	<button class="btn btn-primary" onclick="location.href='/update/${detail.board_seq}'">수정</button> 
	<button class="btn btn-danger" onclick="location.href='/delete/${detail.board_seq}'">삭제</button>  
</div>

<%@ include file="bootstrap.jsp" %>
</body>
</html>