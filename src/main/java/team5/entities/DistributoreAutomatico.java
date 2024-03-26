package team5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DistributoreAutomatico extends Emittente {
    private boolean inServizio;

    // COSTRUTTORE
    public DistributoreAutomatico(String indirizzo, boolean inServizio) {
        super(indirizzo);
        this.inServizio = inServizio;
    }

    public DistributoreAutomatico() {

    }
    // GETTER E SETTER

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
                ", inServizio=" + inServizio +
                '}';
    }
}
