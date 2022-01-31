package pl.Warehouse.controllers.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Warehouse.models.User;
import pl.Warehouse.services.implement.AccountService;

import java.util.Optional;

@RestController
public class RestAccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value="/user",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        accountService.addUser(user);
        return user;
    }
    @RequestMapping(value="/user/{login}",method = RequestMethod.GET)
    public Optional<User> getUserByLogin(@PathVariable String login){
        return accountService.getUserByLogin(login);
    }
}
