/**
 *
 */



 /* バリデーションチェック*/
const submitBtn = document.getElementById("submit");

submitBtn.addEventListener('click',(e) =>{

	const name = document.getElementById("name").value;
	const mail_address = document.getElementById("mail_address").value;
	const address = document.getElementById("address").value;
	const password = document.getElementById("password").value;

	if(name == ""){
		e.preventDefault();
		window.alert("Nameは必須入力項目です")
	}else if(mail_address == ""){
		e.preventDefault();
		window.alert("E-mailは必須入力項目です")
	}else if(address == ""){
		e.preventDefault();
		window.alert("Addressは必須入力項目です")
	}else if(password == ""){
		e.preventDefault();
		window.alert("Passwordは必須入力項目です")
	}
});

 //確認アラート
function MoveCheck() {
	let check =  confirm("ログアウトしてもよろしいですか？");
    if( check == true) {
        window.location.href = "../jp.co.aforce.servlet/user-logout";
    }
    else{

    }
}

function MoveCheck2() {
	let check =  confirm("保存のため再ログインします。");
    if( check == true) {
        window.location.href = "../jp.co.aforce.servlet/user-update";
    }
    else{

    }
}


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

