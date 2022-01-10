public class Echec {
    boolean joueur;

    public Echec() {
        joueur = true;
    }

    public static void jouerTour(Deplacement d, boolean joueur, Plateau p) {
        if (!p.horsLimite(d) && !p.getCase(d.x0, d.y0).estVide() && p.getCase(d.x0, d.y0).getPiece().color == joueur && p.getCase(d.x0, d.y0).getPiece().estValide(d,p)) {
            Piece tmp=p.getCase(d.x0, d.y0).getPiece();
            p.getCase(d.x0, d.y0).enleverPiece();
            p.getCase(d.x1, d.y1).enleverPiece();
            p.getCase(d.x1, d.y1).remplirPiece(tmp);
            joueur=!joueur;

        }

    }

    public static void main(String[] args) {
        Plateau plateau1 = new Plateau(4, 4);
        Tour t1 = new Tour(false);
        Tour t2 = new Tour(false);
        Tour t3 = new Tour(true);
        Tour t4 = new Tour(true);
        Dame dame1 = new Dame(false);
        Dame dame2 = new Dame(true);
        Roi roi1 = new Roi(false);
        Roi roi2 = new Roi(true);
        Pion pion1 = new Pion(false);
        Pion pion2 = new Pion(false);
        Pion pion3 = new Pion(false);
        Pion pion4 = new Pion(false);
        Pion pion5 = new Pion(true);
        Pion pion6 = new Pion(true);
        Pion pion7 = new Pion(true);
        Pion pion8 = new Pion(true);
        plateau1.remplirCase(0, 0, t1);
        plateau1.remplirCase(0, 1, dame1);
        plateau1.remplirCase(0, 2, roi1);
        plateau1.remplirCase(0, 3, t2);
        plateau1.remplirCase(1, 0, pion1);
        plateau1.remplirCase(1, 1, pion2);
        plateau1.remplirCase(1, 2, pion3);
        plateau1.remplirCase(1, 3, pion4);
        plateau1.remplirCase(2, 0, pion5);
        plateau1.remplirCase(2, 1, pion6);
        plateau1.remplirCase(2, 2, pion7);
        plateau1.remplirCase(2, 3, pion8);
        plateau1.remplirCase(3, 0, t3);
        plateau1.remplirCase(3, 1, dame2);
        plateau1.remplirCase(3, 2, roi2);
        plateau1.remplirCase(3, 3, t4);
        plateau1.afficher();
        Deplacement d1=new Deplacement(2,0,1,1);
        jouerTour(d1,true,plateau1);
        System.out.println();
        plateau1.afficher();
    }
}
