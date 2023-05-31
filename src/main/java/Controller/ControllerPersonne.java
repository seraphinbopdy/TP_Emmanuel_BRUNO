package Controller;

import DAO.ChienDAO;
import DAO.PersonneDAO;
import Entites.Chien;
import Entites.Personne;

import java.util.List;

public class ControllerPersonne {


    PersonneDAO personDAO = new PersonneDAO();
    ChienDAO chienDAO = new ChienDAO();

    public void insertPersonne(){


        Personne p1 =  new Personne(15,28,"Ernesto","Martin");
        Personne p2 =  new Personne(16,38,"DUval","Angelber Le Bon");
        Personne p3 =  new Personne(17,48,"Stephane","Seraphin");
        Personne p4 =  new Personne(18,58,"MAbelle","Anne");

        personDAO.persist(p1);
        personDAO.persist(p2);
        personDAO.persist(p3);
        personDAO.persist(p4);

    }

    public List<Personne> getList(){
        List<Chien> listChien = chienDAO.findAll();
        List<Personne> listPersonne = personDAO.findAll();

        for(Personne personne: listPersonne){
            for(Chien chien: listChien){
                if(chien.getId() == personne.getID_PERSONNE()) personne.setChien(chien); ;
            }
        }
        return listPersonne;
    }


    public Personne getPersonByID(int id){
        Personne personne = personDAO.findPersonneById(id);
        System.err.println(personne);
        return personne;
    }


    public void removePersonne(int id) {
        personDAO.deletePersonne(id);
    }

    public void updatePersonne(int id){
        personDAO.updatePersonne(id);
    }

}
