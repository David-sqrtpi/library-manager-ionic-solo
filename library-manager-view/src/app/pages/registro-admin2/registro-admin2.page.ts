import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service'
import{ HttpClient, HttpHeaders } from '@angular/common/http'

@Component({
  selector: 'app-registro-admin2',
  templateUrl: './registro-admin2.page.html',
  styleUrls: ['./registro-admin2.page.scss'],
})

export class RegistroAdmin2Page implements OnInit {

  //private url: string = "https://jsonplaceholder.typicode.com/posts";

  constructor(private adminService:AdminService, private http:HttpClient) {

   }

  ngOnInit() {

  }

  test(){
    //code
  }

  onSubmit(data:object){

    data["rol"] = "administrador";

    this.adminService.addUser(data).subscribe(result=>console.log(result));

    console.warn(data);

  }

}
