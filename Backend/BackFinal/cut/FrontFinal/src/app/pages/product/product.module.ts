import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from '../product-detail/product-detail.component';
import { ProductComponent } from './product.component';

const routes: Routes = [
  { path: '', component: ProductComponent },
  { path: 'product-detail/:id', component: ProductDetailComponent },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductModule {}
