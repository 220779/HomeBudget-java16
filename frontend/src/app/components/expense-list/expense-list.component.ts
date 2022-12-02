import { Component, OnInit } from '@angular/core';
import { expenseListUrl, homeUrl, incomeListUrl} from "../../models/urls";

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.css']
})
export class ExpenseListComponent implements OnInit {

  home = homeUrl
  expense = expenseListUrl
  income = incomeListUrl
  constructor() { }

  ngOnInit(): void {
  }

}
