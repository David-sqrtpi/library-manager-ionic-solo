import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-cantidad-de-libros',
  templateUrl: './cantidad-de-libros.page.html',
  styleUrls: ['./cantidad-de-libros.page.scss'],
})
export class CantidadDeLibrosPage implements OnInit {

  private url: string = "https://jsonplaceholder.typicode.com/posts";

  private NombreBiblioteca: string = "";
  private number: any = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  sendRequest(){

    console.log("Sending Request");

    this.http.post(this.url,{
         "nombreBiblioteca":this.NombreBiblioteca,
         "cantidad":this.number 
       },{
         headers:{
          // 'Access-Control-Request-Headers':'Content-Type',
          //'Content-Type': 'application/json'
          //'Access-Control-Allow-Headers': '*'
         }
       })
       .subscribe(
         result => console.log(result),
         error => console.log(error),
        () => console.log("Finished") 
       );

  }

}
