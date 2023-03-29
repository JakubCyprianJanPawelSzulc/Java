package lab02.zad01.src;

public class Main {
    public static void main(String[] args) {
        Walec walec = new Walec(2, 3);
        System.out.println("Pole podstawy: " + walec.polePodstawy());
        System.out.println("Pole boczne: " + walec.poleBoczne());
        System.out.println("Pole powierzchni calkowitej: " + walec.polePowierzchniCalkowitej());
        System.out.println("Objetosc: " + walec.objetosc());
    }
}