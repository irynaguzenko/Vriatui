import { Injectable } from '@angular/core';
import { Incident } from './models/incident';
import { IncidentsList } from './models/incidentsList';
import { Profile } from './models/profile';
import { Genders } from './models/enums';
import { Address } from './models/address';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { PaginationPage } from './pagination';
import { element } from '../../node_modules/protractor';

@Injectable({
  providedIn: 'root'
})
export class IncidentsService {
  constructor(private _http: HttpClient) { }

  getIncidents(page: number){
    let arr = new Array();
    let items = this._http.get<PaginationPage<Incident>>(this.getUrl(page, 10))
      .subscribe(page => {
        page.content.forEach(element => arr.push(element));
        console.log(arr);
      });
    let item = this.getStubIncident();
    arr.push(item)
    
    return new IncidentsList(arr);
  }

  private getUrl(page: number, size: number){
    return `${environment.baseAddress}incident?page=${page}&size=${size}`;
  }

  private getStubIncident() {
    let profile = new Profile();
    profile.phonesToNotify = "555-2368; +380501234569";
    profile.birthday = new Date(1960, 12, 10);
    profile.diseases = "Volchanka";
    profile.firstName = "Ivan";
    profile.lastName = "Ivanenko";
    profile.gender = Genders.MALE;

    let address = new Address();
    address.city = "Kyiv, not Kiev";
    address.comment = "Entrance code: 666";
    address.floor = 5;
    address.value = "Hrushevskoho, 7";

    let item = new Incident();
    item.problem = "Heart";
    item.address = address;
    item.patientInfo = profile;
    item.happenAt = new Date(Date.now());

    return item;
  }
}
