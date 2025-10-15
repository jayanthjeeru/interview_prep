package com.commonadapterfw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class SopProducerFileFetch {
	public static void main(String[] args) {
		try {
			String key = null;
			int cc=0;
			for (int neid = 110; neid <= 110; neid++) {

				for (int portNum = 5; portNum <= 5; portNum++) {

					int recordgroup = 1;
					BufferedReader bread = new BufferedReader(
							new InputStreamReader(new FileInputStream(new File("101_PORT-1-1-1_dataset.json"))));
					String content = null;
					int numOfRecords = 0;
					StringBuilder nedata = new StringBuilder();
					
					JSONArray ja = new JSONArray();

					while ((content = bread.readLine()) != null) {


						if (numOfRecords == 50) {

							nedata = new StringBuilder();
							JSONObject finalMessage = new JSONObject();
							finalMessage.put("NotifList", ja);
							
							System.out.println(finalMessage);
							cc++;
							ja = new JSONArray();
							
							numOfRecords = 0;
						}

						if (recordgroup == 43) {
							nedata.append(content);
							recordgroup = 1;
							
							ja.put(new JSONObject(nedata.toString()));

							numOfRecords++;
							nedata = new StringBuilder();
						} else {
							nedata.append(content);
							++recordgroup;
						}
					}
					
					if(!ja.isEmpty()) {
						JSONObject finalMessage = new JSONObject();
						finalMessage.put("NotifList", ja);
						cc++;
						System.out.println(ja.length());
					}
				}

			}
			System.out.println(cc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
