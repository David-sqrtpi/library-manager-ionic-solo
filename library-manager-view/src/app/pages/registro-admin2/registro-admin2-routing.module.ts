import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegistroAdmin2Page } from './registro-admin2.page';

const routes: Routes = [
  {
    path: '',
    component: RegistroAdmin2Page
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RegistroAdmin2PageRoutingModule {}
