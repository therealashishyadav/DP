package com.Billing.InvoiceService;

import java.util.List;

import com.Billing.model.Invoice;

public interface InvoiceService {
	Invoice createInvoice(Invoice invoice);

	Invoice getInvoiceById(Long id);

	List<Invoice> getAllInvoices();

	Invoice updateInvoice(Long id, Invoice invoice);

	void deleteInvoice(Long id);

	List<Invoice> getInvoicesByCustomerName(String customerName);
}
