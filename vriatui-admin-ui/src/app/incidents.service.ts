import { Injectable } from '@angular/core';
import { Incident } from './models/incident';
import { IncidentsList } from './models/incidentsList';

@Injectable({
  providedIn: 'root'
})
export class IncidentsService {
  constructor() { }

  getIncidents(page: number){
    let arr = new Array<Incident>(
      new Incident(),
      new Incident(),
      new Incident()
    );
    return new IncidentsList(arr);
  }
}
