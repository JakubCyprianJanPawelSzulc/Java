import java.time.LocalTime;
import java.util.ArrayList;

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
        ArrayList<Spotkanie> spotkaniaOPriorytecie = new ArrayList<Spotkanie>();
        for(int i=0; i<tydzien[dzien].size(); i++){
            if(tydzien[dzien].get(i).getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))){
                spotkaniaOPriorytecie.add(tydzien[dzien].get(i));
            }
        }
        return spotkaniaOPriorytecie;
    }
}
