import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { IonicModule } from '@ionic/angular';

import { CantidadDeLibrosPageRoutingModule } from './cantidad-de-libros-routing.module';

import { CantidadDeLibrosPage } from './cantidad-de-libros.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CantidadDeLibrosPageRoutingModule,
    HttpClientModule
  ],
  declarations: [CantidadDeLibrosPage]
})
export class CantidadDeLibrosPageModule {}
