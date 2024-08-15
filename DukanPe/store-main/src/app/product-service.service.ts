import { Injectable } from '@angular/core';
import Product from './Components/Entity/Product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const BASE_URL_TO_ADD_PRODUCT = "http://localhost:8083/product";

const BASE_URL_TO_DELETE_PRODUCT = "http://localhost:8083/product";



@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  
  private baseUrl = 'http://localhost:8083';

  private baseURL = 'http://localhost:8083/products';


  addItem(product: Product) {
    return this.http.post(BASE_URL_TO_ADD_PRODUCT, product);
  }
  public getAllProducts() {
    return this.http.get<Product[]>("http://localhost:8083/product");
  }

  public deleteProduct(productID: number) {
    return this.http.delete("http://localhost:8083/" + productID);
  }

  getQuantityFromInvoice(productName: string) {
    const url = `${this.baseURL}/${productName}/quantity`;
    return this.http.get<number>(url);
  }

  updateItemAvailable(itemName: string, quantityToSubtract: number) {
    const url = `${this.baseURL}/${itemName}`;
    return this.http.put(url, { quantityToSubtract });
  }

  getQuantityByProductName(productName: string): Observable<number> {
    const url = `${this.baseUrl}/${productName}/quantity`;
    return this.http.get<number>(url);
  }

  updateItemAvailableByItemName(itemName: string, itemAvailable: number): Observable<any> {
    const url = `${this.baseUrl}/updateItemAvailable/${itemName}`;
    return this.http.put(url, { itemAvailable });
  }

  constructor(private http: HttpClient) { }

}

