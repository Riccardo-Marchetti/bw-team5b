package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autobus")
public class Autobus extends Mezzo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int capienza;
    @ManyToOne
    @JoinColumn(name = "inServizio_id")
    private InServizio inServizio;
    @ManyToOne
    @JoinColumn(name = "manutenzione_id")
    private Manutenzione manutenzione;
    public Autobus(){}
    public Autobus(int numeroMatricola, int capienza){
        super(numeroMatricola);
        this.capienza=capienza;
    }
    @Override
    public Long getId() {
        return id;
    }
    public int getCapienza() {
        return capienza;
    }
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
    @Override
    public String toString() {
        return "Autobus{" +
                "id=" + id +
                ", capienza=" + capienza +
                '}';
    }
}
