$(function() {
    $(".trigger-success").on('click', function(event) {
      event.preventDefault();
      iziToast.settings({
          timeout: 1500,
          resetOnHover: true,
          transitionIn: 'flipInX',
          transitionOut: 'flipOutX',
          onOpening: function(){
              console.log('callback abriu!');
          },
          onClosing: function(){
              console.log("callback fechou!");
          }
      });
      // success
      iziToast.success({
        message: 'アドレスをコピーしました',
        position: 'bottomRight',
        transitionIn: 'bounceInLeft',
      });
      
    });
  })