/*
######################################################
# ORA_CODE_PROFILE.JS - v2.1
# BUILD DATE: 22-APRIL-2015
# COPYRIGHT ORACLE CORP 2015 [UNLESS STATED OTHERWISE]
######################################################
*/
function s_setAccount(){var sa=["oracledevall","profile","en-us"];sa[0]=(s_checkdev())?"oracledevall":"oracleglobal";return sa;}
/* Pre and Post Plugins PLUS utility functions */
function s_prePlugins(s){s_oraVer(":profile",":2.1");}function s_postPlugins(s){var locURL=document.location.href.toLowerCase();var profileAtributes=["tid:default","required:default","style:default","code:default"];s.pageName=(typeof(s.pageName)=="undefined"||s.pageName=="")?s_account[1]+":"+s_account[2]+":/default":s.pageName;var pNames=new Array();pNames=[["createuser","create-user"],["updateuser","update-user"],["quickverification","verify-email"],["findusername","sends-username-for-lost"],["resetpassword","password-reset"],["notifypage","notify-password-reset-sent"],["setpassword","set-password"],["internalaccount","internal-account"],["changepassword","change-password"]];var al=pNames.length;for(i=0;i<al;i++){if(locURL.indexOf(pNames[i][0])!=-1){s.pageName=s_account[1]+":"+s_account[2]+":"+pNames[i][1];i=al+1;}}if(s.getQueryParam("tid")){profileAtributes[0]="tid:"+s.getQueryParam("tid");}if(s.getQueryParam("req")){profileAtributes[1]="required:"+s.getQueryParam("req");}if(s.getQueryParam("style")){profileAtributes[2]="style:"+s.getQueryParam("style");}if(s.getQueryParam("code")){profileAtributes[3]="code:"+s.getQueryParam("code");}s.prop56=profileAtributes.join();s.prop57=(s.getQueryParam("showRegions"))?"showRegions:"+s.getQueryParam("showRegions"):"showRegions:default";s.eVar52=(s.eVar52.indexOf("?")>0)?s.eVar52.substr(0,s.eVar52.indexOf("?")-1):s.eVar52;if(typeof USER=="undefined"){var USEROK=new getUserInfo();if(USEROK.username!="NoData"){USER=new getUserInfo();}if(window.s_setGUID){s_setGUID();}}}function getUserInfo(){var USER=new Object();this.value_enc=getCookieData("ORA_UCM_INFO");this.array=this.value_enc.split("~");USER.guid=sani(this.array[1]);USER.username=sani(this.array[4]);return USER;}function getCookieData(label){var labelLen=label.length;var cLen=document.cookie.length;var i=0;var cEnd;while(i<cLen){var j=i+labelLen;if(document.cookie.substring(i,j)==label){cEnd=document.cookie.indexOf(";",j);if(cEnd==-1){cEnd=document.cookie.length;}j++;return decodeURIComponent(document.cookie.substring(j,cEnd).replace("+","%20"));}i++;}return"";}function s_checkdev(){var isDev=false;var devSites=new Array();devSites=["-stage","-dev","-content","localhost","127.0.0.1",":7101",":7003","-mktad","-mktas","us.oracle.com","ucmmv4001.oracle.com"];var al=devSites.length;for(i=0;i<al;i++){if(location.host.indexOf(devSites[i])!=-1){isDev=true;i=al+1;}}return(isDev);}function s_oraVer(_s,_v){_v=_s+_v;oraVersion=(oraVersion.indexOf(_s)==-1)?oraVersion+_v:oraVersion.substr(0,oraVersion.indexOf(_s))+_v;}function oraSetInternalFilters(){s.linkInternalFilters="javascript:,.oracle.";if(location.href.indexOf(":8888")||location.href.indexOf("webstandards-us")){s.linkInternalFilters="javascript:,localhost,webstandards-us.oracle.com,.oracle.";}}function gotjQ(){try{var jq=(jQuery)?true:false;}catch(err){var jq=false;}return jq;}
/* JQUERY FUNCTIONS */
if(gotjQ()){jQuery(document).ready(function($){
/* TRACKAS MOSAIC */
/* TRACKAS OBJECTS */
var trackas=[["div.footer ","footer"],["div.c04","c04"]]
/* TRACKAS LIGHTBOX & OPOP */
;$('a[rel*="lightbox"],a[rel*="opop"]').each(function(){if(!$(".f11v1")[0]){var type=($(this).attr("rel")=="opop")?"popup":"lightbox";if(!$(this).attr("data-lbl")&&$(this).attr("title")){$(this).attr("data-lbl",type+"-open-"+$(this).attr("title").toLowerCase().replace(/ /g,"-"));}else{if(!$(this).attr("data-lbl")&&$(this).text()){$(this).attr("data-lbl",type+"-open-"+$(this).text().toLowerCase().replace(/ /g,"-"));}else{if($(this).attr("data-lbl")){$(this).attr("data-lbl",$(this).attr("data-lbl")+"-"+type+"-open");}else{$(this).attr("data-lbl",type+"-open");}}}if(!$(this).attr("data-trackas")){$(this).attr("data-trackas",type);}}});
/* TRACKAS CODE */
var sn=s_account[1];var ln=s_account[2];$("form.u01searchform").bind("submit",function(e){if(s_setAccount()[1]){navTrack(s_setAccount()[1],s_setAccount()[2],"header","search");}});for(var i=0;i<trackas.length;i++){if(!$(trackas[i][0]).attr("data-trackas")&&trackas[i][1]){$(trackas[i][0]).attr("data-trackas",trackas[i][1]);}if(trackas[i][2]&&trackas[i][2]=="resetpage"){$(trackas[i][0]).attr("data-pgreset","true");}else{if(trackas[i][2]&&!$(trackas[i][0]).attr("data-lbl")){$(trackas[i][0]).attr("data-lbl",trackas[i][2]);}}}$(document).on("click","*[data-trackas] a,a[data-trackas]",function(e){var lbl="";var o=$(this);if(o.attr("data-lbl")!="notrack"){if(o.attr("data-lbl")){lbl=o.attr("data-lbl");}else{if(o.attr("name")){lbl=o.attr("name");}else{if(o.attr("title")){lbl=o.attr("title");}else{if(o.find("img")&&o.find("img").first().attr("title")){lbl=o.find("img").first().attr("title");}else{if(o.find("img")&&o.find("img").first().attr("alt")){lbl=o.find("img").first().attr("alt");}else{if(o.find("img").first().attr("src")){lbl=o.find("img").first().attr("src");lbl=lbl.split("/")[(lbl.split("/").length-1)];}else{lbl=o.text();}}}}}}var d=o.closest("[data-trackas]").attr("data-trackas");d=(d=="hnav"||d=="header"||d=="hp07"||d=="hp08"||d=="hp09")?":":"-";if(!o.attr("data-trackas")){while(o.parent()){o=o.parent();if(o.attr("data-lbl")){lbl=o.attr("data-lbl")+d+lbl;}if(o.attr("data-trackas")){break;}}}lbl=lbl.toLowerCase().replace(/ /g,"-").replace(/-+/g,"-");var sec=(o.attr("data-trackas"))?o.attr("data-trackas"):o.closest("*[data-trackas]").attr("data-trackas");if(sec!="cw22-carouseltop"){navTrack(sn,ln,sec,lbl);}if(o.attr("data-pgreset")=="true"){s.clearVars();if(o.attr("href").indexOf("#")==0&&s.pageName){if(!$("body").attr("data-pgname")){$("body").attr("data-pgname",s.pageName);var pn=s.pageName;}else{var pn=$("body").attr("data-pgname");}s.pageName=pn+"/"+o.attr("href").split("#")[1];}else{s_orapageName(o.attr("href"));}oraSetInternalFilters();s.linkInternalFilters=s.linkInternalFilters+","+o.attr("href");var s_code=s.t();if(s_code){document.write(s_code);}oraSetInternalFilters();}}});});}