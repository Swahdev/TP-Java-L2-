public abstract class Figure {
    // coordonnées du centre approximatif de la figure
    private int posX;
    private int posY;

    public Figure(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public abstract void affiche();

    public double estDistantDe(Figure fig) {
        return Math.sqrt(Math.pow(Math.abs(this.posX - fig.posX), 2) + Math.pow(Math.abs(this.posY - fig.posY), 2));
    }

    public abstract  double surface();

    public void déplacement(int x, int y){
        this.posX += x;
        this.posY += y;
    }
}
