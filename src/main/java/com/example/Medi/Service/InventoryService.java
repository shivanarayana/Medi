package com.example.Medi.Service;

import com.example.Medi.DTO.Inventory;
import com.example.Medi.Repository.InventoryRepository;
import com.univocity.parsers.common.record.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InventoryService {
    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    InventoryRepository inventoryRepository;

    public boolean saveAll(List<Record> parseAllRecords) {
        parseAllRecords.forEach(record -> {
            if(record != null) {
                saveInventory(record);
            }
        });
        logger.info("Records Saved");
        return true;
    }

    private void saveInventory(Record record) {
        Inventory inventory = new Inventory();
        inventory.setCode(record.getString("code"));
        inventory.setName(record.getString("name"));
        inventory.setBatch(record.getString("batch"));
        inventory.setStock(record.getInt("stock"));
        inventory.setDeal(record.getInt("deal"));
        inventory.setFree(record.getInt("free"));
        inventory.setMrp(record.getDouble("mrp"));
        inventory.setRate(record.getDouble("rate"));
        inventory.setExp(record.getString("exp"));
        inventory.setCompany(record.getString("company"));
        inventory.setSupplier(record.getString("supplier"));
        inventoryRepository.save(inventory);
    }
}
