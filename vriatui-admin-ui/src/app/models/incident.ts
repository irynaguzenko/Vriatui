import { Profile } from "./profile";
import { Address } from "./address";

export class Incident {
    id: string;
    location: string; // GeoJsonPoint
    address: Address;
    problem : string;
    happenAt: Date; //LocalDateTime
    patientInfo : Profile;

    constructor() {
    }
}