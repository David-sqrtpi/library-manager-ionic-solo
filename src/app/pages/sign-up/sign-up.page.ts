import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';

import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.page.html',
  styleUrls: ['./sign-up.page.scss'],
})
export class SignUpPage implements OnInit {

  public isWaiting: boolean = false;
  public result: object;
  public error: any;

  public userForm = this.fb.group({
    name: ['', Validators.required],
    lastname: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });



  constructor(private adminService: AdminService, private fb: FormBuilder) {
    this.userForm.valueChanges.subscribe(value => console.log(value));
  }

  ngOnInit() {
  }

  onSubmit(data: object) {
    this.isWaiting = true;

    data["rol"] = "administrador";

    this.adminService.addUser(data).subscribe(
      result => {
        console.log(result);
        this.isWaiting = false;
      }
    );

    console.warn(data);
  }
}