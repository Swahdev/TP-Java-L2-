public class Lanceur {
    public static void main(String[] args) {
        System.out.println("Le jeu du Dénicheur !");
        Joueur joueur1 = new Joueur();
        if (joueur1.veutJouer()) {
            joueur1.demanderNom();
            int[] dim = joueur1.demanderDimension();
            int nbrMines = joueur1.demanderNbMines();
            int minMax = (dim[0] * dim[1]) - 1;
            if (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                while (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                    System.out.println("Il vous faut au moins une mine pour commencer le jeu et au maximum " + minMax + " mines.");
                    nbrMines = joueur1.demanderNbMines();
                }
            }
            Plateau p = new Plateau(dim[0], dim[1], nbrMines);
            p.afficheCourant();
            System.out.println();
            Jeu j = new Jeu(joueur1, p);
            j.jouer();
        }

    }
}
