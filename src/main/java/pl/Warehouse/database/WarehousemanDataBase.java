package pl.Warehouse.database;

import org.springframework.stereotype.Component;
import pl.Warehouse.models.Positions;
import pl.Warehouse.models.Warehouseman;

import java.util.ArrayList;
import java.util.List;

@Component
public class WarehousemanDataBase {
    private List<Warehouseman> warehousemen = new ArrayList<>();

    public WarehousemanDataBase(){
        warehousemen.add(new Warehouseman("Paweł","Dziwisz",22, Positions.MANAGER));
        warehousemen.add(new Warehouseman("Andrzej","Ryba",32, Positions.DRIVER));
        warehousemen.add(new Warehouseman("Sławomir","Disco",22, Positions.HELPER));
        warehousemen.add(new Warehouseman("Mirosław","Gruz",22, Positions.PACKER));
    }


    public List<Warehouseman> getWarehousemen() {
        return warehousemen;
    }

    public void setWarehousemen(List<Warehouseman> warehousemen) {
        this.warehousemen = warehousemen;
    }
}
