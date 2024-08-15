package com.addProduct.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addProduct.Model.Invoice;
import com.addProduct.Model.ProductModel;
import com.addProduct.Repository.InvoiceRepository;
import com.addProduct.Repository.ProductRepository;
import com.addProduct.Service.InvoiceService;
import com.addProduct.Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	private final ProductRepository productRepository;

	private InvoiceService invoiceService;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductModel addProduct(ProductModel product) {
		return productRepository.save(product);
	}

	@Override
	public ProductModel updateProduct(int pId, ProductModel product) {
		ProductModel existingProduct = getProductById(pId);
		if (existingProduct != null) {
			existingProduct.setItemName(product.getItemName());
			existingProduct.setItemPrice(product.getItemPrice());
			existingProduct.setItemQuantity(product.getItemQuantity());
			existingProduct.setItemPurchasedDate(product.getItemPurchasedDate());									
			existingProduct.setItemAvailable(product.getItemAvailable());
			return productRepository.save(existingProduct);
		}
		return null;
	}

	@Override
	public boolean deleteProduct(int pId) {
		ProductModel product = getProductById(pId);
		if (product != null) {
			productRepository.delete(product);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductModel getProductByItemName(String itemName) {
		return productRepository.findByItemName(itemName);
	}

	private ProductModel getProductById(int pId) {
		return productRepository.findById(pId).orElse(null);
	}

	@Override
	public List<String> getAllItemNames() {
		List<String> itemNames = new ArrayList<>();
		List<ProductModel> products = productRepository.findAll();
		for (ProductModel product : products) {
			itemNames.add(product.getItemName());
		}
		return itemNames;
	}

//	 @Override
//	    public int getItemAvailableByItemName(String itemName) {
//	        ProductModel product = productRepository.findByItemName(itemName);
//	        if (product != null) {
//	            return product.getItemAvailable();
//	        }
//	        throw new NoSuchElementException("Item not found: " + itemName);
//	    }
//
//	    @Override
//	    public int getQuantityByItemName(String itemName) {
//	        // Implement the logic to retrieve the quantity from the Invoice repository
//	        // and return the value for the given itemName
//	    	int quantity = 0;
//	        
//	        // Implement the logic to retrieve the quantity from the Invoice repository
//	        List<Invoice> invoices = invoiceRepository.findByItemName(itemName);
//	        if (!invoices.isEmpty()) {
//	            for (Invoice invoice : invoices) {
//	                quantity = invoice.getQuantity();
//	            }
//	        }
//	        
//	        return quantity;
//	    }
//
//	    @Override
//	    public void updateItemAvailableByItemName(String itemName, int updatedItemAvailable) {
//	        ProductModel product = productRepository.findByItemName(itemName);
//	        if (product != null) {
//	            product.setItemAvailable(updatedItemAvailable);
//	            productRepository.save(product);
//	        } else {
//	            throw new NoSuchElementException("Item not found: " + itemName);
//	        }
//	    }
	
	 @Override
	    public void updateItemAvailableByItemName(String itemName, int updatedItemAvailable) {
	        ProductModel product = productRepository.findByItemName(itemName);
	        if (product != null) {
	            product.setItemAvailable(updatedItemAvailable);
	            productRepository.save(product);
	        }
	    }
	 
	 @Override
	    public double getTotalSum() {
	        List<ProductModel> products = productRepository.findAll();
	        double totalSum = products.stream().mapToDouble(ProductModel::getTotal).sum();
	        return totalSum;
	    }
	
}
