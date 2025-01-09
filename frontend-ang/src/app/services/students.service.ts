import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Bill, Payment, Student} from "../model/students.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http : HttpClient) { }

  public getAllPayments() : Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.backendHost}/payments`);
  }

  public getStudents() : Observable<Array<Student>>{
    return this.http.get<Array<Student>>(`${environment.backendHost}/students`);
  }

  public getStudentBills(studentId : bigint) : Observable<Array<Bill>>{
    return this.http.get<Array<Bill>>(`${environment.backendHost}/students/${studentId}/bills`);
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
}
