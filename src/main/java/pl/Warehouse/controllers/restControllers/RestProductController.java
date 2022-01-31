package pl.Warehouse.controllers.restControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Warehouse.models.Product;
import pl.Warehouse.services.implement.ProductService;

@RestController
public class RestProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/status/{id}",method = RequestMethod.GET)
    public Product getProductByID(@PathVariable int id){
        return productService.getProductById(id);
    }

    @RequestMapping(value="/status",method=RequestMethod.POST)
    public Product setProductWeight(@RequestBody Product product){
        productService.AddProducts(product);
        return product;
    }

}
