<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int result = (Integer)request.getAttribute("result");

%>
<script>
	if(${result } > 0){
		alert("제품 정보 삭제 성공!");
		location.href="productList.do";
	} else {
		alert("제품 정보 삭제 실패!");
		location.href="productList.do";
	}

</script>
</body>
</html>