import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { Aadhar } from 'src/app/model/aadhar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-aadhar',
  templateUrl: './update-aadhar.component.html',
  styleUrls: ['./update-aadhar.component.css']
})
export class UpdateAadharComponent implements OnInit {

  aadharnumber:string='';
  aadhar: Aadhar = new Aadhar();

  genders : string[];
  constructor(private authService: AuthService,private router:Router,private route:ActivatedRoute) {
    this.genders = [
      'Male',
      'Female',
      'Other'
    ]
   }

  ngOnInit(): void {
    this.aadharnumber = this.route.snapshot.params['aadharnumber'];
    console.log(this.aadharnumber);
    this.authService.getAadharByNumber(this.aadharnumber).subscribe(data => {
      this.aadhar = data;
    },error=>console.log(error));

    
  }
  submit(){
    this.authService.updateAadhar(this.aadharnumber,this.aadhar).subscribe(data=>{
      this.router.navigate(['/user']);
    },error=>console.log(error));
    
  }

}
