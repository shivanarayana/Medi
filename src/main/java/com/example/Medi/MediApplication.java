package com.example.Medi;

import com.example.Medi.DTO.Inventory;
import com.example.Medi.Service.InventoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MediApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediApplication.class, args);
    }

}