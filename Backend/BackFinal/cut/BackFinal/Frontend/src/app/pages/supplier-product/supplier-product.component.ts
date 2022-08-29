import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-supplier-product',
  templateUrl: './supplier-product.component.html',
  styleUrls: ['./supplier-product.component.css'],
})
export class SupplierProductComponent implements OnInit {
  products: Product[] = [];
  supplierId!: string;

  constructor(
    private readonly productService: ProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.supplierId = params['id'];
    });
    this.productService.fetchProductBySupplierId(this.supplierId).subscribe({
      next: (res) => {
        this.products = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
