import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SupplierProductComponent } from './supplier-product.component';

const routes: Routes = [{ path: ':id', component: SupplierProductComponent }];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SupplierProductModule {}
