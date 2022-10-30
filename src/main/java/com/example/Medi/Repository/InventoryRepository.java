package com.example.Medi.Repository;

import com.example.Medi.DTO.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
    @Query(value = "SELECT * FROM Inventory WHERE company = ?1 or supplier = ?1 and stock>0", nativeQuery = true)
    List<Inventory> findProductBySupplierIdOrSupplierName(@Param("supplierNameOrId") String supplierNameOrId);
}
