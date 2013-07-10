package br.com.cet.util;

import java.util.Collection;



public class UtCollection {

	
	public static boolean isNullOrEmpty(Collection<?> collection) {
		
		if(collection == null || collection.size() == 0){
			return true;
		}
		
		return false;
	}
	
}
