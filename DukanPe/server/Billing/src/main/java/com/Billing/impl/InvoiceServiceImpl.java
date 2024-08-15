package com.Billing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Billing.InvoiceRepository.InvoiceRepository;
import com.Billing.InvoiceService.InvoiceService;
import com.Billing.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {
        if (invoiceRepository.existsById(id)) {
            invoice.setId(id);
            return invoiceRepository.save(invoice);
        }
        return null;
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> getInvoicesByCustomerName(String customerName) {
        return invoiceRepository.findByCustomerName(customerName);
    }
}
