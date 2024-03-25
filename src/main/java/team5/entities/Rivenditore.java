package team5.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Rivenditore {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long numeroTelefono;
//    @OneToOne
//    @JoinColumn (name = "emittente_id")
    @OneToMany (mappedBy = "rivenditore")
    private List<Biglietto> biglietto = new ArrayList<>();
}
