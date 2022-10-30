package com.example.Medi.Service;

import com.example.Medi.DTO.Inventory;
import com.example.Medi.Repository.InventoryRepository;
import com.univocity.parsers.common.record.Record;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
            if (record == null) break;
        }
//        logger.info("Records Saved");
//        return true;
    }

    private void saveInventory(Record record) {
        Inventory inventory = new Inventory();
        inventory.setCode(record.getString("code") == null ? "" : record.getString("code"));
        inventory.setName(record.getString("name") == null ? "" : record.getString("name"));
        inventory.setBatch(record.getString("batch") == null ? "" : record.getString("batch"));
        inventory.setStock(record.getInt("stock") == null ? 0 : record.getInt("stock"));
        inventory.setDeal(record.getInt("deal") == null ? 0 : record.getInt("deal"));
        inventory.setFree(record.getInt("free") == null ? 0 : record.getInt("free"));
        inventory.setMrp(record.getDouble("mrp") == null ? 0.0 : record.getDouble("mrp"));
        inventory.setRate(record.getDouble("rate") == null ? 0.0 : record.getDouble("rate"));
        inventory.setExp(record.getString("exp") == null ? "" : record.getString("exp"));
        inventory.setCompany(record.getString("company") == null ? "" : record.getString("company"));
        inventory.setSupplier(record.getString("supplier") == null ? "" : record.getString("supplier"));
        inventoryRepository.save(inventory);
    }

    public boolean isExpired(String exp) throws Exception{
        try {
            String[] arrExp = exp.split("/", 0);

            Calendar cal = Calendar.getInstance();
            int day = Integer.parseInt(arrExp[0]);
            int month = Integer.parseInt(arrExp[1]);
            int year = Integer.parseInt(arrExp[2]);
            int calenderYear = cal.get(Calendar.YEAR);
            int calenderMonth = cal.get(Calendar.MONTH) + 1;
            int calenderDay = cal.get(Calendar.DATE);

            if (year > calenderYear) {
                return false;
            }
            if (year == calenderYear) {
                if (month > calenderMonth) {
                    return false;
                }
                if (month == calenderMonth) {
                    if (day > calenderDay) {
                        return false;
                    }
                }
            }
        }
        catch(Exception e){
            return true;
        }
        return true;
    }

//    private String getRecordString(String str){
//        return record.getString() == null ? "" : record.getString("code")
//    }
}