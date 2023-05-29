package Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Chien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHIEN")
    private int ID_CHIEN;
    private String nonChien;

    //Correspondence avec Le Chenil
    @JoinColumn(name = "ID_CHENIL")
    private int ID_CHENIL;

    //Correspondence avec La Personne
    @JoinColumn(name = "ID_PERSONNE")
    private int ID_PERSONNE;


    //Correspondence avec les Pathologie
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CHIEN",referencedColumnName = "ID_PATHO")
    private List<Pathologie> listPathologie;

    public Chien(String nonChien) {
        this.nonChien = nonChien;
    }

    public Chien(){}

    public void setID_PERSONNE(int id_personne)
    {
        this.ID_PERSONNE = id_personne;
    }

    public void setID_CHENIL(int id_chenil)
    {
        this.ID_CHENIL = id_chenil;
    }

    public void setListPathologie(Pathologie pathologie)
    {
        this.listPathologie.add(pathologie);
    }

}
