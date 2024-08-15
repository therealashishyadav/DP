package com.account.service;
import java.util.List;

import com.account.model.Shop;

public interface ShopService {

	  List<Shop> getAllShops();

	    Shop getShopById(Long sId);

	    Shop createShop(Shop shop);

	    Shop updateShop(Long sId, Shop shop);

	    boolean deleteShop(Long sId);
}
