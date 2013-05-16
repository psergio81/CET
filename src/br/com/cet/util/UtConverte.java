package br.com.cet.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UtConverte extends UtString{

	
	/**
	 * Metodo para converter uma string numerica em um numero inteiro
	 * @param stringNumero
	 * @return
	 */
	public static int stringToInteiro(String stringNumero){
		
		try {

			if(isNullOrEmpty(stringNumero)){
				return 0;
			}
			
			return Integer.parseInt(stringNumero);
			
		} catch (Exception e) {
			return 0;
		}
	}

	public static int longToInteiro(long numero){

		return Integer.valueOf(String.valueOf(numero));
			
	}
	
	public static Date dataStringToDateSql(String data){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");     
		
		Date dataSQL = null;
		
		try {
			
			if(!UtString.isNullOrEmpty(data)){
			
				dataSQL = new Date(sdf.parse(data).getTime());
			
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataSQL;
		
	}
	
	
	public static String dateSqlTodataString(Date data){
		
		SimpleDateFormat formato;
		String dataString = "";
		
		if(data == null){
			return "";
		}
		
		formato = new SimpleDateFormat("dd/MM/yyyy");  
        dataString = formato.format(data);  
        
		return dataString;
		
	}

}
