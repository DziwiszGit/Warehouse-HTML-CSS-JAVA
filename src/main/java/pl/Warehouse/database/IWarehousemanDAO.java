package pl.Warehouse.database;

import pl.Warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemanDAO {
    public List<Warehouseman> getWarehousemen();
    public void addWarehousemen(Warehouseman warehouseman);
    public Warehouseman getWarehousemenById(int id);
    public Warehouseman getWarehousemanBySurname(String surname);
}
