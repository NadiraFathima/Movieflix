import { Component, OnInit } from '@angular/core';
import {UserService} from '../user-service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  check= false;
  error;
  user = {
    userName: null,
    privilege: 'user',
    password: null,
    repeatPassword: null
  };
  login = {
    userName: null,
    password: null,
  };

  constructor(private userService: UserService, private router: Router ) { }

    addUser() {
      this.userService.addUser(this.user)
        .subscribe(user => {
          console.log(user);
          this.router.navigate(['/users']);
        });
    }
  getUser() {
    this.userService.getUser(this.login.userName, this.login.password)
      .subscribe(login => {this.check = login;
        console.log(`the boolean value is ${this.check}`); },
        error => console.log(error));
      this.router.navigate(['/Title']);


  }

}
