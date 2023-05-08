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
            System.out.println("Co chcesz zrobić?  \n1-Dodaj spotkanie\n2-Usun spotkanie\n3-Wyswietl spotkania z wybranego dnia\n4-Wyswietl spotkania z wybranego dnia o wybranym priorytecie\n5-Wyświetl spotkania w wybranym dniu od podanego czasu\n6-Wyświetl spotkania w wybranym dniu w przedziale czasowym\n7-Wyświetl spotkania w wybranym dniu o wybranym priorytecie i od podanego czasu\n8-Wyjscie");
            wybor = inputInt.nextInt();
            switch (wybor){
                case 1 ->   addMeeting(mojKalendarz, inputInt, inputString);
                case 2 ->   removeMeeting(mojKalendarz, inputInt);
                case 3 ->   showMeetings(mojKalendarz, inputInt);
                case 4 ->   showMeetingsWithPriority(mojKalendarz, inputInt, inputString);
                case 5 ->   showMeetingsFrom(mojKalendarz, inputInt, inputString);
                case 6 ->   showMeetingsFromTo(mojKalendarz, inputInt, inputString);
                case 7 ->   showMeetingsFromWithPriority(mojKalendarz, inputInt, inputString);
            }
        }while (wybor != 8);

    }

    public static void addMeeting(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
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
        System.out.println("Podaj priorytet (niski, sredni, wysoki)");
        String priorytet = inputString.nextLine();
        mojKalendarz.dodajSpotkanie(dzien, opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasKonca), priorytet);
    }

    public static void removeMeeting(Kalendarz mojKalendarz, Scanner inputInt){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj indeks spotkania");
        int index = inputInt.nextInt();
        mojKalendarz.usunSpotkanie(dzien, index);
    }

    // public static void showMeetingsWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
    //     System.out.println("Podaj dzień tygodnia (0-6)");
    //     int dzien = inputInt.nextInt();
    //     System.out.println("Podaj priorytet (wysoki, sredni, niski)");
    //     String priorytet = inputString.nextLine();
    //     printElems(mojKalendarz.getSpotkaniaDniaTygodniaOPriorytecie(dzien, priorytet));
    // }

    public static void showMeetings(Kalendarz mojKalendarz, Scanner inputInt){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        printElems(mojKalendarz.getSpotkaniaDniaTygodnia(dzien));
    }

    public static void showMeetingsWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj priorytet (wysoki, sredni, niski)");
        String priorytet = inputString.nextLine();
        printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOPriorytecie(priorytet)));
    }

    public static void showMeetingsFrom(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku))));
    }

    public static void showMeetingsFromTo(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        System.out.println("Podaj godzine zakonczenia");
        String czasKonca = inputString.nextLine();
        printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku)).and(mojKalendarz.getDoPodanejGodziny(LocalTime.parse(czasKonca)))));
    }

    public static void showMeetingsFromWithPriority(Kalendarz mojKalendarz, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj dzień tygodnia (0-6)");
        int dzien = inputInt.nextInt();
        System.out.println("Podaj godzine rozpoczecia");
        String czasPoczatku = inputString.nextLine();
        System.out.println("Podaj priorytet (wysoki, sredni, niski)");
        String priorytet = inputString.nextLine();
        printElems(mojKalendarz.getDzien(dzien, mojKalendarz.getOdPodanejGodziny(LocalTime.parse(czasPoczatku)).and(mojKalendarz.getOPriorytecie(priorytet))));
    }

    public static void printElems(ArrayList<Spotkanie> elems){
        for (Spotkanie spotkanie : elems){
            System.out.println(spotkanie.toString());
        }
    }

}
