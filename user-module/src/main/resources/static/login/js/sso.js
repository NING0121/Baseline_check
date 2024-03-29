!function(e,t,n){function r(e,t){return typeof e===t}function o(){var e,t,n,o,i,a,s;for(var u in b)if(b.hasOwnProperty(u)){if(e=[],t=b[u],t.name&&(e.push(t.name.toLowerCase()),t.options&&t.options.aliases&&t.options.aliases.length))for(n=0;n<t.options.aliases.length;n++)e.push(t.options.aliases[n].toLowerCase());for(o=r(t.fn,"function")?t.fn():t.fn,i=0;i<e.length;i++)a=e[i],s=a.split("."),1===s.length?Modernizr[s[0]]=o:(!Modernizr[s[0]]||Modernizr[s[0]]instanceof Boolean||(Modernizr[s[0]]=new Boolean(Modernizr[s[0]])),Modernizr[s[0]][s[1]]=o),y.push((o?"":"no-")+s.join("-"))}}function i(e){var t=S.className,n=Modernizr._config.classPrefix||"";if(E&&(t=t.baseVal),Modernizr._config.enableJSClass){var r=new RegExp("(^|\\s)"+n+"no-js(\\s|$)");t=t.replace(r,"$1"+n+"js$2")}Modernizr._config.enableClasses&&(t+=" "+n+e.join(" "+n),E?S.className.baseVal=t:S.className=t)}function a(){return"function"!=typeof t.createElement?t.createElement(arguments[0]):E?t.createElementNS.call(t,"http://www.w3.org/2000/svg",arguments[0]):t.createElement.apply(t,arguments)}function s(){var e=t.body;return e||(e=a(E?"svg":"body"),e.fake=!0),e}function u(e,n,r,o){var i,u,l,f,c="modernizr",d=a("div"),p=s();if(parseInt(r,10))for(;r--;)l=a("div"),l.id=o?o[r]:c+(r+1),d.appendChild(l);return i=a("style"),i.type="text/css",i.id="s"+c,(p.fake?p:d).appendChild(i),p.appendChild(d),i.styleSheet?i.styleSheet.cssText=e:i.appendChild(t.createTextNode(e)),d.id=c,p.fake&&(p.style.background="",p.style.overflow="hidden",f=S.style.overflow,S.style.overflow="hidden",S.appendChild(p)),u=n(d,e),p.fake?(p.parentNode.removeChild(p),S.style.overflow=f,S.offsetHeight):d.parentNode.removeChild(d),!!u}function l(e,t){return!!~(""+e).indexOf(t)}function f(e){return e.replace(/([a-z])-([a-z])/g,function(e,t,n){return t+n.toUpperCase()}).replace(/^-/,"")}function c(e,t){return function(){return e.apply(t,arguments)}}function d(e,t,n){var o;for(var i in e)if(e[i]in t)return n===!1?e[i]:(o=t[e[i]],r(o,"function")?c(o,n||t):o);return!1}function p(e){return e.replace(/([A-Z])/g,function(e,t){return"-"+t.toLowerCase()}).replace(/^ms-/,"-ms-")}function m(t,r){var o=t.length;if("CSS"in e&&"supports"in e.CSS){for(;o--;)if(e.CSS.supports(p(t[o]),r))return!0;return!1}if("CSSSupportsRule"in e){for(var i=[];o--;)i.push("("+p(t[o])+":"+r+")");return i=i.join(" or "),u("@supports ("+i+") { #modernizr { position: absolute; } }",function(e){return"absolute"==getComputedStyle(e,null).position})}return n}function h(e,t,o,i){function s(){c&&(delete M.style,delete M.modElem)}if(i=r(i,"undefined")?!1:i,!r(o,"undefined")){var u=m(e,o);if(!r(u,"undefined"))return u}for(var c,d,p,h,g,v=["modernizr","tspan"];!M.style;)c=!0,M.modElem=a(v.shift()),M.style=M.modElem.style;for(p=e.length,d=0;p>d;d++)if(h=e[d],g=M.style[h],l(h,"-")&&(h=f(h)),M.style[h]!==n){if(i||r(o,"undefined"))return s(),"pfx"==t?h:!0;try{M.style[h]=o}catch(y){}if(M.style[h]!=g)return s(),"pfx"==t?h:!0}return s(),!1}function g(e,t,n,o,i){var a=e.charAt(0).toUpperCase()+e.slice(1),s=(e+" "+z.join(a+" ")+a).split(" ");return r(t,"string")||r(t,"undefined")?h(s,t,o,i):(s=(e+" "+_.join(a+" ")+a).split(" "),d(s,t,n))}function v(e,t,r){return g(e,n,n,t,r)}var y=[],b=[],x={_version:"3.3.1",_config:{classPrefix:"",enableClasses:!0,enableJSClass:!0,usePrefixes:!0},_q:[],on:function(e,t){var n=this;setTimeout(function(){t(n[e])},0)},addTest:function(e,t,n){b.push({name:e,fn:t,options:n})},addAsyncTest:function(e){b.push({name:null,fn:e})}},Modernizr=function(){};Modernizr.prototype=x,Modernizr=new Modernizr,Modernizr.addTest("history",function(){var t=navigator.userAgent;return-1===t.indexOf("Android 2.")&&-1===t.indexOf("Android 4.0")||-1===t.indexOf("Mobile Safari")||-1!==t.indexOf("Chrome")||-1!==t.indexOf("Windows Phone")?e.history&&"pushState"in e.history:!1});var C=x._config.usePrefixes?" -webkit- -moz- -o- -ms- ".split(" "):["",""];x._prefixes=C;var S=t.documentElement,E="svg"===S.nodeName.toLowerCase();E||!function(e,t){function n(e,t){var n=e.createElement("p"),r=e.getElementsByTagName("head")[0]||e.documentElement;return n.innerHTML="x<style>"+t+"</style>",r.insertBefore(n.lastChild,r.firstChild)}function r(){var e=b.elements;return"string"==typeof e?e.split(" "):e}function o(e,t){var n=b.elements;"string"!=typeof n&&(n=n.join(" ")),"string"!=typeof e&&(e=e.join(" ")),b.elements=n+" "+e,l(t)}function i(e){var t=y[e[g]];return t||(t={},v++,e[g]=v,y[v]=t),t}function a(e,n,r){if(n||(n=t),c)return n.createElement(e);r||(r=i(n));var o;return o=r.cache[e]?r.cache[e].cloneNode():h.test(e)?(r.cache[e]=r.createElem(e)).cloneNode():r.createElem(e),!o.canHaveChildren||m.test(e)||o.tagUrn?o:r.frag.appendChild(o)}function s(e,n){if(e||(e=t),c)return e.createDocumentFragment();n=n||i(e);for(var o=n.frag.cloneNode(),a=0,s=r(),u=s.length;u>a;a++)o.createElement(s[a]);return o}function u(e,t){t.cache||(t.cache={},t.createElem=e.createElement,t.createFrag=e.createDocumentFragment,t.frag=t.createFrag()),e.createElement=function(n){return b.shivMethods?a(n,e,t):t.createElem(n)},e.createDocumentFragment=Function("h,f","return function(){var n=f.cloneNode(),c=n.createElement;h.shivMethods&&("+r().join().replace(/[\w\-:]+/g,function(e){return t.createElem(e),t.frag.createElement(e),'c("'+e+'")'})+");return n}")(b,t.frag)}function l(e){e||(e=t);var r=i(e);return!b.shivCSS||f||r.hasCSS||(r.hasCSS=!!n(e,"article,aside,dialog,figcaption,figure,footer,header,hgroup,main,nav,section{display:block}mark{background:#FF0;color:#000}template{display:none}")),c||u(e,r),e}var f,c,d="3.7.3",p=e.html5||{},m=/^<|^(?:button|map|select|textarea|object|iframe|option|optgroup)$/i,h=/^(?:a|b|code|div|fieldset|h1|h2|h3|h4|h5|h6|i|label|li|ol|p|q|span|strong|style|table|tbody|td|th|tr|ul)$/i,g="_html5shiv",v=0,y={};!function(){try{var e=t.createElement("a");e.innerHTML="<xyz></xyz>",f="hidden"in e,c=1==e.childNodes.length||function(){t.createElement("a");var e=t.createDocumentFragment();return"undefined"==typeof e.cloneNode||"undefined"==typeof e.createDocumentFragment||"undefined"==typeof e.createElement}()}catch(n){f=!0,c=!0}}();var b={elements:p.elements||"abbr article aside audio bdi canvas data datalist details dialog figcaption figure footer header hgroup main mark meter nav output picture progress section summary template time video",version:d,shivCSS:p.shivCSS!==!1,supportsUnknownElements:c,shivMethods:p.shivMethods!==!1,type:"default",shivDocument:l,createElement:a,createDocumentFragment:s,addElements:o};e.html5=b,l(t),"object"==typeof module&&module.exports&&(module.exports=b)}("undefined"!=typeof e?e:this,t);var w="Moz O ms Webkit",_=x._config.usePrefixes?w.toLowerCase().split(" "):[];x._domPrefixes=_;var T=function(){function e(e,t){var o;return e?(t&&"string"!=typeof t||(t=a(t||"div")),e="on"+e,o=e in t,!o&&r&&(t.setAttribute||(t=a("div")),t.setAttribute(e,""),o="function"==typeof t[e],t[e]!==n&&(t[e]=n),t.removeAttribute(e)),o):!1}var r=!("onblur"in t.documentElement);return e}();x.hasEvent=T,Modernizr.addTest("hashchange",function(){return T("hashchange",e)===!1?!1:t.documentMode===n||t.documentMode>7}),Modernizr.addTest("cssgradients",function(){for(var e,t="background-image:",n="gradient(linear,left top,right bottom,from(#9f9),to(white));",r="",o=0,i=C.length-1;i>o;o++)e=0===o?"to ":"",r+=t+C[o]+"linear-gradient("+e+"left top, #9f9, white);";Modernizr._config.usePrefixes&&(r+=t+"-webkit-"+n);var s=a("a"),u=s.style;return u.cssText=r,(""+u.backgroundImage).indexOf("gradient")>-1}),Modernizr.addTest("rgba",function(){var e=a("a").style;return e.cssText="background-color:rgba(150,255,150,.5)",(""+e.backgroundColor).indexOf("rgba")>-1});var k=function(){var t=e.matchMedia||e.msMatchMedia;return t?function(e){var n=t(e);return n&&n.matches||!1}:function(t){var n=!1;return u("@media "+t+" { #modernizr { position: absolute; } }",function(t){n="absolute"==(e.getComputedStyle?e.getComputedStyle(t,null):t.currentStyle).position}),n}}();x.mq=k;var N=x.testStyles=u;Modernizr.addTest("touchevents",function(){var n;if("ontouchstart"in e||e.DocumentTouch&&t instanceof DocumentTouch)n=!0;else{var r=["@media (",C.join("touch-enabled),("),"heartz",")","{#modernizr{top:9px;position:absolute}}"].join("");N(r,function(e){n=9===e.offsetTop})}return n});var z=x._config.usePrefixes?w.split(" "):[];x._cssomPrefixes=z;var j={elem:a("modernizr")};Modernizr._q.push(function(){delete j.elem});var M={style:j.elem.style};Modernizr._q.unshift(function(){delete M.style});x.testProp=function(e,t,r){return h([e],n,t,r)};x.testAllProps=g,x.testAllProps=v,Modernizr.addTest("boxshadow",v("boxShadow","1px 1px",!0));var P=function(t){var r,o=C.length,i=e.CSSRule;if("undefined"==typeof i)return n;if(!t)return!1;if(t=t.replace(/^@/,""),r=t.replace(/-/g,"_").toUpperCase()+"_RULE",r in i)return"@"+t;for(var a=0;o>a;a++){var s=C[a],u=s.toUpperCase()+"_"+r;if(u in i)return"@-"+s.toLowerCase()+"-"+t}return!1};x.atRule=P;var O=x.prefixed=function(e,t,n){return 0===e.indexOf("@")?P(e):(-1!=e.indexOf("-")&&(e=f(e)),t?g(e,t,n):g(e,"pfx"))};x.prefixedCSS=function(e){var t=O(e);return t&&p(t)};o(),i(y),delete x.addTest,delete x.addAsyncTest;for(var A=0;A<Modernizr._q.length;A++)Modernizr._q[A]();e.Modernizr=Modernizr}(window,document);
jQuery('html').attr('class',jQuery('html').attr('class').replace(/touchevents/gi,'touch')); // PATCH TO REVERT TOUCH CLASS TO OLD STYLE


