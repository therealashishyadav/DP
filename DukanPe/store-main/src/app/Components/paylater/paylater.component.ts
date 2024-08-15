import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-paylater',
  templateUrl: './paylater.component.html',
  styleUrls: ['./paylater.component.css']
})
export class PaylaterComponent implements OnInit {

  customer = {
    customerName: '',
    customerPhone: '',
    customerEmail: '',
    customerAddress: '',
    customerIdType: '',
    customerId: '',
    itemsPurchased: '',
    timeOfPurchase: '',
    dateOfPurchase: '',
    amountToBePaid: 0,
    dueDate: ''
  };
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
  }
  onSubmit() {
    this.http.post('http://localhost:8085/customers', this.customer)
      .subscribe(response => {
        console.log('Customer added successfully!', response);
        this.customer = {
          customerName: '',
          customerPhone: '',
          customerEmail: '',
          customerAddress: '',
          customerIdType: '',
          customerId: '',
          itemsPurchased: '',
          timeOfPurchase: '',
          dateOfPurchase: '',
          amountToBePaid: 0,
          dueDate: ''
        };
      }, error => {
        console.error('Error adding customer:', error);
      });
  }
}
