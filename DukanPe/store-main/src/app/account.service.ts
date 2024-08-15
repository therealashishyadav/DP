import { Injectable } from '@angular/core';
import UserAccount from './Components/Entity/UserAccount';
import { HttpClient } from '@angular/common/http';
import Shop from './Components/Entity/Shop';

const BASE_URL_TO_ADD_USER = "http://localhost:8084/credential";
const BASE_URL_TO_ADD_SHOP = "http://localhost:8084/shops";
const BASE_URL_FOR_USER_LOGIN = "http://localhost:8084/signin/";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  createUser(user: UserAccount) {
    return this.http.post(BASE_URL_TO_ADD_USER, user);
  }
  shopDetails(shop: Shop) {
    return this.http.post(BASE_URL_TO_ADD_SHOP, shop);
  }

  signin(userName, password) {
    return this.http.get(BASE_URL_FOR_USER_LOGIN + userName + "/" + password);
  }

  constructor(private http: HttpClient) { }
}
