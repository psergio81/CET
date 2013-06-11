
function irParaCrud(codigo){
	
	var id = codigo;
	var action = codigo.substring(1,codigo.length);
	var inicial = codigo.substring(0,1).toUpperCase();
	action = inicial+action;
	
	$('#'+id).attr("action",action+"Action!crud.action");
	$('#'+id).submit();
	
}

/* Brazilian initialisation for the jQuery UI date picker plugin. */
/* Written by Leonildo Costa Silva (leocsilva@gmail.com). */
jQuery(function($){
        $.datepicker.regional['pt-BR'] = {
                closeText: 'Fechar',
                prevText: '&#x3c;Anterior',
                nextText: 'Pr&oacute;ximo&#x3e;',
                currentText: 'Hoje',
                monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
                'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
                'Jul','Ago','Set','Out','Nov','Dez'],
                dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado'],
                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
                dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
                weekHeader: 'Sm',
                dateFormat: 'dd/mm/yy',
                firstDay: 0,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''};
        $.datepicker.setDefaults($.datepicker.regional['pt-BR']);
});

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
	
	var elementos = $('.required');
	var retorno  = true;
	
	for ( var i = 0; i < elementos.length; i++) {
		if(elementos[i].value == ''){
			retorno =  false;
			break;
		}
	}
	
	return retorno;
}

function formataZero(numero, tamanho){
	
	numero = numero.toString();
	
	while(numero.length < tamanho){
		numero = "0"+numero;
	}
	
	return numero;
}


function setDataAtual(campo){
	
	var campoDesabilitado = $('#'+campo).is(':disabled');
    
    if(campoDesabilitado){
        return;
    }
	
     var data = new Date();
     var dia = data.getDate();
     var mes = data.getUTCMonth()+1;
     var ano = data.getUTCFullYear();
     
     if(dia < 10){
         dia = "0"+dia;  
     }
     
     if(mes < 10){
         mes = "0"+mes;
     }
     
     var dataFinal = dia+"/"+mes+"/"+ano;
     
     $('#'+campo).val(dataFinal);
	
}

function setHoraAtual(idCampo){
	
    
    var campoDesabilitado = $('#'+idCampo).is(':disabled');
    
    if(campoDesabilitado){
        return;
    }
    
    var data = new Date();
    var hora = data.getHours();
    var minuto = data.getMinutes();
    
    if(hora < 10){
        hora = "0"+hora;
    }
    if(minuto < 10){
        minuto = "0"+minuto;
    }
    
    hora = hora+":"+minuto; 
    $('#'+idCampo).val(hora);
	
}



$(document).ready(function(){
	
	$('.maiusculo').focusout(function(){
	    this.value = this.value.toUpperCase();
	});
	
	$('.data').datepicker({dateFormat: 'dd/mm/yy'});
	
	var mensagem = $('#mensagemErro').val();
	
	if(mensagem != null && mensagem != ''){
		$('#mensagem').html(mensagem);
		$('#modalMensagem').modal('show');
	}
	
	$('.dropdown-toggle').dropdown();
});


jQuery.validator.addMethod("cpf", function(value, element) {
   value = jQuery.trim(value);
	
	value = value.replace('.','');
	value = value.replace('.','');
	cpf = value.replace('-','');
	while(cpf.length < 11) cpf = "0"+ cpf;
	var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
	var a = [];
	var b = new Number;
	var c = 11;
	for (var  i=0; i<11; i++){
		a[i] = cpf.charAt(i);
		if (i < 9) b += (a[i] * --c);
	}
	if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }
	b = 0;
	c = 11;
	for (var y=0; y<10; y++) b += (a[y] * c--);
	if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }
	
	var retorno = true;
	if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) retorno = false;
	
	return this.optional(element) || retorno;

}, "Informe um CPF válido."); 

jQuery.validator.addMethod("dateBR", function(value, element) {
	 //contando chars
	if(value.length!=10) return false;
	// verificando data
	var data 		= value;
	var dia 		= data.substr(0,2);
	var barra1		= data.substr(2,1);
	var mes 		= data.substr(3,2);
	var barra2		= data.substr(5,1);
	var ano 		= data.substr(6,4);
	if(data.length!=10||barra1!="/"||barra2!="/"||isNaN(dia)||isNaN(mes)||isNaN(ano)||dia>31||mes>12)return false;
	if((mes==4||mes==6||mes==9||mes==11) && dia==31)return false;
	if(mes==2  &&  (dia>29||(dia==29 && ano%4!=0)))return false;
	if(ano < 1900)return false;
	return true;
}, "Informe uma data válida"); 

