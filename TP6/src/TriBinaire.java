import java.util.Arrays;

public class TriBinaire implements Triable {
    String[] tab;

    public TriBinaire(String[] tab) {
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
        int a = Integer.parseInt(tab[i], 2);
        int b = Integer.parseInt(tab[j], 2);
        return b < a;
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public String toString() {
        return "TriBinaire{" +
                "tab=" + Arrays.toString(tab) +
                '}';
    }
}
