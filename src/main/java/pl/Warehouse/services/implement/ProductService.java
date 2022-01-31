package pl.Warehouse.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Warehouse.database.IProductsDAO;
import pl.Warehouse.models.Product;
import pl.Warehouse.services.IProductService;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductsDAO productsDAO;

    public void AddProducts(Product product) {
        boolean added = false;
        if (getProductsList().isEmpty()) {
            productsDAO.AddProducts(product);
            added = true;
        } else {
            for (Product temp_product : getProductsList()) {
                if (temp_product.getName().equals(product.getName())) {
                    temp_product.setWeight(temp_product.getWeight() + product.getWeight());
                    productsDAO.AddProducts(temp_product);
                    added = true;
                }
            }
        }
        if(added==false){
            productsDAO.AddProducts(product);
        }
    }

    public void DeleteProducts(Product product) {
        for (Product product2 : getProductsList()) {
            if (product2.getName().equals(product.getName())) {
                product2.setWeight(product2.getWeight() - product.getWeight());
                productsDAO.DeleteProducts(product2);
            }
        }
    }

    public List<Product> getProductsList() {
        return this.productsDAO.getProductsList();
    }

    @Override
    public Product getProductById(int id) {
        return productsDAO.getProductById(id);
    }

}
