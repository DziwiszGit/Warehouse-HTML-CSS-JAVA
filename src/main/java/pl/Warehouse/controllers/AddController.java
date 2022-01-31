package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.Warehouse.models.Product;
import pl.Warehouse.services.implement.ProductService;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AddController {

    @Autowired
    ProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showProductsWithAreAdded(Model model){
        model.addAttribute("products",this.productService.getProductsList());
        model.addAttribute("logged", sessionObject.isLogged());
        return "add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postProductToAdd(@RequestParam String name, @RequestParam Float weight) {
        productService.AddProducts(new Product(name,weight));
        return "redirect:/add";
    }

}
