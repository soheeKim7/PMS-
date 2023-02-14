package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GroupCodeVO;
import model.PMSDAO;
import model.PMSDAOImpl;
import model.ProductVO;

public class test {

	public static void main(String[] args) {
		ProductVO vo1 = new ProductVO();
		GroupCodeVO vo2 = new GroupCodeVO();
		
		PMSDAO dao = new PMSDAOImpl();
		
//		vo2.setGcode("B");
//		vo2.setGname("냉장고");
//		vo1.setCode("12");
//		vo1.setPname("컴퓨터모니터");
//		vo1.setCost(50000);
//		vo1.setPnum(400);
//		vo1.setJnum(50);
//		vo1.setSale(55000);
//		vo1.setGcode("A");
//		dao.insertProduct(vo1);
//		dao.updateProduct(vo1);
		
//		dao.deleteProduct("12");		
		
		
//		vo1=dao.searchProduct("A01");
//		String code=vo1.getCode();
//		String pname=vo1.getPname();
//		int cost=vo1.getCost();
//		int pnum=vo1.getPnum();
//		int jnum=vo1.getJnum();
//		int sale=vo1.getSale();
//		String gcode=vo1.getGcode();
//		System.out.println(code+pname+cost+pnum+jnum+sale+gcode);
			
//        List<GroupCodeVO> list = new ArrayList<>();
//        
//        list=dao.getGroupcode(); 
//        for(GroupCodeVO vo : list){ 
//        	System.out.println(vo.getGcode());
//        	System.out.println(vo.getGname());
//	     }
        
//        List<ProductVO> list = new ArrayList<>();
//        
//        list=dao.firstProduct();
//        for(ProductVO vo : list){ 
//        	System.out.println(vo.getPname());
//        	System.out.println(vo.getPnum());
//	     }
        
//		List<ProductVO> list = new ArrayList<>();
//        
//        list=dao.profitRanking();
//        for(ProductVO vo : list){ 
//        	System.out.println(vo.getPname());
//        	System.out.println(vo.getCost());
//	     }
        
        List<ProductVO> list = new ArrayList<>();
        
        list=dao.groupJnum();
        for(ProductVO vo : list){ 
        	System.out.println(vo.getPname());
        	System.out.println(vo.getJnum());
	     }
        
        
	}
}
