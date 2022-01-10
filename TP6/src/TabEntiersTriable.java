import java.util.Arrays;

public class TabEntiersTriable implements Triable {
    private final int[] tab;

    public TabEntiersTriable(int[] tab) {
        this.tab = tab;
    }


    @Override
    public void echange(int i, int j) {
        int t = tab[j];
        tab[j] = tab[i];
        tab[i] = t;
    }

    @Override
    public boolean plusGrand(int i, int j) {
        return tab[i] > tab[j];
    }

    @Override
    public int taille() {
        return tab.length;
    }

    @Override
    public String toString() {
        return "TabEntiersTriable{" +
                "tab=" + Arrays.toString(tab) +
                '}';
    }
}
