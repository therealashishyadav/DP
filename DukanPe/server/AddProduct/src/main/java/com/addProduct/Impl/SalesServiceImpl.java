package com.addProduct.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addProduct.Model.Sales;
import com.addProduct.Repository.SalesRepository;
import com.addProduct.Service.SalesService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public Sales createSale(Sales sale) {
        return salesRepository.save(sale);
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Optional<Sales> getSaleById(Long id) {
        return salesRepository.findById(id);
    }

    @Override
    public List<Sales> getSalesByDate(LocalDate date) {
        return salesRepository.findBySaleDate(date);
    }

    @Override
    public List<Sales> getSalesByItemName(String itemName) {
        return salesRepository.findByItemName(itemName);
    }
}
