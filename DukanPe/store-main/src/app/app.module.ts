import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountComponent } from './Components/account/account.component';
import { HomeComponent } from './Components/home/home.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SigninComponent } from './Components/signin/signin.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { AddProductComponent } from './Components/add-product/add-product.component';
import { AdjustmentPageComponent } from './Components/adjustment-page/adjustment-page.component';
import { InventoryManagementComponent } from './Components/inventory-management/inventory-management.component';
import { StockCheckComponent } from './Components/stock-check/stock-check.component';
import { TransactionComponent } from './Components/transaction/transaction.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FooterComponent } from './Components/footer/footer.component';
import { MatSelectModule } from '@angular/material/select';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { FootercardComponent } from './Components/footercard/footercard.component';
import { DeleteItemComponent } from './Components/delete-item/delete-item.component';
import { NgOptimizedImage } from '@angular/common'
import {MatIconModule} from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { PaylaterComponent } from './Components/paylater/paylater.component';
import { CustomerDetailsComponent } from './Components/customer-details/customer-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SalesReportComponent } from './Components/sales-report/sales-report.component';
import { ReportComponent } from './Components/report/report.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { InvoiceComponent } from './Components/invoice/invoice.component';
import { InvoiceStatementComponent } from './Components/invoice-statement/invoice-statement.component';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { NotificationComponent } from './Components/notification/notification.component';
import { ImageSliderComponent } from './Components/image-slider/image-slider.component';
import { UpdateProductComponent } from './Components/update-product/update-product.component';


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    HomeComponent,
    NavBarComponent,
    SigninComponent,
    DashboardComponent,
    AddProductComponent,
    AdjustmentPageComponent,
    InventoryManagementComponent,
    StockCheckComponent,
    TransactionComponent,
    FooterComponent,
    FootercardComponent,
    DeleteItemComponent,
    PaylaterComponent,
    CustomerDetailsComponent,
    SalesReportComponent,
    ReportComponent,
    ProfileComponent,
    InvoiceComponent,
    InvoiceStatementComponent,
    NotificationComponent,
    ImageSliderComponent,
    UpdateProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSnackBarModule,
    NgOptimizedImage,
    MatIconModule,
    MatTableModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
