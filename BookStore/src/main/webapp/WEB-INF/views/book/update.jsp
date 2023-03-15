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
	<h1>도서 수정</h1>
	<form method = "post">
		<p>번호 : ${book.bookid}
		<input type = "hidden" name = "bookid" value = "${book.bookid }">
		<p>제목 : <input type = "text" name = "title" value = "${book.title}">
		<p>종류 : <input type = "text" name = "category" value = "${book.category}">
		<p>가격 : <input type = "text" name = "price" value = "${book.price }">
		<p><input type = "submit" value = "저장">
	</form>
</body>
</html>