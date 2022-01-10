public class Triangle extends Figure implements Deformable {
    private final double base;
    private final double hauteur;

    public Triangle(double base, double hauteur, int posX, int posY) {
        super(posX, posY);
        this.base = base;
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getBase() {
        return base;
    }

    @Override
    public void affiche() {
        System.out.println("Le triange a pour coordonnées du centre  x " + getPosX() + " et y " + getPosY() + " et a pour hauteur " + getHauteur() + " et pour base " + getBase() + ".");
    }

    @Override
    public double surface() {
        return base * hauteur / 2;
    }

    @Override
    public Triangle deformation(double coeffH, double coeffV) {
        return new Triangle(coeffH * base, coeffV * hauteur, getPosX(), getPosY());
    }

}
