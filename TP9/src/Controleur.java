import java.awt.*;

public class Controleur {
    private final Modele mod;
    private final Vue v;

    public Controleur(Modele modele, Vue vue) {
        mod = modele;
        v = vue;
    }

    public void sliderMoved() {
        int r = ((v.getSlider().getValue()) * 255) / 100;
        int g = ((v.getSlider2().getValue()) * 255) / 100;
        int b = ((v.getSlider3().getValue()) * 255) / 100;
        mod.setRouge(r);
        mod.setBleu(b);
        mod.setVert(g);
        v.miseAjour();
    }

    public void memoriser() {
        mod.memorisercolor(((v.getSlider().getValue()) * 255) / 100, ((v.getSlider2().getValue()) * 255) / 100, ((v.getSlider3().getValue()) * 255) / 100);
    }

    public void rappel() {

        v.getSlider().setValue((mod.getRouge1() * 100) / 255);
        v.getSlider2().setValue((mod.getVert1() * 100) / 255);
        v.getSlider3().setValue((mod.getBleu1() * 100) / 255);
        v.miseAjour();

    }

    public void complementaire() {

        v.getSlider().setValue(100 - v.getSlider().getValue());
        v.getSlider2().setValue(100 - v.getSlider2().getValue());
        v.getSlider3().setValue(100 - v.getSlider3().getValue());

    }

}
