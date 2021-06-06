import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { IonicModule } from '@ionic/angular';

import { RegistroAdmin2PageRoutingModule } from './registro-admin2-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RegistroAdmin2PageRoutingModule,
    HttpClientModule,
  ],
})
export class RegistroAdmin2PageModule {}
