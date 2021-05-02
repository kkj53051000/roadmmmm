<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<style>
		.headerWrap{
			width: 100%;
			height: 130px;
			
			border: 1px solid black;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
	</style>
</head>
<body>
	<div class="headerWrap">
		<div>
			<h1>Road To Millio</h1>
		</div>
		<div>
			<c:if test="${user == null}">
				<a href="/">main</a>&nbsp;&nbsp;<a href="/login">login</a>&nbsp;&nbsp;<a href="/join">join</a>
			</c:if>
			<c:if test="${user != null}">
				<a href="/">main</a>&nbsp;&nbsp;<a href="/logout">logout</a>
			</c:if>
		</div>
	</div>
</body>
</html>