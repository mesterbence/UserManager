import {Gender} from "../model/gender";
import {Nationality} from "../model/nationality";
import {NewAddressDTO} from "./new-address-dto";

export class NewUserDTO {
  lastName?: String;
  firstName?: String;
  birthName?: String;
  mothersName?: String;
  genderId?: number;
  nationalityId?: number;
  addresses?: NewAddressDTO[];
  phone?: String;
  taxNumber?: String;
  note?: String;
}
