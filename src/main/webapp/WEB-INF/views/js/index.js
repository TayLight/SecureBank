$(function() {
	$(".btn").click(function() {
		$(".form-signin").toggleClass("form-signin-left");
    $(".form-signup").toggleClass("form-signup-left");
    $(".frame").toggleClass("frame-long");
    $(".signup-inactive").toggleClass("signup-active");
    $(".signin-active").toggleClass("signin-inactive");
    $(".line").toggleClass("line-left");   
    $(this).removeClass("idle").addClass("active");
	});
});

$(function() {
	$(".btn-signup").click(function() {
  $(".nav").toggleClass("nav-up");
  $(".form-signup-left").toggleClass("form-signup-down");
  $(".success").toggleClass("success-left"); 
  $(".frame").toggleClass("frame-short");
  $(setTimeout('location.replace("transfer.html")', 3000));
	});
});

$(function() {
	$(".btn-signin").click(function() {
  $(".btn-animate").toggleClass("btn-animate-grow");
  $(".welcome").toggleClass("welcome-left");
  $(".cover-photo").toggleClass("cover-photo-down");
  $(".frame").toggleClass("frame-short");
  $(".profile-photo").toggleClass("profile-photo-down");
  $(".btn-goback").toggleClass("btn-goback-up");
  $(".line").toggleClass("line-fade");
  $(setTimeout('location.replace("transfer.html")', 3000));
	});
});

$(function() {
  $(".btn-transfer-alert").click(function() {
  $(".btn-animate").toggleClass("btn-animate-grow");
  $(".alert").toggleClass("alert-left-transfer");
  $(".cover-photo").toggleClass("cover-photo-down");
  $(".frame").toggleClass("frame-short");
  $(".profile-photo-transfer").toggleClass("profile-photo-down-transfer");
  $(".btn-goback").toggleClass("btn-goback-up-transfer");
  $(".line").toggleClass("line-fade");
	});
});

$(function() {
  $(".btn-transfer").click(function() {
  $(".btn-animate").toggleClass("btn-animate-grow");
  $(".welcome").toggleClass("welcome-left-transfer");
  $(".cover-photo").toggleClass("cover-photo-down");
  $(".frame").toggleClass("frame-short");
  $(".profile-photo-transfer").toggleClass("profile-photo-down-transfer");
  $(".btn-goback").toggleClass("btn-goback-up-transfer");
  $(".line").toggleClass("line-fade");
	});
});

function clickBack() {
	$(location.replace("index.html"));
};

function clickBackTransferUpdate() {
	$(location.replace("transfer.html"));
};

//Для случая с запрещенной транзакцией
function clickBackAlert() {
	$(location.replace("alert.html"));
};

//Для случая с запрещенной транзакцией
function clickBackTransfer2() {
	$(location.replace("transfer2.html"));
};

//Для случая с запрещенной транзакцией
function clickBackTransfer3() {
	$(location.replace("transfer3.html"));
};
