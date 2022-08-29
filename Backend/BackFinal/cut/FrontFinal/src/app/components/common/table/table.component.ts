import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}
  products = [
    {
      id: 1,
      name: 'Hydrogen',
      image:
        'https://www.wikipedia.org/portal/wikipedia.org/assets/img/Wikipedia-logo-v2.png',
      price: 1.0079,
      inStock: 1,
    },
    {
      id: 2,
      name: 'Helium',
      image:
        'https://www.wikipedia.org/portal/wikipedia.org/assets/img/Wikipedia-logo-v2.png',
      price: 4.0026,
      inStock: 2,
    },
    {
      id: 3,
      name: 'Lithium',
      image:
        'https://www.wikipedia.org/portal/wikipedia.org/assets/img/Wikipedia-logo-v2.png',
      price: 6.941,
      inStock: 3,
    },
  ];

  columns = Object.keys(this.products[0]);
}
