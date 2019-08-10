import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Order } from 'src/app/models/order';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  private apiAddress = environment.api_address;

  constructor(private http: HttpClient) { }

  public getSendOrder(order: Order): Observable<any> {

    let options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };

    const url = this.apiAddress.concat('receiveOrderService/');
    return this.http.post<Number>(url, order, options).pipe(tap(res => {
      if (res)
        return res;
      else
        return of(null);
    }))
  }
}
