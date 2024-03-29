package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "autobus")
public class Autobus extends Mezzo{
    private int capienza;


    public Autobus(){}

    public Autobus(int numeroMatricola, Tratta tratta, int capienza) {
        super(numeroMatricola, tratta);
        this.capienza = capienza;

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
                "capienza=" + capienza +
                ", id=" + id +
                '}';
    }
}
