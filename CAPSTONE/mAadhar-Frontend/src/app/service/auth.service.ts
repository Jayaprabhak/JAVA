import { Aadhar } from './../model/aadhar';
import { User } from './../model/user';
import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginUrl: string='';
  signUpUrl: string ='';
  applyAadharUrl: string='';
  updateAadharUrl: string='';
  getMyAadharUrl: string='';
  getAllAadharUrl: string='';
  deleteAadharUrl:string='';

  constructor(private http:HttpClient) {
    this.loginUrl = 'http://localhost:8082/maadhar/login';
    this.signUpUrl = 'http://localhost:8082/maadhar/register';
    this.applyAadharUrl = 'http://localhost:8082/maadhar/applyAadhar';
    this.updateAadharUrl = 'http://localhost:8082/maadhar/updateAadhar';
    this.getMyAadharUrl = 'http://localhost:8082/maadhar/getMyAadhar';
    this.getAllAadharUrl = 'http://localhost:8082/maadhar/getAllAadhar';
    this.deleteAadharUrl = 'http://localhost:8082/maadhar/deleteAadhar';
   }

   login(user: User) : Observable<any>{
    return this.http.post(`${this.loginUrl}`,user);
   }

   signUp(user : User) : Observable<any> {
    return this.http.post(`${this.signUpUrl}`,user);
  }

  applyAadhar(aadhar : Aadhar) : Observable<any>{
    return this.http.post(`${this.applyAadharUrl}`,aadhar);
  }

  updateAadhar(aadharnumber:string , aadhar : Aadhar) : Observable<any> {
    return this.http.put(`${this.updateAadharUrl}/${aadharnumber}`,aadhar);
  }
  
  getAadharByNumber(aadharnumber:string) :Observable<any> {
    return this.http.get(`${this.getMyAadharUrl}/${aadharnumber}`);
  }

  getAllAadhar():Observable<any>{
    return this.http.get(`${this.getAllAadharUrl}`)
  }

  deleteAadhar(aadharnumber:string) :Observable<any>{
    return this.http.delete(`${this.deleteAadharUrl}/${aadharnumber}`)
  }
  
}
