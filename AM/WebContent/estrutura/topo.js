window.onload=function(){
	
	setInterval(hora,1000);
	setInterval(data,1000);
};

function hora(){
	
	var data = new Date();
	$("#horah5").html("<h5>"+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds()+"</h5>");
}
function data(){
	
	var data = new Date();
	
	var dias =["Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"];
	var meses = ["Janeiro","Fevereiro","Março","Abril","Maio","Junho",
	             "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];
	
	
	
	$("#datah5").html("<h5>"+dias[data.getDay()]+", "
								+data.getDate()+" de "
								+meses[(data.getMonth())]+" de "
								+data.getFullYear()
			+"</h5>");
	
	
}
