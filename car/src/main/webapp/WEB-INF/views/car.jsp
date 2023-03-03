<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>main</title>
</head>
<body>
<%@ include file = "header.jsp" %>
	
	<div class="alert alert-dark" role="alert">
		<div class = "container">
			 차량 상세 보기
		</div>  
	</div>

  	<div class = "container">
  		<div class = "row" align = "center">
  				<div class = "col-md-4">
  					<h3>${car.cid }</h3>
  					<p>${car.cname }</p>
  					<p>${car.cprice }만원</p>
  					<p>${car.ccate }</p>
  					<p>${car.ccate }</p>
  					<p>${car.cdesc }</p>
  					<p><a href = "/car?id=${car.cid }" class = "btn btn-Secondary"
  					role = "button">상세보기</a></p>
  				</div>
  		</div>
  	</div>
<%@ include file = "footer.jsp" %></body>
</html>
