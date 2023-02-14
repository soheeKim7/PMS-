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
<script type="text/javascript">
var answer1 = "${answer1}";
console.log(answer1.length);
</script>

<c:if test="${action=='update'}">
	<script >
		alert("${answer}")
	</script>
</c:if>
<c:if test="${action=='updateCancle'}">
	<script >
	alert("수정이 취소되었습니다.")
	</script>
</c:if>


<script>
location.href="/Production/search";
</script>

</body>
</html>


<%--
<c:if test="${action=='update'}">
	<c:choose>
		<c:when test="${empty answer1}">
			<script >
			alert("${answer2}\n 수정되었습니다.")
			</script>
		</c:when>
		<c:when test="${empty answer2}">
			<script >
			alert("${answer1}\n 수정되었습니다.")
			</script>
		</c:when>
		<c:otherwise>
			<script >
			alert("${answer1}\n${answer2}\n 수정되었습니다.")
			</script>
		</c:otherwise>
	</c:choose>
</c:if> 
--%>