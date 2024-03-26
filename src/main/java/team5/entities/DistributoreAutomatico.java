package team5.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class DistributoreAutomatico extends Emittente{
    @Id
    @GeneratedValue
    private long id;
    private boolean inServizio;

    // COSTRUTTORE
    public DistributoreAutomatico(String indirizzo, boolean inServizio) {
        super(indirizzo);
        this.inServizio = inServizio;
    }

    public DistributoreAutomatico() {

    }
    // GETTER E SETTER
    public long getId() {
        return id;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    // TO STRING
    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "id=" + id +
                ", inServizio=" + inServizio +
                '}';
    }
}
