import java.io.ObjectInputFilter.Status;
import java.time.LocalTime;

public class Zadanie extends Wydarzenie {
    private StatusVals status;
    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);

    enum StatusVals{
        planowane, potwierdzone, realizowane, wykonane
    }

    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasKonca, String status) {
        super(opis, czasPoczatku, czasKonca);
        this.status= StatusVals.valueOf(status);
    }

    public StatusVals getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return "\t" + this.opis + "\n\t" + this.czasPoczatku + "-" + this.czasKonca + "\n\tstatus: " + this.status;
    }
    
}
