package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tram")
public class Tram extends Mezzo {
   private int capienza;

   public Tram() {}

    public Tram(int numeroMatricola, Tratta tratta, int capienza) {
        super(numeroMatricola, tratta);
        this.capienza = capienza;
      ;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

}
