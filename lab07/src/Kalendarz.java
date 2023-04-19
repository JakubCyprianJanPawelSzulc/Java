import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz{
    private ArrayList[] tydzien= new ArrayList[7];

    public Kalendarz(){
        for(int i=0; i<tydzien.length; i++){
            tydzien[i] = new ArrayList<Spotkanie>();
        }
    }

    public void dodajSpotkanie(int dzien, String opis, LocalTime czasPoczatku, LocalTime czasKonca, String priorytet){
        tydzien[dzien].add(new Spotkanie(opis, czasPoczatku, czasKonca, priorytet));
    }

    public void usunSpotkanie(int dzien, int index){
        tydzien[dzien].remove(index);
    }

    public void printSpotkanie(int dzien, int index){
        System.out.println("\n\tSpotkanie " + index);
        System.out.println("\tOpis: " + ((Spotkanie)tydzien[dzien].get(index)).getOpis());
        System.out.println("\tCzas poczatku: " + ((Spotkanie)tydzien[dzien].get(index)).getCzasPoczatku());
        System.out.println("\tCzas konca: " + ((Spotkanie)tydzien[dzien].get(index)).getCzasZakonczenia());
        System.out.println("\tPriorytet: " + ((Spotkanie)tydzien[dzien].get(index)).getPriorytet());
    }

    public void jakiDzienTygodnia(int i){
        switch(i){
            case 0:
                System.out.println("Poniedzialek");
                break;
            case 1:
                System.out.println("Wtorek");
                break;
            case 2:
                System.out.println("Sroda");
                break;
            case 3:
                System.out.println("Czwartek");
                break;
            case 4:
                System.out.println("Piatek");
                break;
            case 5:
                System.out.println("Sobota");
                break;
            case 6:
                System.out.println("Niedziela");
                break;
        }
    }

    public void wyswietlTydzien(){
        for(int i=0; i<tydzien.length; i++){
            jakiDzienTygodnia(i);
            for(int j=0; j<tydzien[i].size(); j++){
                printSpotkanie(i, j);
            }
        }
    }

    public void wyswietlDzien(int dzien){
        jakiDzienTygodnia(dzien);
        for(int i=0; i<tydzien[dzien].size(); i++){
            printSpotkanie(dzien, i);
        }
    }

    public void wyswietlDzienPriorytet(int dzien, String priorytet){
        jakiDzienTygodnia(dzien);
        for(int i=0; i<tydzien[dzien].size(); i++){
            if(((Spotkanie)tydzien[dzien].get(i)).getPriorytet().equals(priorytet)){
                printSpotkanie(dzien, i);
            }
        }
    }
}