import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";
import {User} from "../model/user";
import {environment} from "../environments/environment";
import {Gender} from "../model/gender";
import {Nationality} from "../model/nationality";
import {NewUserDTO} from "../dto/new-user-dto";

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private httpClient: HttpClient) {
  }

  getAllUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${environment.baseUrl}/user/all`);
  }

  getAllGenders(): Observable<Gender[]> {
    return this.httpClient.get<Gender[]>(`${environment.baseUrl}/gender/all`);
  }

  getAllNationalities(): Observable<Nationality[]> {
    return this.httpClient.get<Nationality[]>(`${environment.baseUrl}/nationality/all`);
  }

  recordNewUser(user: NewUserDTO) {
    return this.httpClient.post<NewUserDTO>(`${environment.baseUrl}/user/create`, user)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
      return throwError(error.error);
  }


}
