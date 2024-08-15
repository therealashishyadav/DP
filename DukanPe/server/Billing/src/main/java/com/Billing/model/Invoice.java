package com.Billing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private String address;
	private String post;
	private String email;
	private String phone;
	private String productName;
	private String modelNumber;
	private String imeiNumber;
	private String siNumber;
	private String paymentMethod;
	private int quantity;
	private double rate;
	private double amount;
	private double cashback;
	private double discount;
	private double total;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getImeiNumber() {
		return imeiNumber;
	}

	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	public String getSiNumber() {
		return siNumber;
	}

	public void setSiNumber(String siNumber) {
		this.siNumber = siNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getCashback() {
		return cashback;
	}

	public void setCashback(double cashback) {
		this.cashback = cashback;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Invoice(Long id, String customerName, String address, String post, String email, String phone,
			String productName, String modelNumber, String imeiNumber, String siNumber, String paymentMethod,
			int quantity, double rate, double amount, double cashback, double discount, double total) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.address = address;
		this.post = post;
		this.email = email;
		this.phone = phone;
		this.productName = productName;
		this.modelNumber = modelNumber;
		this.imeiNumber = imeiNumber;
		this.siNumber = siNumber;
		this.paymentMethod = paymentMethod;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
		this.cashback = cashback;
		this.discount = discount;
		this.total = total;
	}

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customerName=" + customerName + ", address=" + address + ", post=" + post
				+ ", email=" + email + ", phone=" + phone + ", productName=" + productName + ", modelNumber="
				+ modelNumber + ", imeiNumber=" + imeiNumber + ", siNumber=" + siNumber + ", paymentMethod="
				+ paymentMethod + ", quantity=" + quantity + ", rate=" + rate + ", amount=" + amount + ", cashback="
				+ cashback + ", discount=" + discount + ", total=" + total + "]";
	}

}