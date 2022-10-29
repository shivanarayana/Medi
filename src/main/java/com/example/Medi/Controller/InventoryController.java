package com.example.Medi.Controller;

import com.example.Medi.Service.InventoryService;
import com.univocity.parsers.csv.CsvParser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStream;
import java.util.List;

import static com.example.Medi.Constants.MediConstants.*;

@RestController
public class InventoryController {
//    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/Hello")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/uploadCSV")
    public String uploadData(@RequestParam("file")MultipartFile csvFile) throws Exception{
        System.out.println("Enter the dragon1");
        InputStream inputStream = csvFile.getInputStream();
        System.out.println("Enter the dragon2");
        CsvParserSettings settings = new CsvParserSettings();
        System.out.println("Enter the dragon3");
        settings.setHeaderExtractionEnabled(true);
        CsvParser csvParser = new CsvParser(settings);
        System.out.println("Enter the dragon4");
        List<Record> parseAllRecords = csvParser.parseAllRecords(inputStream);
        inventoryService.saveAll(parseAllRecords);
        return "UPLOAD SUCCESSFUL";
    }

}
