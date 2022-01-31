package pl.Warehouse.services.implement;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.Warehouse.database.IWarehousemanDAO;
import pl.Warehouse.models.Product;
import pl.Warehouse.models.Warehouseman;
import pl.Warehouse.services.IWarehousemanService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehousemanService implements IWarehousemanService {

    @Autowired
    IWarehousemanDAO warehousemanDAO;

    private List<Warehouseman> WarehousemanList = new ArrayList<>();

    public List<Warehouseman> getWarehousemen() {
       return warehousemanDAO.getWarehousemen();
    }

    public void addWarehousemen(Warehouseman warehousemen) {
        warehousemanDAO.addWarehousemen(warehousemen);
    }

    @Override
    public Warehouseman getWarehousemenById(int id) {
        return warehousemanDAO.getWarehousemenById(id);
    }

    @Override
    public Warehouseman getWarehousemenBySurname(String surname) {
        return warehousemanDAO.getWarehousemanBySurname(surname);
    }
}
