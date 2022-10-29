package com.example.Medi.Service;

import com.example.Medi.DTO.Inventory;
import com.example.Medi.Repository.InventoryRepository;
import com.univocity.parsers.common.record.Record;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InventoryService {
//    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    InventoryRepository inventoryRepository;

    public void saveAll(List<Record> parseAllRecords) {

        for (Record record : parseAllRecords) {
            saveInventory(record);
            if(record==null) break;
        }
        System.out.println("Enter the dragon5");

//        logger.info("Records Saved");
//        return true;
    }

    private void saveInventory(Record record) {
        Inventory inventory = new Inventory();
        inventory.setCode(Optional.ofNullable(record.getString("code")).toString());
        inventory.setName(Optional.ofNullable(record.getString("name")).toString());
        inventory.setBatch(Optional.ofNullable(record.getString("batch")).toString());
        inventory.setStock(Optional.ofNullable(record.getString("stock")).toString());
        inventory.setDeal(Optional.ofNullable(record.getInt("deal")).toString());
        inventory.setFree(Optional.ofNullable(record.getInt("free")).toString());
        inventory.setMrp(Optional.ofNullable(record.getDouble("mrp")).toString());
        inventory.setRate(Optional.ofNullable(record.getDouble("rate")).toString());
        inventory.setExp(Optional.ofNullable(record.getString("exp")).toString());
        inventory.setCompany(Optional.ofNullable(record.getString("company")).toString());
        inventory.setSupplier(Optional.ofNullable(record.getString("supplier")).toString());
        inventoryRepository.save(inventory);
    }
}