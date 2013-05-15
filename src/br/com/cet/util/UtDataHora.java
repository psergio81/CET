package br.com.cet.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class UtDataHora {

	
	public static String getDataAtual(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar calendar = new GregorianCalendar();
		
		return dateFormat.format(calendar.getTimeInMillis());
	}

	public static String getHoraAtual(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		GregorianCalendar calendar = new GregorianCalendar();
		
		return dateFormat.format(calendar.getTimeInMillis());
	}

	public static int dataToInteiro(String horaCompleta){
		if(UtString.isNullOrEmpty(horaCompleta)){
			return 0;
		}
		
		if(horaCompleta.indexOf(":") == -1){
			return 0;
		}
		
		int segundos = 0;
		int minuto = 0;
		int hora = 0;

		hora = UtConverte.stringToInteiro(horaCompleta.substring(0, horaCompleta.indexOf(":")));
		horaCompleta = horaCompleta.substring(horaCompleta.indexOf(":")+1, horaCompleta.length());
		
		if(horaCompleta.indexOf(":") == -1){
			minuto = UtConverte.stringToInteiro(horaCompleta.substring(0, horaCompleta.length()));
			horaCompleta = "";
		}else{
			minuto = UtConverte.stringToInteiro(horaCompleta.substring(0, horaCompleta.indexOf(":")));
			horaCompleta = horaCompleta.substring(horaCompleta.indexOf(":")+1, horaCompleta.length());
		}
	
		segundos = UtConverte.stringToInteiro(horaCompleta);
		
		if(hora == 24 && (minuto > 0 || segundos > 0) && (hora > 23 || minuto > 59 || segundos > 59)){
			return 0;
		}
		
		return hora * 3600 + minuto * 60 + segundos;
	}
	
	
	public static String segundosInteiroToStringHora(int horaInteiro){
		
		int hora = horaInteiro / 3600;
		int minuto = (horaInteiro % 3600) / 60;
		
		String horaString = String.valueOf(hora);
		
		if (hora < 10) {
			horaString = "0"+horaString;
		}
		
		String minutoString = String.valueOf(minuto);
		if(minuto < 10){
			minutoString = "0"+minutoString;
		}
		
		return horaString.concat(":").concat(minutoString);
	}

}
