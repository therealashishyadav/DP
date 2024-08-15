import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { InvoiceService } from 'src/app/invoice.service';
import Bill from '../Entity/Bill';
import { DataService } from 'src/app/data.service';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs';


@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  bill: any = {};
  billForm: FormGroup;
  itemName: string;
  itemNames: string[] = [];
  userInput: string = '';
  itemNameControl = new FormControl();
  filteredItemNames: string[] = [];


  constructor(private invoiceService: InvoiceService,
    private formBuilder: FormBuilder,
    private dataService: DataService
  ) {
    this.billForm = this.formBuilder.group({
      customerName: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required],
      itemName:['', Validators.required],
      modelNumber: ['', Validators.required],
      imeiNumber: ['', Validators.required],
      siNumber: ['', Validators.required],
      paymentMethod: ['', Validators.required],
      quantity: ['', Validators.required],
      amount: ['', Validators.required],
      cashback: ['', Validators.required],
      discount: ['', Validators.required],
      total: ['', Validators.required],
    });
  }


  calculateTotal() {
    const quantity = this.bill.quantity;
    const amount = this.bill.amount;
    const cashback = this.bill.cashback;
    const discount = this.bill.discount;
    const discountDecimal = discount / 100;

    const cashbackprice = (quantity * amount) - (cashback);

    // this.invoice.total = (quantity * amount) - (cashback + (discountDecimal * (quantity * amount)));

    this.bill.total = cashbackprice - (discountDecimal * cashbackprice);

  }

  submitForm(): void {

    const observable = this.invoiceService.createInvoice(this.bill);
    observable.subscribe((response) => {
      console.log(response);
      alert("saved");
    }
    );
    this.generateInvoice();

  }
  generateInvoice(): void {
    
    const customerName = this.bill.customerName;
    const address = this.bill.address;
    const post = this.bill.post;
    const email = this.bill.email;
    const phone = this.bill.phone;
    const modelNumber = this.bill.modelNumber;

    const quantity = this.bill.quantity;
    const itemName = this.bill.itemName;
    const imeiNumber = this.bill.imeiNumber;
    const siNumber = this.bill.siNumber;    
    const paymentMethod = this.bill.paymentMethod;
    const amount = this.bill.amount;
    const cashback = this.bill.cashback;
    const discount = this.bill.discount;
    const total = this.bill.total;

    const invoice = {
      customerName: customerName,
      address: address,
      post: post,
      email: email,
      phone: phone,
      modelNumber: modelNumber,
      imeiNumber : imeiNumber,
      siNumber:siNumber,
      paymentMethod:paymentMethod,
      quantity: quantity,
      itemName: itemName,
      amount: amount,
      cashback: cashback,
      discount: discount,
      total: total
    };

    this.printInvoice(invoice); 
    this.saveInvoice(invoice);
  }

  printInvoice(invoice: any): void {

    const invoiceTable = `
    <div class="invoice">
    <div class="invoice-heading">
      <h1>INVOICE</h1>
    </div>
    <div class="customer-details">
      <h2>Customer Details</h2>
      <table>
        <tr>
          <th>Customer Name</th>
          <th>Address</th>
          <th>Postal Code</th>
          <th>Phone</th>
        </tr>
        <tr>
        <td>${this.bill.customerName}</td>
        <td>${this.bill.address}</td>
        <td>${this.bill.post}</td>
        <td>${this.bill.phone}</td>
        </tr>
      </table>
    </div>
    <div class="product-details">
      <h2>Product Details</h2>
      <table>
        <tr>
        <th>Item Name</th>
        <th>Model Number</th>
        <th>IMEI Number</th>
          <th>S.I. Number</th>
        </tr>
        <tr>
        <td>${ this.bill.itemName }</td>
          <td>${ this.bill.modelNumber }</td>
          <td>${ this.bill.imeiNumber }</td>
          <td>${ this.bill.siNumber }</td>
        </tr>
      </table>
    </div>
    <div class="payment-details">
      <h2>Payment Details</h2>
      <table>
        <tr>
          <th>Quantity</th>
          <th>Amount</th>
          <th>Cashback</th>
          <th>Discount</th>
          <th>Total</th>
        </tr>
        <tr>
          <td>${ this.bill.quantity }</td>
          <td>${ this.bill.amount }</td>
          <td>${ this.bill.cashback }</td>
          <td>${ this.bill.discount }</td>
          <td>${ this.bill.total }</td>
        </tr>
      </table>
    </div>
  </div>
  
    `;

    const printWindow = window.open('', '_blank', 'width=600,height=600');
    printWindow.document.open();
    printWindow.document.write(`
      <html>
        <head>
          <title>Invoice</title>
          <style>
          .invoice {
            background-color: lightgray;
            color: black;
            padding: 20px;
          }
          
          .invoice-heading h1 {
            color: lightblue;
          }
          
          .customer-details table,
          .product-details table,
          .payment-details table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
          }
          
          .customer-details h2,
          .product-details h2,
          .payment-details h2 {
            color: black;
            margin-bottom: 10px;
          }
          
          .customer-details th,
          .product-details th,
          .payment-details th {
            background-color: lightblue;
            color: black;
            font-weight: bold;
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid black;
          }
          
          .customer-details td,
          .product-details td,
          .payment-details td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid lightgray;
          }
          
          .customer-details tr:last-child td,
          .product-details tr:last-child td,
          .payment-details tr:last-child td {
            border-bottom: none;
          }
          
          </style>
        </head>
        <body onload="window.print();">
          ${invoiceTable}
        </body>
      </html>
    `);
    printWindow.document.close();
  }


  saveInvoice(invoice: any): void {
    console.log('Saving invoice:', invoice);
  }

  searchItemName(event: Event) {
    const itemName = (event.target as HTMLInputElement).value;
    this.invoiceService.searchItemName(itemName).subscribe(
      (itemNames: string[]) => {
        this.itemNames = itemNames;
      },
      (error) => {
        console.error('Error searching item names:', error);
      }
    );

  }

  // fetchItemNames() {
  //   this.invoiceService.getItemNames().subscribe(
  //     (response: string[]) => {
  //       this.itemNames = response;
  //     },
  //     (error) => {
  //       console.log('Error fetching item names:', error);
  //     }
  //   );
  // }
 
  fetchItemNames() {
    this.invoiceService.getItemNames().subscribe(
      (response: string[]) => {
        this.itemNames = response;
      },
      (error) => {
        console.log('Error fetching item names:', error);
      }
    );
  }

  subscribeToItemNameChanges() {
    this.itemNameControl.valueChanges
      .pipe(
        debounceTime(300), // Debounce user input to reduce API calls
        distinctUntilChanged() // Only emit distinct values
      )
      .subscribe((value: string) => {
        this.filterItemNames(value);
      });
  }

  filterItemNames(value: string) {
    this.filteredItemNames = this.itemNames.filter((itemName) =>
      itemName.toLowerCase().includes(value.toLowerCase())
    );
  }

  ngOnInit(): void {
    this.subscribeToItemNameChanges();
    // this.fetchItemNames();
    this.fetchItemNames();

  }

}
