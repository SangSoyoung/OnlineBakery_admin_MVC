package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import dto.ProductDTO;


@WebServlet("/pRegist.do")
public class ProductRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// PrintWriter out = response.getWriter();
		
		
		//***** 파일 업로드 처리******//
		// 1. 저장경로 선언
		String savePath = "upload";
		
		// 2. 업로드 파일 최대 크기 설정
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		
		// 3. 인코딩 방법 선언
		String encType = "utf-8";
		
		// 4. 서버상 실제 디렉토리 경로 가져오기
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리 : ");
		System.out.println(uploadFilePath);
		
		MultipartRequest multi = null;
		
		try {
			// 5. MultipartRequest 객체 생성
			multi = new MultipartRequest(
					request, 
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy()
					);
			
			// 6. 업로드된 파일명 얻기(File type name)
			String fileName = multi.getFilesystemName("img");
			
			if(fileName == null) {
				System.out.println("파일이 업로드 되지 않았음");
			} else {
				System.out.println("파일 업로드 성공");
			}
		
		} catch(Exception e) {
			System.out.println("예외 발생 : " + e);
		}
		
		
		
		//*****상품 등록 처리 ******//
		ProductDTO product = new ProductDTO();
		
		// form의 enctype이 multipart이기 때문에 request가 아닌 MultipartRequest객체를 사용해야한다.
		// 타입이 file인 경우, getFilesystemName으로 파라미터를 가져와야 한다.
		String pname = multi.getParameter("pname");
		String pcode = multi.getParameter("pcode");
		String price = multi.getParameter("price");
		String storage = multi.getParameter("storage");
		String expiration = multi.getParameter("expiration");
		String description = multi.getParameter("description");
		String img = multi.getFilesystemName("img");
		
		try {
	
			product.setPname(pname);
			product.setPcode(pcode);
			product.setPrice(Integer.parseInt(price));
			product.setStorage(storage);
			product.setExpiration(expiration);
			product.setDescription(description);
			product.setImg(img);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int result = new ProductDAO().registProduct(product);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("productRegist_process.jsp").forward(request, response);
		
	}

}
