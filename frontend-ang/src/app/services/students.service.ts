import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Bill, Course, Payment, Student} from "../model/students.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http : HttpClient) { }

  public getAllBills() : Observable<Array<Bill>>{
    return this.http.get<Array<Bill>>(`${environment.backendHost}/bills`);
  }

  public getStudents() : Observable<Array<Student>>{
    return this.http.get<Array<Student>>(`${environment.backendHost}/students`);
  }

  getStudentDetails(studentId: bigint) {
    return this.http.get(`${environment.backendHost}/student-details/${studentId}`);
  }

  public getStudentBills(studentId : bigint) : Observable<Array<Bill>>{
    return this.http.get<Array<Bill>>(`${environment.backendHost}/student/${studentId}/bills`);
  }

  public savePayment(formData : any) : Observable<Payment>{
    return this.http.post<Payment>(`${environment.backendHost}/payments`, formData);
  }

  getPaymentDetails(id: number) {
    return this.http.get(`${environment.backendHost}/payments/${id}/file`,
      {responseType: 'blob'});
  }

  addStudent(student: any): Observable<any> {
    return this.http.post(`${environment.backendHost}/student`, student);
  }

  getStudentCourses(studentId: bigint): Observable<Course[]> {
    return this.http.get<Course[]>(`${environment.backendHost}/student/${studentId}/courses`);
  }



}
