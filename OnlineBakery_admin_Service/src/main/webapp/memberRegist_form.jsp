<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 등록 페이지</h1>
<form action="mRegist.do" method="post" name="mReg_frm">
<table>
	<tr>
		<th>아이디 : </th>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호 : </th>
		<td><input type="text" name="pw"></td>
	</tr>
	<tr>
		<th>이&nbsp;&nbsp;름 : </th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>권한등급 : </th>
		<td><input type="text" name="grade">
		* 1 : 관리자 / 2 : VIP / 3 : 일반회원
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="회원 정보 입력" onclick="return inputCheck()">
		</td>
	</tr>
</table>
</form>
<script>

	document.mReg_frm.id.focus();
	
	// 유효성 검사 함수
	function inputCheck(){
		if(document.mReg_frm.id.value.length == 0){
			alert("id를 입력해주세요~");
			document.mReg_frm.id.focus();
			return false;
		}
		
		if(document.mReg_frm.pw.value.length == 0){
			alert("pw를 입력해주세요~");
			document.mReg_frm.pw.focus();
			return false;
		}
		
		if(document.mReg_frm.name.value.length == 0){
			alert("이름을 입력해주세요~");
			document.mReg_frm.name.focus();
			return false;
		}
		
		alert("회원 정보 입력이 완료되었습니다.");
		return true;
	}
</script>
</body>
</html>