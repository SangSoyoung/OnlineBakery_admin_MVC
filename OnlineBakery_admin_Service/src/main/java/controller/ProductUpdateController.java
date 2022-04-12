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

@WebServlet("/pUpdate.do")
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//******인코딩 설정******//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//******파일 업로드******//
		// 1. 파일 저장 경로 변수
		String savePath = "upload";
		// 2. 파일 업로드 최대 크기
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		
		// 3. 인코딩 타입
		String encType = "utf-8";
		
		// 4. 서버상 실제 저장 디렉토리 
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);

		// 5. MultipartRequest 객체 선언
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
					request, 
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy()
					);
			
			// 6. 업로드된 파일 이름
			String filename = multi.getOriginalFileName("img");
			
			if(filename == null) {
				System.out.println("파일이 업로드 되지 않았음");
			} else {
				System.out.println("파일 업로드 성공");
			}
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}
		
		
		//******수정 내용 저장******//
		ProductDTO product = new ProductDTO();
		
		product.setPname(multi.getParameter("pname"));
		product.setPcode(multi.getParameter("pcode"));
		product.setPrice(Integer.parseInt(multi.getParameter("price")));
		product.setStorage(multi.getParameter("storage"));
		product.setExpiration(multi.getParameter("expiration"));
		product.setDescription(multi.getParameter("description"));
		product.setImg(multi.getFilesystemName("img"));

		int result = new ProductDAO().updateProduct(product);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("productUpdate_process.jsp").forward(request, response);
		
	}

}
