
function irParaCrud(codigo){
	
	var id = codigo;
	var action = codigo.substring(1,codigo.length);
	var inicial = codigo.substring(0,1).toUpperCase();
	action = inicial+action;
	
	$('#'+id).attr("action",action+"Action!crud.action");
	$('#'+id).submit();
	
}

function irParaBrowser(codigo){
	
	var id = codigo;
	var action = codigo.substring(1,codigo.length);
	var inicial = codigo.substring(0,1).toUpperCase();
	action = inicial+action;
	
	$('#'+id).attr("action",action+"Action!browser.action");
	$('#'+id).submit();
	
}

function irParaPrincipal(codigo){
	
	var id = codigo;
	var action = codigo.substring(1,codigo.length);
	var inicial = codigo.substring(0,1).toUpperCase();
	action = inicial+action;

	$('#'+id).attr("action",action+"Action!crud.action?ac=principal");
	$('#'+id).submit();
}

function buscaProximoCampo(){
	
	$('.required').each(function(i,obj){

		if(this.value == ''){
			
			this.focus();
			return false;
		}
		
	});
}

function formataZero(numero, tamanho){
	
	numero = numero.toString();
	
	while(numero.length < tamanho){
		numero = "0"+numero;
	}
	
	return numero;
}
