package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inservizio")
public class InServizio {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate data_inizio;

    private LocalDate data_fine;


    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

//    @OneToMany
//    private Tratta tratta;

    public InServizio(LocalDate data_inizio, LocalDate data_fine, Mezzo mezzo) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.mezzo = mezzo;
//        this.tratta = tratta;
    }

    public InServizio() {
    }
    public int getId() {
        return id;
    }
    public LocalDate getData_inizio() {
        return data_inizio;
    }
    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }
    public LocalDate getData_fine() {
        return data_fine;
    }
    public void setData_fine(LocalDate data_fine) {
        this.data_fine = data_fine;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

//    public Tratta getTratta() {
//        return tratta;
//    }

//    public void setTratta(Tratta tratta) {
//        this.tratta = tratta;
//    }

    @Override
    public String toString() {
        return "InServizio{" +
                "id=" + id +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", mezzo=" + mezzo +
//                ", tratta=" + tratta +
                '}';
    }
}
