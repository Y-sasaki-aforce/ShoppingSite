/**
 *
 */
//画像の設定

var windowwidth = window.innerWidth || document.documentElement.clientWidth || 0;
		if (windowwidth > 768){
			var responsiveImage = [//PC用の画像
				{ src: '../img/mountain1-1.jpg'},
				{ src: '../img/mountain1-2.jpg'},
				{ src: '../img/mountain1-3.jpg'}
			];
		} else {
			var responsiveImage = [//タブレットサイズ（768px）以下用の画像
				{ src: '../img/mountain1-1.jpg' },
				{ src: '../img/mountain1-2.jpg' },
				{ src: '../img/mountain1-3.jpg' }
			];
		}

//Vegas全体の設定

$('#slider').vegas({
		overlay: true,//画像の上に網線やドットのオーバーレイパターン画像を指定。
		transition: 'fade2',//切り替わりのアニメーション。http://vegas.jaysalvat.com/documentation/transitions/参照。fade、fade2、slideLeft、slideLeft2、slideRight、slideRight2、slideUp、slideUp2、slideDown、slideDown2、zoomIn、zoomIn2、zoomOut、zoomOut2、swirlLeft、swirlLeft2、swirlRight、swirlRight2、burnburn2、blurblur2、flash、flash2が設定可能。
		transitionDuration: 2000,//切り替わりのアニメーション時間をミリ秒単位で設定
		delay: 5000,//スライド間の遅延をミリ秒単位で。
		animationDuration: 20000,//スライドアニメーション時間をミリ秒単位で設定
		animation: 'random',//スライドアニメーションの種類。http://vegas.jaysalvat.com/documentation/transitions/参照。kenburns、kenburnsUp、kenburnsDown、kenburnsRight、kenburnsLeft、kenburnsUpLeft、kenburnsUpRight、kenburnsDownLeft、kenburnsDownRight、randomが設定可能。
		slides: responsiveImage,//画像設定を読む
		//timer:false,// プログレスバーを非表示したい場合はこのコメントアウトを外してください
	});

//ハンバーガーメニュー（開閉）
$(function() {
  let $gnav   = $('#gnav-area');
  let $btn   = $('.toggle_btn');
  let $mask  = $('#mask');
  let open   = 'open'; // class
  // menu open close
  $btn.on( 'click', function() {
    if ( ! $gnav.hasClass( open ) ) {
      $gnav.addClass( open );
    } else {
      $gnav.removeClass( open );
    }
  });

  $('.gnav-list a[href]').on('click', function() {
        $('.toggle_btn').trigger('click');
    });

  // mask close
  $mask.on('click', function() {
    $gnav.removeClass( open );
  });
});
