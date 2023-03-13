<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body class="text-center">
	<%@ include file = "../../views/header.jsp" %>
	<!-- Custom styles for this template -->
	<link href="sign-in.css" rel="stylesheet">
	<main class="form-signin w-100 m-auto">
		<form action = "/login" method = "post">
	    <img class="mb-4" src="/etc/main.jpg" alt="" width="200" height="160">
	    <h1 class="h3 mb-3 fw-normal">Please login</h1>
	
	    <div class="form-floating">
	      <input type="text" class="form-control" id="floatingInput" name = "username" required>
	      <label for="floatingInput">아이디</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="floatingPassword" name = "password" required>
	      <label for="floatingPassword">패스워드</label>
	    </div>
	    <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>
	    <input type = "hidden" name = "${_csrf.parameterName }" value = "${_csrf.token }">
	    <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
	  </form>
	  <div class = "container">
	  	<form:form modelAttribute="order.customer" class = "Form-horizontal">
	  	
	  	</form:form>
	  </div>
  </main>
  <%@ include file = "../../views/footer.jsp" %> 
</body>
</html>
