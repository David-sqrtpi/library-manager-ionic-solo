import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.page.html',
  styleUrls: ['./sign-up.page.scss'],
})
export class SignUpPage implements OnInit {

  public loading:boolean;
  public result: object;  

  constructor(private http: HttpClient) {

    this.loading = false;

   }

  ngOnInit() {
  }

  onSubmit(data:object){

    this.loading = true;

    this.http.post('https://jsonplaceholder.typicode.com/posts', data).subscribe(result=>{
      console.log(result);
      this.result = result;

      if(!this.result){
        alert("Error en el servidor")
      }
      else{
        this.loading = false
      }

    })

  }

}
