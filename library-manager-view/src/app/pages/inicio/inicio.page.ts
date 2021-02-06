import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
})
export class InicioPage implements OnInit {

private url: string = "http://localhost:8080/BibliotecaAPI-1.0-SNAPSHOT/api/new-admin";
response: any = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  test(){

    this.http.get(this.url).subscribe(
      respuesta => {
        console.log(respuesta);
        (this.response = respuesta);
      },
      error => console.log(error),
      () => console.log("Finished")
    );

  }

}
