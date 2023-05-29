package DAO;


import Entites.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PersonneDAO implements AutoCloseable{



    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP_NUMERO_2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Personne persist(Personne personne)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(personne);
        entityManager.getTransaction().commit();
        return personne;
    }

    public List<Personne> findAll() {
        Query query = entityManager.createQuery("SELECT P FROM Personne P");
        List<Personne> listePersonne = query.getResultList();
        return listePersonne;
    }

    public Personne findPersonneById(int id)
    {
        return entityManager.find(Personne.class,id);
    }

    public void delete(int id){
        Personne personne= findPersonneById(id);
        entityManager.remove(personne);
    }


    @Override
    public void close() throws Exception {

    }
}
