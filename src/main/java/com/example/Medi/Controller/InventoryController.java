package com.example.Medi.Controller;

import com.example.Medi.DTO.Inventory;
import com.example.Medi.Repository.InventoryRepository;
import com.example.Medi.Service.InventoryService;
import com.univocity.parsers.csv.CsvParser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStream;
import java.util.*;

import static com.example.Medi.Constants.MediConstants.*;

@RestController
public class InventoryController {
//    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryService inventoryService;

    @Autowired
    InventoryRepository inventoryRepository;

    //  /{name:[a-zA-Z &+-]*}
    @GetMapping("/hasStock")
    @ResponseBody
    public List<String> findProductsInStock(@RequestParam String supplierNameOrId) {
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            inventoryList = inventoryRepository.findProductBySupplierIdOrSupplierName(supplierNameOrId);
            List<String> productsList = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                if (!productsList.contains(inventory.getName()))
                    productsList.add(inventory.getName());
            }
            return productsList;
        } catch (Exception e) {
            List<String> productResponse = Arrays.asList("Records Not Found", "Please Recheck the Name/Id");
            return productResponse;
        }
    }

    @PostMapping(PRODUCTS_THAT_DID_NOT_EXPIRE)
    @ResponseBody
    public List<String> findProductsNotExpired(@RequestBody List<String> supplierNameOrIdList) {
        List<String> productsList = new ArrayList<>();
        for (String supplierNameOrId : supplierNameOrIdList) {
            List<Inventory> inventoryList = new ArrayList<>();
            try {
                inventoryList = inventoryRepository.findProductBySupplierIdOrSupplierName(supplierNameOrId);
                for (Inventory inventory : inventoryList) {
                    if (!inventoryService.isExpired(inventory.getExp())) {
                        if (!productsList.contains(inventory.getName()))
                            productsList.add(inventory.getName());
                    }
                }
            } catch (Exception e) {
                List<String> productResponse = Arrays.asList(e.toString(),"Records Not Found", "Please Recheck the Name/Id");
                return productResponse;
            }
        }
        return productsList;
    }
//    @GetMapping(FILTER_PRODUCT_NAME)

    @PostMapping(LOAD_CSV_FILE)
    public String uploadData(@RequestParam("file") MultipartFile csvFile) throws Exception {
        InputStream inputStream = csvFile.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        CsvParser csvParser = new CsvParser(settings);
        List<Record> parseAllRecords = csvParser.parseAllRecords(inputStream);
        inventoryService.saveAll(parseAllRecords);
        return "UPLOAD SUCCESSFUL";
    }
}
