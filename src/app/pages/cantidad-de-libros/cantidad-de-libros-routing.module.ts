import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CantidadDeLibrosPage } from './cantidad-de-libros.page';

const routes: Routes = [
  {
    path: '',
    component: CantidadDeLibrosPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CantidadDeLibrosPageRoutingModule {}
