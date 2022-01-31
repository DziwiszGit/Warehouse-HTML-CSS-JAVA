package pl.Warehouse.database.implementation.hybernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.Warehouse.database.IWarehousemanDAO;
import pl.Warehouse.models.User;
import pl.Warehouse.models.Warehouseman;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class WarehousemanDAOImpl implements IWarehousemanDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Warehouseman> getWarehousemen() {
        Session session = this.sessionFactory.openSession();
        Query<Warehouseman> query = session.createQuery("FROM pl.Warehouse.models.Warehouseman");
        List<Warehouseman> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public void addWarehousemen(Warehouseman warehouseman) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(warehouseman);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Warehouseman getWarehousemenById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Warehouseman> query = session.createQuery("FROM pl.Warehouse.models.Warehouseman WHERE id = :id");
        query.setParameter("id", id);
        try {
            Warehouseman warehouseman = query.getSingleResult();
            session.close();
            return warehouseman;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

    @Override
    public Warehouseman getWarehousemanBySurname(String surname) {
        Session session = this.sessionFactory.openSession();
        Query<Warehouseman> query = session.createQuery("FROM pl.Warehouse.models.Warehouseman WHERE surname = :surname");
        query.setParameter("surname", surname);
        try {
            Warehouseman warehouseman = query.getSingleResult();
            session.close();
            return warehouseman;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }
}