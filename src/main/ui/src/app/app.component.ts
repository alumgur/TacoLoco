import { Component } from '@angular/core';
import { CustomerService } from "../app/customer.service";
import { Customer } from "../app/customer";
import { Observable } from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Taco Loco Customers';
  customers: Observable<Customer[]>;

  constructor(private customerService: CustomerService) {}

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.customers = this.customerService.getCustomersList();
  }

}
