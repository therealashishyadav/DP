package com.SalesReport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SalesReport.Model.Sales;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findBySaleDate(LocalDate date);

    List<Sales> findByItemName(String itemName);
}
