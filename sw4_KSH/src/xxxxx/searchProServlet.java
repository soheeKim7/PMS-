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

import model.GroupCodeVO;
import model.PMSDAO;
import model.PMSDAOImpl;
import model.ProductVO;


@WebServlet("/searchPro")
public class searchProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PMSDAO dao = new PMSDAOImpl();
		ProductVO vo=new ProductVO();
		
        List<GroupCodeVO> list = new ArrayList<>();        
        list=dao.getGroupcode(); 
        request.setAttribute("list", list);
		
        request.setCharacterEncoding("utf-8");
		vo=dao.searchProduct(request.getParameter("code"));
		
		request.setAttribute("code", vo.getCode());
		request.setAttribute("pname", vo.getPname());
		request.setAttribute("cost", vo.getCost());
		request.setAttribute("pnum", vo.getPnum());
		request.setAttribute("jnum", vo.getJnum());
		request.setAttribute("sale", vo.getSale());
		request.setAttribute("gcode", vo.getGcode());
		request.setAttribute("gname", dao.getGname(vo.getGcode()));		
		
		RequestDispatcher rd= request.getRequestDispatcher("/search.jsp");
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
