package com.addProduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.addProduct.Model.Invoice;
import com.addProduct.Model.ProductModel;
import com.addProduct.Service.InvoiceService;
import com.addProduct.Service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {

	private final InvoiceService invoiceService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

//    posting invoices

	@PostMapping
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
		Invoice createdInvoice = invoiceService.createInvoice(invoice);
		return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
	}

//    Deleting Invoices

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
		invoiceService.deleteInvoice(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//    Updating Invoices

	@PutMapping("/{id}")
	public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
		Invoice updatedInvoice = invoiceService.updateInvoice(id, invoice);
		return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
	}

//    getting all details

	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		List<Invoice> invoices = invoiceService.getAllInvoices();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

//    getting bill with customer name

	@GetMapping("/customer/{customerName}")
	public ResponseEntity<List<Invoice>> getInvoicesByCustomerName(@PathVariable String customerName) {
		List<Invoice> invoices = invoiceService.getInvoicesByCustomerName(customerName);
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}

//    getting details of items by item name

//	@GetMapping("/item/{itemName}")
//	public ResponseEntity<List<Invoice>> getInvoicesByItemName(@PathVariable String itemName) {
//		List<Invoice> invoices = invoiceService.getInvoicesByItemName(itemName);
//		return new ResponseEntity<>(invoices, HttpStatus.OK);
//	}

//    get quantity of a item 

//	 @GetMapping("/quantity/{itemName}")
//	    public ResponseEntity<Integer> getQuantityByItemName(@PathVariable String itemName) {
//	        int quantity = invoiceService.getQuantityByItemName(itemName);
//	        return ResponseEntity.ok(quantity);
//	    }

	@GetMapping("/quantities/{itemName}")
	public ResponseEntity<Integer> getQuantitiesByItemName(@PathVariable String itemName) {
		int totalQuantity = invoiceService.getTotalQuantityByItemName(itemName);
		return ResponseEntity.ok(totalQuantity);
	}


}
