package Controller;

import DAO.ChenilDAO;
import DAO.ChienDAO;
import Entites.Chenil;
import Entites.Chien;

import java.util.List;

public class ControllerChenil {

    ChienDAO chienDAO = new ChienDAO();
    ChenilDAO chenilDAO = new ChenilDAO();

    public void addChenil(){
        Chenil chenil = new Chenil("Petite Cage");
        Chenil chenil1 = new Chenil("Grande CAge");

        chenilDAO.persist(chenil);
        chenilDAO.persist(chenil1);
    }

    public Chenil getChenilByID(int id){
        Chenil chenil1 =  chenilDAO.findChenilById(id);
        return chenil1;
    }

    public List<Chenil> getList(){
        List<Chenil> listeChenils = chenilDAO.findAll();
        List<Chien> listeChiens = chienDAO.findAll();
        for (Chenil chenil : listeChenils){
            for (Chien chien : listeChiens){
                if (chien.getID_CHENIL() == chenil.getId()){
                    chenil.setListChien(chien);
                }
            }
        }

        return listeChenils;
    }


}
