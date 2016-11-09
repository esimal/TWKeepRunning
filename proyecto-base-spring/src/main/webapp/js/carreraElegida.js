$(document).ready(function(){
	    	
	$("#recorrido").hide();
	$("#reglamento").hide();
	    	
	$("#btnDescripcion").click(function(){
		$("#descripcion").show();
		$("#recorrido").hide();
		$("#reglamento").hide();
	});
	$("#btnRecorrido").click(function(){
		$("#descripcion").hide();
		$("#recorrido").show();
		$("#reglamento").hide();
	});
	$("#btnReglamento").click(function(){
		$("#descripcion").hide();
		$("#recorrido").hide();
		$("#reglamento").show();
	});
});