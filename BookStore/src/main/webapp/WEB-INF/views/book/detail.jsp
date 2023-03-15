<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>책 상세 보기</h1>
	제목 : ${book.title } <br>
	종류 : ${book.category }<br>
	가격 : ${book.price } <br>
	날짜 : ${book.date } <br>
<form>
	<input type = "submit" value = "수정" formaction="/update">
	<input type = "submit" value = "삭제" formaction="/remove" formmethod="post">
	<input type = "hidden" name = "bookid" value = "${book.bookid }">
</form>
</body>
</html>