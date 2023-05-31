package Entites;


import Controller.ControllerChenil;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
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


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ID_CHENIL")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonIdentityReference(alwaysAsId = true )
    private List<Chien> listChien = new ArrayList<>();

    public Chenil(String nomChenil){
        this.nomChenil = nomChenil;
    }

    public Chenil(){}

    public void setListChien(List<Chien> listChien)
    {
        this.listChien = listChien;
    }
    public void addChien(Chien chien)
    {
        this.listChien.add(chien);
    }

    public List<Chien> getListChien()
    {
        return listChien;
    }

    @JsonSetter("listChien")
    public List<Chien> getListChien(List<Integer> listId) {
        return ControllerChenil.chiensOfChenil(listId);
    }








}
