import {AddressType} from "./address-type";
import {User} from "./user";

export class Address {
  type!: AddressType;
  user!: User;
  postCode!: String;
  city!: String;
  street!: String;
  number!: String;
}
