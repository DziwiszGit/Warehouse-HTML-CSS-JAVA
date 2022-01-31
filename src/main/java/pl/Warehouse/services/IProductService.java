package pl.Warehouse.services;

import pl.Warehouse.models.Product;

import java.util.List;

public interface IProductService {
    public void AddProducts(Product product);
    public void DeleteProducts(Product product);
    public List<Product> getProductsList();
    public Product getProductById(int id);
}
