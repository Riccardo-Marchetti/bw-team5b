package team5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Biglietto {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataEmissione;
    private String puntoEmissione;
    private boolean vidimato;
    private LocalDate dataVidimazione;
    @ManyToOne
    @JoinColumn (name = "Rivenditore_id")
    private Rivenditore rivenditore;

}
