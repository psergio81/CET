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


}
