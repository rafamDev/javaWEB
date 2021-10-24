import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();

  id : number;

  constructor(private employeeService: EmployeeService,private router: Router, private Route: ActivatedRoute) { 
     this.id = 0;
     //Check out this, version TS in VScode must be changed.
  }

  ngOnInit(): void {
     this.id = this.Route.snapshot.params['id'];
     this.employeeService.getEmployeeById(this.id).subscribe(data => {
         this.employee = data;
     }, error => console.log(error));
  }

  updateEmployee(){
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data=>{
      console.log(data);
      this.employee = new Employee();
      this.goToEmployeeList();
    }, error => console.log(error));
    
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
    this.updateEmployee();
}

}
