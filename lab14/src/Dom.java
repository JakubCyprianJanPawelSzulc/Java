import java.time.LocalDate;

public final class Dom extends Nieruchomosc {

    private double powierzchniaDzialki;

    public Dom(String ulica, int nrDomu, String miasto, String kodPocztowy, double powierzchnia, double cena, LocalDate dataOferty, int powierzchniaDzialki) {
        super(ulica, nrDomu, miasto, kodPocztowy, powierzchnia, cena, dataOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    public double getPowierzchniaDzialki() {
        return powierzchniaDzialki;
    }

    @Override
    public String toString(){
        return "Dom: " + ulica + " " + nrDomu + ", " + miasto + ", " + kodPocztowy + ", " + powierzchnia + " m^2, " + powierzchniaDzialki + " m^2, "+ cena + " PLN, " + dataOferty;
    }
}