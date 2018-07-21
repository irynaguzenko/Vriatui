import { Incident } from "./incident";
import { Address } from "./address";
import { Genders } from "./enums";

export class Profile {
    id: string;
    firstName : string;
    lastName : string;
    birthday : Date; //LocalDate
    gender : Genders;
    diseases : string;
    phonesToNotify: string;
    address: Address;
    incidents : Array<Incident>;
}