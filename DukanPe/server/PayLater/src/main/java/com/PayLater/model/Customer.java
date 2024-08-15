package com.PayLater.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private String customerIdType;
    private String customerId;
    private String itemsPurchased;
    private double amountToBePaid;
    private LocalDate purchaseDate;
    private LocalDate dueDate;

    // Constructors, getters, and setters
    // ...

    public Customer() {
        // Default constructor
    }

    // Parameterized constructor
    public Customer(String customerName, String customerPhone, String customerEmail, String customerAddress,
                    String customerIdType, String customerId, String itemsPurchased, double amountToBePaid,
                    LocalDate purchaseDate, LocalDate dueDate) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerIdType = customerIdType;
        this.customerId = customerId;
        this.itemsPurchased = itemsPurchased;
        this.amountToBePaid = amountToBePaid;
        this.purchaseDate = purchaseDate;
        this.dueDate = dueDate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerIdType() {
		return customerIdType;
	}

	public void setCustomerIdType(String customerIdType) {
		this.customerIdType = customerIdType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getItemsPurchased() {
		return itemsPurchased;
	}

	public void setItemsPurchased(String itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}

	public double getAmountToBePaid() {
		return amountToBePaid;
	}

	public void setAmountToBePaid(double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress + ", customerIdType="
				+ customerIdType + ", customerId=" + customerId + ", itemsPurchased=" + itemsPurchased
				+ ", amountToBePaid=" + amountToBePaid + ", purchaseDate=" + purchaseDate + ", dueDate=" + dueDate
				+ "]";
	}

}
