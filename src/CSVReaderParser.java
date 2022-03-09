import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CSVReaderParser {

    public static List<Domanda> parser() {

        List<Domanda> domande = readBooksFromCSV("asd.csv");
//        for ( Domanda x : domande) {
//            System.out.println(x.toString());
//        }

        return domande;
    }

    private static List<Domanda> readBooksFromCSV(String fileName) {
        List<Domanda> domande = new ArrayList<>();


        Path pathToFile = Paths.get(fileName);
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        https:
//stackoverflow.com/questions/26268132/all-inclusive-charset-to-avoid-java-nio-charset-malformedinputexception-input
//        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            // read the first line from the text file
            String line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(";");

                Domanda domanda = createBook(attributes);
                // adding book into ArrayList
                domande.add(domanda);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return domande;

    }

//    private String nomePersona;
//    private UUID idDomanda;
//    private Scuola primaScelta;
//    private Scuola secondaScelta;
//    private int punteggioPrimaScelta;
//    private int punteggioSecondaScelta;

    private static Domanda createBook(String[] metadata) {

        List<Scuola> listScuole = initScuole();

        // 0            1          2            3              4                     5
        // nomePersona; idDomanda; primaScelta; secondaScelta; punteggioPrimaScelta; punteggioSecondaScelta

        // 6                  7                           8                             9                          10
        // punteggioFratelli; puntLavoroMadrePrimaScelta; puntLavoroMadreSecondaScelta; puntavoroPadrePrimaScelta; puntLavoroPadreSecondaScelta;

        // 11                   12                   13             14
        // punteggioGravidanza; punteggioDisabilita; dataDiNascita; esito


        String nomePersona = metadata[0];
        int idDomanda = Integer.parseInt(metadata[1]);
//        UUID idDomanda = UUID.randomUUID();


        //Scuola primaScelta = metadata[2];

        Scuola primaScelta;
        switch (metadata[2]) {
            case "Alighieri - Skarabocchio (40)":
                primaScelta = listScuole.get(0);
                break;
            case "Ambaraba' (15)":
                primaScelta = listScuole.get(1);
                break;
            case "Cappuccetto rosso (9)":
                primaScelta = listScuole.get(2);
                break;

            case "D.Alighieri Il Giardino delle Meraviglie  Vismara (35)":
                primaScelta = listScuole.get(3);
                break;
            case "D.Alighieri Mongolfiera S.Maria Fabbrecce  (23)":
                primaScelta = listScuole.get(4);
                break;
            case "Filo rosso (21)":
                primaScelta = listScuole.get(5);
                break;

            case "G. Galilei - Alice (23)":
                primaScelta = listScuole.get(6);
                break;
            case "G. Galilei - Il bosco incantato (23)":
                primaScelta = listScuole.get(7);
                break;
            case "G.Galilei Tresei B.go S.Maria  (33)":
                primaScelta = listScuole.get(8);
                break;
            case "G.GalileiPollicino Casebruciate  (11)":
                primaScelta = listScuole.get(9);
                break;
            case "Gaudiano - Mille colori (7)":
                primaScelta = listScuole.get(10);
                break;
            case "Grillo parlante (8)":
                primaScelta = listScuole.get(11);
                break;
            case "Gulliver di Via Flaminia (28)":
                primaScelta = listScuole.get(12);
                break;
            case "I Tre giardini  (18)":
                primaScelta = listScuole.get(13);
                break;
            case "Il Giardino fantastico di Via Madonna di Loreto (8)":
                primaScelta = listScuole.get(14);
                break;
            case "La giostra (28)":
                primaScelta = listScuole.get(15);
                break;
            case "La Grande quercia di Via Leoncavallo (31)":
                primaScelta = listScuole.get(16);
                break;
            case "Leopardi - Via Bonali (22)":
                primaScelta = listScuole.get(17);
                break;
            case "Leopardi - Via Fermi (22)":
                primaScelta = listScuole.get(18);
                break;
            case "Mary poppins di Colombarone (11)":
                primaScelta = listScuole.get(19);
                break;
            case "Olivieri - Glicine (37)":
                primaScelta = listScuole.get(20);
                break;
            case "Peter pan di Via Livorno (19)":
                primaScelta = listScuole.get(21);
                break;
            case "Pirandello - Dire fare... (10)":
                primaScelta = listScuole.get(22);
                break;
            case "Pirandello - Milleluci (11)":
                primaScelta = listScuole.get(23);
                break;
            case "Pirandello - Prato fiorito (18)":
                primaScelta = listScuole.get(24);
                break;
            case "Poi poi di Via Ferraris (22)":
                primaScelta = listScuole.get(25);
                break;
            case "Specchio magico (17)":
                primaScelta = listScuole.get(26);
                break;
            case "Villa San Martino - Via togliatti (54)":
                primaScelta = listScuole.get(27);
                break;
            case "()":
                primaScelta = listScuole.get(28);
                break;


            default:
                throw new IllegalArgumentException("Invalid day of the week: " + metadata[3]);
        }
//            return primaScelta;


        /////////

        Scuola secondaScelta;
        switch (metadata[3]) {
            case "Alighieri - Skarabocchio (40)":
                secondaScelta = listScuole.get(0);
                break;
            case "Ambaraba' (15)":
                secondaScelta = listScuole.get(1);
                break;
            case "Cappuccetto rosso (9)":
                secondaScelta = listScuole.get(2);
                break;

            case "D.Alighieri Il Giardino delle Meraviglie  Vismara (35)":
                secondaScelta = listScuole.get(3);
                break;
            case "D.Alighieri Mongolfiera S.Maria Fabbrecce  (23)":
                secondaScelta = listScuole.get(4);
                break;
            case "Filo rosso (21)":
                secondaScelta = listScuole.get(5);
                break;

            case "G. Galilei - Alice (23)":
                secondaScelta = listScuole.get(6);
                break;
            case "G. Galilei - Il bosco incantato (23)":
                secondaScelta = listScuole.get(7);
                break;
            case "G.Galilei Tresei B.go S.Maria  (33)":
                secondaScelta = listScuole.get(8);
                break;
            case "G.GalileiPollicino Casebruciate  (11)":
                secondaScelta = listScuole.get(9);
                break;
            case "Gaudiano - Mille colori (7)":
                secondaScelta = listScuole.get(10);
                break;
            case "Grillo parlante (8)":
                secondaScelta = listScuole.get(11);
                break;
            case "Gulliver di Via Flaminia (28)":
                secondaScelta = listScuole.get(12);
                break;
            case "I Tre giardini  (18)":
                secondaScelta = listScuole.get(13);
                break;
            case "Il Giardino fantastico di Via Madonna di Loreto (8)":
                secondaScelta = listScuole.get(14);
                break;
            case "La giostra (28)":
                secondaScelta = listScuole.get(15);
                break;
            case "La Grande quercia di Via Leoncavallo (31)":
                secondaScelta = listScuole.get(16);
                break;
            case "Leopardi - Via Bonali (22)":
                secondaScelta = listScuole.get(17);
                break;
            case "Leopardi - Via Fermi (22)":
                secondaScelta = listScuole.get(18);
                break;
            case "Mary poppins di Colombarone (11)":
                secondaScelta = listScuole.get(19);
                break;
            case "Olivieri - Glicine (37)":
                secondaScelta = listScuole.get(20);
                break;
            case "Peter pan di Via Livorno (19)":
                secondaScelta = listScuole.get(21);
                break;
            case "Pirandello - Dire fare... (10)":
                secondaScelta = listScuole.get(22);
                break;
            case "Pirandello - Milleluci (11)":
                secondaScelta = listScuole.get(23);
                break;
            case "Pirandello - Prato fiorito (18)":
                secondaScelta = listScuole.get(24);
                break;
            case "Poi poi di Via Ferraris (22)":
                secondaScelta = listScuole.get(25);
                break;
            case "Specchio magico (17)":
                secondaScelta = listScuole.get(26);
                break;
            case "Villa San Martino - Via togliatti (54)":
                secondaScelta = listScuole.get(27);
                break;
            case "()":
                secondaScelta = listScuole.get(28);
                break;


            default:
                throw new IllegalArgumentException("Invalid day of the week: " + metadata[3]);
        }


//        Scuola secondaScelta = new Scuola(UUID.randomUUID(), "Alighieri - Skarabocchio", 40);
        int punteggioPrimaScelta = Integer.parseInt(metadata[4]);
        int punteggioSecondaScelta = Integer.parseInt(metadata[5]);

        // 0            1          2            3              4                     5
        // nomePersona; idDomanda; primaScelta; secondaScelta; punteggioPrimaScelta; punteggioSecondaScelta

        // 6                  7                           8                             9                          10
        // punteggioFratelli; puntLavoroMadrePrimaScelta; puntLavoroMadreSecondaScelta; puntavoroPadrePrimaScelta; puntLavoroPadreSecondaScelta;

        // 11                   12                   13             14
        // punteggioGravidanza; punteggioDisabilita; dataDiNascita; esito

        int punteggioFratelli = 0;
        if (metadata[6] == null || metadata[6].length() == 0) {
            punteggioFratelli = 0;
        } else {
            punteggioFratelli = Integer.parseInt(metadata[6]);
        }

        int puntLavoroMadrePrimaScelta;
        if (metadata[7] == null || metadata[7].length() == 0){
            puntLavoroMadrePrimaScelta = 0;
        } else {
            puntLavoroMadrePrimaScelta = Integer.parseInt(metadata[7]);
        }


        int puntLavoroMadreSecondaScelta;
        if (metadata[8] == null || metadata[8].length() == 0){
            puntLavoroMadreSecondaScelta = 0;
        } else {
            puntLavoroMadreSecondaScelta = Integer.parseInt(metadata[8]);
        }


        int puntavoroPadrePrimaScelta = 0;
        if (metadata[9] == null || metadata[9].length() == 0){
            puntavoroPadrePrimaScelta = 0;
        } else {
            puntavoroPadrePrimaScelta = Integer.parseInt(metadata[9]);
        }


        int puntLavoroPadreSecondaScelta = 0;
        if (metadata[10] == null || metadata[10].length() == 0){
            puntLavoroPadreSecondaScelta = 0;
        } else {
            puntLavoroPadreSecondaScelta = Integer.parseInt(metadata[10]);
        }

        int punteggioGravidanza = 0;
        if (metadata[11] == null || metadata[11].length() == 0){
            punteggioGravidanza = 0;
        } else {
            punteggioGravidanza = Integer.parseInt(metadata[11]);
        }



        int punteggioDisabilita = 0;
        if (metadata[12] == null || metadata[12].length() == 0){
            punteggioDisabilita = 0;
        } else {
            punteggioDisabilita = Integer.parseInt(metadata[12]);
        }

//        https://www.w3resource.com/java-exercises/re/java-re-exercise-10.php

//        String dataDiNascita = validate(metadata[13]);
        String dataDiNascita = metadata[13];

        String esito = null;
        if (metadata[14] == null) {
            esito = "Pending";
        } else {
            esito = metadata[14];
        }

        // create and return book of this metadata

        return new Domanda(nomePersona, idDomanda, primaScelta, secondaScelta, punteggioPrimaScelta, punteggioSecondaScelta,
                punteggioFratelli, puntLavoroMadrePrimaScelta, puntLavoroMadreSecondaScelta, puntavoroPadrePrimaScelta, puntLavoroPadreSecondaScelta,
                punteggioGravidanza, punteggioDisabilita, dataDiNascita, esito);
    }

//    public static String validate(String ip) {
//        return ip.replaceAll("(?<=^|\\.)0+(?!\\.|$)","");
//    }

    private static List<Scuola> initScuole() {
/*        Scuola scuolaMilano = new Scuola(UUID.randomUUID(), "Milano", 2);
        Scuola scuolaTorino = new Scuola(UUID.randomUUID(),"Torino", 2);
        Scuola scuolaVenezia = new Scuola(UUID.randomUUID(), "Venezia",1);*/

        Scuola scuolaMilano0 = new Scuola(0, "Alighieri - Skarabocchio", 40);
        Scuola scuolaMilano1 = new Scuola(1, "Ambaraba'", 15);
        Scuola scuolaMilano2 = new Scuola(2, "Cappuccetto rosso", 9);
        Scuola scuolaMilano3 = new Scuola(3, "D.Alighieri Il Giardino delle Meraviglie  Vismara", 35);
        Scuola scuolaMilano4 = new Scuola(4, "D.Alighieri Mongolfiera S.Maria Fabbrecce ", 23);
        Scuola scuolaMilano5 = new Scuola(5, "Filo rosso", 21);
        Scuola scuolaMilano6 = new Scuola(6, "G. Galilei - Alice", 23);
        Scuola scuolaMilano7 = new Scuola(7, "G. Galilei - Il bosco incantato", 23);
        Scuola scuolaMilano8 = new Scuola(8, "G.Galilei Tresei B.go S.Maria ", 33);
        Scuola scuolaMilano9 = new Scuola(9, "G.GalileiPollicino Casebruciate ", 11);
        Scuola scuolaMilano10 = new Scuola(10, "Gaudiano - Mille colori", 7);
        Scuola scuolaMilano11 = new Scuola(11, "Grillo parlante", 8);
        Scuola scuolaMilano12 = new Scuola(12, "Gulliver di Via Flaminia", 29);
//        Scuola scuolaMilano13 = new Scuola(13, "I Tre giardini sez primavera", 18);
        Scuola scuolaMilano13 = new Scuola(13, "I Tre giardini", 18);
        Scuola scuolaMilano14 = new Scuola(14, "Il Giardino fantastico di Via Madonna di Loreto", 8);
        Scuola scuolaMilano15 = new Scuola(15, "La giostra", 28);
        Scuola scuolaMilano16 = new Scuola(16, "La Grande quercia di Via Leoncavallo", 31);
        Scuola scuolaMilano17 = new Scuola(17, "Leopardi - Via Bonali", 22);
        Scuola scuolaMilano18 = new Scuola(18, "Leopardi - Via Fermi", 22);
        Scuola scuolaMilano19 = new Scuola(19, "Mary poppins di Colombarone", 11);
        Scuola scuolaMilano20 = new Scuola(20, "Olivieri - Glicine", 37);
        Scuola scuolaMilano21 = new Scuola(21, "Peter pan di Via Livorno", 19);
        Scuola scuolaMilano22 = new Scuola(22, "Pirandello - Dire fare...", 10);
        Scuola scuolaMilano23 = new Scuola(23, "Pirandello - Milleluci", 11);
        Scuola scuolaMilano24 = new Scuola(24, "Pirandello - Prato fiorito", 18);
        Scuola scuolaMilano25 = new Scuola(25, "Poi poi di Via Ferraris", 22);
        Scuola scuolaMilano26 = new Scuola(26, "Specchio magico", 17);
        Scuola scuolaMilano27 = new Scuola(27, "Villa San Martino - Via togliatti", 54);
        Scuola scuolaMilano28 = new Scuola(28, "VUOTO", 0);

        List<Scuola> listScuole = new ArrayList<>();
        listScuole.add(scuolaMilano0);
        listScuole.add(scuolaMilano1);
        listScuole.add(scuolaMilano2);
        listScuole.add(scuolaMilano3);
        listScuole.add(scuolaMilano4);
        listScuole.add(scuolaMilano5);
        listScuole.add(scuolaMilano6);
        listScuole.add(scuolaMilano7);
        listScuole.add(scuolaMilano8);
        listScuole.add(scuolaMilano9);
        listScuole.add(scuolaMilano10);
        listScuole.add(scuolaMilano11);
        listScuole.add(scuolaMilano12);
        listScuole.add(scuolaMilano13);
        listScuole.add(scuolaMilano14);
        listScuole.add(scuolaMilano15);
        listScuole.add(scuolaMilano16);
        listScuole.add(scuolaMilano17);
        listScuole.add(scuolaMilano18);
        listScuole.add(scuolaMilano19);
        listScuole.add(scuolaMilano20);
        listScuole.add(scuolaMilano21);
        listScuole.add(scuolaMilano22);
        listScuole.add(scuolaMilano23);
        listScuole.add(scuolaMilano24);
        listScuole.add(scuolaMilano25);
        listScuole.add(scuolaMilano26);
        listScuole.add(scuolaMilano27);
        listScuole.add(scuolaMilano28);

//        listScuole.add(scuolaMilano);
//        listScuole.add(scuolaTorino);
//        listScuole.add(scuolaVenezia);

        return listScuole;
    }

}
