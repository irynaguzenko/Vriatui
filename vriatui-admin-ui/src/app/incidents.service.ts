import { Injectable } from '@angular/core';
import { Incident } from './models/incident';
import { IncidentsList } from './models/incidentsList';
import { Profile } from './models/backend/profile';
import { Genders } from './models/enums';
import { Address } from './models/backend/address';

@Injectable({
  providedIn: 'root'
})
export class IncidentsService {
  constructor() { }

  getIncidents(page: number){
    let item = this.getStubIncident();
    let arr = new Array<Incident>(
      item
    );
    return new IncidentsList(arr);
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
    item.happenInAddress = address;
    item.profile = profile;
    item.happenAt = new Date(Date.now());
    return item;
  }
}
