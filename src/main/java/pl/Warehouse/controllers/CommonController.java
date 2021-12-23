package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.Warehouse.session.SessionObject;


@Controller
public class CommonController {

    @Autowired
    SessionObject sessionObject;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String basiclogin(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "redirect:/main";
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String basic(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }
}
