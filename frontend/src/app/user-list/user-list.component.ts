import {Component, inject, OnInit} from '@angular/core';
import {User} from "../model/user";
import {DataServiceService} from "../service/data-service.service";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
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
import {Gender} from "../model/gender";
import {Nationality} from "../model/nationality";
import {NewUserDTO} from "../dto/new-user-dto";
import {NewAddressDTO} from "../dto/new-address-dto";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {NgIf} from "@angular/common";

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
    MatFormFieldModule,
    NgIf
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
  genders!: Gender[];
  nationalities!: Nationality[];


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
        this.dataSource = new MatTableDataSource(this.userList);
      }
    );
    this.service.getAllGenders().subscribe(
      data => {
        this.genders = data;
      }
    );
    this.service.getAllNationalities().subscribe(
      data => {
        this.nationalities = data;
      }
    );
    this.initNewUserFormGroup();
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
      permanentPostCode: [''],
      permanentCity: [''],
      permanentStreet: [''],
      permanentNumber: [''],
      mailPostCode: [''],
      mailCity: [''],
      mailStreet: [''],
      mailNumber: [''],
      residencePostCode: [''],
      residenceCity: [''],
      residenceStreet: [''],
      residenceNumber: [''],
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
    const permanentAddressDTO : NewAddressDTO = {
      type: AddressType.PERMANENT,
      postCode: this.newUserFormGroup.get('permanentPostCode')?.value,
      city: this.newUserFormGroup.get('permanentCity')?.value,
      street: this.newUserFormGroup.get('permanentStreet')?.value,
      number: this.newUserFormGroup.get('permanentNumber')?.value,
    };
    const mailAddressDTO : NewAddressDTO = {
      type: AddressType.MAIL,
      postCode: this.newUserFormGroup.get('mailPostCode')?.value,
      city: this.newUserFormGroup.get('mailCity')?.value,
      street: this.newUserFormGroup.get('mailStreet')?.value,
      number: this.newUserFormGroup.get('mailNumber')?.value,
    };
    const residenceAddressDTO : NewAddressDTO = {
      type: AddressType.RESIDENCE,
      postCode: this.newUserFormGroup.get('residencePostCode')?.value,
      city: this.newUserFormGroup.get('residenceCity')?.value,
      street: this.newUserFormGroup.get('residenceStreet')?.value,
      number: this.newUserFormGroup.get('residenceNumber')?.value,
    };
    const userDTO : NewUserDTO = {
      lastName: this.newUserFormGroup.get('lastName')?.value,
      firstName: this.newUserFormGroup.get('firstName')?.value,
      birthName: this.newUserFormGroup.get('birthName')?.value,
      mothersName: this.newUserFormGroup.get('mothersName')?.value,
      genderId: this.newUserFormGroup.get('gender')?.value,
      nationalityId: this.newUserFormGroup.get('nationality')?.value,
      phone: this.newUserFormGroup.get('phone')?.value,
      taxNumber: this.newUserFormGroup.get('taxNumber')?.value,
      addresses: []
    };
    if(permanentAddressDTO.postCode != null && permanentAddressDTO.postCode.length > 0) {
      userDTO.addresses?.push(permanentAddressDTO);
    }
    if(mailAddressDTO.postCode != null && mailAddressDTO.postCode.length > 0) {
      userDTO.addresses?.push(mailAddressDTO);
    }
    if(residenceAddressDTO.postCode != null && residenceAddressDTO.postCode.length > 0) {
      userDTO.addresses?.push(residenceAddressDTO);
    }
    this.service.recordNewUser(userDTO).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }
}
