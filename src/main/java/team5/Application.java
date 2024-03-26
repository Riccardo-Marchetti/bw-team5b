package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.*;

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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
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
        InServizioDAO inServizioDAO = new InServizioDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        AbbonamentoDAO abbDao = new AbbonamentoDAO(em);


    // CREAZIONE UTENTI E SALVATAGGIO

        Supplier<Utente> utenteSupplier = ()-> new Utente(faker.rickAndMorty().character(), faker.name().lastName());
        List<Utente> utenteList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            utenteList.add(utenteSupplier.get());
        }
        utenteList.forEach(utenteDAO::salvaUtente);

    // CREAZIONE TESSERE E SALVATAGGIO

        Tessera tessera0 = new Tessera(utenteList.get(0), LocalDate.of(2024, 2, 4));
        Tessera tessera1 = new Tessera(utenteList.get(1), LocalDate.of(2024, 2, 3));
        Tessera tessera2 = new Tessera(utenteList.get(2), LocalDate.of(2023, 5, 25));
        Tessera tessera3 = new Tessera(utenteList.get(3), LocalDate.of(2023, 8, 7));
        Tessera tessera4 = new Tessera(utenteList.get(4), LocalDate.of(2020, 9, 19));
        Tessera tessera5 = new Tessera(utenteList.get(5), LocalDate.of(2020, 11, 15));
        Tessera tessera6 = new Tessera(utenteList.get(6), LocalDate.of(2023, 12, 16));
        Tessera tessera7 = new Tessera(utenteList.get(7), LocalDate.of(2024, 2, 18));
        Tessera tessera8 = new Tessera(utenteList.get(8), LocalDate.of(2021, 3, 1));
        Tessera tessera9 = new Tessera(utenteList.get(9), LocalDate.of(2021, 3, 5));


        tesseraDAO.salvaTessera(tessera1);
        tesseraDAO.salvaTessera(tessera2);
        tesseraDAO.salvaTessera(tessera3);
        tesseraDAO.salvaTessera(tessera4);
        tesseraDAO.salvaTessera(tessera5);
        tesseraDAO.salvaTessera(tessera6);
        tesseraDAO.salvaTessera(tessera7);
        tesseraDAO.salvaTessera(tessera8);
        tesseraDAO.salvaTessera(tessera9);


    }
    }
