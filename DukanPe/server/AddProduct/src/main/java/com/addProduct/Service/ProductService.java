package com.addProduct.Service;

import java.util.List;

import com.addProduct.Model.ProductModel;

public interface ProductService {
	ProductModel addProduct(ProductModel product);

	ProductModel updateProduct(int pId, ProductModel product);

	boolean deleteProduct(int pId);

	List<ProductModel> getAllProducts();

	ProductModel getProductByItemName(String itemName);

	List<String> getAllItemNames();

	void updateItemAvailableByItemName(String itemName, int updatedItemAvailable);

	double getTotalSum();
}
