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

