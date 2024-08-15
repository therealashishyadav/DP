import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/account.service';
import UserAccount from '../Entity/UserAccount';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  user: UserAccount = new UserAccount();
  userLoggedIn: UserAccount = new UserAccount();
  userId: any;

  userName: string;
  password: string;
  id: number;

  signin(userName, password) {

    if (this.userName != null && this.password != null) {

      const observable = this.accountService.signin(this.userName, this.password);
      console.log(observable);

      observable.subscribe((response) => {

        if (response[0] == null) {
          alert("something went wrong")
        }
        else {
          console.log(response + "hello");
          this.userLoggedIn = response[0] as UserAccount;

          this.userId = this.userLoggedIn.id

          console.log(this.userId);
          window.location.href = "/dashboard";
        }
      },
        function (error) {
          console.log(error);
          alert("Something went wrong");
        }
      );

    }
    else {
      alert("Please Enter Your Valid credentials");
    }
  }

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

}
