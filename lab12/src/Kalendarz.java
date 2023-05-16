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

    public void usunWydarzenie(int dzien, Predicate<Wydarzenie> warunek){
        ArrayList<Wydarzenie> spotkania = new ArrayList<>();
        for (Wydarzenie spotkanie : tydzien[dzien]){
            if (warunek.test(spotkanie)){
                spotkania.add(spotkanie);
            }
        }
        tydzien[dzien].removeAll(spotkania);
    }

    public ArrayList<Wydarzenie> getSpotkaniaDniaTygodnia(int dzien){
        return tydzien[dzien];
    }
    
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
