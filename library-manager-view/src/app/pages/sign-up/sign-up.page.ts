import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

import { AdminService } from '../../services/admin.service'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.page.html',
  styleUrls: ['./sign-up.page.scss'],
})
export class SignUpPage implements OnInit {

  public loading:boolean;
  public result: object;  
  public error:any;

  constructor(private adminService:AdminService, private http: HttpClient) {

    this.loading = false;

   }

  ngOnInit() {
  }

  onSubmit(data:object){

    this.loading = true;

    this.adminService.validator(data).subscribe(result=>{
      console.log(result);
      this.result = result;
    }, error=>{
      console.log(error);
      this.error = error;
    }, ()=>{
      this.loading = false;
    })

    console.warn(data);

  }

}
