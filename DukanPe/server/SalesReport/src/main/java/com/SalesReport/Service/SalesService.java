package com.SalesReport.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.SalesReport.Model.Sales;

public interface SalesService {

    Sales createSale(Sales sale);

    List<Sales> getAllSales();

    Optional<Sales> getSaleById(Long id);

    List<Sales> getSalesByDate(LocalDate date);

    List<Sales> getSalesByItemName(String itemName);

}
