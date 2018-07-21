import { Injectable } from '@angular/core';
import { Incident } from './models/incident';
import { Profile } from './models/profile';
import { Genders } from './models/enums';
import { Address } from './models/address';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { PaginationPage } from './models/pagination';
import { Observable } from '../../node_modules/rxjs';


@Injectable({
  providedIn: 'root'
})
export class IncidentsService {
  constructor(private _http: HttpClient) { }

  getIncidents(pageNumber: number, size: number) : Observable<PaginationPage<Incident>> {
    let page = this._http.get<PaginationPage<Incident>>(this.getUrl(pageNumber, size));
    return page;
  }

  private getUrl(page: number, size: number){
    return `${environment.baseAddress}incident?page=${page}&size=${size}`;
  }

}
