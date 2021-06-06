import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-tab1',
  templateUrl: './tab1.page.html',
  styleUrls: ['./tab1.page.scss'],
})
export class Tab1Page implements OnInit {

  private url = 'http://127.0.0.1:8080/test-1.0/api/user/';

  private urljson = "http://jsonplaceholder.typicode.com/posts/1";

  private nombre: string = "";
  private apellido: string = "";
  private email: string = "R";
  private password: string = "";
  private edad: string = "";

  something:object;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    
    this.http.get(this.url+encodeURIComponent(this.email)).subscribe(result=>{
    (this.something = result);
    console.log(this.something);
  });

  }

  sendRequest(){

    console.log("Sending Request");

    this.http.get(this.url).subscribe(result=>(this.something = result));

  }

}
