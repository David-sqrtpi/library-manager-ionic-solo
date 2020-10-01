import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'fin',
    pathMatch: 'full'
  },
  {
    path: 'inicio',
    loadChildren: () => import('./pages/inicio/inicio.module').then( m => m.InicioPageModule)
  },
  {
    path: 'registro-admin',
    loadChildren: () => import('./pages/registro-admin/registro-admin.module').then( m => m.RegistroAdminPageModule)
  },
  {
    path: 'tab1',
    loadChildren: () => import('./pages/tab1/tab1.module').then( m => m.Tab1PageModule)
  },
  {
    path: 'registro-admin2',
    loadChildren: () => import('./pages/registro-admin2/registro-admin2.module').then( m => m.RegistroAdmin2PageModule)
  },
  {
    path: 'cantidad-de-libros',
    loadChildren: () => import('./pages/cantidad-de-libros/cantidad-de-libros.module').then( m => m.CantidadDeLibrosPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
