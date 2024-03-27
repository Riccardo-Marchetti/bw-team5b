package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tram")
public class Tram extends Mezzo {
   private int capienza;
   private boolean inServizio;
    @ManyToOne
    @JoinColumn(name = "manutenzione_id")
    private Manutenzione manutenzione;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
   public Tram() {}
    public Tram(int capienza, int numeroMatricola, boolean inServizio, Manutenzione manutenzione, Tratta tratta) {
       super(numeroMatricola, tratta);
       this.capienza=capienza;
       this.inServizio=inServizio;
       this.manutenzione=manutenzione;

   }
    public int getCapienza() {
        return capienza;
    }
    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    public Manutenzione getManutenzione() {
        return manutenzione;
    }

    @Override
    public String toString() {
        return "Tram: " +
                "\nID: " + getId() +
                "\nMatricola: " + getNumeroMatricola() +
                "\nCapienza: " + capienza +
                "\nIn Servizio: " + inServizio +
                "\nManutenzione: " + getManutenzione() +
                "\nTratta: " + getTratta();

    }
}
