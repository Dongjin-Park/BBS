<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>      <!-- 추가 -->
<layoutTag:layout>                                         <!-- 여는 태그 -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>

<div class="contaner">
	<div class="col-xs-12" style="magin:15px auto;">
		<lable style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>게시글 목록</lable>
		<button class="btn btn-primary btn-sm" style="float:right;" onclick="location.href='/insert'">글쓰기</button>
	</div>
	<div class="col-xs-12">
	<table class="table table-hover">
		<tr>
			<th>No</th>
			<th>Subject</th>
			<th>Writer</th>
			<th>Date</th>
		</tr>	

		<c:forEach var="i" items="${list}">
		<tr onclick="location.href='/detail/${i.board_seq}'">
			<td>${i.board_seq}</td>
			<td>${i.subject}</td>
			<td>${i.writer}</td>
			<td><fmt:formatDate value="${i.created}" pattern="yyyy.MM.dd HH:mm:ss"/> </td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>

</body>
</html>
</layoutTag:layout>

