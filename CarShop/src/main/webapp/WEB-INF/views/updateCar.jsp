<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 등록</title>
</head>
<body>
<div style = "height : 600px;">
	<form:form modelAttribute="updateCar" 
			   action="/cars/update?${_csrf.parameterName}=${_csrf.token}"
	           class="form-horizontal"
	           method = "post"
	           enctype="multipart/form-data">
	
	<legend>차량 정보 수정</legend>
	자동차 ID : <input name="cid" class="form-control" value = "${car.cid }" readonly>
	자동차 이름 : <form:input path="cname" class="form-control" value = "${car.cname }"/>
	자동차 가격 : <form:input path="cprice" class="form-control" value = "${car.cprice }"/>
	자동차 카테고리 : <form:input path="ccate" class="form-control" value = "${car.ccate }"/>
	자동차 소개 : <textarea name = "cdesc" cols="50" rows="2" class="form-control">${car.cdesc }</textarea>	
	자동차 사진 : <form:input path="carimage" type="file" class="form-control"/>
	<br>
	<input type="submit" class="btn btn-primary" value="등록"/>

	</form:form>
</div>


</body>
</html>