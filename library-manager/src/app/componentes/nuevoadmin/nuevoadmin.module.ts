import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NuevoadminPageRoutingModule } from './nuevoadmin-routing.module';

import { NuevoadminPage } from './nuevoadmin.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NuevoadminPageRoutingModule
  ],
  declarations: [NuevoadminPage]
})
export class NuevoadminPageModule {}
