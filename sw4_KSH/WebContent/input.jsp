<%@page import="model.PMSDAOImpl"%>
<%@page import="model.PMSDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.GroupCodeVO"%>
<%@page import="model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 등록화면</title>
<style type="text/css">
button { background-color:#FAFAB4; border-color:#FAFAB4; float:left; 
		  width:100px; height:40px; font-size:18px; 
		  margin-right:3px; margin-left:3px; margin-top:1px; margin-botton:1px;	}
fieldset legent{font-size:16px;}
</style>

</head>
<body>
	<h1>생산관리 등록화면</h1>
	<fieldset>
		<legend >생산관리 등록화면</legend>
		<form action="/Production/inputPro">
		<ul>
        <li>제품코드 <input type="text" name="code"> </li> 
        <li>제품이름 <input type="text" name="pname"> </li> 
        <li>제품원가 <input type="number" name="cost"> </li> 
        <li>목표수량 <input type="number" name="pnum"> </li> 
        <li>재고수량 <input type="number" name="jnum"> </li> 
        <li>출고가 &nbsp;&nbsp;&nbsp;<input type="number" name="sale"> </li> 
        <li>그룹이름 
        <select name="gcode">            	
        	<c:forEach items="${glist }" var="voG">
        		<option value=${voG.gcode }>${voG.gname }</option>    	        		
        	</c:forEach>        	
        </select>  
       	</li>      
        </ul>        
        <br>
        <ul>  		
   		<li style="list-style: none;"> 		
   		
		<button name="input" >등 록</button>		
		</li>
		</ul>		
		</form>	
		
		<form action="/Production/main">
		<button name="main">메인화면</button>
		</form>
	</fieldset>
</body>
</html>