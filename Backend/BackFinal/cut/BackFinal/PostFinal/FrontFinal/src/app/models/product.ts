export interface Product {
  id: number;
  name: string;
  stock: number;
  price: number;
  image: string;
  supplierId: number;
  supplierName: string;
  createdAt?: Date;
  updatedAt?: Date;
}
