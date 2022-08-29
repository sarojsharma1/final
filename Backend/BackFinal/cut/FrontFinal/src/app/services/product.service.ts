import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private readonly http: HttpClient) {}

  fetchProduct(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8080/api/v1/product/');
  }

  fetchProductById(id: string): Observable<Product> {
    return this.http.get<Product>('http://localhost:8080/api/v1/product/' + id);
  }

  fetchProductBySupplierId(id: string): Observable<Product[]> {
    return this.http.get<Product[]>(
      'http://localhost:8080/api/v1/product/bysupplier/' + id
    );
  }
}
