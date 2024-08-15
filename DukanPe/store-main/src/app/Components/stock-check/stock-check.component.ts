import { Component, OnInit } from '@angular/core';
import Product from '../Entity/Product';
import { HttpErrorResponse } from '@angular/common/http';
import { ProductServiceService } from 'src/app/product-service.service';

@Component({
  selector: 'app-stock-check',
  templateUrl: './stock-check.component.html',
  styleUrls: ['./stock-check.component.css']
})
export class StockCheckComponent {
  
  productDetails: Product[] =[];

  displayedColumns = ['ID', 'Item Name', 'Item Price', 'Item Quantity','Item Purchased Date', 'Item Sold Date', 'Item Warranty Date', 'Item Available', 'Edit', 'Delete' ];

  constructor(private productService : ProductServiceService) { }

  ngOnInit(): void{
    this.getAllProducts();
  }

  public getAllProducts(){
    this.productService.getAllProducts().subscribe((res: Product[]) => {
      console.log(res);
      this.productDetails = res;
    }, (error: HttpErrorResponse) => {
      console.log(error);
    }
    );
  }

  deleteProduct(pId){
    this.productService.deleteProduct(pId).subscribe((res )=>{
      console.log(res);
      this.getAllProducts();
    },
    (error:HttpErrorResponse)=>{
      console.log(error);
    });
  }

}
