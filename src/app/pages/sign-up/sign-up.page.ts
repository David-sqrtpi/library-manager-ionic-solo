import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

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
    name: ['asd', Validators.required],
    lastname: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });



  constructor(private fb: FormBuilder) {
    this.userForm.valueChanges.subscribe(()=>console.log("Value changed"));
  }

  ngOnInit() {
    console.log("Somehow");
    
  }

  onSubmit() {
    this.isWaiting = true;

    console.log("Form")
    console.log(this.userForm.value)
  }
}