import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { BASE_URL_FILE } from 'src/app/constants/endpoints';
import { isLoggedIn } from 'src/app/helpers/authData';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})
export class ProductDetailComponent implements OnInit {
  selectedItems: number = 1;
  product!: Product;
  prodId!: string;
  urlPrefix: string = BASE_URL_FILE;

  constructor(
    private readonly productService: ProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params: Params) => {
      this.prodId = params['id'];
    });

    this.productService.fetchProductById(this.prodId).subscribe({
      next: (res) => {
        this.product = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  onBuyButtonClick() {
    console.log('Button clicked');
  }

  onDecrementCount() {
    if (this.selectedItems > 1) {
      this.selectedItems--;
    }
  }

  onIncrementCount() {
    if (this.selectedItems < this.product.stock) this.selectedItems++;
  }

  isLoggedIn() {
    return isLoggedIn();
  }
}
