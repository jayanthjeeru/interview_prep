package com.java.cassandrasupport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.cassandrasupport.dto.InventoryDto;
import com.java.cassandrasupport.entity.Inventory;
import com.java.cassandrasupport.entity.InventoryKey;
import com.java.cassandrasupport.service.InventoryService;

@RestController
public class InventoryController {
	
	
	
	@Autowired
	InventoryService invService;
	
	
	@GetMapping("/getinv/{neid}")
	public List<Inventory> getInvByNeid(@PathVariable long neid) {
		return invService.getInventoryFromDBWithNeid(neid);
	}

	@PostMapping("/storeinv/{neid}/{fdn}/{value}/{type}")
	public Inventory storeInvByNeid(@PathVariable long neid, @PathVariable String fdn, @PathVariable String value, @PathVariable String type) {
		Inventory inv = new Inventory(new InventoryKey(neid,fdn),1212l,value,type);
		
		return invService.writeIntoDB(inv);
	}
	
	@PostMapping("/storeinv")
	public Inventory storeInv(@RequestBody InventoryDto inventoryDto) {
		
		
		Inventory inv = new Inventory(new InventoryKey(inventoryDto.getDeviceId(), inventoryDto.getElementPath()),
				inventoryDto.getTimeStamp(), inventoryDto.getModelName(), inventoryDto.getElementValue());
		
		return invService.writeIntoDB(inv);
		
	}
	
	@GetMapping("/getequipinv/{neid}")
	public List<String> getEquipInvByNeid(@PathVariable long neid) {
		return invService.getEquipmentData(neid);
	}
	
	@GetMapping("/getportinv/{neid}")
	public List<String> getPortInvByNeid(@PathVariable long neid) {
		return invService.getPortData(neid);
	}
	
	@DeleteMapping("/deleteinv/{neid}")
	public boolean deleteInvByNeid(@PathVariable long neid) {
		return invService.deleteInventoryData(neid);
	}
	
	@DeleteMapping("/deleteinv/{neid}/{component}")
	public boolean deleteInvByNeid(@PathVariable long neid, @PathVariable String component) {
		return invService.deleteInventoryDataForInvChange(neid, component);
	}
	
	@PutMapping("/updateinv/{neid}/{component}")
	public void updateInvData(@PathVariable long neid, @PathVariable String component) {
		invService.updateInvAttributes( neid, component, null, null);
	}
	
}
