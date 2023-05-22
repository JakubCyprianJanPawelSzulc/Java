import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        ListaOfert mojaListaOfert = new ListaOfert();
        System.out.println("Program do zarzadzania ofertami nieruchomosci");
        int wybor = 0;
        do{
            System.out.println("Co chcesz zrobic?\n1-Dodaj\n2-Wyswietl wszystkie aktualne oferty sprzedazy domów/mieszkan\n3-Wyswietl wszystkie aktualne oferty sprzedazy domow w podanej miejscowosci, o powierzchni nie mniejszej niz podana wartosc\n4-Wyswietl wszystkie aktualne oferty mieszkan w podanej miejscowosci nie drozsze niz podana wartosc i od podanego pietra wzwyz\n5-Wyjdz");
            wybor = inputInt.nextInt();
            switch(wybor){
                case 1 -> addProperty(mojaListaOfert, inputInt, inputString);
                case 2 -> showCurrentOffers(mojaListaOfert, inputInt);
                case 3 -> showCurrentOffersHousesCityArea(mojaListaOfert, inputInt, inputString);
                case 4 -> showCurrentOffersFlatsCityPriceFloor(mojaListaOfert, inputInt, inputString);
            }
        }while (wybor!=5);
    }

    public static void addProperty(ListaOfert mojaListaOfert, Scanner inputInt, Scanner inputString){
        System.out.println("Co chcesz dodac?\n1-Dom\n2-Mieszkanie");
        int wybor = inputInt.nextInt();
        System.out.println("Podaj ulice");
        String ulica = inputString.nextLine();
        System.out.println("Podaj numer domu");
        int nrDomu = inputInt.nextInt();
        System.out.println("Podaj miejscowosc");
        String miasto = inputString.nextLine();
        System.out.println("Podaj kod pocztowy");
        String kodPocztowy = inputString.nextLine();
        System.out.println("Podaj powierzchnie");
        double powierzchnia = inputInt.nextDouble();
        System.out.println("Podaj cene");
        double cena = inputInt.nextDouble();
        System.out.println("Podaj date oferty");
        String dataOferty = inputString.nextLine();
        LocalDate dataOfertyLocalDate = LocalDate.parse(dataOferty);
        switch(wybor){
            case 1:
                System.out.println("Podaj powierzchnie dzialki");
                int powierzchniaDzialki = inputInt.nextInt();
                Dom dom = new Dom(ulica, nrDomu, miasto, kodPocztowy, powierzchnia, cena, dataOfertyLocalDate, powierzchniaDzialki);
                mojaListaOfert.dodajNieruchomosc(dom);
                break;
            case 2:
                System.out.println("Podaj pietro");
                int pietro = inputInt.nextInt();
                System.out.println("Podaj numer mieszkania");
                int numerMieszkania = inputInt.nextInt();
                Mieszkanie mieszkanie = new Mieszkanie(ulica, nrDomu, miasto, kodPocztowy, powierzchnia, cena, dataOfertyLocalDate, pietro, numerMieszkania);
                mojaListaOfert.dodajNieruchomosc(mieszkanie);
                break;
        }
    }

    public static void showCurrentOffers(ListaOfert mojaListaOfert, Scanner inputInt){
        System.out.println("Co chcesz wyswietlic?\n1-domy\n2-mieszkania");
        int wybor = inputInt.nextInt();
        switch(wybor){
            case 1:
                printElems(mojaListaOfert.getListaOfert(nieruchomosc -> nieruchomosc instanceof Dom && (nieruchomosc.getDataOferty().isAfter(LocalDate.now()) || nieruchomosc.getDataOferty().isEqual(LocalDate.now()))));
                break;
            case 2:
                printElems(mojaListaOfert.getListaOfert(nieruchomosc -> nieruchomosc instanceof Mieszkanie && (nieruchomosc.getDataOferty().isAfter(LocalDate.now()) || nieruchomosc.getDataOferty().isEqual(LocalDate.now()))));
                break;
        }
    }

    public static void showCurrentOffersHousesCityArea(ListaOfert mojaListaOfert, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj miejscowosc");
        String miasto = inputString.nextLine();
        System.out.println("Podaj minimalna powierzchnie");
        double powierzchnia = inputInt.nextDouble();
        printElems(mojaListaOfert.getListaOfert(nieruchomosc -> nieruchomosc instanceof Dom && nieruchomosc.getMiasto().equals(miasto) && nieruchomosc.getPowierzchnia()>=powierzchnia && (nieruchomosc.getDataOferty().isAfter(LocalDate.now()) || nieruchomosc.getDataOferty().isEqual(LocalDate.now()))));
    }

    public static void showCurrentOffersFlatsCityPriceFloor(ListaOfert mojaListaOfert, Scanner inputInt, Scanner inputString){
        System.out.println("Podaj miejscowosc");
        String miasto = inputString.nextLine();
        System.out.println("Podaj maksymalna cene");
        double cena = inputInt.nextDouble();
        System.out.println("Podaj pietro");
        int pietro = inputInt.nextInt();
        printElems(mojaListaOfert.getListaOfert(nieruchomosc -> nieruchomosc instanceof Mieszkanie && nieruchomosc.getMiasto().equals(miasto) && nieruchomosc.getCena()<=cena && ((Mieszkanie) nieruchomosc).getPietro()>=pietro && (nieruchomosc.getDataOferty().isAfter(LocalDate.now()) || nieruchomosc.getDataOferty().isEqual(LocalDate.now()))));
    }

    public static void printElems(ArrayList<Nieruchomosc> elems){
        for (Nieruchomosc elem : elems) {
            System.out.println(elem.toString());
        }
    }
}
