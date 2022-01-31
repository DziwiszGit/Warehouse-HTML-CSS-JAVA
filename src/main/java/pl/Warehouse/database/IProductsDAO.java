package pl.Warehouse.database;

import pl.Warehouse.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductsDAO {
    public void AddProducts(Product product);
    public void DeleteProducts(Product product);
    public List<Product> getProductsList();
    public Product getProductById(int id);
}
