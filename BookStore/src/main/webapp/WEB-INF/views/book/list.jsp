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
<h1>책 리스트</h1>


<form>  
	<input type="text" placeholder="검색" name="keyword" />  
	<input type="submit" value="검색" />  
</form>  

<table>
	<tr>
		<td>제목
		<td>종류
		<td>가격
		<td>날짜
		<td>비고
	</tr>
<c:forEach items="${list }" var = "list">
	<tr>
		<td> ${list.title }
		<td> ${list.category }	
		<td> ${list.price }
		<td> ${list.date }
		<td> <a href = "/detail?bookid=${list.bookid }">상세보기</a>
	</tr>
</c:forEach>
</table>
<script>
/* function search() {
	$.ajax({
		type:"POST",
		url:"/list",
		data:{keyword:$('#keyword').val()},
		success:function(result) {
			console.log(result);
		},
		error:function(request, status, error) {
			alert(request.status + " " +request.responseText);
		}
	})

} */
</script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script> 					
</body>
</html>