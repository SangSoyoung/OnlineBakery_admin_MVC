package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;


@WebServlet("/mDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String[] mCheckList = request.getParameterValues("mCheck");
		
		for(int i = 0; i < mCheckList.length; i++) {
			
			String mCheck = mCheckList[i];
			System.out.println(mCheck);
			
			new MemberService().deleteMember(mCheck);
		}
		
		request.getRequestDispatcher("mList.do").forward(request, response);
		
	}

	
}
