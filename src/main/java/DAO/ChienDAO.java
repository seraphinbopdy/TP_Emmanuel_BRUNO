package DAO;


import Entites.Chien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ChienDAO implements AutoCloseable{


    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP_NUMERO_2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Chien persist(Chien chien)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(chien);
        entityManager.getTransaction().commit();
        return chien;
    }

    public List<Chien> findAll() {
        Query query = entityManager.createQuery("SELECT C FROM Chien C");
        List<Chien> listeChien = query.getResultList();
        return listeChien;
    }

    public Chien findChienById(int id)
    {
        return entityManager.find(Chien.class,id);
    }

    public void delete(int id){
        Chien chien= findChienById(id);
        entityManager.remove(chien);
    }


    @Override
    public void close() throws Exception {

    }
}
