<% System.out.println("----- home.jsp 호출 -----"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>ex04</title>
		<meta charset="UTF-8">
	</head>
	<body>
		<h1>메인 페이지</h1>
		<hr/>
		<!-- TODO: 로그인 상태에 따라서 다른 버튼을 보여줌 -->
		<button>로그인</button>
		
		<hr/>
		<a href="">새 글 작성</a>
		
		<hr/>
		<h2>게시글 리스트</h2>
		
	</body>
</html>
