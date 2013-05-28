package br.com.cet.util;

public class UtString {

	/**
	 * Metodo que verifica se uma string eh nula ou vazia
	 * @param string
	 * @return
	 */
	public static boolean isNullOrEmpty(String string){
		
		if(string == null || string.equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
	public static boolean equals(String stringA, String ... stringB){
		
		if(isNullOrEmpty(stringA)){
			return false;
		}
		
		for (String string : stringB) {
			if(!stringA.equals(string)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
	public static boolean equalsIgnoreCase(String stringA, String ... stringB){
		
		if(isNullOrEmpty(stringA)){
			return false;
		}
		
		for (String string : stringB) {
			if(!stringA.equalsIgnoreCase(string)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
	public static boolean equalsOR(String stringA, String ... stringB){
		
		if(isNullOrEmpty(stringA)){
			return false;
		}
		
		for (String string : stringB) {
			if(stringA.equals(string)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
	public static boolean equalsORIgnoreCase(String stringA, String ... stringB){
		
		if(isNullOrEmpty(stringA)){
			return false;
		}
		
		for (String string : stringB) {
			if(stringA.equalsIgnoreCase(string)){
				return true;
			}
		}
		return false;
	}
	
	public static String formataNumeroZeroEsquerda(int qtdCasas, int numero){
		
		String formato = "%0"+qtdCasas+"d";
		
		return String.format(formato, numero); 
	}
	
}
