import {AddressType} from "../model/address-type";
import {User} from "../model/user";

export class NewAddressDTO {
  type?: AddressType;
  user?: User;
  postCode?: String;
  city?: String;
  street?: String;
  number?: String;
}
