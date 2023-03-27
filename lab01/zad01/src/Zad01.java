package lab01.zad01.src;

import java.util.Scanner;
public class Zad01 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Program oblicza silnie z podanej liczby."); 
        int n;
        Scanner menu = new Scanner(System.in);
        int m=1;
        while (m==1) {
            System.out.println("Wybierz:    0-wyjscie   1-licz silnie dla n   2-licz 2 do potegi n");
            m=menu.nextInt();
            switch(m){
                case (0):
                    break;
                case (1):
                    System.out.println("Podaj liczbe naturalna: ");
                    n = reader.nextInt();
                    if(n>=0){
                        long silnia = obliczSilnie(n);
                        System.out.println("Silnia dla liczby " + n + " to: " + silnia);
                    }
                case (2):
                    System.out.println("Podaj liczbe naturalna: ");
                    n = reader.nextInt();
                    if(n>=0){
                        long wynik = dwaDoN(n);
                        System.out.println("2 do potegi " + n + " to: " + wynik);
                    }
            }
        }
        reader.close();
        menu.close();
    }

    public static long obliczSilnie(int x) {
        long wynik = 1;
        for (int i = 1; i <= x; i++) {
            wynik = wynik * i;   
        }
        return wynik;    
    }

    public static long dwaDoN(int x){
        long wynik = 1;
        for (int i = 1; i<=x; i++){
            wynik = wynik*2;
        }
        return wynik;
    }
}