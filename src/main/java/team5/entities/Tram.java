package team5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tram")
public class Tram extends Mezzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   private int capienza;

   public Tram() {}
    public Tram(int capienza, int numeroMatricola){
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
        return "Tram{" +
                "id=" + id +
                ", capienza=" + capienza +
                '}';
    }
}
