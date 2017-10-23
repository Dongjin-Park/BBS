<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<!-- 추가 -->
<layoutTag:layout>
	<!-- 여는 태그 -->

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Detail</title>
		</head>
		<body>
			<div class="container">
				<div class="col-xs-12" style="margin: 15px auto;">
					<lable style="font-size:20px;"> <span
						class="glyphicon glyphicon-list-alt"></span>게시글 상세</lable>
				</div>
				<div class="col-xs-12">
					<form action="/insertProc" method="post">
						<dl class="dl-horizontal">
							<dt>제목</dt>
							<dd>${detail.subject}</dd>
		
							<dt>작성자</dt>
							<dd>${detail.writer}</dd>
		
							<dt>작성날짜</dt>
							<dd>${detail.created}</dd>
		
							<dt>첨부파일</dt>
							<dd>
								<a href="/fileDown/${files.board_seq}">${files.fileOriName}</a>
							</dd>
		
							<dt>내용</Dt>
							<dd>${detail.content}</dd>
						</dl>
					</form>
					<div class="btn-group btn-group-sm" role="group"
						style="float: right;">
						<button class="btn btn-primary" onclick="location.href='/list'">목록으로</button>
						<button class="btn btn-primary"
							onclick="location.href='/update/${detail.board_seq}'">수정</button>
						<button class="btn btn-danger"
							onclick="location.href='/delete/${detail.board_seq}'">삭제</button>
					</div>
				</div>
			</div>
		
		</body>
	</html>

</layoutTag:layout>