package team5;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import team5.dao.*;
import team5.entities.*;
import team5.enums.TipoAbbonamento;
import team5.exception.NotFoundException;

import java.time.LocalDate;
import java.util.*;
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
        AutobusDAO autobusDAO = new AutobusDAO(em);
        TramDAO tramDAO = new TramDAO(em);
        ValidatriceDao validatriceDao = new ValidatriceDao(em);
        PercorsoDAO percorsoDAO = new PercorsoDAO(em);
        InServizioDAO inservizioDAO = new InServizioDAO(em);

        // CREAZIONE UTENTI E SALVATAGGIO
        Supplier<Utente> utenteSupplier = () -> new
                Utente(faker.rickAndMorty().character(), faker.name().lastName());
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
        Tessera tessera5 = new Tessera(utenteList.get(5), LocalDate.of(2020, 11,
                15));
        Tessera tessera6 = new Tessera(utenteList.get(6), LocalDate.of(2023, 12,
                16));
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

        // // CREAZIONE RIVENDITORI
        Rivenditore rivenditore1 = new Rivenditore("via Milano", "Antonio",
                434242425);
        Rivenditore rivenditore2 = new Rivenditore("via Piave", "Riccardo",
                234525231);
        Rivenditore rivenditore3 = new Rivenditore("via Po", "Marco", 523515646);
        Rivenditore rivenditore4 = new Rivenditore("via Roma", "Matteo", 246675369);

        // SALVATAGGIO RIVENDITORI
        rd.salvaRivenditore(rivenditore1);
        rd.salvaRivenditore(rivenditore2);
        rd.salvaRivenditore(rivenditore3);
        rd.salvaRivenditore(rivenditore4);


        // CREAZIONE DISTRIBUTORI
        DistributoreAutomatico distributore1 = new DistributoreAutomatico("via Milano", true);
        DistributoreAutomatico distributore2 = new DistributoreAutomatico("via Po", true);
        DistributoreAutomatico distributore3 = new DistributoreAutomatico("via Piave", true);
        DistributoreAutomatico distributore4 = new DistributoreAutomatico("via Roma", true);

        // SALVATAGGIO DISTRIBUTORI
        dd.salvaDistributore(distributore1);
        dd.salvaDistributore(distributore2);
        dd.salvaDistributore(distributore3);
        dd.salvaDistributore(distributore4);

        // CREAZIONE BIGLIETTI
        Biglietto biglietto = new Biglietto(LocalDate.of(2024, 3, 27), false, null,
                distributore1);
        Biglietto biglietto1 = new Biglietto(LocalDate.of(2024, 2, 20), false, null,
                rivenditore1);
        Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 2, 14), false, null,
                rivenditore2);
        Biglietto biglietto3 = new Biglietto(LocalDate.of(2024, 1, 24), false, null,
                rivenditore2);
        Biglietto biglietto4 = new Biglietto(LocalDate.of(2024, 4, 30), false, null,
                rivenditore3);
        Biglietto biglietto5 = new Biglietto(LocalDate.of(2024, 5, 1), false, null,
                rivenditore3);
        Biglietto biglietto6 = new Biglietto(LocalDate.of(2024, 6, 4), false, null,
                rivenditore4);
        Biglietto biglietto7 = new Biglietto(LocalDate.of(2024, 7, 6), false, null,
                rivenditore4);

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
        Abbonamento abbonamento1 = new Abbonamento(utenteList.get(0),
                LocalDate.of(2024, 3, 27), TipoAbbonamento.SETTIMANALE, distributore1);
        Abbonamento abbonamento2 = new Abbonamento(utenteList.get(1),
                LocalDate.of(2024, 3, 27), TipoAbbonamento.MENSILE, rivenditore2);
        Abbonamento abbonamento3 = new Abbonamento(utenteList.get(2),
                LocalDate.of(2024, 3, 27), TipoAbbonamento.MENSILE, rivenditore1);
        Abbonamento abbonamento4 = new Abbonamento(utenteList.get(3),
                LocalDate.of(2024, 3, 27), TipoAbbonamento.SETTIMANALE, distributore2);
        Abbonamento abbonamento5 = new Abbonamento(utenteList.get(4),
                LocalDate.of(2024, 3, 27), TipoAbbonamento.SETTIMANALE, rivenditore4);
        Abbonamento abbonamento6 = new
                Abbonamento(utenteList.get(0), LocalDate.of(2024, 3, 25),
                TipoAbbonamento.MENSILE, rivenditore1);

        // SALVATAGGIO ABBONAMENTI
        ad.save(abbonamento1);
        ad.save(abbonamento2);
        ad.save(abbonamento3);
        ad.save(abbonamento4);
        ad.save(abbonamento5);
        ad.save(abbonamento6);

        //Creazione tratte
        Tratta tratta1 = new Tratta("Gardaland","Milano",90);
        trattaDAO.save(tratta1);
        Tratta tratta2 = new Tratta("Roma","Fiumicino",120);
        trattaDAO.save(tratta2);
        Tratta tratta3 = new Tratta("Bari","Foggia",30);
        trattaDAO.save(tratta3);
        Tratta tratta4 = new Tratta("Napoli","Milano",240);
        trattaDAO.save(tratta4);

        //Creazione mezzi autobus
        Autobus autobus1 = new Autobus(10000,tratta1,55);
        autobusDAO.save(autobus1);
        Autobus autobus2 = new Autobus(11000,tratta2,55);
        autobusDAO.save(autobus2);
        Autobus autobus3 = new Autobus (15000,tratta4,55);
        autobusDAO.save(autobus3);

        //Creazione mezzi tram
        Tram tram1 = new Tram(12000,tratta1,25);
        tramDAO.save(tram1);
        Tram tram2 = new Tram(13000,tratta2,30);
        tramDAO.save(tram2);
        Tram tram3 = new Tram (14000,tratta3,25);
        tramDAO.save(tram3);

        //Validatrici
        Validatrice validatrice1 = new Validatrice(autobus1);
        Validatrice validatrice2 = new Validatrice(autobus2);
        Validatrice validatrice3 = new Validatrice(autobus3);
        Validatrice validatrice4 = new Validatrice(tram1);
        Validatrice validatrice5 = new Validatrice(tram2);
        Validatrice validatrice6 = new Validatrice(tram3);

