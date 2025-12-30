package com.ProductsFilterSort.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductsFilterSort.Model.Product;
import com.ProductsFilterSort.Service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsFilterSortController 
{
    @Autowired
    private ProductsService productsService;

    // POST mapping to add products data
    @PostMapping
    public ResponseEntity<String> addProducts(@RequestBody List<Product> products) {
        products.forEach(product -> productsService.addProduct(product));
        return ResponseEntity.status(HttpStatus.OK).body("Products added successfully!");
    }

    // GET mapping to filter products by price range
    @GetMapping("/filter/price/{minPrice}/{maxPrice}")
    public ResponseEntity<?> filterProductsByPrice(@PathVariable double minPrice, @PathVariable double maxPrice) {
        List<Product> filteredProducts = productsService.filterByPrice(minPrice, maxPrice);
        if (filteredProducts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No products found within the specified price range.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredProducts);
    }

    //GET mapping to fetch barcodes by price range
    @GetMapping("/barcodes/price/{minPrice}/{maxPrice}")
    public ResponseEntity<?> fetchBarcodesByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {
        List<String> barcodes = productsService.fetchBarcodesByPriceRange(minPrice, maxPrice);
        if (barcodes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No barCoded products found within the specified price range.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(barcodes);
    }

    // GET mapping to sort products by price
    @GetMapping("/sort")
    public ResponseEntity<?> sortProductsByPrice() {
        List<Product> sortedProducts = productsService.sortByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(sortedProducts);
    }

    //GET mapping to fetch barcodes sorted by price
    @GetMapping("/barcodes/sorted")
    public ResponseEntity<?> fetchBarcodesSortedByPrice() {
        List<String> barcodes = productsService.fetchBarcodesSortedByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(barcodes);
    }
}
