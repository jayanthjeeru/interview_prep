package filereaderandwriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVFetchingLogic {
	
	

		public static void parseExternalLinksFromCsv() {
			 String filePath = "C:\\Users\\jayreddy\\Documents\\STS_WORKSPACE\\filereaderandwriter\\topology.csv";
		        List<Map<String, String>> externalDiscoveryAttributes = new ArrayList<>();
		        try {
		            readContentFromFile(filePath, externalDiscoveryAttributes);
		            System.out.println(externalDiscoveryAttributes);
		            
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}

	    public static void main(String[] args) {
	    	
	    	parseExternalLinksFromCsv();
	    }

	    

		public static void readContentFromFile(String filePath, List<Map<String, String>> externalDiscoveryAttributes) throws IOException {
	 
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            int count = 1;
	            List<String> attributes = new ArrayList<>();
	            while ((line = reader.readLine()) != null) {
	            	int attributeCount = 0;
	            	Map<String, String> externalDiscoveryLink = new HashMap<>();
	            	if(count == 1) {
	            		for(String attribute : line.split(",")) {
	            			attributes.add(attribute);
	            		}
	            	} else {
	            		for(String value : line.split(",")) {
	            			externalDiscoveryLink.put(attributes.get(attributeCount++), value);
	            			
	            		}
	            		externalDiscoveryAttributes.add(externalDiscoveryLink);
	            	}
	            		
	                System.out.println(line);
	                count++;
	            }
	        }
	    }
	    
	   
	


}
