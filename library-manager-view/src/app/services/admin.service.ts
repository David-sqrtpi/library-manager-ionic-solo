import { Injectable } from '@angular/core';
import { AdminI } from 'src/app/models/admin/admin.interface'
import { Observable } from 'rxjs'
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private urlAPI = 'http://127.0.0.1:8080/test-1.0/api/user';

  //private url = "http://jsonplaceholder.typicode.com/posts";

  constructor(private http:HttpClient) { }

  addUser(data:object){

    return this.http.post(this.urlAPI, data);

  }

  validator(data:object){

    return this.http.post('http://127.0.0.1:8080/test-1.0/api/validation', data);

  }

  /*updateUser(data:string):Observable<AdminI> {

    return this.http.post<AdminI>(this.urlAPI, data, {headers:this.headers});

  }*/

}
