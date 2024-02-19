import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {environment} from "../environments/environment";
import {Gender} from "../model/gender";

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private httpClient: HttpClient) { }

  getAllUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${environment.baseUrl}/user/all`);
  }

  getAllGenders(): Observable<Gender[]> {
    return this.httpClient.get<Gender[]>(`${environment.baseUrl}/gender/all`);
  }
}