//        SALVATAGGIO VALIDATRICI
        validatriceDao.save(validatrice1);
        validatriceDao.save(validatrice2);
        validatriceDao.save(validatrice3);
        validatriceDao.save(validatrice4);
        validatriceDao.save(validatrice5);
        validatriceDao.save(validatrice6);

       //CREAZIONE MANUTENZIONI
        Manutenzione manutenzione1 = new Manutenzione(LocalDate.now(),LocalDate.now().plusDays(10),"Cambio gomme",autobus1);
        md.save(manutenzione1);
        Manutenzione manutenzione2 = new Manutenzione(LocalDate.of(2024,3,20),LocalDate.now(),"Verifica componenti elettrici",tram1);
        md.save(manutenzione2);

//      SALVATAGGIO MANUTENZIONI
        md.save(manutenzione1);
        md.save(manutenzione2);

//        CREAZIONE PERCORSI
        Percorso percorso1 = new Percorso(autobus1, tratta1, 40);
        Percorso percorso2 = new Percorso(tram1, tratta3,120);
        Percorso percorso3 = new Percorso(tram3, tratta2,90);
        Percorso percorso4 = new Percorso(autobus3, tratta4,60);

//        SALVATAGGIO PERCORSI
        percorsoDAO.save(percorso1);
        percorsoDAO.save(percorso2);
        percorsoDAO.save(percorso3);
        percorsoDAO.save(percorso4);

//        CREAZIONE IN SERVIZIO
        InServizio servizio1 = new InServizio(LocalDate.of(2024, 3, 30), LocalDate.of(2024, 4, 1), autobus1);
        InServizio servizio2 = new InServizio(LocalDate.of(2024, 4, 4), LocalDate.of(2024, 4, 5), tram2);
        InServizio servizio3 = new InServizio(LocalDate.of(2024, 3, 9), LocalDate.of(2024, 4, 10), autobus3);

//        SALVATAGGIO IN SERVIZIO
        inservizioDAO.save(servizio1);
        inservizioDAO.save(servizio2);
        inservizioDAO.save(servizio3);

