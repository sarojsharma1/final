import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard.component';
import { AdminProductComponent } from '../admin-product/admin-product.component';

const routes: Routes = [
  { path: '', component: AdminDashboardComponent },
  { path: 'products', component: AdminProductComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminDashboardModule {}
