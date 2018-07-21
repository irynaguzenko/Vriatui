import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import { Incident } from "./models/incident";
import { BehaviorSubject, Observable } from "../../node_modules/rxjs";
import { IncidentsService } from "./incidents.service";
import { interval, of } from 'rxjs';
import { filter, map, take, toArray, catchError, finalize } from 'rxjs/operators';
import { PaginationPage } from "./models/pagination";

export class IncidentsDataSource implements DataSource<Incident>{
    private incidentsSubject = new BehaviorSubject<Incident[]>([]);
    private loadingSubject = new BehaviorSubject<boolean>(false);

    public loading$ = this.loadingSubject.asObservable();

    totalItems : number;
    pageSize : number = 15;

    constructor(private service: IncidentsService){
    }

    connect(collectionViewer: CollectionViewer): Observable<Incident[]>{
        return this.incidentsSubject.asObservable();
    }
    
    disconnect(collectionViewer: CollectionViewer): void {
        this.incidentsSubject.complete();
        this.loadingSubject.complete();
    }

    loadData(pageIndex = 0){
        this.loadingSubject.next(true);

        this.service.getIncidents(pageIndex, this.pageSize)
            .pipe<PaginationPage<Incident>>(
            catchError(() => of([])),
            finalize(() => this.loadingSubject.next(false))
        ).subscribe(page => {
            this.incidentsSubject.next(page.content);
            this.totalItems = page.totalElements;
        });
    }
}