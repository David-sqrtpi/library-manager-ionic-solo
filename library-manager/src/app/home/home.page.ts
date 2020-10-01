import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private http: HttpClient) {}

  public objt: any = null;
  public url: any = "https://jsonplaceholder.typicode.com/todos/1";

  ngOnInit() {

    this.consulta();

  }

  consulta(){

    this.http.get(this.url).subscribe(
      respuesta => this.objt = respuesta,
      error=> console.log(error)
    )

  }

}
