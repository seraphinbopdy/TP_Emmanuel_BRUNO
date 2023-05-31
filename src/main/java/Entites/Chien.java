package Entites;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Chien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CHIEN")
    private int id;
    private String nonChien;

    public void setChenil(Chenil chenil) {
        this.chenil = chenil;
        chenil.addChien(this);
    }

    //Correspondence avec Le Chenil
    @ManyToOne
    @JoinColumn(name = "ID_CHENIL")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ToString.Exclude
    private Chenil chenil;

    //Correspondence avec La Personne
    @JoinColumn(name = "ID_PERSONNE")
    private int ID_PERSONNE;


    //Correspondence avec les Pathologie
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CHIEN")
    @ToString.Exclude
    private List<Pathologie> listPathologie = new ArrayList<>();

    public Chien(String nonChien) {
        this.nonChien = nonChien;
    }

    public Chien(){}

    public void setID_PERSONNE(int id_personne)
    {
        this.ID_PERSONNE = id_personne;
    }

    public void setListPathologie(Pathologie pathologie)
    {
        this.listPathologie.add(pathologie);
    }

}
