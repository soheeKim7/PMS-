package xxxxx;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PMSDAO;
import model.PMSDAOImpl;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PMSDAO dao = new PMSDAOImpl();
		
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		
		dao.deleteProduct(code);
		
		request.setAttribute("code", code);
		
		RequestDispatcher rd= request.getRequestDispatcher("/deletePro.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
