package br.com.cet.util;

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

}
