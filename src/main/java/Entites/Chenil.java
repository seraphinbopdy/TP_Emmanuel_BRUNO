package Entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Chenil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHENIL")
    private int id;

    private String nomChenil;


    @OneToMany
    @JoinColumn(name = "ID_CHENIL", referencedColumnName = "ID_CHENIL")
    private List<Chien> listChien;

    public Chenil(String nomChenil){
        this.nomChenil = nomChenil;
    }

    public Chenil(){}

    public void setListChien(Chien chien)
    {
        this.listChien.add(chien);
    }

    public List<Chien> getListChien()
    {
        return listChien;
    }


}
