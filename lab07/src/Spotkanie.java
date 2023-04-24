import java.time.LocalTime;

public class Spotkanie {
    
    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasKonca;
    private PriorytetVals priorytet;

    public enum PriorytetVals {
        niski, sredni, wysoki
    }
    

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasKonca = czasKonca;
        this.priorytet = PriorytetVals.valueOf(priorytet);
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

    public PriorytetVals getPriorytet(){
        return this.priorytet;
    }

    public String wypisz(){
        return ("\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tpriorytet: " + this.priorytet);
    }
}
