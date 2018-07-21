import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-incident',
  templateUrl: './incident.component.html',
  styleUrls: ['./incident.component.css']
})
export class IncidentComponent implements OnInit {
  isExpanded: boolean;
  model: Incident;

  constructor(model: Incident) {
    this.model = model;
  }

  ngOnInit() {
  }

  expand(){
    this.isExpanded = !this.isExpanded;
  }
}
