public class Domanda {

    private String nomePersona;
    private int idDomanda;

    // list domande graduatorie
    // per ogni domanda, noi abbiamo un esito perchè consideriamo ogni domanda come un oggetto duplicato per ogni graduatoria
    // TODO sarebbe bello se invece di avere una variabile esito, avremmo un esito di prima scelta e un esito di seconda scelta
    // in modo da evitare di duplicare gli oggetti
    /*
    List<DomandeGrad> 0-1
    DomandeGrad {
        scelta,
        punteggio,
        esito,
        EnumSceltaDomanda
    }
     */
    // prima scelta
    // putenggio scelta
    // esito scelta
    private Scuola primaScelta;
    private Scuola secondaScelta;
    private int punteggioPrimaScelta;
    private int punteggioSecondaScelta;

    private int punteggioFratelli;
    private int puntLavoroMadrePrimaScelta;
    private int puntLavoroMadreSecondaScelta;
    private int puntavoroPadrePrimaScelta;
    private int puntLavoroPadreSecondaScelta;
    private int punteggioGravidanza;
    private int punteggioDisabilita;
    private String dataDiNascita;


    private EnumEsitoDomanda esito;
    private EnumSceltaDomanda scelta;

//    public Domanda(String nomePersona, int idDomanda, Scuola primaScelta, Scuola secondaScelta, int punteggioPrimaScelta, int punteggioSecondaScelta, String esito) {
//        this.nomePersona = nomePersona;
//        this.idDomanda = idDomanda;
//        this.primaScelta = primaScelta;
//        this.secondaScelta = secondaScelta;
//        this.punteggioPrimaScelta = punteggioPrimaScelta;
//        this.punteggioSecondaScelta = punteggioSecondaScelta;
//        this.esito = EnumEsitoDomanda.getEnumByString(esito);
//    }


    // TODO Sting estio portare ad Enum
    public Domanda(String nomePersona, int idDomanda, Scuola primaScelta, Scuola secondaScelta, int punteggioPrimaScelta, int punteggioSecondaScelta, int punteggioFratelli, int puntLavoroMadrePrimaScelta, int puntLavoroMadreSecondaScelta, int puntavoroPadrePrimaScelta, int puntLavoroPadreSecondaScelta, int punteggioGravidanza, int punteggioDisabilita, String dataDiNascita, String esito) {
        this.nomePersona = nomePersona;
        this.idDomanda = idDomanda;
        this.primaScelta = primaScelta;
        this.secondaScelta = secondaScelta;
        this.punteggioPrimaScelta = punteggioPrimaScelta;
        this.punteggioSecondaScelta = punteggioSecondaScelta;
        this.punteggioFratelli = punteggioFratelli;
        this.puntLavoroMadrePrimaScelta = puntLavoroMadrePrimaScelta;
        this.puntLavoroMadreSecondaScelta = puntLavoroMadreSecondaScelta;
        this.puntavoroPadrePrimaScelta = puntavoroPadrePrimaScelta;
        this.puntLavoroPadreSecondaScelta = puntLavoroPadreSecondaScelta;
        this.punteggioGravidanza = punteggioGravidanza;
        this.punteggioDisabilita = punteggioDisabilita;
        this.dataDiNascita = dataDiNascita;
        this.esito = EnumEsitoDomanda.getEnumByString(esito);
    }

    // deep copy
    public Domanda(Domanda otherDomanda) {
        this.nomePersona = otherDomanda.getNomePersona();
        this.idDomanda = otherDomanda.getIdDomanda();
        this.primaScelta = otherDomanda.getPrimaScelta();
        this.secondaScelta = otherDomanda.getSecondaScelta();
        this.punteggioPrimaScelta = otherDomanda.getPunteggioPrimaScelta();
        this.punteggioSecondaScelta = otherDomanda.getPunteggioSecondaScelta();
        this.punteggioFratelli = otherDomanda.punteggioFratelli;
        this.puntLavoroMadrePrimaScelta = otherDomanda.puntLavoroMadrePrimaScelta;
        this.puntLavoroMadreSecondaScelta = otherDomanda.puntLavoroMadreSecondaScelta;
        this.puntavoroPadrePrimaScelta = otherDomanda.puntavoroPadrePrimaScelta;
        this.puntLavoroPadreSecondaScelta = otherDomanda.puntLavoroPadreSecondaScelta;
        this.punteggioGravidanza = otherDomanda.punteggioGravidanza;
        this.punteggioDisabilita = otherDomanda.punteggioDisabilita;
        this.dataDiNascita = otherDomanda.dataDiNascita;
        this.esito = otherDomanda.getEsito();
    }

    public String getNomePersona() {
        return nomePersona;
    }

    public void setNomePersona(String nomePersona) {
        this.nomePersona = nomePersona;
    }

    public Integer getIdDomanda() {
        return idDomanda;
    }

