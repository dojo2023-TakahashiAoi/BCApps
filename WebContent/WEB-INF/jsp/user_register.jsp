<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル名刺管理</title>
</head>
<body>
<h1>アカウント登録</h1>
<hr>
<form method="POST" action="/simpleBC/UserRegisterServlet">
ID<input type="text" name="ID"><br>
PW<input type="password" name="PW"><br>
PW（確認）<input type="password" name="PW_2"><br>
名前<input type="text" name="NAME"><br>
<input type="submit" name="LOGIN" value="アカウント登録">
</form>
<p>${message}</p>
<a href="LoginServlet">ログイン</a>
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
    <title>新規登録｜名刺管理アプリ</title>
</head>
<body>
  <div class="log">
    <h2>名刺管理アカウント</h2>
    <form method="POST" action="/simpleBC/UserRegisterServlet">
      <div class="input-cont">
        <input type="text" id="userid" name="ID") required>
        <label>ユーザーID</label>
        <div class="border1"></div>
      </div>
      <!-- <span id="userid-error" class="error"></span> -->
      <div class="input-cont">
        <input type="text" id="username" name="NAME" required>
        <label>名前</label>
        <div class="border1"></div>
      </div>
      <div class="input-cont">
        <input type="password" id="password" name="PW")" required>
        <label>パスワード</label>
        <div class="border2"></div>
      </div>
      <!-- <span id="password-error" class="error"></span> -->
      <div class="login-button-panel">
        <input type="submit" class="login-button" name="LOGIN" title="新規登録する" value="新規登録">
        </div>
    </form>
    <div class="loginform-footer">
        <p>${message}</p>
        <p>アカウントをお持ちの方は<a href="LoginServlet">ログイン</a>してください。</p>
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

  function validateUserId(userid) {
      const userIdRegex = /^[A-Za-z0-9_]{4,15}$/;
      const userIdError = document.getElementById("userid-error");
      if (!userIdRegex.test(userid)) {
        userIdError.textContent = "ユーザーIDは4文字以上15文字以下で、半角英数字とアンダーバー(_)のみ使用できます";
        console.log("true");
      } else {
        userIdError.textContent = "";
        console.log("false");
      }
    }

  function validatePassword(password) {
    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    const passwordError = document.getElementById("password-error");
    if (!passwordRegex.test(password)) {
      passwordError.textContent = "パスワードは8文字以上で、半角英数字と記号を含む必要があります";
      console.log("true");
    } else {
      passwordError.textContent = "";
      console.log("false");
    }
  }
</script>
</html>