import { Component, OnInit } from '@angular/core';
import { Product, ProductPayload } from './product.class';
import {PRODUCT_TABLE_CONF} from './products-admin-table.conf';
import { ProductsService } from './products.service';

import { BehaviorSubject } from 'rxjs';

import { BaseTableLoader } from 'app/shared/ui/table/base-table-loader.class';

import { CrudItemOptions } from 'app/shared/utils/crud-item-options/crud-item-options.model';

@Component({
  selector: 'app-products-admin',
  templateUrl: './products-admin.component.html',
  styleUrls: ['./products-admin.component.scss']
})
export class ProductsAdminComponent extends BaseTableLoader implements OnInit {

  public payload$: BehaviorSubject<ProductPayload> = new BehaviorSubject<ProductPayload>({products:[],total:0});
  public conf: CrudItemOptions[] = PRODUCT_TABLE_CONF;
  public entity = Product;

  constructor(
    private readonly productsService: ProductsService
  ) {
    super();
  }

  ngOnInit(): void {

    // Display data table
    this.productsService.getProducts().subscribe(products => 
    {
      this.payload$.next({products: products, total: products.length})
    });

  }

  public onDeleteProduct(ids: number[]): void {
    this.delete(ids[0]);
  }

  public onSave(product: Product): void {
    product.id ? this.update(product) : this.create(product);
  }

  private create(product: Product): void {
    this.handleReload(this.productsService.create(product));
  }

  private update(product: Product): void {
    this.handleReload(this.productsService.update(product));
  }

  // NOTE :Dans la méthode delete de la classe ProductsAdminComponent, l'appel à 
  // handleReload pour gérer la suppression d'un produit ne fonctionnait pas comme prévu.
 /*  private delete(id: number): void {
    this.handleReload(this.productsService.delete(id));
  } */

  // Cette correction permet de s'assurer que l'interface utilisateur est 
  // toujours à jour après une opération de suppression
  private delete(id: number): void {
    this.productsService.delete(id).subscribe({
      next: () => {
        this.productsService.getProducts().subscribe(products => {
          this.payload$.next({ products, total: products.length });
        });
      },
      error: err => {
        console.error('Error deleting product:', err);
      }
    });
  }


}
