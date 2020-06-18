package myapp.service;

import myapp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findProduct(int id);
    void saveProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);

}
