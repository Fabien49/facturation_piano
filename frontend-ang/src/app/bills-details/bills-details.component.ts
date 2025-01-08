import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {Bill, Payment} from "../model/students.model";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-bills-details',
  templateUrl: './bills-details.component.html',
  styleUrl: './bills-details.component.css'
})
export class BillsDetailsComponent implements OnInit{

  studentId! : bigint;
  studentBills! : Array<Bill>;
  billsDataSource! : MatTableDataSource<Bill>;
  public displayedColumns = ['id', 'date', 'amount', 'type', 'status', 'firstName', 'details'];

  constructor(private activatedRoute : ActivatedRoute,
              private studentsService : StudentsService,
              private router : Router) {
  }

  ngOnInit() {
    this.studentId = this.activatedRoute.snapshot.params['billId'];
    this.studentsService.getStudentBills(this.studentId).subscribe({
      next : value => {
        this.studentBills = value;
        this.billsDataSource = new MatTableDataSource<Bill>(this.studentBills);
      },
      error : err => {
        console.log(err);
      }
    });
  }

  newPayment() {
    this.router.navigateByUrl(`/admin/new-bill/${this.studentId}`)
  }

  paymentDetails(payment:Payment) {
    this.router.navigateByUrl(`/admin/payment-details/${payment.id}`);
  }
}
