package team5.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mezzo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    private int numeroMatricola;

    @OneToMany(mappedBy = "mezzo")
    private List<InServizio> inServizi;
    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    public Mezzo( int numeroMatricola, Tratta tratta){
        this.numeroMatricola=numeroMatricola;
        this.tratta=tratta;
    }
    public Mezzo() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }
    public void setNumeroMatricola(int numeroMatricola) {
        this.numeroMatricola = numeroMatricola;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

}
