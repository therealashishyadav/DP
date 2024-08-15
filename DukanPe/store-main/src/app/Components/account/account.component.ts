import { Component, OnInit } from '@angular/core';
import UserAccount from '../Entity/UserAccount';
import { AccountService } from 'src/app/account.service';
import Shop from '../Entity/Shop';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  user: UserAccount = new UserAccount();
  users: UserAccount[] = [];
  shop:Shop = new Shop();
  shops : Shop[] = [];

  saveUser() {

    // console.log(this.user)
    const observable = this.accountService.createUser(this.user);
    observable.subscribe((response) => {
      console.log(response);
      alert("User Created");

      window.location.href = "/signin";      
    },
      function (error) {
        console.log(error);
        alert("Something went wrong");
      }
    );
  }

  saveShop(){
    const observable = this.accountService.shopDetails(this.shop);
    observable.subscribe((response) =>{
      console.log(response);
      alert("shop Register!");

    },
    function(error){
      console.log(error);
      alert("Something went wrong");
    }
    );
  }

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

}
