import {Component, inject, OnInit, TemplateRef} from '@angular/core';
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
import {animate, state, style, transition, trigger} from "@angular/animations";
import {AddressType} from "../model/address-type";
import {MatButton} from "@angular/material/button";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";

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
    MatCellDef,
    MatButton,
    ReactiveFormsModule,
    MatFormField,
    MatSelect,
    MatInput,
    MatFormFieldModule
  ],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css',
  animations: [
    trigger('showDetails', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class UserListComponent implements  OnInit{

  constructor(private service: DataServiceService, private formBuilder: FormBuilder) { }

  dataSource!: any;
  userList!: User[];
  displayedColumns: string[] = ['lastName', 'firstName', 'birthName', 'phone', 'taxNumber'];
  expanded!: any;
  clicked: boolean = false;
  newUserFormGroup!: FormGroup;


  toggleRow(row: any) {
    if(!this.clicked) {
      if (this.expanded === row) {
        this.expanded = null;
      } else {
        this.expanded = row;
      }
    } else {
      this.clicked = false;
    }
  }
  ngOnInit() {
    this.service.getAllUsers().subscribe(
      data => {
        this.userList = data;
        console.log(data);
        this.dataSource = new MatTableDataSource(this.userList);
      }
    );
  }

  initNewUserFormGroup() {
    this.newUserFormGroup = this.formBuilder.group({
      lastName: [''],
      firstName: [''],
      birthName: [''],
      mothersName: [''],
      gender: [''],
      nationality: [''],
      addresses: [''],
      phone: [''],
      taxNumber: [''],
    });
  }

  getAddressType(type: AddressType): String {
    return type == AddressType.PERMANENT ? "Állandó lakcím" : (type == AddressType.MAIL ? "Levelezési cím" : "Tartózkodási hely");
  }

  protected readonly AddressType = AddressType;

  private modalService = inject(NgbModal);

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }


  onSubmit() {

  }
}
