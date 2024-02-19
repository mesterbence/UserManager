import {Component, OnInit} from '@angular/core';
import {User} from "../model/user";
import {DataServiceService} from "../service/data-service.service";
import {
  MatCell, MatCellDef,
  MatColumnDef, MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [
    MatTable,
    MatHeaderRow,
    MatRow,
    MatHeaderRowDef,
    MatRowDef,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderCellDef,
    MatCell,
    MatCellDef
  ],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements  OnInit{

  constructor(private service: DataServiceService) { }

  dataSource!: any;
  userList!: User[];
  displayedColumns: string[] = ['lastName', 'firstName', 'birthName', 'phone', 'taxNumber'];

  ngOnInit() {
    this.service.getAllUsers().subscribe(
      data => {
        this.userList = data;
        console.log(data);
        this.dataSource = new MatTableDataSource(this.userList);
      }
    );
  }

}
