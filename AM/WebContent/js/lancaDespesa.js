
function validaData(){
	
	
	
	dataValorCampo = $("#idDataDespesa");
	
	dateCampo = new Date(dataValorCampo.val());
	
	
	dataHoje = new Date();
	
	console.log(dateCampo);
	console.log(dataHoje);
	
	if (dateCampo>dataHoje){
		
		alert("Data n�o pode ser maior que atual");
		
	}
}


$(document).ready(alert("sdsd"));