import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Program oblicza parametry walca");
        Walec walec = new Walec();
        int wybor = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Wybierz opcje:");
            System.out.println("1 - wyswietlenie wartosci zmiennych instancji obiektu klasy Walec");
            System.out.println("2 - zmiana wartosci zmiennych instancji obiektu klasy Walec");
            System.out.println("3 - wyliczenie i wyświetlenie na konsoli pol powierzchni oraz objetosci obiektu klasy Walec");
            System.out.println("4 - wyjscie z programu");
            wybor = scanner.nextInt();
            switch(wybor) {
                case 1:
                    System.out.println("Promien walca: " + walec.getPromien());
                    System.out.println("Wysokosc walca: " + walec.getWysokosc());
                    break;
                case 2:
                    System.out.println("Podaj nowy promien walca: ");
                    walec.setPromien(scanner.nextDouble());
                    System.out.println("Podaj nowa wysokosc walca: ");
                    walec.setWysokosc(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Pole podstawy: " + walec.polePodstawy() + " Pole boczne: " + walec.poleBoczne());
                    System.out.println("Pole powierzchni calkowitej: " + walec.polePowierzchniCalkowitej() + " Objetosc: " + walec.objetosc());
                    break;
                case 4:
                    System.out.println("Wyjscie z programu");
                    break;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        } while(wybor != 4);
        scanner.close();
    }
}
