import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { NavbarComponent } from './components/common/navbar/navbar.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormComponent } from './components/common/form/form.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { CardComponent } from './components/common/card/card.component';
import { TableComponent } from './components/common/table/table.component';
import { AuthInterceptor } from './helpers/auth.interceptor';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { ProductComponent } from './pages/product/product.component';
import { AdminProductComponent } from './pages/admin-product/admin-product.component';
import { SupplierProductComponent } from './pages/supplier-product/supplier-product.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    ProductDetailComponent,
    FormComponent,
    PageNotFoundComponent,
    CardComponent,
    TableComponent,
    AdminDashboardComponent,
    ProductComponent,
    AdminProductComponent,
    SupplierProductComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule, BrowserAnimationsModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
