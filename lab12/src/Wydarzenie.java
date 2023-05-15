import java.time.LocalTime;

abstract sealed class Wydarzenie permits Zadanie, Spotkanie {
    protected String opis;
    protected LocalTime czasPoczatku;
    protected LocalTime czasKonca;
    
    public Wydarzenie(String opis, LocalTime czasPoczatku, LocalTime czasKonca) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasKonca = czasKonca;
    }

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime getCzasZakonczenia() {
        return czasKonca;
    }

}
