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
	
	//System.out.println(result);

%>
<script>
	if(${result } == 1) {
		alert("로그인 성공!");
		location.href="main.jsp";
	}
		
	if(${result } == -1) {
		alert("비밀번호를 다시 확인해주세요.");
		location.href="login_form.jsp";
	}
		
	if(${result } == -2) {
		alert("아이디를 다시 확인해주세요.");
		location.href="login_form.jsp";
	}	
</script>
</body>
</html>