public class Carre extends Rectangle implements Deformable {
    public Carre(double cote, int posX, int posY) {
        super(cote, cote, posX, posY);
    }

    @Override
    public void affiche() {
        System.out.println("Le carré a pour coordonnées du centre  x " + getPosX() + " et y " + getPosY() + " et a pour côté " + getHauteur() + ".");
    }

    @Override
    public Rectangle deformation(double coeffH, double coeffV) {
        return super.deformation(coeffH, coeffV);
    }

    @Override
    public double surface() {
        return getHauteur()*getHauteur();
    }
}
