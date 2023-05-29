package Controller;

import DAO.ChienDAO;
import DAO.PathologieDAO;
import Entites.Chien;
import Entites.Pathologie;


import java.util.List;

public class ControllerPathologie {


    ChienDAO chienDAO = new ChienDAO();
    PathologieDAO pathologieDAO = new PathologieDAO();

    public List<Pathologie> getList(){
        List<Pathologie> pathologieList = pathologieDAO.findAll();
        for (Pathologie pathologie:pathologieList
        ) {
            System.out.println(pathologie);
        }
        return pathologieList;
    }


    public void insertPathologie() {

        Chien chien1 = chienDAO.findAll().get(0);
        Chien chien = chienDAO.findAll().get(1);
        Pathologie pathologie2 = new Pathologie("herpes", "virus pour allemand");
        Pathologie pathologie3 = new Pathologie("viral ", "virus pour rageux");
        Pathologie pathologie1 = new Pathologie("boudock", "virus pour cheval");
        Pathologie pathologie4 = new Pathologie("rock ", "virus pour berger");


        pathologie1.setID_CHIEN(chienDAO.findAll().get(0).getID_CHIEN());
        pathologie2.setID_CHIEN(chienDAO.findAll().get(0).getID_CHIEN());
        pathologie3.setID_CHIEN(chienDAO.findAll().get(1).getID_CHIEN());
        pathologie4.setID_CHIEN(chienDAO.findAll().get(1).getID_CHIEN());

        pathologieDAO.persist(pathologie1);
        pathologieDAO.persist(pathologie2);
        pathologieDAO.persist(pathologie3);
        pathologieDAO.persist(pathologie4);



    }


    public Pathologie getPathologieByID(int id){
        Pathologie pathologie = pathologieDAO.findPathologieById(id);
        System.err.println(pathologie);
        return pathologie;

    }




/*
*
*     public void deletePathoById(long id) {
        pathologieDao.delete(pathologieDao.findById(id));
    }
*/



    }
