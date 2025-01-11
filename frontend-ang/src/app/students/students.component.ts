import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {Student} from "../model/students.model";
import {MatTableDataSource} from "@angular/material/table";
import {Router} from "@angular/router";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent implements OnInit{
  students! : Array<Student>;
  studentsDataSource! : MatTableDataSource<Student>;
  displayedColumns : string[]=['studentId', 'firstName', 'lastName', 'address', 'zipCode', 'city', 'phoneNumber', 'mail', 'student', 'bills', 'details']

  constructor(private studentsService : StudentsService, private router : Router) {
  }

  ngOnInit() {
    this.studentsService.getStudents().subscribe({
      next : data => {
        this.students = data;
        this.studentsDataSource = new MatTableDataSource<Student>(this.students);
      },
      error : err => {
        console.log(err)
      }
    })
  }

  studentBills(student: Student) {
    this.router.navigateByUrl(`/admin/bills-details/${student.studentId}`)

  }

  newStudent() {
    this.router.navigateByUrl(`/admin/new-student`)
  }

  studentDetails(student: Student) {
    this.router.navigateByUrl(`/admin/student-details/${student.studentId}`);
  }
}
