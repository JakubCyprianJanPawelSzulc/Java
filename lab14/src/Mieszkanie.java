import java.time.LocalDate;

public final class Mieszkanie extends Nieruchomosc {
    private int numerMieszkania;
    private int pietro;

    public Mieszkanie(String ulica, int nrDomu, String miasto, String kodPocztowy, double powierzchnia, double cena, LocalDate dataOferty, int pietro, int numerMieszkania) {
        super(ulica, nrDomu, miasto, kodPocztowy, powierzchnia, cena, dataOferty);
        this.pietro = pietro;
        this.numerMieszkania = numerMieszkania;
    }

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public int getPietro() {
        return pietro;
    }

    @Override
    public String toString(){
        return "Mieszkanie: " + ulica + " " + nrDomu + "/" + numerMieszkania + ", " + pietro + ", "+miasto + ", " + kodPocztowy + ", " + powierzchnia + " m^2, " + cena + " PLN, " + dataOferty;
    }
}
