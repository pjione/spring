<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>main</title>
<script>
function addToCart(action){
	document.addForm.action = action;
	document.addForm.submit();
	alert("제품이 장바구니에 추가되었습니다.");
	history.back();
}
function addcartFunction() {
	$.ajax({
		type:"POST",
		url:"/cart/ajaxadd",
		data:{cid:"${car.cid}"},
		beforeSend : function(xhr)
	          {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
	              xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
	          },
		success:function(result) {
			alert("제품이 장바구니에 추가되었습니다.");
		},
		error:function(request, status, error) {
			alert(request.status + " " +request.responseText);
		}
	})
}
</script>

</head>
<body>

  	<div class = "container">
  		<div class = "row" align = "center">
  				<div class = "col-md-4">
  					<h3>${car.cid }</h3>
  					<p>${car.cname }</p>
  					<p>${car.cprice }만원</p>
  					<p>${car.ccate }</p>
  					<p>${car.ccate }</p>
  					<p>${car.cdesc }</p>
  				</div>
  				<form:form name = "addForm" method = "put">
  					<p>
	  					<a href = "javascript:addToCart('/cart/add/${car.cid }')" class = "btn btn-primary ">제품주문&raquo;</a>
	  					<a href = "javascript:addcartFunction()" class = "btn btn-primary ">ajax제품주문&raquo;</a>
	  					<a href = "/cart" class = "btn btn-success"
	  					role = "button">장바구니&raquo;</a>
	  					<a href = "/cars" class = "btn btn-success"
	  					role = "button">제품목록&raquo;</a>
					</p>
				</form:form>
  		</div>
  	</div>
</body>
</html>
