<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
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
<a href="UserRegisterServlet">登録ページ</a>
</body>
</html> -->

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/ress.min.css">
    <link rel="stylesheet" href="css/login_style.css">
    <title>ログイン｜名刺管理アプリ</title>
</head>
<body>
  <div class="log">
    <h2>名刺管理アカウント</h2>
    <form method="POST" action="/simpleBC/LoginServlet">
      <div class="input-cont">
        <input type="text" id="username" name="ID" required>
        <label>ユーザーID</label>
        <div class="border1"></div>
      </div>
      <div class="input-cont">
        <input type="password" id="password" name="PW" required>
        <label>パスワード</label>
        <div class="border2"></div>
      </div>
      <div class="login-button-panel">
        <input type="submit" class="login-button" name="LOGIN" title="ログインする" value="ログイン">
        </div>
    </form>
    <div class="loginform-footer">
        <p>アカウントをお持ちでない場合は<a href="UserRegisterServlet">登録</a></p>
        <br>
        <small>&copy;Copyright plusDOJO(SE plus). All rights reserved.</small>
    </div>
</div>
</body>
<script>
  // フォームに文字列が入力されてるときにラベルのスタイルを変更
  const inputElements = document.querySelectorAll('.input-cont input');
  inputElements.forEach((input) => {
    input.addEventListener('input', (event) => {
      const label = event.target.nextElementSibling;
      if (input.value !== '') {
        label.classList.add('filled');
      } else {
        label.classList.remove('filled');
      }
    });
  });
</script>
</html>