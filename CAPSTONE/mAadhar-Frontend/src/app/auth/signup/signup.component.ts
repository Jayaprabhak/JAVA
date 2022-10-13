import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  name : string = '';
  username : string = '';
  password : string = '';
  email : string = '';
  mobile : any = '';
  user : User = new User();

  constructor(private authService : AuthService, private route : Router) {   }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
    this.name = '';
    this.email = '';
    this.mobile = '';
  }

  signup() {

    this.user.username = this.username;
    this.user.password = this.password;
    this.user.name = this.name;
    this.user.role = 'User';
    this.user.email = this.email;
    this.user.mobile = this.mobile;
    console.log(this.user);
    
    this.authService.signUp(this.user).subscribe(res => {
      if(res == null) {
        alert("Registration failed");
        this.ngOnInit();
      }else {
        console.log("Registration successful");
        alert("Registration successful");
        this.route.navigate(['/']);
      }
    }, error => {
      alert("Registration failed.");
      this.ngOnInit();
    })

  }

}
