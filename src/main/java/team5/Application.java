package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.Biglietto;
import team5.entities.Rivenditore;
import team5.dao.MezzoDAO;
import team5.dao.TesseraDAO;
import team5.dao.TrattaDAO;
import team5.dao.UtenteDAO;
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
        BigliettoDAO bd = new BigliettoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        Rivenditore rivenditore1 = new Rivenditore("via Milano", "Matteo", 434242425);
        rd.salvaRivenditore(rivenditore1);
        Biglietto biglietto = new Biglietto(LocalDate.of(2024, 03, 27), "Milano", false, null, rivenditore1);
        Biglietto biglietto1 = new Biglietto(LocalDate.of(2024, 03, 27), "Milano", false, null, rivenditore1);
        bd.salvaBiglietto(biglietto);

        System.out.println(bd.numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 3, 26), LocalDate.of(2024,3, 27), 19));
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
