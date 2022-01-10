public class Rectangle extends Figure implements Deformable {
    private final double largeur;
    private final double hauteur;

    public Rectangle(double largeur, double hauteur, int posX, int posY) {
        super(posX, posY);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public void affiche() {
        System.out.println("Le rectangle a pour coordonnées du centre  x " + getPosX() + " et y " + getPosY() + " et a pour hauteur " + getHauteur() + " et pour largeur " + getLargeur() + ".");
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    @Override
    public Rectangle deformation(double coeffH, double coeffV) {
        if (largeur * coeffH != hauteur * coeffV)
            return new Rectangle(largeur * coeffH, hauteur * coeffV, getPosX(), getPosY());
        else
            return new Carre(getHauteur() * coeffH, getPosX(), getPosY());
    }

    @Override
    public double surface() {
        return hauteur*largeur;
    }
}
