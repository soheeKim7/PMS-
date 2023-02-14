<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리 시스템</title>
<style type="text/css">
button { background-color:#FAFAB4; border-color:#FAFAB4; float:left; 
		  width:150px; height:40px; font-size:18px; 
		  margin-right:3px; margin-left:3px; margin-top:1px; margin-botton:1px;	}
fieldset legent{font-size:16px;}
fieldset {padding-left:2px; padding-rigtht:2px; padding-top:4px; padding-bottom:4px; }
</style>

</head>
<body>

	<h1>생산관리 시스템</h1>
	<fieldset>
		<legend >생산관리 메인메뉴 </legend>
		<form action="/Production/input">
		<button name="input">제품입력</button>
		</form>
		<form action="/Production/search">
		<button name="serch">제품조회</button>
		</form>
		<form action="/Production/firstProduct">
		<button name="firstProduct">우선생산제품</button>
		</form>
		<form action="/Production/profit">
		<button name="profit">이익순위</button>
		</form>
		<form action="/Production/group">
		<button name="group">그룹별재고수량</button>
		</form>
	</fieldset>

</body>
</html>