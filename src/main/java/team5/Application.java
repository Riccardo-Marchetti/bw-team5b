package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.*;
import team5.entities.Tessera;
import team5.entities.Tratta;
import team5.entities.Utente;
import java.time.LocalDate;
import java.util.Locale;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        System.out.println("CIAO");
        Faker faker = new Faker(Locale.ITALY);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        AbbonamentoDAO abbDao = new AbbonamentoDAO(em);


        /*
         * Supplier<Utente> utenteSupplier = ()->{
         * Faker faker = new Faker(Locale.ITALY);
         * return new Utente(faker.rickAndMorty().character(), )
         * 
         * };
         */

        // Create a new tratta
        // Supplier<Tratta> trattaSupplier = () -> {
        // };

    }
}
