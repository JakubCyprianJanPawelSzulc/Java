import java.time.LocalTime;

public class Spotkanie {
    
    private final LocalTime MIN_CZAS = LocalTime.of(8, 0);
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasKonca;
    private String priorytet;
    

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasKonca = czasKonca;
        this.priorytet = priorytet;
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

    public String getPriorytet(){
        return priorytet;
    }
}
