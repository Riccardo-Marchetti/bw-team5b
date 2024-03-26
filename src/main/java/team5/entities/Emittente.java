package team5.entities;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Emittente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    protected String indirizzo;

    public Emittente( String indirizzo) {

        this.indirizzo = indirizzo;
    }

    public Emittente() {
    }
}