jQuery.validator.addMethod("dateTimeBR", function(value, element) {
	 //contando chars
	if(value.length!=16) return false;
	 // dividindo data e hora
	if(value.substr(10,1)!=' ') return false; // verificando se há espaços
	var arrOpcoes = value.split(' ');
	if(arrOpcoes.length!=2) return false; // verificando a divisão de data e hora
	// verificando data
	var data 		= arrOpcoes[0];
	var dia 		= data.substr(0,2);
	var barra1		= data.substr(2,1);
	var mes 		= data.substr(3,2);
	var barra2		= data.substr(5,1);
	var ano 		= data.substr(6,4);
	if(data.length!=10||barra1!="/"||barra2!="/"||isNaN(dia)||isNaN(mes)||isNaN(ano)||dia>31||mes>12)return false;
	if ((mes==4||mes==6||mes==9||mes==11) && dia==31)return false;
	if (mes==2  &&  (dia>29||(dia==29 && ano%4!=0)))return false;
	// verificando hora
	var horario 	= arrOpcoes[1];
	var	hora 		= horario.substr(0,2);
	var doispontos 	= horario.substr(2,1);
	var minuto 		= horario.substr(3,2);
	if(horario.length!=5||isNaN(hora)||isNaN(minuto)||hora>23||minuto>59||doispontos!=":")return false;
	return true;
}, "Informe uma data e uma hora válida");	



jQuery.validator.addMethod("timeBR", function(value, element) {
	 //contando chars
	if(value.length!=5) return false;
	
	// verificando hora
	var horario 	= value;
	var	hora 		= horario.substr(0,2);
	var doispontos 	= horario.substr(2,1);
	var minuto 		= horario.substr(3,2);
	if(horario.length!=5||isNaN(hora)||isNaN(minuto)||hora>23||minuto>59||doispontos!=":")return false;
	return true;
}, "Informe uma hora v&aacute;lida");



/*
 *
 * NOVO METODO PARA O JQUERY VALIDATE
 * VALIDA CNPJ COM 14 OU 15 DIGITOS
 * A VALIDAÃ‡ÃƒO Ã‰ FEITA COM OU SEM OS CARACTERES SEPARADORES, PONTO, HIFEN, BARRA
 *
 * ESTE MÉTODO FOI ADAPTADO POR:
 * 
 * Shiguenori Suguiura Junior <junior@dothcom.net>
 * 
 * http://blog.shiguenori.com
 * http://www.dothcom.net
 * 
 */
jQuery.validator.addMethod("cnpj", function(cnpj, element) {
   cnpj = jQuery.trim(cnpj);
	
	// DEIXA APENAS OS NÚMEROS
   cnpj = cnpj.replace('/','');
   cnpj = cnpj.replace('.','');
   cnpj = cnpj.replace('.','');
   cnpj = cnpj.replace('-','');

   var numeros, digitos, soma, i, resultado, pos, tamanho, digitos_iguais;
   digitos_iguais = 1;

   if (cnpj.length < 14 && cnpj.length < 15){
      return this.optional(element) || false;
   }
   for (i = 0; i < cnpj.length - 1; i++){
      if (cnpj.charAt(i) != cnpj.charAt(i + 1)){
         digitos_iguais = 0;
         break;
      }
   }

   if (!digitos_iguais){
      tamanho = cnpj.length - 2
      numeros = cnpj.substring(0,tamanho);
      digitos = cnpj.substring(tamanho);
      soma = 0;
      pos = tamanho - 7;

      for (i = tamanho; i >= 1; i--){
         soma += numeros.charAt(tamanho - i) * pos--;
         if (pos < 2){
            pos = 9;
         }
      }
      resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
      if (resultado != digitos.charAt(0)){
         return this.optional(element) || false;
      }
      tamanho = tamanho + 1;
      numeros = cnpj.substring(0,tamanho);
      soma = 0;
      pos = tamanho - 7;
      for (i = tamanho; i >= 1; i--){
         soma += numeros.charAt(tamanho - i) * pos--;
         if (pos < 2){
            pos = 9;
         }
      }
      resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
      if (resultado != digitos.charAt(1)){
         return this.optional(element) || false;
      }
      return this.optional(element) || true;
   }else{
      return this.optional(element) || false;
   }
}, "Informe um CNPJ válido."); 
 






