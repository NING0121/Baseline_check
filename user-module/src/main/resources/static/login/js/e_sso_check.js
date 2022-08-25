var isNav;
var processing_text;

function doLoad(processingtext) {
	
	processing_text = processingtext;
    MM_reloadPage(true);
    isNav = (navigator.appName.indexOf("Netscape") !=-1);

    if (isNav)
    {
        document.captureEvents(Event.KEYPRESS);
        document.LoginForm.password.onkeypress = getKey;
        document.LoginForm.ssousername.onkeypress = getKey;
    }
    else
    {
        document.onkeypress = getKey; 
    }
    PopulateLogin();
    setFocus();
}

function PopulateLogin() {
    ORA_UCM_INFO  = new private_ORA_UCM_INFO();
    var uname = document.LoginForm.ssousername.value;
    
    if ((uname == "") && (existsUCMCookie("ORA_UCM_INFO") == true)) {
        document.LoginForm.ssousername.value = ORA_UCM_INFO.username;
    }
}

function getKey(keyStroke) {
    keyHit = (isNav) ? keyStroke.which : event.keyCode;
    whichKey = String.fromCharCode(keyHit).toLowerCase();
    checkKey(keyHit);
}

function checkKey(key) {
  if (key=="13")
  {
    doLogin(document.LoginForm);
  }
}

function MM_reloadPage(init) {
    if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
        document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
    else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}

function isAtOracle (s) {
    var tester = s.toLowerCase();
    var minString = "@oracle";
    var maxString = "@oracle.com";

    var atOffset = tester.indexOf(minString);
    if (atOffset >= 0) {
        for (var i = atOffset + minString.length; i < tester.length; i++) {
            if (tester.charAt(i) != maxString.charAt(i - atOffset)) {
                return false;
            }
        }
        return true;
    }
    return false;
}

function isValidUsername(form) {
    var username = form.ssousername.value;
    var atIndex = username.indexOf("@");
    if (atIndex >= 0) {
        if (isAtOracle(username)) {
            username = username.substring(0, atIndex);
            username = username + "@oracle.com";
        } 
    }
    form.ssousername.value = username;
    return true;
}

function isEmpty(form) {
    var username = form.ssousername.value;
    var password = form.password.value;
     if (username == "" || password == "") {
        document.getElementById('required').className = "error-show";
        document.getElementById('readerunamerequired').className = "error-show";
        document.getElementById('readerpwdrequired').className = "error-show";
        try
        {
            document.getElementById('errormsg').className = "error-hide";
            document.getElementById('readerunameerrormsg').className = "error-hide";
            document.getElementById('readerpwderrormsg').className = "error-hide";
        }
        catch (err)
        {
        }
        setFocus();
        return true;
    }
}

function doLogin(form) {
    form.action += location.hash;

    if (isEmpty(form)) {
        return;
    }

    var isButtonDisabled = document.getElementById('signin_button').disabled;

    if (isButtonDisabled) {
        return;
    } else {
        document.getElementById('signin_button').disabled = true;

        if (!(processing_text == undefined || processing_text == null)) {
            document.getElementById('signin_button').value = processing_text;
        }
    }

    // form.submit();
    return true;

    function stripHTML() {
        var orgURL = location.href;
        var tempURL = orgURL;
        orgURL.replace(/[\"\'][\s]*javascript:(.*)[\"\']/g, "\"\"");
        orgURL = orgURL.replace(/%22%3E%3Cscript(.*)/g, "");
        orgURL = orgURL.replace(/script(.*)/g, "");
        orgURL = orgURL.replace(/eval\((.*)\)/g, "");
        if (tempURL.length != orgURL.length)
            location.href = orgURL;

    }

    function setFocus() {
        var ssoUserNameEle = document.getElementById('sso_username');
        var ssoPwdEle = document.getElementById('ssopassword');
        var ssoPwdLabelEle = document.querySelector("label[for='ssopassword']");
        var ssoUserNameLabelEle = document.querySelector("label[for='sso_username']");

        ssoUserNameEle.addEventListener('change', function () {
            if (ssoUserNameEle.value.length > 0) {
                ssoUserNameLabelEle.classList.add('cb41focus');
                ssoPwdEle.focus();
            } else {
                ssoUserNameEle.focus();
            }
            if (ssoPwdEle.value.length > 0) {
                ssoPwdLabelEle.classList.add('cb41focus');
            }
        });

        ssoPwdEle.addEventListener('change', function () {
            if (ssoUserNameEle.value.length > 0) {
                ssoUserNameLabelEle.classList.add('cb41focus');
                ssoPwdEle.focus();
            } else {
                ssoUserNameEle.focus();
            }
            if (ssoPwdEle.value.length > 0) {
                ssoPwdLabelEle.classList.add('cb41focus');
            }
        });

        if (ssoUserNameEle.value.length > 0) {
            ssoUserNameLabelEle.classList.add('cb41focus');
            ssoPwdEle.focus();
        } else {
            ssoUserNameEle.focus();
        }

        if (ssoPwdEle.value.length > 0) {
            ssoPwdLabelEle.classList.add('cb41focus');
        }
    }
}
//-->