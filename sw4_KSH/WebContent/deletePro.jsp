<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${action=='delete'}">
	<script >
	alert("제품코드: ${code}, 제품이름: ${pname} \n해당품목이 삭제되었습니다.")
	</script>
</c:if>
<c:if test="${action=='deleteCancle'}">
	<script >
	alert("삭제가 취소되었습니다.")
	</script>
</c:if>

<script>
location.href="/Production/search";
</script>

</body>
</html>