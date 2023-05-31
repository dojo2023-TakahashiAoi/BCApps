<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="ja">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- CSS -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
      <link rel="stylesheet" href="css/ress.min.css">
      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/izimodal/1.5.1/css/iziModal.min.css">
      <link rel="stylesheet" href="css/iziToast.css">
      <link rel="stylesheet" href="css/iziToast.min.css">
      <!-- JS -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/izimodal/1.5.1/js/iziModal.min.js"></script>
      <script type="text/javascript" src="./js/jquery-migrate-3.4.1.js"></script>
      <script src="js/iziToast.min.js" type="text/javascript"></script>
      <script src="js/iziToast.js" type="text/javascript"></script>
      <script src="js/Modal.js" type="text/javascript"></script>
      <script src="js/Toast.js" type="text/javascript"></script>
      <script src="js/script.js"></script>
      <!-- <script src="js/bcUpload.js"></script> -->

      <title>トップページ｜名刺管理アプリ</title>
    </head>
    <body>
      <header id="header">
        <!-- ロゴ -->
        <div class="logo">
          <h1>Logo</h1>
        </div>
        <nav>
          <ul id="gnav"> </ul>
        </nav>
        <!-- 検索フォーム -->
        <div class="search">
          <form method="POST" action="/simpleBC/SearchServlet" class="searchform"> <label>
                    <input type="text" name="SEARCH_QUERY" placeholder="名刺を検索">
                </label> <button type="submit" name="REGIST" aria-label="検索"></button> </form>
        </div>
        <!-- ユーザアイコン -->
        <div class="icon"> <img src="img/bc_icon.png" alt="ユーザーアイコン">
          <div class="dropdown-menu">
            <ul>
              <li><a href="#">マイページ</a></li>
              <li><a href="#">ログアウト</a></li>
            </ul>
          </div>
        </div>
      </header>

      <main id="main">
        <c:forEach var="e" items="${cardList}">
          <!-- ユーザー情報を表示するウィンドウ用のJS -->
          <script>
            $(function () {
              $(".iziModal_${e.id}").iziModal({
                width: "600px",
                transitionIn: "fadeInUp",
                padding: "20px",
                headerColor: "#768793",
                top: "30px"});});

            $(document).on('click', '.trigger-${e.id}', function (event) {
                event.preventDefault();
                $('.iziModal_${e.id}').iziModal('open');
            });

            $(function () {
              $(".iziModal_edit_${e.id}").iziModal({
                width: "600px",
                transitionIn: "fadeInUp",
                padding: "20px",
                headerColor: "#768793",
                top: "30px"});});

            $(document).on('click', '.trigger-edit-${e.id}', function (event) {
                event.preventDefault();
                $('.iziModal_edit_${e.id}').iziModal('open');
            });
          </script>

          <!-- 名刺情報モーダル -->
          <div class="iziModal_${e.id}" data-izimodal-title="名刺" data-izimodal-subtitle="名刺情報の確認,修正,削除ができます。">
            <div class="bc">
              <!-- 削除 -->
              <form onsubmit="return showAlert()" method="POST" action="/simpleBC/UpdateDeleteServlet">
                <input type="hidden" name="UUID" value="${e.id}" readonly>
                <input type="submit" class="material-symbols-outlined delete_icon" name="SELECT" value="delete">
              </form>
              <script>
                // アラートを表示
                function showAlert() {
                  alert("名刺を削除してもよろしいですか？");
                  return true;
                }
              </script>
              <!-- 編集 -->
              <div class="edit_icon trigger-edit-${e.id}"><span class="material-symbols-outlined">edit</span></div>
            </div>
            <div class="bc_info"> <img src="img/bc_icon.png" alt="アイコン" class="bc_icon">
              <p><span>${e.name} </span></p> <span>${e.company} / ${e.department}</span> </div>
            <div class="bc_detail">
              <div class="item"> <span class="label">役職</span> <span class="value">${e.position}</span> </div>
              <div class="item"> <span class="label">郵便番号</span> <span class="value">${e.post_code}</span> </div>
              <div class="item"> <span class="label">住所</span> <span class="value">${e.address}</span> </div>
              <div class="item"> <span class="label">電話番号</span> <span class="value">${e.phone_number}</span> </div>
              <div class="item"> <span class="label">メールアドレス</span>
                <!-- <span class="value">${e.email}</span> --><span class="value copylink"><a href="#" id="copy" onclick="copyToClipboard('copy')">${e.email}</a><span class="material-symbols-outlined trigger-success copy_icon">content_copy</span></span>
              </div>
              <div class="item"> <span class="label">メモ</span> <span class="value">${e.memo}</span> </div>
              <div class="item"> <span class="label">登録日</span> <span class="value">${e.timestamp}</span> </div>
              <div class="item"> <span class="label">登録者</span> <span class="value">${e.linkedUser}</span> </div>
            </div>
          </div>

         <!-- 名刺編集モーダル -->
        <div class="iziModal_edit_${e.id}" data-izimodal-title="名刺情報の編集" data-izimodal-subtitle="名刺の情報を編集します。">
          <div class="log">
            <form method="POST" action="/simpleBC/UpdateDeleteServlet"> <br>

              <div class="input-cont"> <input type="text" id="name" name="NAME" value="${e.name}" required> <label>名前</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="company" name="COMPANY" value="${e.company}"> <label>会社名</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="department" name="DEPARTMENT" value="${e.department}"> <label>部署</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="position" name="POSITION" value="${e.position}"> <label>役職</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="number" id="postcode" name="POST_CODE" value="${e.post_code}"> <label>郵便番号</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="address" name="ADDRESS" value="${e.address}"> <label>住所</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="email" id="mail" name="EMAIL" value="${e.email}"> <label>メール</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="tel" id="tel" name="PHONE_NUMBER" value="${e.phone_number}"> <label>電話番号</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <textarea id="memo" rows="2" cols="60" name="MEMO" value="${e.memo}"></textarea> <label>メモ</label>
                <div class="border2"></div>
              </div>
              <div class="login-button-panel"><input type="submit" name="SELECT" class="login-button" title="登録する" value="登録する"></div>
            </form>
          </div>
        </div>
        </c:forEach>

        <h1 id="title">名刺帳</h1>

        <!-- メインテーブル -->
        <table class="list">
          <tr class="row_01">
            <td id="A1">名前</td>
            <td>会社</td>
            <td>部署/役職</td>
            <td>住所</td>
            <td>電話番号</td>
            <td>メールアドレス</td>
          </tr>
          <tr>
            <c:forEach var="e" items="${cardList}">
              <td class="trigger-${e.id}">${e.name}</td>
              <td class="trigger-${e.id}">${e.company}</td>
              <td class="trigger-${e.id}">${e.department}<br>${e.position}</td>
              <td class="trigger-${e.id}">${e.address}</td>
              <td class="trigger-${e.id}">${e.phone_number}</td>
              <td class="copylink"><a href="#" id="copy" onclick="copyToClipboard('copy')">${e.email}</a><span class="material-symbols-outlined trigger-success copy_icon">content_copy</span></td>
          </tr>
          </c:forEach>
        </table>

        <!-- 名刺追加モーダル -->
        <div class="iziModal" data-izimodal-title="新しい名刺を追加" data-izimodal-subtitle="新しい名刺の情報を登録します。">
          <div class="log">
            <form method="POST" action="/simpleBC/RegistServlet"> <br>
              <div class="input-cont"> <input type="text" id="name" name="NAME" required> <label>名前</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="company" name="COMPANY"> <label>会社名</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="department" name="DEPARTMENT"> <label>部署</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="position" name="POSITION"> <label>役職</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="number" id="postcode" name="POST_CODE"> <label>郵便番号</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="text" id="address" name="ADDRESS"> <label>住所</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="email" id="mail" name="EMAIL"> <label>メール</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <input type="tel" id="tel" name="PHONE_NUMBER"> <label>電話番号</label>
                <div class="border1"></div>
              </div>
              <div class="input-cont"> <textarea id="memo" rows="2" cols="60" name="MEMO"></textarea> <label>メモ</label>
                <div class="border2"></div>
              </div>
              <div class="login-button-panel"> <input type="submit" name="REGIST" class="login-button" title="登録する" value="登録"> </div>
            </form>
          </div>
        </div>
      </main>

      <div class="floating-button trigger-addCard"> <span>＋</span> </div>
      <footer> <small>&copy;Copyright plusDOJO(SE plus). All rights reserved.</small> </footer>

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
    <script>
      function copyToClipboard(copy) {
        var emailLink = document.getElementById(copy);
        console.log(copy);
        emailLink.addEventListener("click", function() {
        // メールアドレスの取得
        var email = emailLink.textContent;
        console.log(email);
        navigator.clipboard.writeText(email)
          .then(() => console.log('Copied to clipboard'))
          .catch((error) => console.error('Error copying to clipboard:', error));
    	})};
    </script>
    </html>