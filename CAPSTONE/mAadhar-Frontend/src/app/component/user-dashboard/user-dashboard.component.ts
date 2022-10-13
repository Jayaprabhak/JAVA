import { Observable } from 'rxjs';
import { AuthService } from 'src/app/service/auth.service';
import { Aadhar } from 'src/app/model/aadhar';
import { User } from 'src/app/model/user';
import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css'],
})
export class UserDashboardComponent implements OnInit {

  aadhar:any;
  name:string='';
  dob:string='';
  gender:string='';
  mobilenumber:string='';
  housenumber:string='';
  street:string='';
  district:string='';
  state:string='';
  pincode:string='';
  aadharnumber:string='';
  constructor(private route:ActivatedRoute, private authService: AuthService,private router : Router) { }
  ngOnInit(): void {
  }


  logout() {
    localStorage.removeItem("token");
    this.router.navigate(['/']);
  }

  submit(aadharnumber:string){
    this.authService.getAadharByNumber(aadharnumber).subscribe(res=>{
      this.aadhar=res;
      console.log(this.aadhar);
    },error=>alert("Error"));
  }
  
  applyAadhar(){
    this.router.navigate(['/applyAadhar'])
  }

  updateAadhar(aadharnumber:string){
    this.router.navigate(['/updateAadhar',aadharnumber])
  }

  duplicateAadhar(aadharnumber:string){
    alert("You have applied duplicate aadhar card for "+aadharnumber);
  }

  deleteAadhar(aadharnumber:string){
    this.authService.deleteAadhar(aadharnumber).subscribe(res=>{
      alert("Deleted");
      this.router.navigate(['/user']);
    });
  }

}
