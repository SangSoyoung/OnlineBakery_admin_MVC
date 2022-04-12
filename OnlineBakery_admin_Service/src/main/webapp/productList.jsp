<%@page import="dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%
	String id = (String)session.getAttribute("id");
	ArrayList<ProductDTO> plist = (ArrayList<ProductDTO>)request.getAttribute("plist");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>${id }님 안녕하세요^^</div>
<h1>상품 조회</h1>
<table border="1" style="text-align: center;">
	<tr>
		<th>상품코드</th>
		<th>상품명</th>
		<th>가격</th>
		<th>상품 이미지</th>
	</tr>
<c:forEach var="p" items="${plist }">	
	<tr>
		<td>
			<a href="pDetail.do?pcode=${p.pcode }">
				${p.pcode }
			</a>
		</td>
		<td>${p.pname }</td>
		<td>${p.price }</td>
		<td>
			<img src="upload/${p.img }" style="width:100px;height:auto;" alt="이미지 없음">
		</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="4">
			<button name="pRegist" onclick="location.href='productRegist_form.jsp'">상품등록</button>
			<button onclick="location.href='pTruncate.do'">초기화</button>
			<button onclick="location.href='main.jsp'">메인 페이지 가기</button>
		</td>
	</tr>

</table>

</body>
</html>