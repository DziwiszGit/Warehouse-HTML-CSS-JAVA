package pl.Warehouse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.Warehouse.services.implement.WarehousemanService;
import pl.Warehouse.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class WarehouseController {

    @Autowired
    WarehousemanService warehousemanService;
    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/warehouseman", method = RequestMethod.GET)
    public String statusAboutWarehousemanInWarehouse(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("warehouseman", this.warehousemanService.getWarehousemen());
        return "warehouseman";
    }
}
