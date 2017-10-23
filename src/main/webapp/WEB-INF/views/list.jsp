<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>      <!-- 추가 -->
<layoutTag:layout>                                         <!-- 여는 태그 -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>

<h2> 게시글 목록 </h2>

<br>
<br>

<div class="contaner">
	<table class="table table-hover">
		<tr>
			<th>No</th>
			<th>Subject</th>
			<th>Writer</th>
			<th>Date</th>
		</tr>	

		<c:forEach var="i" items="${list}">
		<tr onclick="location.href='/detail/${i.board_seq}'">
			<th>${i.board_seq}</th>
			<th>${i.subject}</th>
			<th>${i.writer}</th>
			<th>${i.created}</th>
		</tr>
		</c:forEach>
	</table>
<button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>

</div>

</body>
</html>
</layoutTag:layout>

