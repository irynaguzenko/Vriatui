import { Component, OnInit, ViewChild } from '@angular/core';
import { IncidentsService } from '../incidents.service';
import { IncidentsDataSource } from '../incidents-data-source';
import { MatPaginator } from '../../../node_modules/@angular/material/paginator';
import { tap } from '../../../node_modules/rxjs/operators';
import { Observable, interval } from '../../../node_modules/rxjs';


@Component({
  selector: 'app-incidents',
  templateUrl: './incidents.component.html',
  styleUrls: ['./incidents.component.css']
})
export class IncidentsComponent implements OnInit {
  dataSource : IncidentsDataSource;
  displayedColumns= ["address", "name", "problem", "gender", "diseases", "yearOfBirth", "location" ];

  @ViewChild(MatPaginator) paginator: MatPaginator;


  constructor(private incidentsService : IncidentsService) {
  }

  ngOnInit() {
    this.dataSource = new IncidentsDataSource(this.incidentsService);
    this.dataSource.loadData(0);
    interval(5000)
      .subscribe(obs => {
      if (this.paginator.pageIndex == 0){
        this.dataSource.loadData(0);
      }
    });
  }

  ngAfterViewInit() {
    this.paginator.page
      .pipe(tap(() => this.dataSource.loadData(this.paginator.pageIndex)))
      .subscribe();
  }
}
