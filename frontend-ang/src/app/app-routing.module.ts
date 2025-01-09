import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProfileComponent} from "./profile/profile.component";
import {LoginComponent} from "./login/login.component";
import {LoadStudentsComponent} from "./load-students/load-students.component";
import {LoadPaymentsComponent} from "./load-payments/load-payments.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {StudentsComponent} from "./students/students.component";
import {BillsComponent} from "./bills/bills.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorization.guard";
import {StudentDetailsComponent} from "./student-details/student-details.component";
import {NewBillComponent} from "./new-bill/new-bill.component";
import {PaymentDetailsComponent} from "./payment-details/payment-details.component";
import {BillsDetailsComponent} from "./bills-details/bills-details.component";
import {NewStudentComponent} from "./new-student/new-student.component";

const routes: Routes = [
  {path : "", component : LoginComponent},
  {path : "login", component : LoginComponent},
  {path : "admin", component : AdminTemplateComponent,
    canActivate : [AuthGuard],
    children : [
      {path : "home", component : HomeComponent},
      {path : "profile", component : ProfileComponent},
      {path : "dashboard", component : DashboardComponent},
      {path : "students", component : StudentsComponent},
      {path : "payments", component : BillsComponent},
      {path : "bills-details/:studentId", component : BillsDetailsComponent},
      {path : "student-details/:studentId", component : StudentDetailsComponent},
      {path : "new-student", component : NewStudentComponent},
      {path : "new-bill/:studentId", component : NewBillComponent},
      {path : "payment-details/:id", component : PaymentDetailsComponent},
      {
        path : "loadStudents", component : LoadStudentsComponent,
        canActivate : [AuthorizationGuard], data : {roles : ['ADMIN']}
      },
      {path : "loadPayments", component : LoadPaymentsComponent,
        canActivate : [AuthorizationGuard], data : {roles : ['ADMIN']}
      },

    ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
