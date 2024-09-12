import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Product } from './product.class';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

    private static productslist: Product[] = null;
    private products$: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);
    private apiUrl = 'http://localhost:8080/products'; 


    constructor(private http: HttpClient) { }


    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.apiUrl).pipe(
            tap(data => this.products$.next(data))
        );
    }

    create(prod: Product): Observable<Product> {
        return this.http.post<Product>(this.apiUrl, prod).pipe(
            tap(newProduct => {
                this.products$.next([...this.products$.value, newProduct]); 
            })
        );
    }

    update(prod: Product): Observable<Product> {
        return this.http.patch<Product>(`${this.apiUrl}/${prod.id}`, prod).pipe(
            tap(updatedProduct => {
                const currentProducts = this.products$.value;
                const index = currentProducts.findIndex(element => element.id === updatedProduct.id);
                if (index > -1) {
                    currentProducts[index] = updatedProduct;
                    this.products$.next([...currentProducts]);
                }
            })
        );
    }

    delete(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
            tap(() => {
                const updatedProducts = this.products$.value.filter(product => product.id !== id);
                this.products$.next(updatedProducts);
            })
        );
    }


    /* getProducts(): Observable<Product[]> {
        if( ! ProductsService.productslist )
        {
            this.http.get<any>('assets/products.json').subscribe(data => {
                ProductsService.productslist = data.data;
                
                this.products$.next(ProductsService.productslist);
            });
        }
        else
        {
            this.products$.next(ProductsService.productslist);
        }

        return this.products$;
    }

    create(prod: Product): Observable<Product[]> {

        ProductsService.productslist.push(prod);
        this.products$.next(ProductsService.productslist);
        
        return this.products$;
    }

    update(prod: Product): Observable<Product[]>{
        ProductsService.productslist.forEach(element => {
            if(element.id == prod.id)
            {
                element.name = prod.name;
                element.category = prod.category;
                element.code = prod.code;
                element.description = prod.description;
                element.image = prod.image;
                element.inventoryStatus = prod.inventoryStatus;
                element.price = prod.price;
                element.quantity = prod.quantity;
                element.rating = prod.rating;
            }
        });
        this.products$.next(ProductsService.productslist);

        return this.products$;
    }


    delete(id: number): Observable<Product[]>{
        ProductsService.productslist = ProductsService.productslist.filter(value => { return value.id !== id } );
        this.products$.next(ProductsService.productslist);
        return this.products$;
    } */
}