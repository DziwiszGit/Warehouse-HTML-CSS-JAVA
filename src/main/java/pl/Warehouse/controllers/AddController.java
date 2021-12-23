package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.Warehouse.database.ProductsDataBase;
import pl.Warehouse.models.Product;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AddController {

    @Autowired
    ProductsDataBase productsDataBase;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        List<Product> products;
        products = this.productsDataBase.getProductsList();
        model.addAttribute("products",products);
        model.addAttribute("logged", this.sessionObject.isLogged());

        return "add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String AddProducts(@RequestParam String name, @RequestParam Float weight) {
        productsDataBase.AddProducts(new Product(name,weight));
        return "redirect:/add";
    }

}
