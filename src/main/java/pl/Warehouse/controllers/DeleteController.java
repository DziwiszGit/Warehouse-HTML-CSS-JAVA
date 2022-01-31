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
public class DeleteController {

    @Autowired
    ProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String showProductsWithAreDeleted(Model model){
        model.addAttribute("products",this.productService.getProductsList());
        model.addAttribute("logged", this.sessionObject.isLogged());

        return "delete";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String postProductsToDelete(@RequestParam String name, @RequestParam Float weight) {

        productService.DeleteProducts(new Product(name,weight));
        return "redirect:/delete";
    }
}
