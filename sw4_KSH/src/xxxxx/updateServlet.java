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

@WebServlet("/update")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PMSDAO dao = new PMSDAOImpl();
		ProductVO vo=new ProductVO();	
		
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		String pname=request.getParameter("pname");
		int cost=Integer.parseInt(request.getParameter("cost"));
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		int jnum=Integer.parseInt(request.getParameter("jnum"));
		int sale=Integer.parseInt(request.getParameter("sale"));
		String gcode=request.getParameter("gcode");
		
		vo.setCode(code);
		vo.setPname(pname);
		vo.setCost(cost);
		vo.setPnum(pnum);
		vo.setJnum(jnum);
		vo.setSale(sale);
		vo.setGcode(gcode);
		dao.updateProduct(vo);
		
		request.setAttribute("code", code);
		request.setAttribute("pname",pname);
		request.setAttribute("cost", cost);
		request.setAttribute("pnum", pnum);
		request.setAttribute("jnum", jnum);
		request.setAttribute("sale", sale);
		request.setAttribute("gcode", gcode);
		
		RequestDispatcher rd= request.getRequestDispatcher("/updatePro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
