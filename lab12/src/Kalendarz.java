import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz{
    private ArrayList<Wydarzenie>[] tydzien = new ArrayList[7];

    public Kalendarz(){
        this(7);
    }

    public Kalendarz(int dni){
        for(int i = 0; i < dni; i++){
            tydzien[i] = new ArrayList<Wydarzenie>();
        }
    }

    public void dodajWydarzenie(int dzien, Spotkanie spotkanie){
        tydzien[dzien].add(spotkanie);
    }

    public void dodajWydarzenie(int dzien, Zadanie zadanie){
        tydzien[dzien].add(zadanie);
    }

    public void usunWydarzenie(int dzien, int index, Predicate<Wydarzenie> warunek){
        ArrayList<Wydarzenie> spotkania = tydzien[dzien];
        for (Wydarzenie spotkanie : tydzien[dzien]){
            if (warunek.test(spotkanie)){
                spotkania.remove(spotkanie);
            }
        }
    }

    // public Spotkanie getSpotkanie(int dzien, int index) {
    //     Spotkanie spotkanie = tydzien[dzien].get(index);
    //     return spotkanie;
    // }

    public ArrayList<Wydarzenie> getSpotkaniaDniaTygodnia(int dzien){
        return tydzien[dzien];
    }

    // public ArrayList<Spotkanie> getSpotkaniaDniaTygodniaOPriorytecie(int dzien, String priorytet){
    //     ArrayList<Spotkanie> spotkania = tydzien[dzien];
    //     for (Spotkanie spotkanie : tydzien[dzien]){
    //         if (spotkanie.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))){
    //             spotkania.add(spotkanie);
    //         }
    //     }
    //     return spotkania;
    // }

    // public Predicate<Spotkanie> getOdPodanejGodziny(LocalTime czas){
    //     return s -> s.getCzasPoczatku().compareTo(czas) >= 0;
    // }

    // public Predicate<Spotkanie> getDoPodanejGodziny(LocalTime czas){
    //     return s -> s.getCzasZakonczenia().compareTo(czas) <= 0;
    // }

    // public Predicate<Spotkanie> getOPriorytecie(String priorytet){
    //     return s -> s.getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet));
    // }
    
    public ArrayList<Wydarzenie> getDzien(int dzien, Predicate<Wydarzenie> warunek){
        ArrayList<Wydarzenie> spotkania = new ArrayList<>();
        for (Wydarzenie spotkanie : tydzien[dzien]){
            if (warunek.test(spotkanie)){
                spotkania.add(spotkanie);
            }
        }
        return spotkania;
    }
}