//        SCANNER
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto/a su EpicTrasporti!");
        caricamentoMain();
        boolean uscire = false;
        int scelta;
        try {
            mainLoop:
            do {
                System.out.println("Seleziona gestione:");
                System.out.println("1 - Gestione clienti");
                System.out.println("2 - Gestione interna");
                System.out.println("3 - Gestione mezzi");
                System.out.println("4 - Esci");
                scelta = scanner.nextInt();
                switch (scelta) {
                    case 1:
                        caricamento();
                        System.out.println("Gestione cliente:");
                        System.out.println("1 - Emetti un biglietto");
                        System.out.println("2 - Emetti un abbonamento");
                        System.out.println("3 - Ritorna al menù precedente");
                        try {
                            int scelta1 = scanner.nextInt();
                            switch (scelta1) {
                                case 1:
                                    emissioneBiglietto(scanner, rd, bd, dd);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 2:
                                    emissioneAbbonamento(scanner, rd, tesseraDAO, ad, dd);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 3:
                                    caricamento();
                                    break;
                                default:
                                    throw new IllegalArgumentException("Inserisci un numero compreso tra 1 e 3");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input non valido, inserisci un numero");
                            scanner.next();
                        }
                        break;
                    case 2:
                        caricamento();
                        System.out.println("Gestione interna");
                        System.out.println("1 - Verifica abbonamento");
                        System.out.println("2 - Annulla abbonamento");
                        System.out.println("3 - Valida Biglietto");
                        System.out.println("4 - Ritorna al menù precedente");
                        try {
                            int scelta2 = scanner.nextInt();
                            switch (scelta2) {
                                case 1:
                                    System.out.println("Verifica abbonamento:");
                                    System.out.println("Inserisci numero tessera");
                                    long tessera = scanner.nextLong();
                                    ad.verificaAbbonamento(tessera).forEach(System.out::println);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 2:
                                    System.out.println("Annulla abbonamento");
                                    System.out.println("Inserisci numero abbonamento");
                                    long abbonamento = scanner.nextLong();
                                    ad.annullaAbbonamento(abbonamento);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 3:
                                    System.out.println("Valida biglietto");
                                    System.out.println("Inserisci codice biglietto");
                                    Biglietto valido = bd.findById(scanner.nextLong());
                                    scanner.nextLine();
                                    validatriceDao.vidimazioneBiglietto(valido);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 4:
                                    caricamento();
                                    break;
                                default:
                                    throw new IllegalArgumentException("Inserisci un numero compreso tra 1 e 4");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input non valido, inserisci un numero");
                            scanner.next();
                        }
                        break;
                    case 3:
                        caricamento();
                        System.out.println("Gestione mezzi");
                        System.out.println("1 - Mezzi in servizio");
                        System.out.println("2 - Mezzi in manutenzione");
                        System.out.println("3 - Cerca periodo manutenzioni");
                        System.out.println("4 - Controlla quante volte un mezzo ha percorso una tratta");
                        System.out.println("5 - Controlla il tempo effettivo delle tratte percorse da un mezzo");
                        System.out.println("6 - Ritorna al menù precedente");
                        try {
                            int scelta2 = scanner.nextInt();
                            switch (scelta2) {
                                case 1:
                                    caricamento();
                                    System.out.println("Mezzi in servizio");
                                    for (Mezzo m : mezzoDAO.findMezziInServizio()) {
                                        System.out.println(m);
                                        System.out.println("-------------------------");
                                    }
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 2:
                                    caricamento();
                                    System.out.println("Lista mezzi in manutenzione:");
                                    mezzoDAO.getAllMezziManutenzione().forEach(System.out::println);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 3:
                                    caricamento();
                                    scanner.nextLine();
                                    System.out.println("Inserisci il periodo di manutenzione:");
                                    System.out.println("Dal (inserisci data aaaa-mm-gg)");
                                    String stringDataInizio = scanner.nextLine();
                                    LocalDate dataInizio = LocalDate.parse(stringDataInizio);
                                    System.out.println("Al (inserisci data aaaa-mm-gg)");
                                    String stringDataFine = scanner.nextLine();
                                    LocalDate dataFine = LocalDate.parse(stringDataFine);
                                    System.out.println("Inserisci id del mezzo");
                                    int mezzoId = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Lista mezzi in manutenzione nel periodo selezionato trovati:");
                                    caricamento();
                                    mezzoDAO.periodiDiManutenzioneDelMezzo(dataInizio,dataFine,mezzoId).forEach(System.out::println);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 4:
                                    // System.out.println("Controlla quante volte un mezzo ha percorso una tratta");
                                    // System.out.println("Inserisci numero matricola");
                                    // int matricola = scanner.nextInt();
                                    // scanner.nextLine();
                                    // System.out.println("Inserisci Partenza");
                                    // String partenza = scanner.nextLine();
                                    // System.out.println("Inserisci Capolinea");
                                    // String capolinea = scanner.nextLine();
                                    // System.out.println("La tratta " + partenza + " - " + capolinea + " è stato
                                    // percorsa dal mezzo " + matricola + " " +
                                    // mezzoDAO.countPercorsiByMezzoAndTratta(matricola, partenza, capolinea) + "
                                    // volte");
                                    // System.out.println("-------------------------");
                                    // da sistemare e rivedere domani
                                    caricamento();
                                    System.out.println("Inserisci numero matricola");
                                    int mezzoIdManutenzione = scanner.nextInt();
                                    Mezzo mezzo = mezzoDAO.findById(scanner.nextInt());
                                    scanner.nextLine();
                                    System.out.println("Inserisci Partenza");
                                    String partenza = scanner.nextLine();
                                    System.out.println("Inserisci Arrivo");
                                    String capolinea = scanner.nextLine();
                                    System.out.println("Tratta percorsa dal mezzo: (n° di volte)");
                                    System.out.println(percorsoDAO.countPercorsiByMezzoAndTratta(mezzoIdManutenzione,partenza,capolinea));
//                                    Tratta partenza = trattaDAO.findById(scanner.nextInt()); //modificare metodo da usare
//                                    long prova = mezzoDAO.countPercorsiByMezzoAndTratta(mezzo, partenza);
//                                    System.out.println("prova" + prova);
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }
                                case 5:
                                    caricamento();
                                    System.out.println("Inserisci id mezzo");
                                    int idMezzo = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Inserisci Partenza");
                                    String partenza2 = scanner.nextLine();
                                    System.out.println("Inserisci Arrivo");
                                    String capolinea2 = scanner.nextLine();
                                    System.out.println("Tempi effettivi della tratta percorsa:");
                                    percorsoDAO.countPercorsiByMezzoAndTrattaAndGetEffectiveTime(idMezzo,partenza2,capolinea2).forEach(element-> System.out.println(element.getTempoEffettivo()+" minuti"));
                                    if (confermaContinuo(scanner)) {
                                        uscire = true;
                                        break mainLoop;
                                    } else {
                                        continue mainLoop;
                                    }

                                case 6:
                                    caricamento();
                                    break;
                                default:
                                    throw new IllegalArgumentException("Inserisci un numero compreso tra 1 e 5");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input non valido, inserisci un numero");
                            scanner.next();
                        }
                        break;
                    case 4:
                        System.out.println("Sicuro di voler uscire? (s/n)");
                        String sceltaS = scanner.next();
                        if (sceltaS.equals("s")) {
                            uscire = true;
                            System.out.println("Chiusura del programma in corso");
                            caricamentoMain();
                            System.out.println("Grazie e arrivederci!");
                            break mainLoop;
                        } else if (sceltaS.equals("n")) {
                            caricamento();
                            continue mainLoop;
                        } else {
                            System.out.println(
                                    "Input non valido, si prega di inserire 's' per confermare l'uscita o 'n' per tornare al menù principale.");
                            break;
                        }
                    default:
                        System.out.println("Scelta non valida");
                        break;
                }
            } while (!uscire);
            // prova
        } catch (InputMismatchException e) {
            System.out.println("Input non valido, inserisci un numero");
            scanner.next();
        }

    }

    private static boolean confermaContinuo(Scanner scanner) {
        System.out.println("-----------");
        System.out.println("Vuoi tornare al menù principale? (s/n)");
        String scelta = scanner.next().toLowerCase();
        switch (scelta) {
            case "s":
                caricamento();
                return false;
            case "n":
                System.out.println("Chiusura del programma in corso");
                caricamentoMain();
                System.out.println("Grazie e arrivederci!");
                return true;
            default:
                System.out.println("Input non valido, si prega di inserire 's' per confermare l'uscita o 'n' per tornare al menù principale.");
                return confermaContinuo(scanner);
        }
    }

    private static void caricamento() {
        System.out.println("Caricamento");
        System.out.print("[");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print("=");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }

    private static void caricamentoMain() {
        System.out.println("Caricamento");
        System.out.print("[");
        try {
            for (int i = 0; i < 20; i++) {
                System.out.print("=");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }

    private static void emissioneBiglietto(Scanner scanner, RivenditoreDAO rd, BigliettoDAO bd,
                                           DistributoreAutomaticoDAO dd) {
        System.out.println("1 - Rivenditore");
        System.out.println("2 - Distributore");
        try {
            int scelta2 = scanner.nextInt();
            if (scelta2 == 1) {
                emissioneBigliettoRivenditore(rd, bd, scanner);
            } else if (scelta2 == 2) {
                emissioneBigliettoDistributore(dd, bd, scanner);
            } else {
                throw new IllegalArgumentException("Numero non valido, inserisci un numero compreso tra 1 e 2");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input non valido, inserisci un numero");
            scanner.next();
        }
    }

    private static void emissioneBigliettoRivenditore(RivenditoreDAO rd, BigliettoDAO bd, Scanner scanner) {
        List<Rivenditore> listaRivenditori = rd.getAllRivenditori();
        for (int i = 0; i < listaRivenditori.toArray().length; i++) {
            System.out.println(i + 1 + " - " + listaRivenditori.get(i));
        }
        if (listaRivenditori.isEmpty()) {
            throw new NotFoundException("Non è stato trovato nessun rivenditore");
        } else {
            int input = scanner.nextInt();
            if (input >= 1 && input <= listaRivenditori.size()) {
                Rivenditore rivenditore = listaRivenditori.get(input - 1);
                Biglietto biglietto = new Biglietto(LocalDate.now(), false, null, rivenditore);
                bd.salvaBiglietto(biglietto);
            } else {
                throw new IllegalArgumentException("Inserisci un numero valido");
            }
        }
    }

    private static void emissioneBigliettoDistributore(DistributoreAutomaticoDAO dd, BigliettoDAO bd, Scanner scanner) {
        List<DistributoreAutomatico> listaDistributori = dd.getAllDistributori();
        for (int i = 0; i < listaDistributori.toArray().length; i++) {
            System.out.println(i + 1 + " - " + listaDistributori.get(i));
        }
        if (listaDistributori.isEmpty()) {
            throw new NotFoundException("Non è stato trovato nessun distributore automatico");
        } else {
            int input = scanner.nextInt();
            if (input >= 1 && input <= listaDistributori.size()) {
                DistributoreAutomatico distributore = listaDistributori.get(input - 1);
                Biglietto biglietto = new Biglietto(LocalDate.now(), false, null, distributore);
                bd.salvaBiglietto(biglietto);
            } else {
                throw new IllegalArgumentException("Inserisci un numero valido");
            }
        }
    }

    private static void emissioneAbbonamento(Scanner scanner, RivenditoreDAO rd, TesseraDAO tesseraDAO,
                                             AbbonamentoDAO ad, DistributoreAutomaticoDAO dd) {
        System.out.println("1 - Rivenditore");
        System.out.println("2 - Distributore");
        try {
            int scelta3 = scanner.nextInt();
            if (scelta3 == 1) {
                emissioneAbbonamentoRivenditore(scanner, rd, tesseraDAO, ad);
            } else if (scelta3 == 2) {
                emissioneAbbonamentoDistributore(scanner, dd, tesseraDAO, ad);
            } else {
                throw new IllegalArgumentException("Numero non valido, inserisci un numero compreso tra 1 e 2");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input non valido, inserisci un numero");
            scanner.next();
        }
    }

    private static void emissioneAbbonamentoRivenditore(Scanner scanner, RivenditoreDAO rd, TesseraDAO tesseraDAO,
                                                        AbbonamentoDAO ad) {
        boolean verifica = false;
        List<Rivenditore> listaRivenditori = rd.getAllRivenditori();
        for (int i = 0; i < listaRivenditori.toArray().length; i++) {
            System.out.println(i + 1 + " " + listaRivenditori.get(i));
        }
        System.out.println("Scegli il rivenditore inserendo il numero di riferimento");
        if (listaRivenditori.isEmpty()) {
            throw new NotFoundException("Non è stato trovato nessun rivenditore");
        } else {
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input >= 1 && input <= listaRivenditori.size()) {
                Rivenditore rivenditore = listaRivenditori.get(input);
                long numeroTessera;
                System.out.println("inserisci il numero tessera dell'utente");
                do {
                    numeroTessera = scanner.nextLong();
                    try {
                        scanner.nextLine();
                        Tessera tessera = tesseraDAO.findTesseraById(numeroTessera);
                        if (tessera != null) {
                            verifica = true;
                            if (tessera.getDataScadenza().isBefore(LocalDate.now())) {
                                System.out.println("Tessera scaduta! Si prega di aggiornare la data di scadenza!");
                                System.out.println("Vuoi aggiornare la tua tessera? y/n");
                                String inputYesOrNo = scanner.nextLine();
                                if (Objects.equals(inputYesOrNo, "y")) {
                                    tesseraDAO.aggiornaTesseraScaduta(numeroTessera);
                                } else {
                                    tesseraDAO.eliminaTesseraScadutaById(numeroTessera);
                                }
                            } else {
                                System.out.println("Inserisci il tipo di abbonamento: 1-Settimanale o 2-Mensile");
                                int inputTipoAbbonamento = scanner.nextInt();
                                if (inputTipoAbbonamento == 1) {
                                    Abbonamento abbonamento = new Abbonamento(tessera.getUtente(), LocalDate.now(),
                                            TipoAbbonamento.SETTIMANALE, rivenditore);
                                    ad.save(abbonamento);

                                } else if (inputTipoAbbonamento == 2) {
                                    Abbonamento abbonamento = new Abbonamento(tessera.getUtente(), LocalDate.now(),
                                            TipoAbbonamento.MENSILE, rivenditore);
                                    ad.save(abbonamento);

                                } else {
                                    throw new IllegalArgumentException("Inserisci un numero valido");
                                }
                            }
                        }
                    } catch (NoResultException e) {
                        System.out.println("Inserisci un numero di tessera esistente");
                    }
                } while (!verifica);
            } else {
                throw new IllegalArgumentException("Inserisci un numero valido");
            }
        }
    }

    private static void emissioneAbbonamentoDistributore(Scanner scanner, DistributoreAutomaticoDAO dd,
                                                         TesseraDAO tesseraDAO, AbbonamentoDAO ad) {
        boolean verifica = false;
        List<DistributoreAutomatico> listaDistributori = dd.getAllDistributori();
        for (int i = 0; i < listaDistributori.toArray().length; i++) {
            System.out.println(i + 1 + " - " + listaDistributori.get(i));
        }
        System.out.println("Scegli il distributore automatico inserendo il numero di riferimento");
        if (listaDistributori.isEmpty()) {
            throw new NotFoundException("Non è stato trovato nessun distributore automatico");
        } else {
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input >= 1 && input <= listaDistributori.size()) {
                DistributoreAutomatico distributoreAutomatico = listaDistributori.get(input);
                long numeroTessera;
                System.out.println("Inserisci il numero tessera dell'utente");
                do {
                    numeroTessera = scanner.nextLong();
                    try {
                        scanner.nextLine();
                        Tessera tessera = tesseraDAO.findTesseraById(numeroTessera);
                        if (tessera != null) {
                            verifica = true;
                            if (tessera.getDataScadenza().isBefore(LocalDate.now())) {
                                System.out.println("Tessera scaduta! Si prega di aggiornare la data di scadenza!");
                                System.out.println("Vuoi aggiornare la tua tessera? y/n");
                                String inputYesOrNo = scanner.nextLine();
                                if (Objects.equals(inputYesOrNo, "y")) {
                                    tesseraDAO.aggiornaTesseraScaduta(numeroTessera);
                                } else {
                                    tesseraDAO.eliminaTesseraScadutaById(numeroTessera);
                                }
                            } else {
                                System.out.println("Inserisci il tipo di abbonamento: 1-Settimanale o 2-Mensile");
                                int inputTipoAbbonamento = scanner.nextInt();
                                if (inputTipoAbbonamento == 1) {
                                    Abbonamento abbonamento = new Abbonamento(tessera.getUtente(), LocalDate.now(),
                                            TipoAbbonamento.SETTIMANALE, distributoreAutomatico);
                                    ad.save(abbonamento);

                                } else if (inputTipoAbbonamento == 2) {
                                    Abbonamento abbonamento = new Abbonamento(tessera.getUtente(), LocalDate.now(),
                                            TipoAbbonamento.MENSILE, distributoreAutomatico);
                                    ad.save(abbonamento);

                                } else {
                                    throw new IllegalArgumentException("Numero inserito non valido");
                                }
                            }
                        }
                    } catch (NoResultException e) {
                        System.out.println("Inserisci un numero di tessera esistente");
                    }
                } while (!verifica );
            } else {
                throw new IllegalArgumentException("Inserisci un numero valido");
            }
        }
    }
}
