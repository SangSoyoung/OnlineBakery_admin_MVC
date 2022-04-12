<%@page import="dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	
	ProductDTO product = (ProductDTO)request.getAttribute("product");
	pageContext.setAttribute("p", product);	
	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${id }님 안녕하세요^^</div>
<h1>상품 상세 정보</h1>
<form name="p_reg_frm" action="pUpdate.do" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<th>상품코드<br>(중복불가)</th>
		<td><input type="text" name="pcode" value="${p.pcode }" readonly></td>
		<td rowspan="5">
			<img src="upload/${p.img }" style="width:100px;height:auto;" alt="이미지 없음">
			<br>
			<input type="file" name="img">
		</td>
	</tr>
	<tr>
		<th>상품명</th>
		<td><input type="text" name="pname" value="${p.pname }"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="text" name="price" value="${p.price }"></td>
	</tr>
	<tr>
		<th>보관방법</th>
		<td><input type="text" name="storage" value="${p.storage }"></td>
	</tr>
	<tr>
		<th>유통기한</th>
		<td><input type="text" name="expiration" value="${p.expiration }"></td>
	</tr>
	<tr>
		<th>상품설명</th>
		<td colspan="2"><textarea rows="5" cols="50" name="description">${p.description }</textarea></td>	
	</tr>
	
	<tr>
		<td colspan="3">
			<input type="submit" value="수정" onclick="return inputCheck()">
			<input type="button" value="삭제" onclick="moveDelete()">
			<input type="button" value="목록보기" onclick="movePList()">
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
	
	
	// 목록 보기 클릭 함수
	function movePList(){
		location.href="productList.do";
	}	
	
	// 삭제 클릭 함수
	function moveDelete(){
		location.href="pDelete.do?pcode=${p.pcode }";
	}
	
</script>	
</body>
</html>