package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dto.MemberDTO;

public interface IMemberDAO {
	
	// 1. db 연결
	Connection getConnection();
	
	// 2. 회원 등록
	int registMember(MemberDTO member);
	
	// 3. 회원 정보 조회(전체 목록 보기)
	ArrayList<MemberDTO> getList();
	
	// 4. 회원 정보 삭제
	void deleteMember(String id);
	
	// 5. id/pw 확인(로그인)
	int checkLogin(String id, String pw);
	
}
