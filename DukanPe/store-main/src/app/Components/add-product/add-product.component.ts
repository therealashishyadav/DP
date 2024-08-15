import { Component, OnInit } from '@angular/core';
import Product from '../Entity/Product';
import { ProductServiceService } from 'src/app/product-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  product: Product = new Product;
  products: Product[] = [];
  // quantity: number;

  productName: string;
  quantity: number | null;
  newItemAvailable: number;


  addproduct() {

    const observable = this.productService.addItem(this.product);

    observable.subscribe((response) => {
      console.log(response);
      this._snackBar.open("Successfully added !", '',{
        duration:3000
      });

    },
      function (error) {
        console.log(error);
        this._snackBar.open("Something went wrong !");
      }
    );

  }
  updateItem() {
    const itemName = 'example-item'; 
    const quantityToSubtract = 5; 
    this.productService.updateItemAvailable(itemName, quantityToSubtract).subscribe(
      () => {
        console.log('Item updated successfully');
      },
      error => {
        console.error(error);
      }
    );
  }

  getQuantity(): void {
    if (this.productName) {
      this.productService.getQuantityByProductName(this.productName)
        .subscribe(
          quantity => this.quantity = quantity,
          error => console.log('Error fetching quantity:', error)
        );
    }
  }

  updateItemAvailable(): void {
    if (this.productName && this.newItemAvailable !== undefined) {
      this.productService.updateItemAvailableByItemName(this.productName, this.newItemAvailable)
        .subscribe(
          () => console.log('Item available updated successfully'),
          error => console.log('Error updating item available:', error)
        );
    }
  }

  constructor(private productService: ProductServiceService , private _snackBar : MatSnackBar) {}

  ngOnInit(): void {
    const productName = 'example-product'; 
    this.productService.getQuantityFromInvoice(productName).subscribe(
      response => {
        this.quantity = response;
      },
      error => {
        console.error(error);
      }
    );
  }
}


