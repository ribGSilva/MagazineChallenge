import { Sandwich } from "./sandwich"
import { Promotion } from './promotion';

export interface Order {
    sandwich: Sandwich;
    cost: number;
    promotions: Array<Promotion>
}