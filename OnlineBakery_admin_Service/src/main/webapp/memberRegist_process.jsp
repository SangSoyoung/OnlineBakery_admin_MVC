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
		alert("회원 정보 입력을 성공하였습니다^^");
		location.href="main.jsp";
		
	} else {
		alert("회원가입 실패 ㅠㅠ 다시 시도해주세요~");
		location.href="memberRegist_form.jsp";
	}

</script>
</body>
</html>