import { Component, Input, OnInit } from '@angular/core';
import { BASE_URL_FILE } from 'src/app/constants/endpoints';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {
  @Input() product!: Product;

  urlPrefix: string = BASE_URL_FILE;
  constructor() {}

  ngOnInit(): void {}
}
