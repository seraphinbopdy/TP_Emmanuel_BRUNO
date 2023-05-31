package DAO;


import Entites.Pathologie;
import Entites.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PersonneDAO implements AutoCloseable{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP_NUMERO_2");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Personne persist(Personne personne){
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

    public Personne findPersonneById(int id){
        return entityManager.find(Personne.class,id);
    }

    public void deletePersonne(int id){
        entityManager.getTransaction().begin();
        Personne personne= findPersonneById(id);
        entityManager.remove(personne);
        entityManager.getTransaction().commit();
    }


    public Personne updatePersonne(int id){
        Personne personne1 = findPersonneById(id);
        entityManager.getTransaction().begin();
        personne1.setNomPersonne(personne1.getNomPersonne());
        personne1.setPrenomPersonne(personne1.getPrenomPersonne());
        personne1.setAgePersonne(personne1.getAgePersonne());
        personne1.setIdentifiant(personne1.getIdentifiant());
        entityManager.persist(personne1);
        entityManager.getTransaction().commit();
        return personne1;
    }

    public Personne updatePersonne(Personne personne){
        Personne personne1 = findPersonneById(personne.getID_PERSONNE());
        entityManager.getTransaction().begin();
        personne1.setNomPersonne(personne.getNomPersonne());
        personne1.setPrenomPersonne(personne.getPrenomPersonne());
        personne1.setAgePersonne(personne.getAgePersonne());
        personne1.setIdentifiant(personne.getIdentifiant());
        entityManager.persist(personne);
        entityManager.getTransaction().commit();
        return personne;
    }


    @Override
    public void close() throws Exception {

    }
}
