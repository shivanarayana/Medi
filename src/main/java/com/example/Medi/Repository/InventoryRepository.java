package com.example.Medi.Repository;

import com.example.Medi.DTO.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
