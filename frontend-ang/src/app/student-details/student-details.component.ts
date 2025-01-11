import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { StudentsService } from "../services/students.service";
import { Bill, Student, Course } from "../model/students.model";

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  studentId!: bigint;
  studentDetails!: any;
  studentBills: Bill[] = [];
  studentCourses: Course[] = [];
  showBills: boolean = false;
  showCourses: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private studentsService: StudentsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.studentId = this.activatedRoute.snapshot.params['studentId'];
    this.studentsService.getStudentDetails(this.studentId).subscribe({
      next : value => {
        this.studentDetails = value;
      },
      error : err => {
        console.log(err);
      }
    });
  }

  loadStudentBills(): void {
    if (!this.showBills) {
      this.studentsService.getStudentBills(this.studentId).subscribe({
        next: (bills: Bill[]) => {
          this.studentBills = bills;
          this.showBills = true;
        },
        error: (err) => {
          console.error('Erreur lors de la récupération des factures :', err);
        }
      });
    } else {
      this.showBills = false;
    }
  }

  loadStudentCourses(): void {
    if (!this.showCourses) {
      this.studentsService.getStudentCourses(this.studentId).subscribe({
        next: (courses: Course[]) => {
          this.studentCourses = courses;
          console.log(courses)
          this.showCourses = true;
        },
        error: (err) => {
          console.error('Erreur lors de la récupération des cours :', err);
        }
      });
    } else {
      this.showCourses = false;
    }
  }

  viewBillDetails(bill: Bill): void {
    this.router.navigateByUrl(`/admin/bill-details/${bill.billNumber}`);
  }

  newBill(): void {
    this.router.navigateByUrl(`/admin/new-bill/${this.studentId}`);
  }

}
