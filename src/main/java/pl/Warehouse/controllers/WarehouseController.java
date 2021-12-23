package pl.Warehouse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.Warehouse.database.WarehousemanDataBase;
import pl.Warehouse.models.Warehouseman;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class WarehouseController {
    @Autowired
    WarehousemanDataBase warehousemanDataBase;
    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/warehouseman", method = RequestMethod.GET)
    public String status(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("warehouseman", this.warehousemanDataBase.getWarehousemen());
        return "warehouseman";
    }
}
