package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.Warehouse.services.implement.ProductService;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String statusAboutProductInWarehouse(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());

        model.addAttribute("products",this.productService.getProductsList());
        return "status";
    }
}
