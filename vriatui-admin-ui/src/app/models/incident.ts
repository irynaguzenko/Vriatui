import { Profile } from "./profile";
import { Address } from "./address";

export class Incident {
    id: string;
    location: Location; // GeoJsonPoint
    address: Address;
    problem : string;
    happenAt: Date; //LocalDateTime
    patient : Profile;

    constructor() {
    }
}