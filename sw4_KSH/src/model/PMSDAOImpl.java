package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PMSDAOImpl extends DAOBase implements PMSDAO {
	
	//제품입력
	@Override
	public void insertProduct(ProductVO vo) {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {			
			stmt=conn.prepareStatement("insert into product values(?,?,?,?,?,?,?)");						
			stmt.setString(1, vo.getCode());    
			stmt.setString(2, vo.getPname());	
			stmt.setInt(3, vo.getCost());
			stmt.setInt(4, vo.getPnum());
			stmt.setInt(5, vo.getJnum());
			stmt.setInt(6, vo.getSale());
			stmt.setString(7, vo.getGcode());
			stmt.executeUpdate();			
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);	
		}			
		
	}
	//그룹코드에서 정보(그룹코드,그룹이름) 가져오기
	@Override
	public List<GroupCodeVO> getGroupcode(){		
		List<GroupCodeVO> list = new ArrayList<>();
		Connection conn=getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();			
			String query="select * from groupcode";
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				GroupCodeVO vo=new GroupCodeVO();
				vo.setGcode(rs.getString("gcode"));
				vo.setGname(rs.getString("gname"));
				list.add(vo);
			}			
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);	
		}	
		return list;
	}
	
	@Override
	public ProductVO searchProduct(String code) {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		ProductVO vo=new ProductVO();	
		try {
			stmt=conn.prepareStatement("select * from product where code=?");				
			stmt.setString(1, code); 
			rs=stmt.executeQuery();		
			rs.next();
			vo.setCode(rs.getString("code"));
			vo.setPname(rs.getString("pname"));
			vo.setCost(rs.getInt("cost"));
			vo.setPnum(rs.getInt("pnum"));
			vo.setJnum(rs.getInt("jnum"));
			vo.setSale(rs.getInt("sale"));
			vo.setGcode(rs.getString("gcode"));						
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);
		}			
		return vo;
	}
	
	@Override
	public String getGname(String gcode) {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String gname=null;
		try {
			stmt=conn.prepareStatement("select gname from groupcode where gcode=?");				
			stmt.setString(1, gcode); 
			rs=stmt.executeQuery();		
			rs.next();
			gname=rs.getString(1);
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);
		}			
		return gname;
	}

	@Override
	public void updateProduct(ProductVO vo) {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {			
			stmt=conn.prepareStatement("update product set code=?,pname=?,cost=?,pnum=?,jnum=?,sale=?,gcode=? where code=?");						
			stmt.setString(1, vo.getCode());    
			stmt.setString(2, vo.getPname());	
			stmt.setInt(3, vo.getCost());
			stmt.setInt(4, vo.getPnum());
			stmt.setInt(5, vo.getJnum());
			stmt.setInt(6, vo.getSale());
			stmt.setString(7, vo.getGcode());
			stmt.setString(8, vo.getCode()); 
			stmt.executeUpdate();			
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);	
		}			
	}

	@Override
	public void deleteProduct(String code) {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {			
			stmt=conn.prepareStatement("delete from product where code=?");						
			stmt.setString(1, code); 
			stmt.executeUpdate();			
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);	
		}		
		
	}
	
	@Override
	public List<ProductVO> firstProduct() {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<ProductVO> list = new ArrayList<>();		
		try {
			stmt=conn.prepareStatement("select pname,pnum-jnum as hnum from product where jnum<pnum*0.2");			
			rs=stmt.executeQuery();		
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setPname(rs.getString(1));
				vo.setPnum(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);
		}			
		return list;
	}	
	
	@Override
	public List<ProductVO> profitRanking() {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<ProductVO> list = new ArrayList<>();		
		try {
			stmt=conn.prepareStatement("select pname,(sale-cost)*jnum as profit from product order by profit desc");			
			rs=stmt.executeQuery();		
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setPname(rs.getString(1));
				vo.setCost(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);
		}			
		return list;	
	}
	
	@Override
	public List<ProductVO> groupJnum() {
		Connection conn=getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<ProductVO> list = new ArrayList<>();		
		try {
			stmt=conn.prepareStatement("select gname,sum(jnum) from product join groupcode using(gcode) group by gname");			
			rs=stmt.executeQuery();		
			while(rs.next()) {
				ProductVO vo=new ProductVO();
				vo.setPname(rs.getString(1));
				vo.setJnum(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			closeDBResources(rs, stmt, conn);
		}			
		return list;	
	}
	
	
}



/*//statement일때!!!
 * stmt=conn.createStatement();
	String query=("insert into product values('"+code+"','"+pname+"',"+cost+","+pnum+","+jnum+","+sale+",'"+gcode+"')");	
	stmt.executeUpdate(query);
 */ 


/*//제품입력
 * @Override
	public void insertProduct(ProductVO vo) {
		dbConn();	
		try {			
			pstmt=conn.prepareStatement("insert into product values(?,?,?,?,?,?,?)");						
			pstmt.setString(1, vo.getCode());    
			pstmt.setString(2, vo.getPname());	
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, vo.getGcode());
			pstmt.executeUpdate();
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			dbClose();	
		}			
 */

/*
 * //그룹코드에서 정보(그룹코드,그룹이름) 가져오기
	@Override
	public List<GroupCodeVO> getGroupcode(){		
		List<GroupCodeVO> list = new ArrayList<>();
		dbConn();
		try {
			pstmt=conn.prepareStatement("select * from groupcode");				
			result=pstmt.executeQuery();
			while(result.next()) {
				GroupCodeVO vo=new GroupCodeVO();
				vo.setGcode(result.getString("gcode"));
				vo.setGname(result.getString("gname"));
				list.add(vo);
			}			
		} catch (Exception e) {    
			e.printStackTrace();
		}finally {
			dbClose();	
		}	
		return list;
	}
 */

/* //입력하려는 제품코드 있는지 확인하기 
 * 	@Override
	public String checkGcode(String gcode) {
		dbConn();
		try {
			pstmt=conn.prepareStatement("select gcode from groupcode where gcode=?");
			pstmt.setString(1, gcode);		
			result=pstmt.executeQuery();
			result.next(); 
			gcode=result.getString(1);	
		} catch (SQLException e) {
			gcode=null;
		}finally {
			dbClose();
		}
		return gcode;
	}
 * 
 */


