package com.wipro.pop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Prop {
	
	

	public static void main(String[] args) {
		

//		 FileInputStream reader=new FileInputStream("resources/1011.meta");  
//			Properties p=new Properties();
//			p.load(reader);
//			for(Object s : p.keySet())
//				System.out.println((String)s+" "+p.getProperty((String)s));
			
			
		String configFile = "resources/plugins.cfg";
		Properties properties = new Properties();
			
		try(InputStream is = new FileInputStream(configFile);
				) {
			
			
			properties.load(is);
			System.out.println(properties);
					 properties.setProperty("pluginstats", "{\"plugin1\":false2,\"plugin2\":t}");

					
			          
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try(OutputStream out = new FileOutputStream(configFile)) {
			  properties.store(out, null);
	            out.close();
			
			System.out.println(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		        
		  
			 
	}
	
	
	
	

}
