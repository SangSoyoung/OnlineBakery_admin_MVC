package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;


@WebServlet("/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ArrayList<ProductDTO> plist = new ArrayList<>();
		plist = new ProductDAO().getPList();
		
		request.setAttribute("plist", plist);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

}
