package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PMSDAO {
	
	//제품입력
	void insertProduct(ProductVO vo);
	//그룹코드에서 정보(그룹코드,그룹이름) 가져오기
	List<GroupCodeVO> getGroupcode();
	
	//제품조회
	ProductVO searchProduct(String code);
	//gcode에 해당하는 gname 가져오기
	String getGname(String gcode);
	
	//제품수정
	void updateProduct(ProductVO vo);
	
	//제품삭제
	void deleteProduct(String code);
	
	//우선 생산 제품 화면
	List<ProductVO> firstProduct();	
	
	//이익 순위 제품 화면
	List<ProductVO> profitRanking();
	
	//그룹별 재고수량 목록
	List<ProductVO> groupJnum(); 

}
