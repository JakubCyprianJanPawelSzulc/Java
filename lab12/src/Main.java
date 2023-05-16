import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        Kalendarz mojKalendarz = new Kalendarz();

        System.out.println("Program do zarządzania kalendrzem spotkań");
        int wybor = 0;
        do{
            System.out.println("Co chcesz zrobić?  \n1-Dodaj \n2-Usun \n3-Wyswietl z wybranego dnia\n4-Wyswietl z wybranego dnia o wybranym priorytecie/statusie\n5-Wyświetl w wybranym dniu od podanego czasu\n6-Wyświetl w wybranym dniu w przedziale czasowym\n7-Wyświetl w wybranym dniu o wybranym priorytecie/statusie i od podanego czasu\n8-Wyświetl do podanego czasu\n9-Wyjscie");
            wybor = inputInt.nextInt();
            switch (wybor){
                case 1 ->   addEvent(mojKalendarz, inputInt, inputString);
                case 2 ->   removeEvent(mojKalendarz, inputInt, inputString);
                case 3 ->   showEvents(mojKalendarz, inputInt);
                case 4 ->   showEventsWithPriorityStatus(mojKalendarz, inputInt, inputString);
                case 5 ->   showEventsFrom(mojKalendarz, inputInt, inputString);
                case 6 ->   showEventsFromTo(mojKalendarz, inputInt, inputString);
                case 7 ->   showEventsFromWithPriorityStatus(mojKalendarz, inputInt, inputString);
                case 8 ->   showEventsTo(mojKalendarz, inputInt, inputString);
            }
        }while (wybor != 9);

    }

    public static void addEvent(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Zadanie czy spotkanie (1/2)");
        int wybor = inputInt.nextInt();
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj opis spotkania");
        String opis = inputString.nextLine();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        while (LocalTime.parse(czasPoczatku).compareTo(Spotkanie.MIN_CZAS) < 0){
            System.out.println("Godzina niepoprawna, podaj jeszcze raz");
            czasPoczatku = inputString.nextLine();
        }
        System.out.println("Podaj godzine zakonczenia");
        String czasKonca = inputString.nextLine();
        if(wybor == 1){
            System.out.println("Podaj priorytet (niski, sredni, wysoki)");
            String priorytet = inputString.nextLine();
            mojKalendarz.dodajWydarzenie(dzien, new Spotkanie(opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasKonca), priorytet));
        }
        else if (wybor==2){
            System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane)");
            String status = inputString.nextLine();
            mojKalendarz.dodajWydarzenie(dzien, new Zadanie(opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasKonca), status));
        }
        
    }

    public static void removeEvent(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Zadanie czy spotkanie (1/2)");
        int wybor = inputInt.nextInt();
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj opis spotkania");
        String opis = inputString.nextLine();
        Predicate <Wydarzenie> warunek = e -> e.getOpis().equals(opis);
        Predicate <Wydarzenie> warunek2 = e -> true;
        if(wybor ==1){
            warunek2 = e -> e instanceof Spotkanie;
        }
        else if (wybor == 2){
            warunek2 = e -> e instanceof Zadanie;
        }
        mojKalendarz.usunWydarzenie(dzien, warunek.and(warunek2));
    }

    public static void showEvents(Kalendarz mojKalendarz, Scanner inputInt){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        if(wybor ==1){
            printElems(mojKalendarz.getDzien(dzien, e -> e instanceof Spotkanie));
        }
        else if (wybor == 2){
            printElems(mojKalendarz.getDzien(dzien, e -> e instanceof Zadanie));
        }
    }

    public static void showEventsWithPriorityStatus(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        if (wybor == 1){
            System.out.println("Podaj priorytet (wysoki, sredni, niski)");
            String priorytet = inputString.nextLine();
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Spotkanie && ((Spotkanie)s).getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))));
        }
        else if (wybor == 2){
            System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane)");
            String status = inputString.nextLine();
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Zadanie && ((Zadanie)s).getStatus().equals(Zadanie.StatusVals.valueOf(status))));
        }
    }

    public static void showEventsFrom(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        if(wybor==1){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Spotkanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0));
        }
        else if (wybor == 2){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Zadanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0));
        }
    }

    public static void showEventsFromTo(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        System.out.println("Podaj godzine zakonczenia");
        String czasKonca = inputString.nextLine();
        if(wybor==1){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Spotkanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && s.getCzasZakonczenia().compareTo(LocalTime.parse(czasKonca)) <= 0));
        }
        else if (wybor == 2){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Zadanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && s.getCzasZakonczenia().compareTo(LocalTime.parse(czasKonca)) <= 0));
        }
    }

    public static void showEventsFromWithPriorityStatus(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        if(wybor==1){
            System.out.println("Podaj priorytet (wysoki, sredni, niski)");
            String priorytet = inputString.nextLine();
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Spotkanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && ((Spotkanie)s).getPriorytet().equals(Spotkanie.PriorytetVals.valueOf(priorytet))));
        }
        else if (wybor == 2){
            System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane)");
            String status = inputString.nextLine();
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Zadanie && s.getCzasPoczatku().compareTo(LocalTime.parse(czasPoczatku)) >= 0 && ((Zadanie)s).getStatus().equals(Zadanie.StatusVals.valueOf(status))));
        }
    }

    public static void showEventsTo(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine zakonczenia");
        String czasKonca = inputString.nextLine();
        System.out.println("spotkanie czy zadanie (1/2)");
        int wybor = inputInt.nextInt();
        if(wybor==1){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Spotkanie && s.getCzasZakonczenia().compareTo(LocalTime.parse(czasKonca)) <= 0));
        }
        else if (wybor == 2){
            printElems(mojKalendarz.getDzien(dzien, s -> s instanceof Zadanie && s.getCzasZakonczenia().compareTo(LocalTime.parse(czasKonca)) <= 0));
        }
    }

    public static void printElems(ArrayList<Wydarzenie> elems){
        for (Wydarzenie spotkanie : elems){
            System.out.println(spotkanie.toString());
        }
    }

}
