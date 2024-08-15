package com.addProduct.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addProduct.Model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByCustomerName(String customerName);

	List<Invoice> findByItemName(String itemName);

	

//	List<Invoice> findByItemName(String itemName);


}
