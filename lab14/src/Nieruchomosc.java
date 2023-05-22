import java.time.LocalDate;

abstract sealed class Nieruchomosc permits Mieszkanie, Dom{
    protected String ulica;
    protected int nrDomu;
    protected String miasto;
    protected String kodPocztowy;
    protected double powierzchnia;
    protected double cena;
    protected LocalDate dataOferty;

    public Nieruchomosc (String ulica, int nrDomu, String miasto, String kodPocztowy, double powierzchnia, double cena, LocalDate dataOferty) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataOferty = dataOferty;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public double getCena() {
        return cena;
    }

    public LocalDate getDataOferty() {
        return dataOferty;
    }

}
