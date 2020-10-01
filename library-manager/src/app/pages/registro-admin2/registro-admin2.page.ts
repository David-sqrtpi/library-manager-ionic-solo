import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-registro-admin2',
  templateUrl: './registro-admin2.page.html',
  styleUrls: ['./registro-admin2.page.scss'],
})
export class RegistroAdmin2Page implements OnInit {

  private url: string = "http://localhost:8080/BibliotecaAPI-1.0-SNAPSHOT/api/new-admin";

  private Nombre: string = "";
  private Apellido: string = "";
  private Email: string = "";
  private Password: string = "";
  private Edad: string = "";

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  sendRequest(){

  console.log("Sending Request");

    this.http.post(this.url,{
         "nombre":this.Nombre,
         "apellido":this.Apellido,
         "email":this.Email,
         "pass":this.Password,
         "edad":this.Edad 
       },{
         headers:{
           'Content-Type': 'application/json',
           'Access-Control-Request-Headers':'application/json',
           'Access-Control-Request-Method': 'application/json'
         }
       })
       .subscribe(
         result => console.log(result),
         error => console.log(error),
        () => console.log("Terminado") 
       );

  }

}