jQuery('html').first().addClass('hasjs');

if(window.history.pushState){
	jQuery('html').first().addClass('haspushstate');
}

if(window.devicePixelRatio >= 1.2 || document.location.href.indexOf('?retina') > -1){
	jQuery('html').addClass('retina');
}

if(navigator && navigator.platform && navigator.platform.match(/^(iPad|iPod|iPhone)$/)){
	jQuery('html').first().addClass('iOSdevice');
}



jQuery(document).ready(function($) {	
	$(window).on("mousemove", function (e) {
		if ($("html.touch")[0] && !$("html.iOSdevice")[0]) {
			$("html").removeClass("touch");
			$(".cb41").each( function (i, cb41) {
				$(cb41).find(".cb41noteshoverbtn").each( function ( j,btn ){
					cb41removeTouch(btn);
				});
			});
		}
	});
	$(window).on("keypress", function (e) {
	    if (e.which == 13 || e.keyCode == 13) {
	        if ($(".cb41notefocus")[0]) {
	        	if ($(".cb41notefocus").closest(".cb41active")[0]) {
	        		cb41noteHide($(".cb41notefocus"));
	        	} else {
		        	cb41noteShow($(".cb41notefocus"));
	        	}
	        	e.preventDefault();
	        }
	    }
	});
	$(".cb41").each( function (i, context) {
		var cb41 = $(context),
			input = cb41.find('input').not('input[type="submit"]');
		cb41.find(".cb41notescontent").prepend('<span class="cb41arrow"></span>');
		input.on("focus", function (e) {
			
			$(e.currentTarget).closest(".cb41w2,.cb41w3").addClass("cb41focus");
			
			$('label[for="' + $(e.currentTarget).attr('id') + '"]').addClass("cb41focus");

			cb41.find(".cb41noteshoverbtn").each( function ( i,btn ){
				cb41noteHide(btn);
			});

		});
		input.on("blur", function (e) {
			
			if (!$(e.currentTarget).val()) {
				$('label[for="' + $(e.currentTarget).attr('id') + '"]').removeClass("cb41focus");
			}
			$(e.currentTarget).closest(".cb41w2,.cb41w3").removeClass("cb41focus");
		});
		cb41.find(".cb41noteshoverbtn").each( function ( i,btn ){
			$(btn).append('<span class="cb41btnhvr"></span>');
			cb41addEvents(btn);
		});
	});
	function cb41removeTouch(btn) {
		$(".cb41mobbtn").remove();
		$(btn).on("mouseenter", function (e) {
			cb41noteShow(btn);
		});
		$(btn).on("mouseleave", function (e) {
			cb41noteHide(btn);
		});
		$(btn).on("focus", function (e) {
			$(btn).addClass("cb41notefocus");
		});
		$(btn).on("blur", function (e) {
			$(btn).removeClass("cb41notefocus");
		});
	}
	function cb41addEvents(btn) {
		if ($("html.touch")[0]) {
			$(btn).closest(".cb41w6").append('<span class="cb41mobbtn"></span>');
		} else {
			$(btn).on("mouseenter", function (e) {
				cb41noteShow(btn);
			});
			$(btn).on("mouseleave", function (e) {
				cb41noteHide(btn);
			});
			$(btn).on("focus", function (e) {
				$(btn).addClass("cb41notefocus");
			});
			$(btn).on("blur", function (e) {
				$(btn).removeClass("cb41notefocus");
			});
		}
		$(btn).closest(".cb41w6").find(".cb41mobbtn").on("click", function (e) {
			if ($(btn).closest(".cb41active")[0]) {
				cb41noteHide(btn);
			} else {
				cb41noteShow(btn);
			}
		});
		$(btn).find("a:last").on("blur", function (e) {
			cb41noteHide(btn);
		});
	}
	function cb41noteShow(target) {
		$(target).find(".cb41notescontent").stop(true,true).hide();
		$(target).find(".cb41notescontent").show().animate({opacity:1},250);
		$(target).closest(".cb41w5").addClass("cb41active");
	}
	function cb41noteHide(target) {
		$(target).find(".cb41notescontent").animate({opacity:0},250,function () {
			//if (!$(target).closest(".cb41w5").hasClass("cb41active")) {
				$(target).find(".cb41notescontent").hide();
			//}
		});
		$(target).closest(".cb41w5").removeClass("cb41active");
	}
});

$(function() {
   $('input.submit_btn').closest('div').addClass('submit_btn_w1');
});