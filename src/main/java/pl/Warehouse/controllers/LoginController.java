package pl.Warehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.Warehouse.exceptions.AuthValidationException;

import pl.Warehouse.services.implement.AuthenticateSerivice;
import pl.Warehouse.session.SessionObject;
import pl.Warehouse.validation.LoginValidator;

import javax.annotation.Resource;



@Controller
public class LoginController {

    @Autowired
    AuthenticateSerivice authenticateSerivice;

    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String returnSessionBeforeSuccesLogin(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validationAttemptToLogIn(@RequestParam String login, @RequestParam String password) {
        try {
            LoginValidator.validateLogin(login);
            LoginValidator.validatePass(password);
        } catch (AuthValidationException e) {
            return "redirect:/login";
        }
        this.authenticateSerivice.authentication(login,password);

        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/main";
    }
}

