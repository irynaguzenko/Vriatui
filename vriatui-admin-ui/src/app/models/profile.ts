import { Incident } from "./incident";
import { Address } from "./address";
import { Genders } from "./enums";

export class Profile {
    id: string;
    firstName : string;
    lastName : string;
    yearOfBirth : number;
    gender : Genders;
    diseases : string;
    rhesusFactor : string;
}