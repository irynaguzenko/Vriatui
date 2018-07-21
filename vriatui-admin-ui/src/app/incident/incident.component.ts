import { Component, OnInit, Input } from '@angular/core';
import { Incident } from '../models/incident';

@Component({
  selector: 'app-incident',
  templateUrl: './incident.component.html',
  styleUrls: ['./incident.component.css']
})
export class IncidentComponent implements OnInit {
  isExpanded: boolean = false;
  @Input() model: Incident;

  constructor() {
  }

  ngOnInit() {
  }

  expand(){
    this.isExpanded = !this.isExpanded;
  }
}
