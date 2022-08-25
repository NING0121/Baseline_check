/* JS Utils file for MyProfile.
*/
/* <![CDATA[ */
$(function set_placeholder() {
	var input = document.createElement("input");
    if(('placeholder' in input)==false) {
		$('[placeholder]').focus(function() {
			var i = $(this);
			if(i.val() == i.attr('placeholder')) {
				i.val('').removeClass('placeholder');
			}
		}).blur(function() {
			var i = $(this);
			if(i.val() == '' || i.val() == i.attr('placeholder')) {
				i.addClass('placeholder').val(i.attr('placeholder'));
			}
		}).blur().parents('form').submit(function() {
			$(this).find('[placeholder]').each(function() {
				var i = $(this);
				if(i.val() == i.attr('placeholder'))
					i.val('');
			})
		});
	}
});

/* This function is used for the "Select All" behaviour of the Korean disclaimer checkboxes.
   The names of the checkboxes should not change otherwise the functionality will be broken. */
function selectAll(event) 
{
    var source = event.getSource();
	var chk1 = AdfPage.PAGE.findComponentByAbsoluteId('disclaimerPersonalInformation1');
    var chk2 = AdfPage.PAGE.findComponentByAbsoluteId('disclaimerPersonalInformation2');
    var chk3 = AdfPage.PAGE.findComponentByAbsoluteId('disclaimerPersonalInformation3');
    var chk4 = AdfPage.PAGE.findComponentByAbsoluteId('disclaimerPersonalInformation4');
	
	//If "Select All" checkbox is selected, select the four checkboxes
	if (source.getValue() == true)
	{
	    chk1.setValue(true);
		chk2.setValue(true);
		chk3.setValue(true);
		chk4.setValue(true); 
	}
	//If "Select All" checkbox is unselected, unselect the four checkboxes
	else
	{
	    chk1.setValue(false);
		chk2.setValue(false);
		chk3.setValue(false);
		chk4.setValue(false); 
	}

  }
/* ]]> */