package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ProductDTO;


public class ProductDAO implements IProductDAO {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
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

	@Override // 상품 정보 등록
	public int registProduct(ProductDTO product) {
		
		String pname = product.getPname();
		String pcode = product.getPcode();
		int price = product.getPrice();
		String storage = product.getStorage();
		String expiration = product.getExpiration();
		String description = product.getDescription();
		String img = product.getImg();

		int result = 0;
		String sql = "insert into b_product values (?, ?, ?, ?, ?, ?, ?)";
		
		try {

			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pname);
			pstmt.setString(2, pcode);
			pstmt.setInt(3, price);
			pstmt.setString(4, storage);
			pstmt.setString(5, expiration);
			pstmt.setString(6, description);
			pstmt.setString(7, img);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("제품 등록 성공!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	
	@Override // 상품 정보 수정
	public int updateProduct(ProductDTO product) {
		
		int result = 0;

		String sql = "update b_product set pcode=?, pname=?, price=?, storage=?, expiration=?, description=?, img=? where pcode=?";
		
		try {

			Connection con = getConnection();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getPcode());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getStorage());
			pstmt.setString(5, product.getExpiration());
			pstmt.setString(6, product.getDescription());
			pstmt.setString(7, product.getImg());
			pstmt.setString(8, product.getPcode());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("제품 정보 수정 성공!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@Override // (전체)상품 정보 조회
	public ArrayList<ProductDTO> getPList() {
		
		ArrayList<ProductDTO> plist = new ArrayList<>();
		
		try {

			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select pcode, pname, price, img from b_product");
			
			while(rs.next()) {
				
				ProductDTO product = new ProductDTO();
				
				product.setPcode(rs.getString("pcode"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getInt("price"));
				product.setImg(rs.getString("img"));

				plist.add(product);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;
	}


	@Override // 세부 상품 정보 조회
	public ProductDTO getPDetailList(String pcode) {
		
		ProductDTO product = new ProductDTO();
		
		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();

			String sql = "select * from b_product where pcode='" + pcode + "'";	
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
				product.setPcode(rs.getString(1));
				product.setPname(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setStorage(rs.getString(4));
				product.setExpiration(rs.getString(5));
				product.setDescription(rs.getString(6));
				product.setImg(rs.getString(7));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	@Override // 상품 정보 삭제
	public int deleteProduct(String pcode) {
		
		int result = 0;
		
		try {

			Connection con = getConnection();
			Statement stmt = con.createStatement();
			
			String sql = "delete from b_product where pcode='" + pcode + "'";
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
		System.out.println("제품 삭제 성공!");
		}
		return result;
		
	}

	@Override // (전체)상품 정보 삭제
	public void truncateProduct() {

		try {
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("truncate table b_product");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
