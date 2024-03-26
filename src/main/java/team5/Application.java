package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import team5.dao.*;

import team5.dao.BigliettoDAO;
import team5.dao.RivenditoreDAO;
import team5.entities.*;
import team5.dao.MezzoDAO;
import team5.dao.TesseraDAO;
import team5.dao.TrattaDAO;
import team5.dao.UtenteDAO;
import team5.enums.TipoAbbonamento;

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
        BigliettoDAO bd = new BigliettoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        DistributoreAutomaticoDAO dd = new DistributoreAutomaticoDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        
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

        // SALVATAGGIO TESSERE
        tesseraDAO.salvaTessera(tessera0);
        tesseraDAO.salvaTessera(tessera1);
        tesseraDAO.salvaTessera(tessera2);
        tesseraDAO.salvaTessera(tessera3);
        tesseraDAO.salvaTessera(tessera4);
        tesseraDAO.salvaTessera(tessera5);
        tesseraDAO.salvaTessera(tessera6);
        tesseraDAO.salvaTessera(tessera7);
        tesseraDAO.salvaTessera(tessera8);
        tesseraDAO.salvaTessera(tessera9);

        // CREAZIONE RIVENDITORI
        Rivenditore rivenditore1 = new Rivenditore("via Milano", "Antonio", 434242425);
        Rivenditore rivenditore2 = new Rivenditore("via Piave", "Riccardo", 234525231);
        Rivenditore rivenditore3 = new Rivenditore("via Po", "Marco", 523515646);
        Rivenditore rivenditore4 = new Rivenditore("via Roma", "Matteo", 246675369);

        // SALVATAGGIO RIVENDITORI
        rd.salvaRivenditore(rivenditore1);
        rd.salvaRivenditore(rivenditore2);
        rd.salvaRivenditore(rivenditore3);
        rd.salvaRivenditore(rivenditore4);

        // CREAZIONE DISTRIBUTORI
        DistributoreAutomatico distributore1 = new DistributoreAutomatico("via Milano",true);
        DistributoreAutomatico distributore2 = new DistributoreAutomatico("via Po",true);
        DistributoreAutomatico distributore3 = new DistributoreAutomatico("via Piave",true);
        DistributoreAutomatico distributore4 = new DistributoreAutomatico("via Roma",true);

        // SALVATAGGIO DISTRIBUTORI
        dd.salvaDistributore(distributore1);
        dd.salvaDistributore(distributore2);
        dd.salvaDistributore(distributore3);
        dd.salvaDistributore(distributore4);

        // CREAZIONE BIGLIETTI
        Biglietto biglietto = new Biglietto(LocalDate.of(2024, 3, 27),  false, null, distributore1);
        Biglietto biglietto1 = new Biglietto(LocalDate.of(2024, 2, 20),  false, null, rivenditore1);
        Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 2, 14),  false, null, rivenditore2);
        Biglietto biglietto3 = new Biglietto(LocalDate.of(2024, 1, 24),  false, null, rivenditore2);
        Biglietto biglietto4 = new Biglietto(LocalDate.of(2024, 4, 30),  false, null, rivenditore3);
        Biglietto biglietto5 = new Biglietto(LocalDate.of(2024, 5, 1),  false, null, rivenditore3);
        Biglietto biglietto6 = new Biglietto(LocalDate.of(2024, 6, 4),  false, null, rivenditore4);
        Biglietto biglietto7 = new Biglietto(LocalDate.of(2024, 7, 6),  false, null, rivenditore4);

        // SALVATAGGIO BIGLIETTI
        bd.salvaBiglietto(biglietto);
        bd.salvaBiglietto(biglietto1);
        bd.salvaBiglietto(biglietto2);
        bd.salvaBiglietto(biglietto3);
        bd.salvaBiglietto(biglietto4);
        bd.salvaBiglietto(biglietto5);
        bd.salvaBiglietto(biglietto6);
        bd.salvaBiglietto(biglietto7);

        // CREAZIONE ABBONAMENTI
        Abbonamento abbonamento1 = new Abbonamento(utenteList.get(0), LocalDate.of(2024, 3, 27),  TipoAbbonamento.SETTIMANALE, distributore1);
        Abbonamento abbonamento2 = new Abbonamento(utenteList.get(1), LocalDate.of(2024, 3, 27),  TipoAbbonamento.MENSILE, rivenditore2);
        Abbonamento abbonamento3 = new Abbonamento(utenteList.get(2), LocalDate.of(2024, 3, 27),  TipoAbbonamento.MENSILE, rivenditore1);
        Abbonamento abbonamento4 = new Abbonamento(utenteList.get(3), LocalDate.of(2024, 3, 27),  TipoAbbonamento.SETTIMANALE, distributore2);
        Abbonamento abbonamento5 = new Abbonamento(utenteList.get(4), LocalDate.of(2024, 3, 27),  TipoAbbonamento.SETTIMANALE, rivenditore4);

        // SALVATAGGIO ABBONAMENTI
        ad.save(abbonamento1);
        ad.save(abbonamento2);
        ad.save(abbonamento3);
        ad.save(abbonamento4);
        ad.save(abbonamento5);

        // NUMERO BIGLIETTI X ID E DATA
        System.out.println(bd.numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 2, 19), LocalDate.of(2024,2, 21), 152));

        // NUMERO ABBONAMENTI X ID E DATA
        System.out.println(ad.numeroDiAbbonamentiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 3, 26), LocalDate.of(2024,3, 28), 356));
        System.out.println(ad.verificaAbbonamento(1));
    }
    }
