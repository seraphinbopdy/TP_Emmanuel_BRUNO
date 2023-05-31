package DAO;

import Entites.Chenil;
import Entites.Chien;
import jakarta.persistence.*;

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



    public void deleteById(int id) {
        System.err.println(id);
        entityManager.getTransaction().begin();
        entityManager.remove(findChenilById(id));
        entityManager.getTransaction().commit();
    }



    public Chenil updateChenil(Chenil chenil) {
        entityManager.getTransaction().begin();
        System.err.println("liste des chiens" + chenil.getListChien());
        entityManager.merge(chenil);
        entityManager.getTransaction().commit();
        return chenil;
    }

    public List<Chien> returnListChien(List<Integer> list){
        TypedQuery<Chien> query = entityManager.createQuery("Select C FROM Chien c where c.id in :list", Chien.class);
        query.setParameter("list",list);
        List<Chien> c = query.getResultList();
        System.err.println(c);
        return c;
    }

    @Override
    public void close() throws Exception {

    }

}
