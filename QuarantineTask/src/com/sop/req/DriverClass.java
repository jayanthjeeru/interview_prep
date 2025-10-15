package com.sop.req;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class DriverClass {
	public static void main(String[] args) {
		MeasurementData measurementData = new MeasurementData();
		measurementData.setObjectId("PORT-1-1-L1");
		measurementData.setMeasurementBaseTime("1234567");
		
		List<List<String>> measurements = new ArrayList<>();
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = new ArrayList<>();
		s1.add("1");
		s1.add("2");
		s1.add("3");
		
		s2.add("1");
		s2.add("2");
		s2.add("3");
		
		s3.add("1");
		s3.add("2");
		s3.add("3");
		
		measurements.add(s1);
		measurements.add(s2);
		measurements.add(s3);
		
		measurementData.setMeasurements(measurements);
		
		MeasurementDetails measurementDetails = new MeasurementDetails();
		
		List<String> measurementSchema = new ArrayList<>();
		measurementSchema.add("measurementRelativeTimeMs");
		measurementSchema.add("measurementRelativeTimeNs");
		measurementSchema.add("s1");
		measurementSchema.add("s2");
		measurementSchema.add("s3");
		measurementDetails.setMeasurementSchema(measurementSchema);
		
		List<MeasurementData> measurementDataList = new ArrayList<>();
		measurementDataList.add(measurementData);
		measurementDetails.setMeasurementData(measurementDataList);
		
		
		
		DataStream dataStream = new DataStream();
		Map<String, MeasurementDetails> measurementsMap = new HashMap<>();
		measurementsMap.put("sop", measurementDetails);
		dataStream.setMeasurementsMap(measurementsMap);
		
		String[] measurements1 = new String[1];
		measurements1[0] = "SOP";
		
		dataStream.setMeasurements(measurements1);
		
		Gson gson = new Gson();
		
		String finalString = gson.toJson(dataStream);
		
		System.out.println(finalString);
		
	}
}
