public class Ellipse extends Figure implements Deformable {

    private final double grand_Rayon;
    private final double petit_Rayon;

    public Ellipse(double grand_Rayon, double petit_Rayon, int posX, int posY) {
        super(posX, posY);
        this.grand_Rayon = grand_Rayon;
        this.petit_Rayon = petit_Rayon;
    }

    @Override
    public void affiche() {
        System.out.println("L'ellipse a pour coordonnées du centre  x " + getPosX() + " et y " + getPosY() + " et a pour grand rayon " + getGrand_Rayon() + " et pour petit rayon " + getPetit_Rayon() + ".");

    }


    public double getGrand_Rayon() {
        return grand_Rayon;
    }

    public double getPetit_Rayon() {
        return petit_Rayon;
    }

    @Override
    public Ellipse deformation(double coeffH, double coeffV) {
        if (coeffH * grand_Rayon != coeffV * petit_Rayon)
            return new Ellipse(coeffH * grand_Rayon, coeffV * petit_Rayon, getPosX(), getPosY());
        else
            return new Circle(getGrand_Rayon() * coeffH, getPosX(), getPosY());
    }

    @Override
    public double surface() {
        return Math.PI*grand_Rayon*petit_Rayon;
    }
}
