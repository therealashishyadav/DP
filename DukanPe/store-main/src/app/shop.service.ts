import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Shop from './Components/Entity/Shop';

const BASE_URL_TO_ADD_SHOP = "http://localhost:8082/shop";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  addShop(shop : Shop) {

    return this.http.post(BASE_URL_TO_ADD_SHOP,shop );

  }
  constructor( private http : HttpClient ) { }
}
