import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { IncidentsComponent } from './incidents/incidents.component';
import { IncidentComponent } from './incident/incident.component';

@NgModule({
  declarations: [
    AppComponent,
    IncidentsComponent,
    IncidentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
