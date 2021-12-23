package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.Warehouse.database.ProductsDataBase;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;



@Controller
public class ProductController {
    @Autowired
    ProductsDataBase productDataBase;
    @Resource
    SessionObject sessionObject;
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String status(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());

        model.addAttribute("products",this.productDataBase.getProductsList());
        return "status";
    }
}
