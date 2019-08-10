import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Ingredient } from '../../models/ingredient';
import { Promotion } from '../../models/promotion';
import { Sandwich } from '../../models/sandwich';
import { Order } from 'src/app/models/order';

@Injectable({
  providedIn: 'root'
})
export class IngredientListService {

  private apiAddress = environment.api_address;

  constructor(private http: HttpClient) { }

  public getIngredientList(): Observable<Ingredient[]> {

    let options = {headers: new HttpHeaders().set('Content-Type', 'application/json')};

    const url = this.apiAddress.concat('ingredientListService/');
    return this.http.get<Ingredient[]>(url, options).pipe(tap(res => {
      if (res) 
        return res;
      else 
        return of(null);
    }))
  }

  public getPromotionList(): Observable<Promotion[]> {

    let options = {headers: new HttpHeaders().set('Content-Type', 'application/json')};

    const url = this.apiAddress.concat('promotionListService/');
    return this.http.get<Promotion[]>(url, options).pipe(tap(res => {
      if (res) 
        return res;
      else 
        return of(null);
    }))
  }

  public getCalculateSandwichPrice(sandwich: Sandwich): Observable<Order> {

    let options = {headers: new HttpHeaders().set('Content-Type', 'application/json')};

    const url = this.apiAddress.concat('calculateSandwichPriceService/');
    return this.http.post<Order>(url, sandwich, options).pipe(tap(res => {
      if (res) 
        return res;
      else 
        return of(null);
    }))
  }

}
