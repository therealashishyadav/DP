import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomerService } from 'src/app/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {
  customers: any[];

  constructor(private http: HttpClient,private router: Router, private customerService: CustomerService) {}

  ngOnInit(): void {
    this.getCustomers();
  }
  getCustomers() {
    this.http.get<any[]>('http://localhost:8085/customers').subscribe(
      data => {
        this.customers = data;
      },
      error => {
        console.log('Error:', error);
      }
    );
  }

  goBack() {
    this.router.navigate(['/paylater']);
  }
}
