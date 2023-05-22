<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル名刺管理</title>
</head>
<body>
<h1>ログイン</h1>
<p>※ID=DOJO, PW=password でログインできます。
<hr>
<form method="POST" action="/simpleBC/LoginServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
<input type="submit" name="LOGIN" value="ログイン">
</form>
</body>
</html>
