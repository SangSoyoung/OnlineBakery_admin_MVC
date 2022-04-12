package service;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {
	
	// 회원 등록
	public int registMember(MemberDTO member) {
		return new MemberDAO().registMember(member);
	}
	
	
	// 회원 조회
	public ArrayList<MemberDTO> getList() {
		return new MemberDAO().getList();
	}
	
	
	// 회원 정보 삭제
	public void deleteMember(String id) {
		new MemberDAO().deleteMember(id);
	}
	
	
	// id/pw 확인(로그인)
	public int checkLogin(String id, String pw) {
		return new MemberDAO().checkLogin(id, pw);
	}
	
}
