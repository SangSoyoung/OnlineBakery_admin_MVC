<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${id }님 안녕하세요^^</div>
	<h1>상품 관리 시스템(관리자 페이지)</h1>
	<br>
	<a href="productRegist_form.jsp"><button>상품등록</button></a>
	<a href="memberRegist_form.jsp"><button>회원등록</button></a>
	<br>
	<a href="productList.do"><button>상품조회</button></a>
	<a href="mList.do"><button>회원조회</button></a>
	<br><br>
	<div>상품 수정/삭제는 조회 페이지에서 해당 상품의 상세 페이지로 들어간 후 작업하세요.</div>
</body>
</html>
