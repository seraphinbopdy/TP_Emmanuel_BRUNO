package Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Pathologie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PATHO")
    private int ID_PATHO;

    private String nomPathologie;
    private String descriptionPathologie;

    @Column(name = "ID_CHIEN")
    private int ID_CHIEN;


    public Pathologie( String nomPathologie, String descriptionPathologie) {
        this.nomPathologie = nomPathologie;
        this.descriptionPathologie = descriptionPathologie;
    }


    public void setID_PATHO(int patho)
    {
        this.ID_PATHO = patho;
    }

}
