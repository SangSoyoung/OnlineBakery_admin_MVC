package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

@WebServlet("/pDetail.do")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pcode = request.getParameter("pcode");
		
		ProductDTO product = new ProductDAO().getPDetailList(pcode);

		request.setAttribute("pcode_ex", pcode);
		request.setAttribute("product", product);
		request.getRequestDispatcher("productDetail.jsp").forward(request, response);
	}

}
