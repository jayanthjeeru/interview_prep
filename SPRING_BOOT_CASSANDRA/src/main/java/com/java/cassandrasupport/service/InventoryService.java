package com.java.cassandrasupport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.stereotype.Service;

import com.java.cassandrasupport.entity.Inventory;
import com.java.cassandrasupport.repo.InventoryRepo;

@Service
public class InventoryService {
	
	
	
	@Autowired
	InventoryRepo invRepo;

	
	
	
	public Inventory writeIntoDB(Inventory inv) {
		
		Inventory res = null;
		
		try {
			res = invRepo.insert(inv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<Inventory> getInventoryFromDBWithNeid(long neid) {

		return invRepo.findByKeyDeviceId(neid);
	}
	
	
	public List<Map<String, String>> getInventoryFromDBWithFilter(long neid, String modelName) {
		
		
		
		return invRepo.findByKeyDeviceIdAndModelName(neid, modelName).stream()
				.map(i -> {
					Map<String, String> map = new HashMap<>();
					map.put(i.getKey().getElementPath(), i.getElementValue());
					return map;
				}).collect(Collectors.toList());
		
	}
	
	
	public List<String> getEquipmentData(long neid) {
		
		List<Map<String, String>> invData = getInventoryFromDBWithFilter(neid, "openconfig-platform");
		
		List<String> finalResult = null;
		
		try {
			finalResult = invData.stream()
					.filter(row -> row.keySet().stream()
							.anyMatch(key -> key.contains("//card/") || key.contains("//shelf/")))
					.map(row -> (String) row.values().iterator().next()).collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return finalResult;
	}
	
	public List<String> getPortData(long neid) {

		List<Map<String, String>> invData = getInventoryFromDBWithFilter(neid, "openconfig-platform");

		List<String> finalResult = null;

		try {
			finalResult = invData.stream().filter(row -> row.keySet().stream().anyMatch(key -> key.contains("//port/")))
					.map(row -> (String) row.values().iterator().next()).collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return finalResult;
	}
	
	
	public boolean deleteInventoryData(long neid) {
		
		return invRepo.deleteByKeyDeviceId(neid);
	}
	
	public boolean deleteInventoryDataForInvChange(long neid, String component) {
		
		List<Inventory> inv = invRepo.findByKeyDeviceId(neid);
		
		List<String> childComponents = new ArrayList<>();
		
		for(Inventory in : inv) {
			
			
			String elemPath = in.getKey().getElementPath();
			if(component.toLowerCase().contains("chassis") && (elemPath.contains("//shelf/") || elemPath.contains("//card/") || elemPath.contains("//port/"))) {
				String inpIndex = component.strip().split("-")[1];
				
			
				if(elemPath.split("/")[elemPath.split("/").length-1].split("-")[1].equals(inpIndex)) {
					childComponents.add(elemPath);
				}
			} else if(component.toLowerCase().contains("card") && (elemPath.contains("//card/") || elemPath.contains("//port/"))) {
				String cardinpIndex1 = component.strip().split("-")[1];
				String cardinpIndex2 = component.strip().split("-")[2];
				
				if(elemPath.split("/")[elemPath.split("/").length-1].split("-")[1].equals(cardinpIndex1) && elemPath.split("/")[elemPath.split("/").length-1].split("-")[2].equals(cardinpIndex2)) {
					childComponents.add(elemPath);
				}
			}
		}
		
		return deleteChildrenWithBatch(neid, childComponents);
	}
	
	
	public boolean deleteChildrenWithBatch(long deviceId, List<String> childrenPaths) {
        

        for (String path : childrenPaths) {
            
        	invRepo.deleteByKeyDeviceIdAndKeyElementPath(deviceId, path);
        }

        return true;
    }
	
	public boolean updateInvAttributes(long deviceId, String component, String attributeKey, String attributeValue) {
		
		String path = "";
		
		if (component.toLowerCase().contains("chassis")) {
			path = path + "systemid/NETCONF//ne/" + deviceId + "//shelf/" + component;
		} else if (component.toLowerCase().contains("card")) {
			path = path + "systemid/NETCONF//ne/" + deviceId + "//card/" + component;
		} else if (component.toLowerCase().contains("port")) {
			path = path + "systemid/NETCONF//ne/" + deviceId + "//port/" + component;
		}
		
		Inventory inv = invRepo.findByKeyDeviceIdAndKeyElementPath(deviceId, path);
		
		inv.setModelName(inv.getModelName()+"modified");
		
		invRepo.save(inv);
		
		return true;
	}
	
}
