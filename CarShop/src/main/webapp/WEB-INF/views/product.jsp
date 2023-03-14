<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Detail</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

<script>

			
	function ajaxremoveFromCart(item) {
		$.ajax({
			type:"POST",
			url:"/cars/ajaxremove",
 			data:{cid:item},
			beforeSend : function(xhr)
		          {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
		              xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
		          },
			success:function(result) {
				alert("제품이 삭제되었습니다.");
			},
			error:function(request, status, error) {
				alert(request.status + " " +request.responseText);
			}
		})

	    window.location.reload();
	}
	</script>

</head>
<body>

	<div class="container">
		
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>종류</th>
					<th>상태</th>
				</tr>
			
					<c:forEach items="${carList}" var="car">
						<tr>
							<td>${car.cid}</td>
							<td>${car.cname}</td>
							<td>${car.cprice}</td>
							<td>${car.ccate}</td>
							<td>${car.cdesc}</td>
							<td>
								<a id = "item" href="javascript:ajaxremoveFromCart('${car.cid}')"
								class="btn btn-danger btn-sm">삭제</a>
								</td>
								<td>
								<a href="/cars/update?cid=${car.cid}"
								class="btn btn-primary btn-sm">수정</a>
								</td>
						</tr>
					</c:forEach>
			
				
			</table>

			<a href="<c:url value="/cars" />" class="btn btn-secondary">
				&laquo; 목록으로</a>
		</div>
		<hr>

	</div>
</body>
</html>