import java.util.Arrays;

public class Dictionnaire implements Triable {

    String[] tab;

    public Dictionnaire(String[] tab) {
        this.tab = tab;
    }


    @Override
    public void echange(int i, int j) {
        String t = tab[j];
        tab[j] = tab[i];
        tab[i] = t;
    }

    @Override
    public boolean plusGrand(int i, int j) {
        return tab[j].compareTo(tab[i]) < 0;
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public String toString() {
        return "Dictionnaire{" +
                "tab=" + Arrays.toString(tab) +
                '}';
    }
}
