package com.addProduct.Service;

import java.util.List;
import java.util.Map;

import com.addProduct.Model.Invoice;

public interface InvoiceService {

	Invoice createInvoice(Invoice invoice);

	void deleteInvoice(Long id);

	Invoice updateInvoice(Long id, Invoice invoice);

	List<Invoice> getAllInvoices();

	List<Invoice> getInvoicesByCustomerName(String customerName);

	int getTotalQuantityByItemName(String itemName);

	int getUpdatedItemAvailableByItemName(String itemName);



}
