import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private urlEmployees = "http://localhost:8080/api/v1/employees";

  constructor(private httpClient: HttpClient) {}

  getEmployeeList() : Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.urlEmployees}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.urlEmployees}`,employee);
  }

  getEmployeeById(id: number) : Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.urlEmployees}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<any>{
    return this.httpClient.put(`${this.urlEmployees}/${id}`, employee);
  }
}
