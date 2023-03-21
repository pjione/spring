<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Detail</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
		
		<div style="padding-top: 50px">
			<p>제목 : ${board.btitle}
			<p>내용 : ${board.bcontent}
			<p>작성자 : ${board.bwriter}
			<p>조회수 : ${board.bview}
			<p>좋아요 :<a href = "#" class = "btn btn-primary">[${board.blike}]</a>
			<p>싫어요 :<a href = "#" class = "btn btn-primary">[${board.bhate}]</a>
			<p>작성일 : ${board.bdate}

			<p><a href="<c:url value="/boards/list"/>" class="btn btn-secondary">
				&laquo;목록으로</a> 
				<a href="<c:url value="/boards/update"/>" class="btn btn-secondary">
				&laquo;수정</a> 
				<a href="<c:url value="/boards/remove"/>" class="btn btn-secondary">
				&laquo;삭제</a> 
		</div>
		<hr>
		<div class = "card">
			<div class = "card-body">
				답변 게시물 리스트
			</div>
		</div>
		
		<sec:authentication property="principal" var="user"/> 
		<input id = "bid" type = "hidden" name = "bid" value = "${board.bid }">
		<input id = "bwriter" type = "hidden" name = "bwriter" value = "${user.username }">
		내용 : <textarea id = "bconent" name = "bcontent" rows = "5" class = "form-control"></textarea>
		<button type = "button" class = "btn btn-primary" onclick = "replyNewFunction()">등록</button>
		
		
	</div>
</body>
</html>