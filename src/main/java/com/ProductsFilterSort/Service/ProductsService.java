package com.ProductsFilterSort.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ProductsFilterSort.Model.Product;

@Service
public class ProductsService 
{
    // Private field to hold the list of products
    private List<Product> products = new ArrayList<>();

    //Add another method to insert products
    public void addProduct(Product product) {
        products.add(product);
    }

    //Add another method fetch barcode only based price range
    public List<String> fetchBarcodesByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .map(Product::getBarCode)
                .collect(Collectors.toList());
    }

    // Method to filter products by price range
    public List<Product> filterByPrice(double minPrice, double maxPrice) {
        return products.stream()
                .filter(product -> product.getPrice() >= minPrice && product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Method to sort products by price in ascending order
    public List<Product> sortByPrice() {
        return products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .collect(Collectors.toList());
    }

    //Add another method to fetch barCode and sort products by price in ascending order
    public List<String> fetchBarcodesSortedByPrice() {
        return products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .map(Product::getBarCode)
                .collect(Collectors.toList());
    }

}
