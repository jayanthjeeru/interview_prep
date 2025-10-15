package com.java.cassandrasupport.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.cassandrasupport.entity.Inventory;
import com.java.cassandrasupport.entity.InventoryKey;

@Repository
public interface InventoryRepo extends CassandraRepository<Inventory, InventoryKey> {
	
	
	 List<Inventory> findByKeyDeviceId(long deviceId);
	 
	 boolean deleteByKeyDeviceId(long deviceId);
	 
	 boolean deleteByKeyDeviceIdAndKeyElementPath(long deviceId, String elementPath);
	 
	 Inventory findByKeyDeviceIdAndKeyElementPath(long deviceId, String elementPath);
	 
	 @Query("SELECT elementPath, elementValue FROM deviceinventory.devinventory WHERE \"deviceId\" = :deviceId AND modelname = :modelname")
	 public List<Map<String, Object>> getInventoryFromDBWithFilter(@Param("deviceId") long deviceId, @Param("modelname") String modelname);
	 
	 @Query("SELECT * FROM devinventory WHERE \"deviceId\" = :deviceId AND modelname = :modelname ALLOW FILTERING")
	 List<Inventory> findByKeyDeviceIdAndModelName(long deviceId, String modelname);
	 
	 


}
