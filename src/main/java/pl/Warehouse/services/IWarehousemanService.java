package pl.Warehouse.services;

import pl.Warehouse.models.Warehouseman;

import java.util.List;

public interface IWarehousemanService {
    public List<Warehouseman> getWarehousemen();
    public void addWarehousemen(Warehouseman warehousemen);
    public Warehouseman getWarehousemenById(int id);
    public Warehouseman getWarehousemenBySurname(String surname);
}
