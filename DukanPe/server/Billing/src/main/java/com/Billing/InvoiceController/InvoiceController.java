package com.Billing.InvoiceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Billing.InvoiceService.InvoiceService;
import com.Billing.model.Invoice;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "http://localhost:4200")

public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }

    @GetMapping("/customer/{customerName}")
    public List<Invoice> getInvoicesByCustomerName(@PathVariable String customerName) {
        return invoiceService.getInvoicesByCustomerName(customerName);
    }
}
