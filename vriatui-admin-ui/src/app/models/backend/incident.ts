import { Address } from "./address";

export class Incident {
    id: string;
    location: string; // GeoJsonPoint
    happenInAddress: Address;
    problem : string;
    happenAt: Date; //LocalDateTime
}