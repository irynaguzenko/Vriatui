import { Component, OnInit } from '@angular/core';
import { IncidentsService } from '../incidents.service';
import { IncidentsList } from '../models/incidentsList';

@Component({
  selector: 'app-incidents',
  templateUrl: './incidents.component.html',
  styleUrls: ['./incidents.component.css']
})
export class IncidentsComponent implements OnInit {
  model : IncidentsList;

  constructor(private incidentsService : IncidentsService) {
  }

  ngOnInit() {
    this.model = this.incidentsService.getIncidents(0);
  }

}
