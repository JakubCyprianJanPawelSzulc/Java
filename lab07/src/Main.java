import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void wyswietlOpcjeDniTygodnia(){
        System.out.println("Wybierz dzien tygodnia:");
        System.out.println("0. Poniedzialek");
        System.out.println("1. Wtorek");
        System.out.println("2. Sroda");
        System.out.println("3. Czwartek");
        System.out.println("4. Piatek");
        System.out.println("5. Sobota");
        System.out.println("6. Niedziela");
    }

    public static void wyswietlOpcjePriorytet(){
        System.out.println("Wybierz priorytet:");
        System.out.println("wysoki");
        System.out.println("sredni");
        System.out.println("niski");
    }

    public static void wyswietlWszystkieDzienPriorytet(Kalendarz kalendarz){
        wyswietlOpcjeDniTygodnia();
        Scanner wyswietlWszystkieDzienPriorytetScannerDzien = new Scanner(System.in);
        int wyborDzien = wyswietlWszystkieDzienPriorytetScannerDzien.nextInt();
        wyswietlOpcjePriorytet();
        Scanner wyswietlWszystkieDzienPriorytetScannerPriorytet = new Scanner(System.in);
        String wyborPriorytet = wyswietlWszystkieDzienPriorytetScannerPriorytet.nextLine();
        kalendarz.wyswietlDzienPriorytet(wyborDzien, wyborPriorytet);
        wyswietlWszystkieDzienPriorytetScannerDzien.close();
        wyswietlWszystkieDzienPriorytetScannerPriorytet.close();

    }

    public static void wyswietlWszystkieWWybranymDniu(Kalendarz kalendarz){
        Scanner wyswietlWszystkieWWybranymDniuScanner = new Scanner(System.in);
        wyswietlOpcjeDniTygodnia();
        int wyborDzien = wyswietlWszystkieWWybranymDniuScanner.nextInt();
        kalendarz.wyswietlDzien(wyborDzien);

        wyswietlWszystkieWWybranymDniuScanner.close();
    }

    public static void dodajSpotkanie(Kalendarz kalendarz){
        Scanner dodajSpotkanieScanner = new Scanner(System.in);
        wyswietlOpcjeDniTygodnia();
        int wyborDzien = dodajSpotkanieScanner.nextInt();
        Scanner dodajSpotkanieScannerOpis = new Scanner(System.in);
        System.out.println("Podaj opis spotkania:");
        String opis = dodajSpotkanieScannerOpis.nextLine();
        System.out.println("Podaj czas poczatek spotkania:");
        Scanner dodajSpotkanieScannerCzasPoczatek = new Scanner(System.in);
        LocalTime czasPoczatek = LocalTime.parse(dodajSpotkanieScannerCzasPoczatek.nextLine());
        System.out.println("Podaj czas konca spotkania:");
        Scanner dodajSpotkanieScannerCzasKonca = new Scanner(System.in);
        LocalTime czasKonca = LocalTime.parse(dodajSpotkanieScannerCzasKonca.nextLine());
        System.out.println("Podaj priorytet spotkania:");
        wyswietlOpcjePriorytet();
        Scanner dodajSpotkanieScannerPriorytet = new Scanner(System.in);
        String priorytet = dodajSpotkanieScannerPriorytet.nextLine();

        kalendarz.dodajSpotkanie(wyborDzien, opis, czasPoczatek, czasKonca, priorytet);

        dodajSpotkanieScanner.close();
        dodajSpotkanieScannerOpis.close();
        dodajSpotkanieScannerCzasPoczatek.close();
        dodajSpotkanieScannerCzasKonca.close();
        dodajSpotkanieScannerPriorytet.close();

    }

    public static void usunSpotkanie(Kalendarz kalendarz){
        Scanner usunSpotkanieScanner = new Scanner(System.in);
        wyswietlOpcjeDniTygodnia();
        int wyborDzien = usunSpotkanieScanner.nextInt();
        System.out.println("Podaj numer spotkania do usuniecia:");
        int numerSpotkania = usunSpotkanieScanner.nextInt();

        kalendarz.usunSpotkanie(wyborDzien, numerSpotkania);

        usunSpotkanieScanner.close();
    }

    public static void printujTydzien(Kalendarz kalendarz){
        kalendarz.wyswietlTydzien();
    }

    public static void main(String[] args){
        // Kalendarz kalendarz = new Kalendarz();
        // kalendarz.dodajSpotkanie(0, "eeee", LocalTime.parse("13:00:00"), LocalTime.parse("14:00:00"), "wysoki");
        // kalendarz.dodajSpotkanie(0, "ą", LocalTime.parse("14:00:00"), LocalTime.parse("15:00:00"), "sredni");
        // // kalendarz.wyswietlTydzien();
        // kalendarz.usunSpotkanie(0, 0);
        // // kalendarz.wyswietlTydzien();
        // kalendarz.dodajSpotkanie(0, "ddd", LocalTime.parse("18:00:00"), LocalTime.parse("19:00:00"), "wysoki");
        // kalendarz.wyswietlDzien(0);
        // kalendarz.wyswietlDzienPriorytet(0, "wysoki");
        int wyborMain = 0;
        Kalendarz mojKalendarz = new Kalendarz();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Wybierz opcje:");
            System.out.println("1 - Dodaj spotkanie na dany dzien");
            System.out.println("2 - Usun wybrane spotkanie z wybranego dnia");
            System.out.println("3 - Wyswietl wszystkie spotkania w wybranym dniu");
            System.out.println("4 - Wyswietl wszystkie spotkania w wybranym dniu o wybranym priorytecie");
            System.out.println("5 - Wyjscie z programu");
            wyborMain = scanner.nextInt();
            switch(wyborMain) {
                case 1:
                    dodajSpotkanie(mojKalendarz);
                    break;
                case 2:
                    usunSpotkanie(mojKalendarz);
                    break;
                case 3:
                    wyswietlWszystkieWWybranymDniu(mojKalendarz);
                    break;
                case 4:
                    wyswietlWszystkieDzienPriorytet(mojKalendarz);
                    break;
                case 5:
                    System.out.println("Wyjscie z programu");
                    break;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        } while(wyborMain != 5);
        scanner.close();
        
    }
}
