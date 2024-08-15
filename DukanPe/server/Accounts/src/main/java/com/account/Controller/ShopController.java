package com.account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.account.model.Shop;
import com.account.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/shops")
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {

	private final ShopService shopService;

	@Autowired
	public ShopController(ShopService shopService) {
		this.shopService = shopService;
	}

	 @GetMapping
	    public ResponseEntity<List<Shop>> getAllShops() {
	        List<Shop> shops = shopService.getAllShops();
	        return new ResponseEntity<>(shops, HttpStatus.OK);
	    }

	    @GetMapping("/{sId}")
	    public ResponseEntity<Shop> getShopById(@PathVariable Long sId) {
	        Shop shop = shopService.getShopById(sId);
	        if (shop != null) {
	            return new ResponseEntity<>(shop, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
	        Shop createdShop = shopService.createShop(shop);
	        return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
	    }

	    @PutMapping("/{sId}")
	    public ResponseEntity<Shop> updateShop(@PathVariable Long sId, @RequestBody Shop shop) {
	        Shop updatedShop = shopService.updateShop(sId, shop);
	        if (updatedShop != null) {
	            return new ResponseEntity<>(updatedShop, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{sId}")
	    public ResponseEntity<Void> deleteShop(@PathVariable Long sId) {
	        boolean deleted = shopService.deleteShop(sId);
	        if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}