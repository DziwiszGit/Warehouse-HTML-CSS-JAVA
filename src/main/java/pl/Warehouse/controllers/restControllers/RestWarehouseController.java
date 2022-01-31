package pl.Warehouse.controllers.restControllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Warehouse.models.Warehouseman;
import pl.Warehouse.services.implement.WarehousemanService;

@RestController
public class RestWarehouseController {

    @Autowired
    WarehousemanService warehousemanService;

    @RequestMapping(value="/warehouseman/{id}",method = RequestMethod.GET)
    public Warehouseman getWarehousemanByID(@PathVariable int id){
        return warehousemanService.getWarehousemenById(id);
    }

    @RequestMapping(value="/warehouseman/about/{surname}",method = RequestMethod.GET)
    public Warehouseman getWarehousemanBySurname(@PathVariable String surname){
        return warehousemanService.getWarehousemenBySurname(surname);
    }

    @RequestMapping(value="/warehouseman",method = RequestMethod.POST)
    public Warehouseman addWarehouseman(@RequestBody Warehouseman warehouseman){
        warehousemanService.addWarehousemen(warehouseman);
        return warehouseman;
    }
}
