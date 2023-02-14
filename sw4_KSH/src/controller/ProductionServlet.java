package controller;

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

@WebServlet("/Production/*")
public class ProductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PMSDAO dao = new PMSDAOImpl();
	List<GroupCodeVO> grouplist = new ArrayList<>();
	List<ProductVO> productlist = new ArrayList<>();
	ProductVO voP = new ProductVO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String uri = request.getRequestURI();
		String cp=request.getContextPath();
		String delStr=cp+"/Production/";
		String cmd=uri.substring(delStr.length());
		request.setCharacterEncoding("utf-8");
		String gourl =""; 
		
		if(cmd.equals("main")){
			gourl ="/main.jsp"; 
		}else if(cmd.equals("input")) {	       
	        
	        grouplist=dao.getGroupcode(); 
	        request.setAttribute("glist", grouplist);			
	        gourl ="/input.jsp";
	        
		}else if(cmd.equals("inputPro")) {			
			voP.setCode(request.getParameter("code"));
			voP.setPname(request.getParameter("pname"));
			voP.setCost(Integer.parseInt(request.getParameter("cost")));
			voP.setPnum(Integer.parseInt(request.getParameter("pnum")));
			voP.setJnum(Integer.parseInt(request.getParameter("jnum")));
			voP.setSale(Integer.parseInt(request.getParameter("sale")));
			voP.setGcode(request.getParameter("gcode"));
			dao.insertProduct(voP);
					
			request.setAttribute("vo",voP); 			
			gourl ="/inputPro.jsp";
			
		}else if(cmd.equals("search")) {	        
	        grouplist=dao.getGroupcode(); 
	        request.setAttribute("glist", grouplist);
	        gourl ="/search.jsp";
	        
	        String action = request.getParameter("action");	    
	        if(action!=null) {
		        if(action.equals("searchPro")) {    
			        grouplist=dao.getGroupcode(); 
			        request.setAttribute("glist", grouplist);
					
					voP=dao.searchProduct(request.getParameter("code"));
					
					request.setAttribute("searchdata", voP);
					request.setAttribute("gname", dao.getGname(voP.getGcode()));		
					gourl ="/search.jsp";
				
		        }else if(action.equals("update")) {				
					voP.setCode(request.getParameter("code"));
					voP.setPname(request.getParameter("pname"));
					voP.setCost(Integer.parseInt(request.getParameter("cost")));
					voP.setPnum(Integer.parseInt(request.getParameter("pnum")));
					voP.setJnum(Integer.parseInt(request.getParameter("jnum")));
					voP.setSale(Integer.parseInt(request.getParameter("sale")));
					voP.setGcode(request.getParameter("gcode"));
					dao.updateProduct(voP);				
					request.setAttribute("updatedata", voP );				
					
					ProductVO searchVO = new ProductVO();
					searchVO.setCode(request.getParameter("searchcode"));
					searchVO.setPname(request.getParameter("searchpname"));
					searchVO.setCost(Integer.parseInt(request.getParameter("searchcost")));
					searchVO.setPnum(Integer.parseInt(request.getParameter("searchpnum")));
					searchVO.setJnum(Integer.parseInt(request.getParameter("searchjnum")));
					searchVO.setSale(Integer.parseInt(request.getParameter("searchsale")));
					searchVO.setGcode(request.getParameter("searchgcode"));				
					request.setAttribute("searchdata", searchVO);				
					
					String answer="";
					System.out.println(searchVO);
					ProductVO updateVO =voP;
					if(!searchVO.getPname().equals(updateVO.getPname()))
						answer=" 제품이름:"+searchVO.getPname()+"->"+updateVO.getPname();
					if(searchVO.getCost()!=updateVO.getCost())
						answer=answer+" 제품원가:"+searchVO.getCost()+"->"+updateVO.getCost();
					if(searchVO.getPnum()!=updateVO.getPnum())
						answer=answer+" 목표수량:"+searchVO.getPnum()+"->"+updateVO.getPnum();
					if(!answer.equals(""))
						answer=answer+"\\n";
					System.out.println(answer);
														
					if(searchVO.getJnum()!=updateVO.getJnum())
						answer=answer+" 재고수량:"+searchVO.getJnum()+"->"+updateVO.getJnum();
					if(searchVO.getSale()!=updateVO.getSale())
						answer=answer+" 출고가:"+searchVO.getSale()+"->"+updateVO.getSale();
					if(!searchVO.getGcode().equals(updateVO.getGcode()))
						answer=answer+" 그룹코드:"+searchVO.getGcode()+"->"+updateVO.getGcode();								
					if(!answer.equals(""))
						answer=answer+"\\n";
					System.out.println(answer);
					
					answer=answer+" 수정되었습니다.";
					System.out.println(answer);
					
					request.setAttribute("answer", answer);
					
					request.setAttribute("action", action);
					gourl ="/updatePro.jsp";
				
		        }else if(action.equals("updateCancle")) {		        	
		        	request.setAttribute("code", request.getParameter("code"));
					request.setAttribute("pname",request.getParameter("pname"));
					request.setAttribute("cost", Integer.parseInt(request.getParameter("cost")));
					request.setAttribute("pnum", Integer.parseInt(request.getParameter("pnum")));
					request.setAttribute("jnum", Integer.parseInt(request.getParameter("jnum")));
					request.setAttribute("sale", Integer.parseInt(request.getParameter("sale")));
					request.setAttribute("gcode", request.getParameter("gcode"));
					
					request.setAttribute("action", action);					
					gourl ="/updatePro.jsp";
					
		        }else if(action.equals("delete")) {							
					String code=request.getParameter("code");			
					dao.deleteProduct(code);			
					request.setAttribute("code", code);	
					request.setAttribute("pname", request.getParameter("pname"));
					
					request.setAttribute("action", action);
					gourl ="/deletePro.jsp";	
					
		        }else if(action.equals("deleteCancle")) {										
					request.setAttribute("code", request.getParameter("code"));		
					request.setAttribute("pname", request.getParameter("pname"));
					
					request.setAttribute("action", action);					
					gourl ="/deletePro.jsp";	
		        }
	        }
		}else if(cmd.equals("firstProduct")) {				
			productlist=dao.firstProduct();				
			request.setAttribute("list", productlist);			
			gourl ="/firstProduct.jsp";
			
		}else if(cmd.equals("profit")){			
			productlist=dao.profitRanking();			
			request.setAttribute("list", productlist);		
			gourl ="/profitRanking.jsp";
			
		}else if(cmd.equals("group")) {			
			productlist=dao.groupJnum();			
			request.setAttribute("list", productlist);				
			gourl ="/groupJnum.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(gourl);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
