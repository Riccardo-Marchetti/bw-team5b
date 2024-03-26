package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autobus")
public class Autobus extends Mezzo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int capienza;
    private boolean inServizio;
    @ManyToOne
    @JoinColumn(name = "manutenzione_id")
    private Manutenzione manutenzione;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    public Autobus(){}
    public Autobus(int numeroMatricola, int capienza, boolean inServizio , Manutenzione manutenzione, Tratta tratta) {
        super(numeroMatricola);
        this.capienza=capienza;
        this.inServizio = inServizio;
        this.manutenzione = manutenzione;
        this.tratta = tratta;

    }
    @Override
    public int getId() {
        return id;
    }
    public int getCapienza() {
        return capienza;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
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
