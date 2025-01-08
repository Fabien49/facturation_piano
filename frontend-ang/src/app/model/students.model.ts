export interface Student {
  studentId : bigint,
  firstName : string,
  lastName : string,
  address : string,
  zipCode : string,
  city : string,
  phoneNumber : string,
  mail : string,
  student : boolean
}

export interface Payment {
  id : number,
  date : string,
  amount : number,
  type : string,
  status : string,
  file : string,
  student : Student
}

export interface Bill {
  billId : number,
  date : string,
  amount : number,
  type : string,
  status : string,
  file : string,
  student : Student
}

export enum PaymentType {
  CASH, CHECK, TRANSFER, DEPOSIT
}

export enum PaymentStatus {
  CREATED, VALIDATED, REJECTED
}
