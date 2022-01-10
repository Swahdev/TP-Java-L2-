public class Circle extends Ellipse implements Deformable {
    public Circle(double rayon, int posX, int posY) {
        super(rayon, rayon, posX, posY);
    }

    @Override
    public void affiche() {
        System.out.println("Le cercle a pour coordonnées du centre  x " + getPosX() + " et y " + getPosY() + " et a pour rayon " + getGrand_Rayon() + ".");
    }

    @Override
    public Ellipse deformation(double coeffH, double coeffV) {
        return super.deformation(coeffH, coeffV);
    }

    @Override
    public double surface() {
        return Math.PI * Math.pow(getGrand_Rayon(),2) ;
    }
}
