<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル名刺管理</title>
</head>
<body>
<h1>検索結果（更新／削除）</h1>
<hr>

<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/simpleBC/UpdateDeleteServlet">
	番号<input type="text" name="NUMBER" value="${e.number}"><br>
	氏名<input type="text" name="NAME" value="${e.name}"><br>
	住所<input type="text" name="ADDRESS" value="${e.address}"><br>
	<input type="submit" name="SUBMIT" value="更新">
	<input type="submit" name="SUBMIT" value="削除"><br>
	</form>
	<hr>
</c:forEach>
<a href="/simpleBC/MenuServlet">メニューへ戻る</a>

</body>
</html>
