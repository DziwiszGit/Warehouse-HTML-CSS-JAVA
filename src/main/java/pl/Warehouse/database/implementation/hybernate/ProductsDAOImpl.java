package pl.Warehouse.database.implementation.hybernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.Warehouse.database.IProductsDAO;
import pl.Warehouse.models.Product;
import pl.Warehouse.models.Warehouseman;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductsDAOImpl implements IProductsDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void AddProducts(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(product);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void DeleteProducts(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if(product.getWeight()>0){
                session.update(product);
            }
            else{
                session.delete(product);
            }
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> getProductsList() {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.Warehouse.models.Product");
        List<Product> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Product> query = session.createQuery("FROM pl.Warehouse.models.Product WHERE id = :id");
        query.setParameter("id", id);
        try {
            Product product = query.getSingleResult();
            session.close();
            return product;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

}


