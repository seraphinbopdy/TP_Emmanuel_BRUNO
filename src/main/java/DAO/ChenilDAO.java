package DAO;

import Entites.Chenil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;


public class ChenilDAO implements AutoCloseable {



    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP_NUMERO_2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Chenil persist(Chenil chenil)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(chenil);
        entityManager.getTransaction().commit();
        return chenil;
    }

    public List<Chenil> findAll() {
        Query query = entityManager.createQuery("SELECT C FROM Chenil C");
        List<Chenil> listeChenil = query.getResultList();
        return listeChenil;
    }

    public Chenil findChenilById(int id)
    {
        return entityManager.find(Chenil.class,id);
    }

    public void delete(int id){
        Chenil chenil = findChenilById(id);
        entityManager.remove(chenil);
    }


    @Override
    public void close() throws Exception {

    }

    public void deleteById(int id) {
        System.err.println(id);
        entityManager.getTransaction().begin();
        entityManager.remove(findChenilById(id));
        entityManager.getTransaction().commit();
    }
}
