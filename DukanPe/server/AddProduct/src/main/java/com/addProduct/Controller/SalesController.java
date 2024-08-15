package com.addProduct.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.addProduct.Model.Sales;
import com.addProduct.Service.SalesService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController { 
	
    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
        Sales createdSale = salesService.createSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSale);
    }

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = salesService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Long id) {
        Optional<Sales> sale = salesService.getSaleById(id);
        return sale.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Sales>> getSalesByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Sales> sales = salesService.getSalesByDate(date);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/item/{itemName}")
    public ResponseEntity<List<Sales>> getSalesByItemName(@PathVariable String itemName) {
        List<Sales> sales = salesService.getSalesByItemName(itemName);
        return ResponseEntity.ok(sales);
    }
}


