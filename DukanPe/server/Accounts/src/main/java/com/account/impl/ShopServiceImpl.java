package com.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.model.Shop;
import com.account.repository.ShopRepository;
import com.account.service.ShopService;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(Long sId) {
        return shopRepository.findById(sId).orElse(null);
    }

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop updateShop(Long sId, Shop shop) {
        Shop existingShop = shopRepository.findById(sId).orElse(null);
        if (existingShop != null) {
            existingShop.setShopName(shop.getShopName());
            existingShop.setShopAddress(shop.getShopAddress());
            existingShop.setShopPhone(shop.getShopPhone());
            existingShop.setShopEmail(shop.getShopEmail());
            return shopRepository.save(existingShop);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteShop(Long sId) {
        Shop existingShop = shopRepository.findById(sId).orElse(null);
        if (existingShop != null) {
            shopRepository.delete(existingShop);
            return true;
        } else {
            return false;
        }
    }
}
