import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Bill from './Components/Entity/Bill';
import Product from './Components/Entity/Product';


const baseURL = 'http://localhost:8083/invoices';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  private baseUrl = 'http://localhost:8083/invoices';
  private itemNamesUrl = 'http://localhost:8083/product/itemNames';


  constructor(private http : HttpClient){}

  getItemNames() {
    return this.http.get<string[]>(this.itemNamesUrl);
  }

  createInvoice(bill: Bill) {
    return this.http.post(baseURL, bill);
  }
  searchItemName(itemName: string) {
    return this.http.get<string[]>(`${this.baseUrl}/search?itemName=${itemName}`);
  }
}
