package DAO;



import Entites.Pathologie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PathologieDAO implements AutoCloseable{




    public Pathologie persist(Pathologie pathologie)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(pathologie);
        entityManager.getTransaction().commit();
        return pathologie;
    }

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP_NUMERO_2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Pathologie> findAll() {
        Query query = entityManager.createQuery(" SELECT P FROM Pathologie P ");
        List<Pathologie> listePathologie = query.getResultList();
        return listePathologie;
    }



    public Pathologie findPathologieById(int id)
    {
        return entityManager.find(Pathologie.class,id);
    }

    public void delete(int id){
        Pathologie pathologie = findPathologieById(id);
        entityManager.remove(pathologie);
    }



    @Override
    public void close() throws Exception {

    }
}
