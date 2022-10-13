import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-aadhar',
  templateUrl: './all-aadhar.component.html',
  styleUrls: ['./all-aadhar.component.css']
})
export class AllAadharComponent implements OnInit {

  aadhar:any;
  constructor(private authService:AuthService,private route : Router) { }

  ngOnInit(): void {
    this.authService.getAllAadhar().subscribe(data=>{
      this.aadhar=data;
    });
  }

  Back(){
    this.route.navigate(['admin']);

  }

  deleteAadhar(aadharnumber:string){
    this.authService.deleteAadhar(aadharnumber).subscribe(res=>{
      alert("Deleted");
      this.route.navigate(['/admin']);
    });
  }

}
