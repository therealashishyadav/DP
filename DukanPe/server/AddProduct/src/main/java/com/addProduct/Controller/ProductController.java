package com.addProduct.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.addProduct.Model.Invoice;
import com.addProduct.Model.Invoice;
import com.addProduct.Model.ProductModel;
import com.addProduct.Service.InvoiceService;
import com.addProduct.Service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	private final ProductService productService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
//	public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel product) {
//		ProductModel newProduct = productService.addProduct(product);
//		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

	public void addProduct(@RequestBody ProductModel product) {
		double total = product.getItemQuantity() * product.getItemPrice();
		product.setTotal(total);
			
		productService.addProduct(product);
	}

	@PutMapping("/{itemName}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable int pId, @RequestBody ProductModel product) {
		ProductModel updatedProduct = productService.updateProduct(pId, product);
		if (updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{itemName}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int pId) {
		boolean deleted = productService.deleteProduct(pId);
		if (deleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		List<ProductModel> products = productService.getAllProducts();
		if (!products.isEmpty()) {
			return ResponseEntity.ok(products);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<ProductModel> getProductByItemName(@RequestParam("itemName") String itemName) {
		ProductModel product = productService.getProductByItemName(itemName);
		if (product != null) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

//	get only product names

	@GetMapping("/itemNames")
	public ResponseEntity<List<String>> getAllItemNames() {
		List<String> itemNames = productService.getAllItemNames();
		return ResponseEntity.ok(itemNames);
	}

//	get Item Available

	@GetMapping("/itemAvailable/{itemName}")
	public ResponseEntity<Integer> getItemAvailableByItemName(@PathVariable String itemName) {
		ProductModel product = productService.getProductByItemName(itemName);
		if (product != null) {
			int itemAvailable = product.getItemAvailable();
			return ResponseEntity.ok(itemAvailable);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/itemAvailable/{itemName}")
	public ResponseEntity<String> updateItemAvailableByItemName(@PathVariable String itemName) {
		try {
			// Get the updatedItemAvailable from the Invoice entity
			int updatedItemAvailable = invoiceService.getUpdatedItemAvailableByItemName(itemName);

			// Update the itemAvailable in the Product entity
			productService.updateItemAvailableByItemName(itemName, updatedItemAvailable);

			return ResponseEntity.ok("itemAvailable updated successfully.");
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating itemAvailable.");
		}
	}

	// Get the sum of all totals
	@GetMapping("/total-sum")
	public double getTotalSum() {
		List<ProductModel> products = productService.getAllProducts();
		double totalSum = products.stream().mapToDouble(ProductModel::getTotal).sum();
		return totalSum;
	}

}
