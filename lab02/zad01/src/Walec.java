package lab02.zad01.src;


public class Walec {

    private double promien;
    private double wysokosc;

    public Walec(double promien, double wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public Walec() {
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getPromien() {
        return promien;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double polePodstawy() {
        return Math.PI * Math.pow(promien, 2);
    }

    public double poleBoczne() {
        return 2 * Math.PI * promien * wysokosc;
    }

    public double polePowierzchniCalkowitej() {
        return 2 * polePodstawy() + poleBoczne();
    }

    public double objetosc(){
        return polePodstawy() * wysokosc;
    }
     
}
