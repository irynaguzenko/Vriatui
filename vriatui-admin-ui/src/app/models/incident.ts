import { Profile } from "./backend/profile";
import { Address } from "./backend/address";

export class Incident {
    id: string;
    location: string; // GeoJsonPoint
    happenInAddress: Address;
    problem : string;
    happenAt: Date; //LocalDateTime
    profile : Profile;

    constructor() {
    }
}