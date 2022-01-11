public class Palette {
    private final Vue view;
    private final Modele mod;
    private final Controleur controle;

    public Palette() {
        this.mod = new Modele(0, 128, 0);
        view = new Vue(mod);
        view.setVisible(true);
        controle = new Controleur(mod, view);
        view.control = controle;

    }

    public static void main(String[] args) {
        new Palette();
    }
}
