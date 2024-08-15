import { Component, HostListener, OnInit } from '@angular/core';
import UserAccount from '../Entity/UserAccount';
import { Router, RouterLink } from '@angular/router';
import { ProductServiceService } from 'src/app/product-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})



export class NavBarComponent implements OnInit {

  user: UserAccount = new UserAccount();
  userLogout: UserAccount = new UserAccount();
  userId: any;

  userName: string;
  password: string;
  id: number;

  searchQuery: string;
  searchResults: any[];

  isScrolled: boolean = false;

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.isScrolled = window.scrollY > 0;
  }



  logout() {

    window.sessionStorage.clear();

    this.router.navigate(['signin']);

  }

  constructor(public router: Router , private productService: ProductServiceService, private http: HttpClient) { }
  
  ngOnInit(): void {

    if (sessionStorage == null) {
      this.router.navigate(['/signin']);
    }
    this.onWindowScroll();

  }

}
