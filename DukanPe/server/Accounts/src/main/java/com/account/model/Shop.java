package com.account.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;
    private String shopName;
    private String shopAddress;
    private String shopPhone;
    private String shopEmail;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;
    // Constructors, getters, and setters

    public Shop() {
    }

    public Shop(String shopName, String shopAddress, String shopPhone, String shopEmail) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopPhone = shopPhone;
        this.shopEmail = shopEmail;
    }

    // Getters and setters

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

	@Override
	public String toString() {
		return "Shop [sId=" + sId + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopPhone="
				+ shopPhone + ", shopEmail=" + shopEmail + ", credential=" + credential + "]";
	}
    
}
