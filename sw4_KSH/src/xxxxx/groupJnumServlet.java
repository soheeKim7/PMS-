package xxxxx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PMSDAO;
import model.PMSDAOImpl;
import model.ProductVO;


@WebServlet("/group")
public class groupJnumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PMSDAO dao = new PMSDAOImpl();
		List<ProductVO> list = new ArrayList<>();
		
		list=dao.groupJnum();		
		
		request.setAttribute("list", list);			
		
		RequestDispatcher rd= request.getRequestDispatcher("/groupJnum.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
