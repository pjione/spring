<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>main</title>
</head>
<body>
<%@ include file = "header.jsp" %>
	
	<div class="alert alert-dark" role="alert">
		<div class = "container">
			 차량 등록
		</div>  
	</div>

  	<div class = "container">
  		<form class = "form-horiznotal" action = "/add" method = "post">
 			<fieldset><legend>${addTitle }</legend></fieldset>
  			자동차 id : <input type="text" class = "form-control" name = "cid"><br>
  			자동차 이름 : <input type="text" class = "form-control" name = "cname"><br>
  			자동차 가격 : <input type="text" class = "form-control" name = "cprice"><br>
  			자동차 카테고리: <input type="text" class = "form-control" name = "ccate"><br>
  			자동차 소개 : <textarea class = "form-control" cols="50" rows="2" name = "cdesc"></textarea>
  			<input type = "submit" class = "btn btn-primary" value = "등록">
  		</form>
  		
  	</div>
<%@ include file = "footer.jsp" %></body>
</html>
