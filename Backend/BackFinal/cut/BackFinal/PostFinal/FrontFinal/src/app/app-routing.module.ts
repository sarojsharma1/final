import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormComponent } from './components/common/form/form.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AdminGuard } from './helpers/admin.guard';
import { AuthGuard } from './helpers/auth.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('../app/pages/product/product.module').then(
        (m) => m.ProductModule
      ),
  },
  {
    path: 'supplier',
    loadChildren: () =>
      import('../app/pages/supplier-product/supplier-product.module').then(
        (m) => m.SupplierProductModule
      ),
  },
  {
    path: 'login',
    component: FormComponent,
  },

  {
    path: 'admin',
    loadChildren: () =>
      import('../app/pages/admin-dashboard/admin-dashboard.module').then(
        (m) => m.AdminDashboardModule
      ),
    canActivate: [AuthGuard, AdminGuard],
  },

  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
