/**
 * checkBox.js
 */
$(function(){
	$("#checkBoxs").click(function(){
		if($(this).prop("checked")){
			$("input:checkbox[name=nums]").prop("checked",true);
		}else{
			$(":checkbox[name=nums]").prop("checked",false);
		}
	});
	$(":checkbox[name=nums]").click(function(){
		var tot = $(":checkbox[name=nums]").length;
		var cnt = $(":checkbox[name=nums]:checked").length;
		if(tot == cnt)$("#checkBoxs").prop("checked",true);
		else $("#checkBoxs").prop("checked",false);
	});
});	