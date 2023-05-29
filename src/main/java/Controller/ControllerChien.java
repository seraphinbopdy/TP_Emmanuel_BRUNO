package Controller;

import DAO.ChenilDAO;
import DAO.ChienDAO;
import DAO.PathologieDAO;
import DAO.PersonneDAO;
import Entites.Chien;
import Entites.Pathologie;

import java.util.List;

public class ControllerChien {

    PersonneDAO personDAO = new PersonneDAO();
    ChienDAO chienDAO = new ChienDAO();
    PathologieDAO pathologieDao = new PathologieDAO();
    ChenilDAO chenilDAO = new ChenilDAO();
    public  void insertChien(){
        Chien chien1 = new Chien("BERGER");
        Chien chien2 = new Chien("Boby");
        chien2.setID_PERSONNE(4);
        chien2.setID_CHENIL(2);
        chien1.setID_PERSONNE(4);
        chien1.setID_CHENIL(2);
        //Chien chien3 = new Chien("Berger Allemand");
        //Chien chien4 = new Chien("MaxWELL");

        System.out.println(chenilDAO.findAll());
        System.out.println(personDAO.findAll());

        chienDAO.persist(chien1);
        chienDAO.persist(chien2);
    }

    public List<Chien> getList(){
        List<Chien> listChien = chienDAO.findAll();
        List<Pathologie> pathologieList = pathologieDao.findAll();

        for(Chien chien : listChien) {
            for (Pathologie pathologie : pathologieList) {
                if(pathologie.getID_CHIEN() == chien.getID_CHIEN()) chien.setListPathologie(pathologie);
            }
        }
        return listChien;
    }

    public Chien getChienByID(int id){

        Chien chien1 = chienDAO.findChienById(id);
        return chien1;

    }


}






