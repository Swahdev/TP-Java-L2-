import java.awt.*;

public class Modele {
    private final Color[] colors;

    public Modele(int x) {
        colors = new Color[x];
    }

    public void add(int i, Color color) {
        colors[i] = color;
    }

    public Color[] getColors() {
        return colors;
    }

    public boolean gagne() {
        Color c = colors[0];
        for (int i = 1; i < colors.length; i++) {
            if (!colors[i].equals(c))
                return false;
        }
        return true;
    }
}
