import {Gender} from "./gender";
import {Nationality} from "./nationality";
import {Address} from "./address";
import {Note} from "./note";

export class User {
  lastName!: String;
  firstName!: String;
  birthName!: String;
  mothersName!: String;
  gender?: Gender;
  nationality!: Nationality;
  addresses!: Address[];
  phone!: String;
  taxNumber!: String;
  note!: Note;

}
