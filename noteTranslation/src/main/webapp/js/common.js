

function openNewWindow(url, window_title, width, height){
	let windowFeatures = "";
	if(!width && !height){
		windowFeatures = 'scrollbars=yes, width=400, height=400, resizable=yes';
	}else{
		windowFeatures = 'scrollbars=yes, width='+width+', height='+height+', resizable=yes';
	}
	window.open(url, window_title, windowFeatures);
}




