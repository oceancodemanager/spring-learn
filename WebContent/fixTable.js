function fixTr(tableId, fixColumnNumber, width) {
	var oldtable = $("#" + tableId);
	var height  = oldtable.height();
    if ($("#" + tableId + "_tableLayout").length != 0) {
    	$("#" + tableId + "_tableLayout").before($("#" + tableId));
    	$("#" + tableId + "_tableLayout").empty();
    }else {
      $("#" + tableId).after("<div id='" + tableId + "_tableLayout' style='overflow:hidden;height:" + height + "px; width:" + width + "px;'></div>");
    }
    $('<div id="' + tableId + '_tableFix"></div>'
    + '<div id="' + tableId + '_tableHead"></div>'
    + '<div id="' + tableId + '_tableColumn"></div>'
    + '<div id="' + tableId + '_tableData"></div>').appendTo("#" + tableId + "_tableLayout");
   
    var tableFixClone = oldtable.clone(true);
    tableFixClone.attr("id", tableId + "_tableFixClone");
    $("#" + tableId + "_tableFix").append(tableFixClone);
    var tableHeadClone = oldtable.clone(true);
    tableHeadClone.attr("id", tableId + "_tableHeadClone");
    $("#" + tableId + "_tableHead").append(tableHeadClone);
    var tableColumnClone = oldtable.clone(true);
    tableColumnClone.attr("id", tableId + "_tableColumnClone");
    $("#" + tableId + "_tableColumn").append(tableColumnClone);
    $("#" + tableId + "_tableData").append(oldtable);
    $("#" + tableId + "_tableLayout table").each(function () {
      $(this).css("margin", "0");
    });
    var HeadHeight = $("#" + tableId + "_tableHead thead").height();
    HeadHeight += 2;
    $("#" + tableId + "_tableHead").css("height", HeadHeight);
    $("#" + tableId + "_tableFix").css("height", HeadHeight);
    var columnsWidth = 0;
    var columnsNumber = 0;
    $("#" + tableId + "_tableColumn tr:last td:lt(" + fixColumnNumber + ")").each(function () {
      columnsWidth += $(this).outerWidth(true);
      columnsNumber++;
    });
    columnsWidth += 2;
    if ($.browser.msie) {
      switch ($.browser.version) {
        case "7.0":
          if (columnsNumber >= 3) columnsWidth--;
          break;
        case "8.0":
          if (columnsNumber >= 2) columnsWidth--;
          break;
      }
    }
    $("#" + tableId + "_tableColumn").css("width", columnsWidth);
    $("#" + tableId + "_tableFix").css("width", columnsWidth);
    
    $("#" + tableId + "_tableData").scroll(function () {
      $("#" + tableId + "_tableHead").scrollLeft($("#" + tableId + "_tableData").scrollLeft());
      $("#" + tableId + "_tableColumn").scrollTop($("#" + tableId + "_tableData").scrollTop());
    });
    
    $("#" + tableId + "_tableFix").css({ "overflow": "hidden", "position": "relative", "z-index": "50", "background-color": "LightYellow" });
    $("#" + tableId + "_tableHead").css({ "overflow": "hidden", "width": width - 17, "position": "relative", "z-index": "45", "background-color": "LightYellow" });
    $("#" + tableId + "_tableColumn").css({ "overflow": "hidden", "height": height - 17, "position": "relative", "z-index": "40", "background-color": "LightYellow" });
    $("#" + tableId + "_tableData").css({ "overflow-x": "auto",  "overflow-y": "hidden","width": width, "height": height, "position": "relative", "z-index": "35" });
    
    if ($("#" + tableId + "_tableHead").width() > $("#" + tableId + "_tableFix table").width()) {
      $("#" + tableId + "_tableHead").css("width", $("#" + tableId + "_tableFix table").width());
      $("#" + tableId + "_tableData").css("width", $("#" + tableId + "_tableFix table").width() + 17);
    }
    
    if ($("#" + tableId + "_tableColumn").height() > $("#" + tableId + "_tableColumn table").height()) {
      $("#" + tableId + "_tableColumn").css("height", $("#" + tableId + "_tableColumn table").height());
      $("#" + tableId + "_tableData").css("height", $("#" + tableId + "_tableColumn table").height() + 17);
    }
    
    $("#" + tableId + "_tableFix").offset($("#" + tableId + "_tableLayout").offset());
    $("#" + tableId + "_tableHead").offset($("#" + tableId + "_tableLayout").offset());
    $("#" + tableId + "_tableColumn").offset($("#" + tableId + "_tableLayout").offset());
    $("#" + tableId + "_tableData").offset($("#" + tableId + "_tableLayout").offset());
    resetInputIds();
}
/**
 * 将用于锁列显示的其他几个table中的输入元素的id重新设置，不然页面和后台接受都有问题
 * 
 */
function resetInputIds(){
	$("table[id$='Clone']").find("input,select,textarea").each(function(){
		if($(this)[0].hasAttribute("id")){
			$(this).attr("id","tem_"+$(this).attr("id"));
		}
		if($(this)[0].hasAttribute("name")){
			$(this).attr("name","tem_"+$(this).attr("name"));
		}
	});
	//$("ul li:nth-child(2)"),$("ul li:nth-child(odd)"),$("ul li:nth-child(3n + 1)") 
	//batch_ev_table_tableHeadClone
	//batch_ev_table_tableFixClone
	//batch_ev_table_tableColumnClone
}