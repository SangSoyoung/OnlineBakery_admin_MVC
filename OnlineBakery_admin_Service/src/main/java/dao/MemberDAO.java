package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberDTO;

public class MemberDAO implements IMemberDAO {
	
	Scanner sc = new Scanner(System.in);
	
	@Override // db 연결
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {	
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc8.jar파일을 추가해주세요.");
		} catch (SQLException e) {
			System.out.println("db 연결 정보(주소, id, pw)를 확인해주세요.");
		}
		return conn;
	}

	@Override // 회원 등록
	public int registMember(MemberDTO member) {

		int result = 0;
		String sql = "insert into b_member values (?, ?, ?, ?)";
				
		try {

			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			String id = member.getId();
			String pw = member.getPw();
			String name = member.getName();
			String grade = member.getGrade();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, grade);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("등록 성공!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override // 회원 조회
	public ArrayList<MemberDTO> getList() {
		
		ArrayList<MemberDTO> dlist = new ArrayList<>();
		
		try {

			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from b_member");
			
			while(rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getString("grade"));
				
				dlist.add(dto);
			}
			
			//System.out.println(dlist.toString());
			
			if(dlist != null) {
				System.out.println("출력 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}


	@Override // 회원 정보 삭제
	public void deleteMember(String id) {

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "delete from b_member where id='" + id + "'";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("삭제 성공!");
	}


	@Override // id/pw 확인(로그인)
	public int checkLogin(String id, String pw) {

		int result = 0;
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "select id, pw from b_member where id='"+ id +"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			// id 확인
			if(rs.next()) {
				// pw 확인
				if(pw.equals(rs.getString("pw"))) {
					// 로그인 성공
					result = 1;
					System.out.println("로그인 성공!");
				} else {
					System.out.println("비밀번호를 다시 확인해주세요.");
					result = -1;
				} 
			} else {
				System.out.println("아이디를 다시 확인해주세요.");
				result = -2;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
