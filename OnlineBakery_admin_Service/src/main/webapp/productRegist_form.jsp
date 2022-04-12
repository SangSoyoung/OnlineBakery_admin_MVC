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
<h1>상품 등록</h1>
<form name="p_reg_frm" action="pRegist.do" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<th>상품명</th>
		<td><input type="text" name="pname"></td>
		<!-- 버튼명 : 상품 이미지 선택으로 바꾸기 -->
		<td rowspan="5"><input type="file" name="img"></td>
	</tr>
	<tr>
		<th>상품코드<br>(중복불가)</th>
		<td><input type="text" name="pcode"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="text" name="price"></td>
	</tr>
	<tr>
		<th>보관방법</th>
		<td><input type="text" name="storage"></td>
	</tr>
	<tr>
		<th>유통기한</th>
		<td><input type="text" name="expiration"></td>
	</tr>
	<tr>
		<th>상품설명</th>
		<td colspan="2"><textarea rows="5" cols="50" name="description"></textarea></td>	
	</tr>
	<tr>
		<td colspan="3">
			<input type="submit" value="상품등록" onclick="return inputCheck()">
			<input type="reset" value="초기화">
			<input type="button" value="메인 페이지 가기" onclick="goMain()">
		</td>
	</tr>
</table>
</form>

<script>

	document.p_reg_frm.pname.focus();
	
	// 유효성 검사 함수
	function inputCheck(){
		if(document.p_reg_frm.pname.value.length == 0){
			alert("상품명을 입력해주세요");
			document.p_reg_frm.pname.focus();
			return false;
		}
		if(document.p_reg_frm.pcode.value.length == 0){
			alert("상품코드를 입력해주세요");
			document.p_reg_frm.pcode.focus();
			return false;
		}
		if(document.p_reg_frm.pprice.value.length == 0){
			alert("가격을 입력해주세요");
			document.p_reg_frm.price.focus();
			return false;
		}
		if(document.p_reg_frm.storage.value.length == 0){
			alert("보관방법을 입력해주세요");
			document.p_reg_frm.storage.focus();
			return false;
		}
		if(document.p_reg_frm.expiration.value.length == 0){
			alert("유통기한을 입력해주세요");
			document.p_reg_frm.expiration.focus();
			return false;
		}
		if(document.p_reg_frm.description.value.length == 0){
			alert("상품설명을 입력해주세요");
			document.p_reg_frm.description.focus();
			return false;
		}
		if(document.p_reg_frm.img.value.length == 0){
			alert("상품의 이미지 파일을 선택해주세요");
			document.p_reg_frm.img.focus();
			return false;
		}
		
		return true;
	}
	
	
	// 메인 페이지 가기 클릭 함수
	function goMain(){
		location.href="main.jsp";
	}	
	
	
</script>	
</body>
</html>