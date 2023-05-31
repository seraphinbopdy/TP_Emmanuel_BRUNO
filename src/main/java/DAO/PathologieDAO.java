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

    public void deletePathologie(int id){
        entityManager.getTransaction().begin();
        Pathologie pathologie = findPathologieById(id);
        entityManager.remove(pathologie);
        entityManager.getTransaction().commit();
    }



    public Pathologie updatePathologie(int id){
        Pathologie pathologie1 = findPathologieById(id);
        entityManager.getTransaction().begin();
        pathologie1.setNomPathologie(pathologie1.getNomPathologie());
        pathologie1.setDescriptionPathologie(pathologie1.getDescriptionPathologie());
        entityManager.persist(pathologie1);
        entityManager.getTransaction().commit();
        return pathologie1;
    }


    public Pathologie updatePathologie(Pathologie pathologie){
        Pathologie pathologie1 = findPathologieById(pathologie.getID_PATHO());
        entityManager.getTransaction().begin();
        pathologie1.setNomPathologie(pathologie.getNomPathologie());
        pathologie1.setDescriptionPathologie(pathologie.getDescriptionPathologie());
        entityManager.persist(pathologie);
        entityManager.getTransaction().commit();
        return pathologie;
    }


    @Override
    public void close() throws Exception {

    }
}
