package myapp.service;

import myapp.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl  implements IProductService{
    private static Map<Integer,Product> products;
    static {
        products= new HashMap<>();
        products.put(1,new Product(1,"Iphone","Chống nước, hàng nhập",10,"Apple"));
        products.put(2,new Product(1,"Galaxy","Chống nước, hàng nhập",11,"Sang Sung"));
        products.put(3,new Product(1,"Nokia 10i","Chống nước, hàng nhập",12,"Nokia"));
        products.put(4,new Product(1,"Iphone 11","Bảo hàng mãi mãi, hàng nhập",14,"Apple"));
        products.put(5,new Product(1,"Opple Max","Giá rẻ, hàng nội địa",10,"Opple"));
        products.put(6,new Product(1,"Xiaomi pro","Camera mặt trước, hàng nhập",10,"Xiaomi"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findProduct(int id) {
        return products.get(id);
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id,product);

    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);

    }
}
