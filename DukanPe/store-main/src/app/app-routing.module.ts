import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountComponent } from './Components/account/account.component';
import { HomeComponent } from './Components/home/home.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { SigninComponent } from './Components/signin/signin.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { AddProductComponent } from './Components/add-product/add-product.component';
import { TransactionComponent } from './Components/transaction/transaction.component';
import { StockCheckComponent } from './Components/stock-check/stock-check.component';
import { AdjustmentPageComponent } from './Components/adjustment-page/adjustment-page.component';
import { InventoryManagementComponent } from './Components/inventory-management/inventory-management.component';
import { FooterComponent } from './Components/footer/footer.component';
import { FootercardComponent } from './Components/footercard/footercard.component';

import { DeleteItemComponent } from './Components/delete-item/delete-item.component';
import { PaylaterComponent } from './Components/paylater/paylater.component';
import { CustomerDetailsComponent } from './Components/customer-details/customer-details.component';
import { SalesReportComponent } from './Components/sales-report/sales-report.component';
import { ReportComponent } from './Components/report/report.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { InvoiceComponent } from './Components/invoice/invoice.component';
import { ImageSliderComponent } from './Components/image-slider/image-slider.component';

const routes: Routes = [
  {path:'account' , component:AccountComponent},
  {path:'home' , component:HomeComponent},
  {path:'navbar' , component:NavBarComponent},
  {path:'signin' , component:SigninComponent},
  {path:'dashboard' , component:DashboardComponent},
  {path:'addproduct', component:AddProductComponent},
  {path:'adjustmentpage', component:AdjustmentPageComponent},
  {path:'inventorymanagement', component:InventoryManagementComponent},
  {path:'stockcheck', component:StockCheckComponent},  
  {path:'transaction', component:TransactionComponent},
  {path:'footer', component: FooterComponent},
  {path:'footercard', component: FootercardComponent},
  {path:'deleteProduct', component: DeleteItemComponent},
  {path:'paylater', component: PaylaterComponent},
  {path:'customerdetails', component: CustomerDetailsComponent},
  {path:'salesreport', component: SalesReportComponent},
  {path:'report', component: ReportComponent},
  {path:'profile' , component: ProfileComponent},
  {path:'invoice' , component: InvoiceComponent},
  {path:'slider' , component : ImageSliderComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
