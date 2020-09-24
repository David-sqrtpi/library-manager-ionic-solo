import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NuevoadminPage } from './nuevoadmin.page';

const routes: Routes = [
  {
    path: '',
    component: NuevoadminPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NuevoadminPageRoutingModule {}
