<%@page import="model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.GroupCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 조회&수정 화면</title>
<style type="text/css">
button { background-color:#FAFAB4; border-color:#FAFAB4; float:left; 
		  width:100px; height:40px; font-size:18px; 
		  margin-right:3px; margin-left:3px; margin-top:1px; margin-botton:1px;	}
fieldset legent{font-size:16px;}
</style>
</head>
<body>
<h1>생산관리 조회&수정 화면</h1>
	<fieldset>
		<legend >생산관리 조회화면</legend>
		<form action="/Production/search">
		<ul>
        <li>제품코드 <input type="text" name="code" value=${searchdata.code }></li> 
        <li>제품이름 <input type="text" name="pname" value=${searchdata.pname }> </li> 
        <li>제품원가 <input type="number" name="cost" value=${searchdata.cost }> </li> 
        <li>목표수량 <input type="number" name="pnum" value=${searchdata.pnum }> </li> 
        <li>재고수량 <input type="number" name="jnum" value=${searchdata.jnum }> </li> 
        <li>출고가 &nbsp;&nbsp;&nbsp;<input type="number" name="sale" value=${searchdata.sale }> </li> 
        <li>그룹이름 
        <select name="gcode"> 
        	<c:choose>            	
	        	<c:when test="${searchdata.gcode!=null && gname!=null }">
	        		<c:forEach items="${glist }" var="voG">
	        			<c:choose>
		        			<c:when test="${searchdata.gcode==voG.gcode && gname==voG.gname }">
		        				<option value=${voG.gcode } selected>${voG.gname }</option>  
		        			</c:when>
		        			<c:otherwise>
		        				<option value=${voG.gcode }>${voG.gname }</option>  
		        			</c:otherwise>    
	        			</c:choose>    			
	        		</c:forEach>
	        	</c:when>
	        	<c:otherwise>           	
		        	<c:forEach items="${glist }" var="voG">
		        		<option value=${voG.gcode }>${voG.gname }</option>    	        		
		        	</c:forEach>  
	        	</c:otherwise> 
        	</c:choose> 
        </select>    
       	</li>      
        </ul>  
        <input type="hidden" name="searchcode" value=${searchdata.code }>
        <input type="hidden" name="searchpname" value=${searchdata.pname }>
        <input type="hidden" name="searchcost" value=${searchdata.cost }>
        <input type="hidden" name="searchpnum" value=${searchdata.pnum }>
        <input type="hidden" name="searchjnum" value=${searchdata.jnum }>
        <input type="hidden" name="searchsale" value=${searchdata.sale }>
        <input type="hidden" name="searchgcode" value=${searchdata.gcode }>                
        <br>
        <ul>  		
   		<li style="list-style: none;"> 		
		<button name="action" value="searchPro" >조 회</button>	
		<button name="action" value="update" id="update" onclick="updateCheck();">수 정</button>	
		<button name="action" value="delete" id="delete" onclick="deleteCheck();">삭 제</button>
		</li>
		</ul>		
		</form>			
		
		<form action="/Production/main">
		<button name="main">메인화면</button>
		</form>
	</fieldset>	

	<script>				
		function updateCheck(){          
	        if (confirm("제품코드: ${searchdata.code}, 제품이름: ${searchdata.pname} \n해당품목을 수정하시겠습니까?") == true){    //확인
	        	var check = document.getElementById("update");
	        	console.log(check.value);	        
	        }else{   //취소
	        	var check = document.getElementById("update");
	        	console.log(check.value);
	        	check.value = "updateCancle";
	        	console.log(check.value);
	          }
        }
		
		function deleteCheck(){          
	        if (confirm("제품코드: ${searchdata.code}, 제품이름: ${searchdata.pname} \n해당품목을 삭제하겠습니까?") == true){    //확인
	        	var check = document.getElementById("delete");
	        	console.log(check.value);	        
	        }else{   //취소
	        	var check = document.getElementById("delete");
	        	console.log(check.value);
	        	check.value = "deleteCancle";
	        	console.log(check.value);
	          }
        }
	
	</script>
	
	
</body>
</html>