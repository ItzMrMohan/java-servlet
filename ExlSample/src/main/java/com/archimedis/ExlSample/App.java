package com.archimedis.ExlSample;

import org.json.simple.JSONObject;

/**
 * Hello world!
 *
 */
public class App
{

		public static void main( String[] args )throws ArrayIndexOutOfBoundsException{
			
			try {
				String one= args[0];
		    	String two= args[1];
		    	
		    	
		    	try {
		    		
					JSONObject abc= Logic.excelJson(one, two, 0, 1);
					System.out.println(abc);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		    	
		    	
		    }catch(Exception e){
				System.out.println("Pass the Excel File Has Argument1 and the Sheet has Argument2");
			}
			
	    	
	    }
	
    
}
