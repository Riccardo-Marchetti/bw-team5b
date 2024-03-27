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
import team5.exception.NotFoundException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionetrasporti");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        Random rndm = new Random();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        MezzoDAO mezzoDAO = new MezzoDAO(em);
        BigliettoDAO bd = new BigliettoDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        DistributoreAutomaticoDAO dd = new DistributoreAutomaticoDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        ManutenzioneDAO md = new ManutenzioneDAO(em);
        AutobusDAO busDAO = new AutobusDAO(em);
        TramDAO tramDAO = new TramDAO(em);
        PercorsoDAO percorsoDAO = new PercorsoDAO(em);
        
    // CREAZIONE UTENTI E SALVATAGGIO

     /*  Supplier<Utente> utenteSupplier = ()-> new Utente(faker.rickAndMorty().character(), faker.name().lastName());
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

        // NUMERO BIGLIETTI X ID E DATA
        System.out.println("Numero biglietti emessi entro tot");
        System.out.println(bd.numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2027, 2, 19), LocalDate.of(2024,2, 21), 1));

        // NUMERO ABBONAMENTI X ID E DATA
        System.out.println("Numero di abbonamenti emessi entro tot periodo:");
        System.out.println(ad.numeroDiAbbonamentiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 3, 26), LocalDate.of(2024,3, 28), 53));

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
        Biglietto biglietto1 = new Biglietto(LocalDate.of(2024, 2, 20),  true,LocalDate.of(2024, 2, 21) , rivenditore1);
        Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 2, 14),  true,LocalDate.of(2024, 2, 20) , rivenditore2);
        Biglietto biglietto3 = new Biglietto(LocalDate.of(2024, 1, 24),  true,LocalDate.of(2024, 1, 30), rivenditore2);
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
        Abbonamento abbonamento6 = new Abbonamento(utenteList.get(0),LocalDate.of(2024,3,25), TipoAbbonamento.MENSILE, rivenditore1);
         //SALVATAGGIO ABBONAMENTI
        ad.save(abbonamento1);
        ad.save(abbonamento2);
        ad.save(abbonamento3);
        ad.save(abbonamento4);
        ad.save(abbonamento5);
        ad.save(abbonamento6);
        // NUMERO BIGLIETTI X ID E DATA
        System.out.println("Numero biglietti emessi entro tot");
        System.out.println(bd.numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 2, 19), LocalDate.of(2024,2, 21), 3));

        // NUMERO ABBONAMENTI X ID E DATA
        System.out.println("Numero di abbonamenti emessi entro tot periodo:");
       System.out.println(ad.numeroDiAbbonamentiEmessiDaUnEmittentePerPeriodo(LocalDate.of(2024, 3, 26), LocalDate.of(2024,3, 28), 4));
       System.out.println(" ");
      System.out.println("Verifica abbonamento");
        ad.verificaAbbonamento(1).forEach(System.out::println);
*/


        //CREAZIONE MANUTENZIONI
    /*    Manutenzione manutenzione1 = new Manutenzione(LocalDate.now(),LocalDate.of(2024,03,27),"Guasto motore");
        Manutenzione manutenzione2 = new Manutenzione(LocalDate.now(),LocalDate.of(2024,03,30),"Cambio gomme");

        //SALVATAGGIO MANUTENZIONI
        md.save(manutenzione1);
        md.save(manutenzione2);

        //CREAZIONE TRATTA
        Tratta tratta1 = new Tratta("Roma","Firenze",120);
        Tratta tratta2 = new Tratta("Torino","Napoli",120);
        Tratta tratta3 = new Tratta("Genoa","Bologna",240);
        Tratta tratta4 = new Tratta("Palermo","Catania",240);
        Tratta tratta5 = new Tratta("Empoli","Udine",180);


        //SALVATAGGIO TRATTA
        trattaDAO.save(tratta1);
        trattaDAO.save(tratta2);
        trattaDAO.save(tratta3);
        trattaDAO.save(tratta4);
        trattaDAO.save(tratta5);



        //CREAZIONE AUTOBUS
        List<Autobus> autobusList = new ArrayList<>();
        Autobus bus1 = new Autobus(534189,100,true,null,tratta1);
        Autobus bus2 = new Autobus(134986,100,true,null,tratta2);
        Autobus bus3 = new Autobus(234568,100,false,manutenzione1,null);
        Autobus bus4 = new Autobus(964521,100,true,null,tratta3);

        autobusList.add(bus1);
        autobusList.add(bus2);
        autobusList.add(bus3);
        autobusList.add(bus4);

        //SALVATAGGIO AUTOBUS
        busDAO.save(bus1);
        busDAO.save(bus2);
        busDAO.save(bus3);
        busDAO.save(bus4);

        Percorso percorso1 = new Percorso(bus1,tratta1,120);
        Percorso percorso2 = new Percorso(bus1,tratta1,120);

        percorsoDAO.save(percorso1);
        percorsoDAO.save(percorso2);

       //CREAZIONE TRAM
        List<Tram> tramList = new ArrayList<>();
        Tram tram1 = new Tram(200,257963,false,manutenzione2,null);
        Tram tram2 = new Tram(200,112498,true,null,tratta1);
        Tram tram3 = new Tram(200,531794,true,null,tratta4);
        Tram tram4 = new Tram(200,484946,true,null,tratta5);

        tramList.add(tram1);
        tramList.add(tram2);
        tramList.add(tram3);
        tramList.add(tram4);


        //SALVATAGGIO TRAM
        tramDAO.save(tram1);
        tramDAO.save(tram2);
        tramDAO.save(tram3);
        tramDAO.save(tram4);
*/








     //RICERCA DEI MEZZI IN SERVIZIO SU UNA TRATTA
        Tratta tratta = null;
        try {
            tratta = trattaDAO.findById(1);
        } catch (NotFoundException e) {
            System.out.println("Tratta non trovata");
            e.printStackTrace();
        }

        if (tratta != null) {
            try {
                List<Mezzo> mezziInServizio = mezzoDAO.findMezziInServizioByTratta(tratta);

                System.out.println("Mezzi in servizio sulla tratta " + tratta.getPartenza() + " - " + tratta.getCapolinea() + ":");

                for (Mezzo m : mezziInServizio) {
                    System.out.println(m.toString());
                }
            } catch (Exception e) {
                System.out.println("Si è verificato un errore durante il recupero dei mezzi in servizio.");
                e.printStackTrace();
            }
        }

        System.out.println("-------------------");
       //CALCOLO NUMERO PERCORSI PER MEZZO
        try {
            Tratta tratta1 = trattaDAO.findById(1);
            Mezzo mezzo = mezzoDAO.findById(1);

            int numeroPercorsi = mezzoDAO.countPercorsiByMezzoAndTratta(mezzo, tratta1);

            String tipoMezzo;
            if (mezzo instanceof Autobus) {
                tipoMezzo = "Autobus";
            } else if (mezzo instanceof Tram) {
                tipoMezzo = "Tram";
            } else {
                tipoMezzo = "Mezzo sconosciuto";
            }

            System.out.println("Numero di percorsi per il mezzo " + tipoMezzo + ": " + numeroPercorsi);
        } catch (Exception e) {
            System.err.println("Si è verificato un'errore durante il recupero dei percorsi: " + e.getMessage());
        }

        System.out.println("-------------------");
        //CAOLCOLO TEMPO EFFETTIVO PERCORRENZA PER MEZZO
        try {
            Tratta tratta1 = trattaDAO.findById(1);
            Autobus bus = busDAO.findById(1);

            Long tempoEffettivo = mezzoDAO.calculateTempoEffettivoPercorrenza(bus, tratta1);

            System.out.println("Tempo effettivo di percorrenza per l'autobus sulla tratta: " + tempoEffettivo);
        } catch (Exception e) {
            System.err.println("Si è verificato un'errore durante il calcolo del tempo effettivo di percorrenza: " + e.getMessage());
        }

        /*System.out.println("Aggiornamento della data di scadenza");
        tesseraDAO.aggiornaTesseraScaduta(1L);

        System.out.println(" ");

        System.out.println("Trova Tessera Scaduta ed Elimina");
     // tesseraDAO.eliminaTesseraScadutaById(24);

        System.out.println(" ");
        System.out.println("Trova Utente ed elimina");
        utenteDAO.findUtenteById(1);
     // utenteDAO.eliminaUtenteById(1); */










    }
    }
