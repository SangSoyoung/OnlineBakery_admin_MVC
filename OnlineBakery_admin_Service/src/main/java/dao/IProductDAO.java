package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dto.ProductDTO;

public interface IProductDAO {
	
	// 1. db 연결
	Connection getConnection();
	
	// 2. 상품 등록
	int registProduct(ProductDTO product);
	
	// 3. 상품 정보 수정
	int updateProduct(ProductDTO product);
	
	// 4. (전체)상품 정보 조회
	ArrayList<ProductDTO> getPList();
	
	// 5. 세부 상품 정보 조회
	ProductDTO getPDetailList(String pcode);
	
	// 6. 상품 정보 삭제
	int deleteProduct(String pcode);
	
	// 7. (전체)상품 정보 삭제
	void truncateProduct();
	
	
}
