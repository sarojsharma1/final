import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  constructor(private readonly productService: ProductService) {}

  ngOnInit(): void {
    this.productService.fetchProduct().subscribe({
      next: (res) => {
        this.products = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
