package pl.Warehouse.database;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.Warehouse.models.Product;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ProductsDataBase {

        private List<Product> ProductsList = new ArrayList<>();

        public void AddProducts(Product product) {
            boolean add = false;
            int temp_i = 0;
            if (ProductsList.isEmpty()) {
                ProductsList.add(product);
            } else {
                for (int i = 0; i < ProductsList.size(); i++) {
                    if (ProductsList.get(i).getName().equals(product.getName())) {
                        add = true;
                        temp_i = i;
                    }
                }
                if (add == true)
                    ProductsList.get(temp_i).setWeight(ProductsList.get(temp_i).getWeight() + product.getWeight());
                else ProductsList.add(product);
            }
        }

        public void DeleteProducts(Product product) {
            int temp_i = 0;
            for (Product product2 : this.ProductsList) {
                if (product2.getName().equals(product.getName())) {
                    product2.setWeight(product2.getWeight() - product.getWeight());
                    temp_i = ProductsList.indexOf(product2);
                }
            }
            if (ProductsList.get(temp_i).getWeight() == 0)
                ProductsList.remove(temp_i);
        }

        public List<Product> getProductsList() {
            return ProductsList;
        }
}

