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
import model.ProductVO;

@WebServlet("/inputPro")
public class InputProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PMSDAO dao = new PMSDAOImpl();
		ProductVO vo = new ProductVO();
		request.setCharacterEncoding("utf-8");
		vo.setCode(request.getParameter("code"));
		vo.setPname(request.getParameter("pname"));
		vo.setCost(Integer.parseInt(request.getParameter("cost")));
		vo.setPnum(Integer.parseInt(request.getParameter("pnum")));
		vo.setJnum(Integer.parseInt(request.getParameter("jnum")));
		vo.setSale(Integer.parseInt(request.getParameter("sale")));
		vo.setGcode(request.getParameter("gcode"));
		dao.insertProduct(vo);
				
		request.setAttribute("vo",vo); 		
		
		RequestDispatcher rd= request.getRequestDispatcher("/inputPro.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
