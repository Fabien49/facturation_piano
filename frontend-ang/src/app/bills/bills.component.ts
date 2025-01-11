import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {StudentsService} from "../services/students.service";
import {Bill} from "../model/students.model";

@Component({
  selector: 'app-payments',
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit{

  public bills : any;
  public dataSource : any;
  public displayedColumns = ['id', 'date', 'amount', 'type', 'status', 'firstName'];

  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort
  constructor(private studentsService : StudentsService) {
  }

  ngOnInit() {
    this.studentsService.getAllBills().subscribe({
      next : data => {
        console.log(data);
        this.bills = data;
        this.dataSource = new MatTableDataSource(this.bills);
        this.bills.forEach((bill: Bill) => {
          console.log('Checking Bill:', bill);
          console.log('ID:', bill.billNumber);
          console.log('Date:', bill.date);
          console.log('Type:', bill.type);
          console.log('Status:', bill.status);
          console.log('Student:', bill.student.firstName);
        });
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        this.dataSource._updateChangeSubscription();
      },
      error : err => {
        console.log(err)
      }
    })
  }

}
