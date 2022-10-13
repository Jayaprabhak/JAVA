import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { Aadhar } from 'src/app/model/aadhar';

@Component({
  selector: 'app-apply-aadhar',
  templateUrl: './apply-aadhar.component.html',
  styleUrls: ['./apply-aadhar.component.css']
})
export class ApplyAadharComponent implements OnInit {

    name: string = '';
    dob: string = '';
    gender: string = '';
    mobilenumber: string = '';
    aadharnumber: string = '';
    housenumber: string = '';
    street: string = '';
    district: string = '';
    state: string = '';
    pincode: string = '';

    aadhar : Aadhar = new Aadhar(); 

    genders : string[];

  constructor(private authService : AuthService, private route : Router) {
    this.genders = [
      'Male',
      'Female',
      'Other'
    ]
   }

  ngOnInit(): void {
    this.name = '';
    this.dob = '';
    this.mobilenumber='';
    this.housenumber = '';
    this.street = '';
    this.district = '';
    this.state = '';
    this.pincode = '';
  }

  applyAadhar(){
    this.aadhar.name = this.name;
    this.aadhar.dob = this.dob;
    this.aadhar.gender = this.gender;
    this.aadhar.mobilenumber = this.mobilenumber;
    this.aadhar.housenumber = this.housenumber;
    this.aadhar.street = this.street;
    this.aadhar.district = this.district;
    this.aadhar.state = this.state;
    this.aadhar.pincode = this.pincode;

    this.authService.applyAadhar(this.aadhar).subscribe(res =>{
      if(res==null) {
        alert("Application failed");
        this.ngOnInit();
      }else {
        alert("Applied successfully");
        this.route.navigate(['/user']);
      }
    }, error => {
      alert("Error! Application failed");
      this.ngOnInit();
    })
  }
}
