import java.time.LocalTime;

public class Spotkanie extends Wydarzenie{
    
    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
    private PriorytetVals priorytet;

    public enum PriorytetVals {
        niski, sredni, wysoki
    }
    

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet) {
        super(opis, czasPoczatku, czasKonca);
        this.priorytet = PriorytetVals.valueOf(priorytet);
    }

    public PriorytetVals getPriorytet(){
        return this.priorytet;
    }

    @Override
    public String toString(){
        return "\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tpriorytet: " + this.priorytet;
    }
}
