package service;

import java.util.ArrayList;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductService {

	// 상품 정보 등록
	public int registProduct(ProductDTO product) {
		return new ProductDAO().registProduct(product);
	}
	
	// 상품 정보 수정
	public int updateProduct(ProductDTO product) {
		return new ProductDAO().updateProduct(product);
	}
	
	// (전체)상품 정보 조회
	public ArrayList<ProductDTO> getPList() {
		return new ProductDAO().getPList();
	}
	
	// 세부 상품 정보 조회
	public ProductDTO getPDetailList(String pcode) {
		return new ProductDAO().getPDetailList(pcode);
	}
	
	// 상품 정보 삭제
	public int deleteProduct(String pcode) {
		return new ProductDAO().deleteProduct(pcode);
	}
	
	// (전체)상품 정보 삭제
	public void truncateProduct() {
		new ProductDAO().truncateProduct();
	}
	
}
