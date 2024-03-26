package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mezzo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroMatricola;



    public Mezzo() {}

    public Mezzo( int numeroMatricola){
        this.numeroMatricola=numeroMatricola;
    }



    public Long getId() {
        return id;
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }

    public void setNumeroMatricola(int numeroMatricola) {
        this.numeroMatricola = numeroMatricola;
    }





}
