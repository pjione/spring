<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>car shop</title>
</head>
<body>
	<!-- <div class="alert alert-dark">
		<div class="container">
			<h1>게시판 등록</h1>
		</div>
	</div>
	 -->
	<sec:authentication property="principal" var="user"/> 
	<div class = "container">
  		<form class = "form-horiznotal" method = "post" enctype="multipart/form-data">
  			제목 : <input type="text" class = "form-control" name = "btitle">
  			내용 : <textarea class = "form-control" rows="10" cols="3" name = "bcontent"></textarea>
  			<input type="hidden" name = "bwriter" value = "${user.username }">
  			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  			<input type = "submit" class = "btn btn-primary" value = "등록">
  		</form>
  		
  	</div>
	



</body>
</html>