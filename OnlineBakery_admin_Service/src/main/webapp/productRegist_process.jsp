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
	pageContext.setAttribute("result", result);
%>
	<script>
		if(${result } > 0){
			alert("제품 등록 성공!");
			location.href="productList.do";
		} else {
			alert("제품 코드를 다시 확인해주세요~");
			location.href="productRegist_form.jsp";
		}
	</script>
</body>
</html>