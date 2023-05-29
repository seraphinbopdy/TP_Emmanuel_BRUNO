package Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity

public class Personne {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PERSONNE")
    private int ID_PERSONNE;

    private int identifiant;

    private int agePersonne;
    private String nomPersonne;
    private String prenomPersonne;


    //Correspondence avec le chien
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CHIEN",referencedColumnName = "ID_PERSONNE")
    private Chien chien;

    public Personne(int identifiant, int agePersonne, String nomPersonne, String prenomPersonne)
    {
        this.identifiant = identifiant;
        this.agePersonne = agePersonne;
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;

    }



}
