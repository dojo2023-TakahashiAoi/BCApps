<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル名刺管理</title>
</head>
<body>
<h1>登録</h1>
<hr>
<form method="POST" action="/simpleBC/RegistServlet">
番号<input type="text" name="NUMBER"><br>
氏名<input type="text" name="NAME"><br>
住所<input type="text" name="ADDRESS"><br>
<input type="submit" name="REGIST" value="登録"><br>
</form>
<a href="/simpleBC/MenuServlet">メニューへ戻る</a>
</body>
</html>
