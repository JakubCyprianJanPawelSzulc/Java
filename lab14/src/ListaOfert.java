import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Nieruchomosc> listaOfert;

    public ListaOfert() {
        listaOfert = new ArrayList<Nieruchomosc>();
    }

    public void dodajNieruchomosc(Dom dom) {
        listaOfert.add(dom);
    }

    public void dodajNieruchomosc(Mieszkanie mieszkanie) {
        listaOfert.add(mieszkanie);
    }

    public ArrayList<Nieruchomosc> getListaOfert(Predicate<Nieruchomosc> warunek) {
        ArrayList<Nieruchomosc> lista = new ArrayList<Nieruchomosc>();
        for (Nieruchomosc nieruchomosc : listaOfert) {
            if (warunek.test(nieruchomosc)) {
                lista.add(nieruchomosc);
            }
        }
        return lista;
    }
}
