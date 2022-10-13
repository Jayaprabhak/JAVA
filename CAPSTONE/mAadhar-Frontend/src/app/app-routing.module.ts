import { AllAadharComponent } from './component/all-aadhar/all-aadhar.component';
import { UpdateAadharComponent } from './component/update-aadhar/update-aadhar.component';
import { ApplyAadharComponent } from './component/apply-aadhar/apply-aadhar.component';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginComponent } from './auth/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"user",component:UserDashboardComponent},
  {path:"admin",component:AdminDashboardComponent},
  {path:"applyAadhar",component:ApplyAadharComponent},
  {path:"updateAadhar",component:UpdateAadharComponent},
  {path:"allAadhar",component:AllAadharComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
