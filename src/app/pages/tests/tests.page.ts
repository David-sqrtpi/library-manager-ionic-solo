import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-tests',
  templateUrl: './tests.page.html',
  styleUrls: ['./tests.page.scss'],
})
export class TestsPage implements OnInit {
  form = this.fb.group({
    input: ['']
  });
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
  }
}