import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

const firebaseConfig = {
  apiKey: "AIzaSyDRZKqNga3XjnpV2TApAJ593ojI3GiOCxc",
  authDomain: "library-manager-78716.firebaseapp.com",
  projectId: "library-manager-78716",
  storageBucket: "library-manager-78716.appspot.com",
  messagingSenderId: "925918019842",
  appId: "1:925918019842:web:efa8cdc8a2c3dae1a9021b",
  measurementId: "G-LVVJLFPBX7"
};

const firebase = require("firebase");
require("firebase/firestore");
firebase.initializeApp(firebaseConfig);
var db = firebase.firestore();

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.page.html',
  styleUrls: ['./sign-up.page.scss'],
})

export class SignUpPage implements OnInit {
  public isWaiting: boolean = false;
  public userForm = this.fb.group({
    name: ['', Validators.required],
    lastname: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
  });

  constructor(private fb: FormBuilder) { }

  ngOnInit() { }

  onSubmit() {
    console.log(this.userForm.value);
    db.collection("users").add(this.userForm.value)
      .then((docRef) => {
        console.log("Document written with ID: ", docRef.id);
      })
      .catch((error) => {
        console.error("Error adding document: ", error);
      });
  }
}