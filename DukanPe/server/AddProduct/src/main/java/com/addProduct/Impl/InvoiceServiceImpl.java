package com.addProduct.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addProduct.Model.Invoice;
import com.addProduct.Model.ProductModel;
import com.addProduct.Repository.InvoiceRepository;
import com.addProduct.Repository.ProductRepository;
import com.addProduct.Service.InvoiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private ProductRepository productRepository;

	private final InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		
//		int quant = invoice.getQuantity();
//		
//		return invoiceRepository.save(invoice);
	
		Invoice savedInvoice = invoiceRepository.save(invoice);

	    // Update the itemAvailable in the Product entity
	    String itemName = invoice.getItemName();
	    int quantity = invoice.getQuantity();
	    ProductModel product = productRepository.findByItemName(itemName);
	    
	    if (product != null) {
	        int itemAvailable = product.getItemAvailable();
	        int updatedItemAvailable = itemAvailable - quantity;
	        product.setItemAvailable(updatedItemAvailable);
	        productRepository.save(product);
	    }
	    
	    return savedInvoice;
	
	}

	@Override
	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
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
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> getInvoicesByCustomerName(String customerName) {
		return invoiceRepository.findByCustomerName(customerName);
	}

//	@Override
//	public List<Invoice> getInvoicesByItemName(String itemName) {
//		return invoiceRepository.findByItemName(itemName);
//	}

	@Override
    public int getTotalQuantityByItemName(String itemName) {
        int totalQuantity = 0;
        List<Invoice> invoices = invoiceRepository.findByItemName(itemName);
        for (Invoice invoice : invoices) {
            totalQuantity += invoice.getQuantity();
        }
        return totalQuantity;
    }

	@Override
	public int getUpdatedItemAvailableByItemName(String itemName) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
