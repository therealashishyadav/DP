import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  credential: any = {};
  shops: any[] = [];
  isProfileEditMode: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    
    this.http.get('http://localhost:8084/credential').subscribe((data: any) => {
      this.credential = data;
    });

    
    this.http.get('http://localhost:8080/shops').subscribe((data: any[]) => {
      this.shops = data;
    });
  }

  saveCredential(): void {
    
    this.http.put('http://localhost:8084/credential', this.credential).subscribe(() => {
      console.log('Credential saved successfully!');
      this.isProfileEditMode = false; 
    });
  }

  toggleProfileEditMode(): void {
    this.isProfileEditMode = !this.isProfileEditMode;
  }

  saveShop(shop: any): void {
    this.http.put(`http://localhost:8080/shops/${shop.id}`, shop).subscribe(() => {
      console.log('Shop saved successfully!');
    });
  }
}
