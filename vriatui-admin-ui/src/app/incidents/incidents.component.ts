import { Component, OnInit } from '@angular/core';
import { IncidentsService } from '../incidents.service';
import { IncidentsDataSource } from '../incidents-data-source';

@Component({
  selector: 'app-incidents',
  templateUrl: './incidents.component.html',
  styleUrls: ['./incidents.component.css']
})
export class IncidentsComponent implements OnInit {
  dataSource : IncidentsDataSource;
  displayedColumns= ["address", "name", "problem", "gender", "diseases", "yearOfBirth", "location" ];

  constructor(private incidentsService : IncidentsService) {
  }

  ngOnInit() {
    this.dataSource = new IncidentsDataSource(this.incidentsService);
    this.dataSource.loadData(0);
  }

}
