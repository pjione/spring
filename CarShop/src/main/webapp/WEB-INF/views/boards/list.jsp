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

<!-- <script>

			
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
	</script> -->

</head>
<body>

	<div class="container">
		
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>좋아요</th>
					<th>싫어요</th>
					<th>작성일</th>
					<th>비고</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
						<tr>
							<td>${board.bid}</td>
							<td>${board.btitle}</td>
							<td>${board.bwriter}</td>
							<td>${board.bview}</td>
							<td>${board.blike}</td>
							<td>${board.bhate}</td>
							<td>${board.bdate}</td>	
							<td><a href = "/boards/view?bid=${board.bid}">상세보기</a></td>
						</tr>			
				</c:forEach>
			</table>
		
			<a href="<c:url value="/boards/addBoard"/>" class="btn btn-secondary">
				&laquo;글작성</a> 
		</div>
		<hr>

	</div>
</body>
</html>