package com.addProduct.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addProduct.Model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
	ProductModel findByItemName(String itemName);

	boolean existsByItemName(String itemName);
}
