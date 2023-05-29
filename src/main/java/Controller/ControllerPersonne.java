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
                if(chien.getID_CHIEN() == personne.getID_PERSONNE()) personne.setChien(chien); ;
            }
        }
        return listPersonne;
    }


    public Personne getPersonByID(int id){
        Personne personne = personDAO.findPersonneById(id);
        System.err.println(personne);
        return personne;
    }


/*


    public void updatePerson(long id ,String nom , String prenom ){
        Personne user = personDAO.findById(id);
        String[] param = null;
        param[0]=nom;
        param[1]= prenom;
        personDAO.update(user,param);
    }

*
    public void deleteChienPersonnne(long idPersonne) {

        listChien = chienDAO.findAll();
        listPersonne = personDAO.findAll();
        pathologieList = pathologieDao.findAll();
        for(Personne p: listPersonne){
            for(Chien c: listChien){
                if(c.getPersonne_id() == p.getPersonne_id()){
                    p.setChien(c);
                }
            }
        }

        Personne p = new Personne();
        for(Personne pers: listPersonne){
            if(pers.getPersonne_id() == idPersonne)
                p = pers;
        }
        for(Pathologie patho: pathologieList){
            if (patho.getChien_id() ==p.getChien().getChien_id())
                pathologieDao.delete(patho);
        }
        chienDAO.delete(p.getChien());
    }

*
* */




}
