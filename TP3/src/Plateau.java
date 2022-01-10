public class Plateau {
    int lon;
    int larg;
    Case[][] p;

    public Plateau(int longueur, int largeur) {
        this.lon = longueur;
        this.larg = largeur;

        p = new Case[longueur][largeur];
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                Case c = new Case((j % 2 != 0 || i % 2 != 0) && (j % 2 != 1 || i % 2 != 1));
                this.p[i][j] = c;
            }
        }
    }


    public boolean horsLimite(int x, int y) {
        return !(x < lon && y < larg && x >= 0 && y >= 0);
    }

    public Case getCase(int x, int y) {
        if (horsLimite(x, y))
            return null;
        else {
            return p[x][y];
        }
    }

    public boolean horsLimite(Deplacement d) {
        return !(d.x1 < lon && d.y1 < larg && d.x1 >= 0 && d.y1 >= 0 && d.x0 < lon && d.y0 < larg && d.x0 >= 0 && d.y0 >= 0);
    }

    public void remplirCase(int x, int y, Piece piece) {
        if (!horsLimite(x, y)) {
            p[x][y].remplirPiece(piece);
        }
    }

    public void afficher() {
        for (int i = 0; i < lon; i++) {
            System.out.println();
            for (int j = 0; j < larg; j++) {
                System.out.print(p[i][j].toString() + " ");
            }
        }
    }

}
