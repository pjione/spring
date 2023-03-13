<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

 <nav class="navbar navbar-expand navbar-dark bg-dark" aria-label="Second navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Always expand</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample02">
        <ul class="navbar-nav me-auto">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/cart">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/cars">차량 보기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/add">차량 등록</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="/board">게시판</a>
          </li>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            		회원 관리
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
           <li class="nav-item">
         
           <sec:authorize access = "isAuthenticated()">
           		<a href = "/logout">로그아웃</a>
           </sec:authorize>
            <sec:authorize access = "isAnonymous()">
           <a href = "/login">로그인</a>
           </sec:authorize>
           <%--  <c:choose>
            	<c:when test="${isLogOn == true }">
	        		<a href = "/logout">로그아웃</a>
	        	</c:when>
	        	<c:otherwise>
	        		<a href = "/login">로그인</a>
	        	</c:otherwise>
            </c:choose> --%>
          </li>
        </ul>
        <form role="nav-item">
          <input class="form-control" type="search" placeholder="Search" aria-label="Search">
        </form>
      </div>
    </div>
  </nav>
  
   					
