package Controller;

import DAO.ChenilDAO;
import DAO.ChienDAO;
import Entites.Chenil;
import Entites.Chien;

import java.util.List;

public class ControllerChenil {

    ChienDAO chienDAO = new ChienDAO();
    private static  final ChenilDAO chenilDAO = new ChenilDAO();

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
        return listeChenils;
    }

    public void removeChenil(int id) {
        chenilDAO.deleteById(id);
    }

    public void updateChenil(Chenil chenil){
        chenilDAO.updateChenil(chenil);
    }

    public static List<Chien> chiensOfChenil(List<Integer> liste){
        return chenilDAO.returnListChien(liste);
    }

}
