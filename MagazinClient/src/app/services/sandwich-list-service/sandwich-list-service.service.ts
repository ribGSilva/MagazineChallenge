import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Sandwich } from '../../models/sandwich';

@Injectable({
  providedIn: 'root'
})
export class SandwichListServiceService {

  private apiAddress = environment.api_address;

  constructor(private http: HttpClient) { }

  public getSandwichList(): Observable<Sandwich[]> {

    let options = {headers: new HttpHeaders().set('Content-Type', 'application/json')};

    const url = this.apiAddress.concat('sandwichListService/');
    return this.http.get<Sandwich[]>(url, options).pipe(tap(res => {
      if (res) 
        return res;
      else 
        return of(null);
    }))
  }

}
