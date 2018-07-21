import { Incident } from "./incident";

export class IncidentsList {
    items: Array<Incident>;

    constructor(items: Array<Incident>) {
        this.items = items;
    }
}