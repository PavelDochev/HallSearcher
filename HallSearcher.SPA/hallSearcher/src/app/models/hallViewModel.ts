import { HallAttributesViewModel } from "./hallAttributesViewModel";
import { HallAvailabilitiesViewModel } from "./hallAvailabilitiesViewModel";

export class HallViewModel{
    id:number;
    name:string;
    attributes:HallAttributesViewModel[];
    availabilities:HallAvailabilitiesViewModel[];
    pricePerHour:number;
    pricePerHourNight:number;
    startOfNightPeriod:string;
    minNumberOfPeople:number;
    endOfNightPeriod:string;
    avrgPrice:number;

    
}