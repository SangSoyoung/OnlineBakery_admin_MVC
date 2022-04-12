<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<MemberDTO> mlist = (ArrayList<MemberDTO>)request.getAttribute("mlist");
	pageContext.setAttribute("mlist", mlist);
%>
<h1>회원 목록</h1>
<form action="mDelete.do" method="get">
<table border="1">
	<tr>
		<th>선택</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>권한등급</th>
	</tr>
<c:forEach var="m" items="${mlist }">
	<tr>
		<td><input type="checkbox" name="mCheck" value="${m.id }"></td>
		<td>${m.id }</td>
		<td>${m.pw }</td>
		<td>${m.name }</td>
		<td>${m.grade }</td>
	</tr>
</c:forEach>
</table>
	<input type="submit" value="선택회원삭제"><br>
</form>
<button onclick="location.href='main.jsp'">메인 페이지 가기</button>


</body>
</html>