    public void setIdDomanda(int idDomanda) {
        this.idDomanda = idDomanda;
    }

    public Scuola getPrimaScelta() {
        return primaScelta;
    }

    public void setPrimaScelta(Scuola primaScelta) {
        this.primaScelta = primaScelta;
    }

    public Scuola getSecondaScelta() {
        return secondaScelta;
    }

    public void setSecondaScelta(Scuola secondaScelta) {
        this.secondaScelta = secondaScelta;
    }

    public int getPunteggioPrimaScelta() {
        return punteggioPrimaScelta;
    }

    public void setPunteggioPrimaScelta(int punteggioPrimaScelta) {
        this.punteggioPrimaScelta = punteggioPrimaScelta;
    }

    public int getPunteggioSecondaScelta() {
        return punteggioSecondaScelta;
    }

    public void setPunteggioSecondaScelta(int punteggioSecondaScelta) {
        this.punteggioSecondaScelta = punteggioSecondaScelta;
    }

    public EnumEsitoDomanda getEsito() {
        return esito;
    }

    public void setEsito(EnumEsitoDomanda esito) {
        this.esito = esito;
    }

    public EnumSceltaDomanda getScelta() {
        return scelta;
    }

    public void setScelta(EnumSceltaDomanda scelta) {
        this.scelta = scelta;
    }

    public int getPunteggioFratelli() {
        return punteggioFratelli;
    }

    public void setPunteggioFratelli(int punteggioFratelli) {
        this.punteggioFratelli = punteggioFratelli;
    }

    public int getPuntLavoroMadrePrimaScelta() {
        return puntLavoroMadrePrimaScelta;
    }

    public void setPuntLavoroMadrePrimaScelta(int puntLavoroMadrePrimaScelta) {
        this.puntLavoroMadrePrimaScelta = puntLavoroMadrePrimaScelta;
    }

    public int getPuntLavoroMadreSecondaScelta() {
        return puntLavoroMadreSecondaScelta;
    }

    public void setPuntLavoroMadreSecondaScelta(int puntLavoroMadreSecondaScelta) {
        this.puntLavoroMadreSecondaScelta = puntLavoroMadreSecondaScelta;
    }

    public int getPuntavoroPadrePrimaScelta() {
        return puntavoroPadrePrimaScelta;
    }

    public void setPuntavoroPadrePrimaScelta(int puntavoroPadrePrimaScelta) {
        this.puntavoroPadrePrimaScelta = puntavoroPadrePrimaScelta;
    }

    public int getPuntLavoroPadreSecondaScelta() {
        return puntLavoroPadreSecondaScelta;
    }

    public void setPuntLavoroPadreSecondaScelta(int puntLavoroPadreSecondaScelta) {
        this.puntLavoroPadreSecondaScelta = puntLavoroPadreSecondaScelta;
    }

    public int getPunteggioGravidanza() {
        return punteggioGravidanza;
    }

    public void setPunteggioGravidanza(int punteggioGravidanza) {
        this.punteggioGravidanza = punteggioGravidanza;
    }

    public int getPunteggioDisabilita() {
        return punteggioDisabilita;
    }

    public void setPunteggioDisabilita(int punteggioDisabilita) {
        this.punteggioDisabilita = punteggioDisabilita;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

//    @Override
//    public String toString() {
//        return "Domanda{" +
//                "nomePersona='" + nomePersona + '\'' +
//                ", idDomanda=" + idDomanda +
//                ", primaScelta=" + primaScelta +
//                ", secondaScelta=" + secondaScelta +
//                ", punteggioPrimaScelta=" + punteggioPrimaScelta +
//                ", punteggioSecondaScelta=" + punteggioSecondaScelta +
//                ", esito=" + esito +
//                '}';
//    }


    @Override
    public String toString() {
        return "Domanda{" +
                "nomePersona='" + nomePersona + '\'' +
                ", idDomanda=" + idDomanda +
                ", primaScelta=" + primaScelta +
                ", secondaScelta=" + secondaScelta +
                ", punteggioPrimaScelta=" + punteggioPrimaScelta +
                ", punteggioSecondaScelta=" + punteggioSecondaScelta +
                ", punteggioFratelli=" + punteggioFratelli +
                ", puntavoroMadrePrimaScelta=" + puntLavoroMadrePrimaScelta +
                ", puntavoroMadreSecondaScelta=" + puntLavoroMadreSecondaScelta +
                ", puntavoroPadrePrimaScelta=" + puntavoroPadrePrimaScelta +
                ", puntavoroPadreSecondaScelta=" + puntLavoroPadreSecondaScelta +
                ", punteggioGravidanza=" + punteggioGravidanza +
                ", punteggioDisabilita=" + punteggioDisabilita +
                ", dataDiNascita=" + dataDiNascita +
                ", esito=" + esito +
//                ", scelta=" + scelta +
                '}';
    }
}
