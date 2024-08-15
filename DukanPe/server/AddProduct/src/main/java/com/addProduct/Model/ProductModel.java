package com.addProduct.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductModel {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int pId;
	private String itemName;
	private Double itemPrice;
	private int itemQuantity;
	private String itemPurchasedDate;
	private int itemAvailable;
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ProductModel(int pId, String itemName, Double itemPrice, int itemQuantity, String itemPurchasedDate,
			int itemAvailable, double total) {
		super();
		this.pId = pId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemPurchasedDate = itemPurchasedDate;
		this.itemAvailable = itemAvailable;
		this.total = total;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemPurchasedDate() {
		return itemPurchasedDate;
	}

	public void setItemPurchasedDate(String itemPurchasedDate) {
		this.itemPurchasedDate = itemPurchasedDate;
	}

	public int getItemAvailable() {
		return itemAvailable;
	}

	public void setItemAvailable(int itemAvailable) {
		this.itemAvailable = itemAvailable;
	}

	public ProductModel(int pId, String itemName, Double itemPrice, int itemQuantity, String itemPurchasedDate,
			int itemAvailable) {
		super();
		this.pId = pId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemPurchasedDate = itemPurchasedDate;
		this.itemAvailable = itemAvailable;
	}

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductModel [pId=" + pId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity="
				+ itemQuantity + ", itemPurchasedDate=" + itemPurchasedDate + ", itemAvailable=" + itemAvailable
				+ ", total=" + total + "]";
	}

}