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
<div class="input-cont">
  <input type="text" id="name" name="NAME" required>
  <label>名前</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="text" id="company" name="COMPANY">
  <label>会社名</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="text" id="department" name="DEPARTMENT">
  <label>部署</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="text" id="position" name="POSITION">
  <label>役職</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="number" id="postcode" name="POST_CODE">
  <label>郵便番号</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="text" id="address" name="ADDRESS">
  <label>住所</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="email" id="mail" name="EMAIL">
  <label>メール</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <input type="tel" id="tel" name="PHONE_NUMBER">
  <label>電話番号</label>
  <div class="border1"></div>
</div>
<div class="input-cont">
  <textarea id="memo" rows="2" cols="60" name="MEMO"></textarea>
  <label>メモ</label>
  <div class="border2"></div>
</div>
<input type="submit" name="REGIST" value="登録"><br>
</form>
<a href="/simpleBC/MenuServlet">メニューへ戻る</a>
</body>
</html>
