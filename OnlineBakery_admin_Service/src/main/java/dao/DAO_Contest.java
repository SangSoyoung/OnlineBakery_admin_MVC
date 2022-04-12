package dao;

import java.sql.Connection;

public class DAO_Contest {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		
		try {
			
			Connection connection = dao.getConnection();
			
			if(connection != null) {
				System.out.println("db 연결 성공!");
			} else {
				System.out.println("db 연결 실패!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}