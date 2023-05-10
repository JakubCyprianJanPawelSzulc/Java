import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz{
    private ArrayList<Spotkanie>[] tydzien = new ArrayList[7];

    public Kalendarz(){
        this(7);
    }

    public Kalendarz(int dni){
        for(int i = 0; i < dni; i++){
            tydzien[i] = new ArrayList<Spotkanie>();
        }
    }

    public void dodajSpotkanie(int dzien, String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet){
        tydzien[dzien].add(new Spotkanie(opis, czasPoczatku, czasKonca, priorytet));
    }

    public void usunSpotkanie(int dzien, int index){
        tydzien[dzien].remove(index);
    }

    public Spotkanie getSpotkanie(int dzien, int index) {
        Spotkanie spotkanie = tydzien[dzien].get(index);
        return spotkanie;
    }

    public ArrayList<Spotkanie> getSpotkaniaDniaTygodnia(int dzien){
        return tydzien[dzien];
    }

    public ArrayList<Spotkanie> getSpotkaniaDniaTygodniaOPriorytecie(int dzien, String priorytet){
        ArrayList<Spotkanie> spotkania = tydzien[dzien];
        for (Spotkanie spotkanie : tydzien[dzien]){
            if (spotkanie.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))){
                spotkania.add(spotkanie);
            }
        }
        return spotkania;
    }

    public Predicate<Spotkanie> getOdPodanejGodziny(LocalTime czas){
        return s -> s.getCzasPoczatku().compareTo(czas) >= 0;
    }

    public Predicate<Spotkanie> getDoPodanejGodziny(LocalTime czas){
        return s -> s.getCzasZakonczenia().compareTo(czas) <= 0;
    }

    public Predicate<Spotkanie> getOPriorytecie(String priorytet){
        return s -> s.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet));
    }
    
    public ArrayList<Spotkanie> getDzien(int dzien, Predicate<Spotkanie> warunek){
        ArrayList<Spotkanie> spotkania = new ArrayList<>();
        for (Spotkanie spotkanie : tydzien[dzien]){
            if (warunek.test(spotkanie)){
                spotkania.add(spotkanie);
            }
        }
        return spotkania;
    }
}
