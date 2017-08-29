import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class UserService {

  constructor(private http: Http) { }

  addUser(user): Observable<any> {
    // let headers = new Headers({'Authorization': 'asdfasdfasdfasd'});
    // let options = new RequestOptions({headers: headers});

    return this.http.post('http://localhost:8080/Movieflix/api/Users', user)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getUser(userName, password): Observable<any> {
    // let headers = new Headers({'Authorization': 'asdfasdfasdfasd'});
    // let options = new RequestOptions({headers: headers});

    return this.http.post(`http://localhost:8080/Movieflix/api/Users/userName/${userName}`, password)
      .map(response => response.json())
      .catch((error) => Observable.throw(error.statusText));
  }

}
