$(function(){
	var url = window.location.href; 
	if(url.indexOf("pid=mysql") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/mysql-logo.png");
		$('.branded-logo').wrap( "<a href='http://www.mysql.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=ou") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/oracle-university-logo.png");
		$('.branded-logo').wrap( "<a href='http://education.oracle.com/pls/web_prod-plq-dad/db_pages.getpage?page_id=3' target='_blank'></a>" );
	}
	if(url.indexOf("pid=ow") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/openworld-logo.png");
		$('.branded-logo').wrap( "<a href='http://www.oracle.com/openworld/index.html' target='_blank'></a>" );
	}
	if(url.indexOf("pid=career") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/career-logo.png");
		$('.branded-logo').wrap( "<a href='https://irecruitment.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=cloud") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/cloud-logo.png");
		$('.branded-logo').wrap( "<a href='https://cloud.oracle.com/home' target='_blank'></a>" );
	}
	if(url.indexOf("pid=oic") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/industry-connect-logo.png");
		$('.branded-logo').wrap( "<a href='https://www.oracle.com/oracleindustryconnect/index.html' target='_blank'></a>" );
	}
	if(url.indexOf("pid=jcp") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/java-community-process-logo.png");
		$('.branded-logo').wrap( "<a href='https://jcp.org/en/home/index' target='_blank'></a>" );
	}
	if(url.indexOf("pid=javaone") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/javaone-logo.png");
		$('.branded-logo').wrap( "<a href='http://www.oracle.com/javaone/index.html' target='_blank'></a>" );
	}
	if(url.indexOf("pid=opn") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/oracle-partner-network-logo.png");
		$('.branded-logo').wrap( "<a href='http://www.oracle.com/partners' target='_blank'></a>" );
	}
	if(url.indexOf("pid=ops") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/oracle-partner-store-logo.png");
		$('.branded-logo').wrap( "<a href='https://partnerstore.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=store") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/store-logo.png");
		$('.branded-logo').wrap( "<a href='https://shop.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=edelivery") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/default-logo.png");
		$('.branded-logo').wrap( "<a href='https://edelivery.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=linux") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/linux-logo.png");
		$('.branded-logo').wrap( "<a href='https://linux.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=mos") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/mos-logo.png");
		$('.branded-logo').wrap( "<a href='https://support.oracle.com' target='_blank'></a>" );
	}
	if(url.indexOf("pid=community") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/oracle-technology-network.png");
		$('.branded-logo').wrap( "<a href='http://www.oracle.com/technetwork/index.html' target='_blank'></a>" );
	}
	if(url.indexOf("pid=academy") > -1){
		$('.branded-logo').attr("src", "images/branded-logos/oracle-academy-logo.png");
		$('.branded-logo').wrap( "<a href='https://academy.oracle.com/' target='_blank'></a>" );
	}
});