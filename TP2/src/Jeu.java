import java.util.Scanner;

public class Jeu {
    Joueur j;
    Plateau p;
    private final Scanner scanReponse;

    public Jeu(Joueur joueur, Plateau plateau) {
        this.j = joueur;
        this.p = plateau;
        this.scanReponse = new Scanner(System.in);
    }

    public void jouer() {
        char c;
        c = j.demanderAction();
        while (!p.jeuGagne()) {
            System.out.println();
            System.out.println(j.nom + " voulez-vous révéler une case (r) ou placer un drapeau (d) ?");
            c = j.demanderAction();
            if (c == 'r') {
                int[] coordonnes = j.demanderCoordonnes();
                if (p.jeuPerdu(coordonnes[0], coordonnes[1])) {
                    System.out.println("Vous avez perdu !");
                    break;
                } else {
                    p.revelerCase(coordonnes[0], coordonnes[1]);
                }
            } else if (c == 'd') {
                int[] coordonnes = j.demanderCoordonnes();
                p.drapeauCase(coordonnes[0], coordonnes[1]);
                System.out.println();
            } else {
                System.out.println("Erreur");
                continue;
            }
            p.afficheCourant();
        }
        if (p.jeuGagne()) {
            System.out.println();
            System.out.println();
            System.out.println("Bravo pour la victoire " + j.nom + " ! ");
            p.afficheTout();
            System.out.println();
            System.out.println("Voulez vous rejouer ? (oui/non)");
            String rep = scanReponse.nextLine();
            if (rep.equals("oui")) {
                int[] dim = j.demanderDimension();
                int nbrMines = j.demanderNbMines();
                int minMax = dim[0] * dim[1] - 1;
                if (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                    while (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                        System.out.println("Il vous faut au moins une mine pour commencer le jeu et au maximum " + minMax + " mines.");
                        nbrMines = j.demanderNbMines();
                    }
                }
                Plateau ne = new Plateau(dim[0], dim[1], nbrMines);
                this.p = ne;
                p.afficheCourant();
                System.out.println();
                jouer();
            }

        } else {
            System.out.println();
            p.afficheTout();
            System.out.println();
            System.out.println("Vous avez malheuresement perdu " + j.nom + " !");
            p.afficheTout();
            System.out.println();
            System.out.println("Voulez vous retenter votre chance ? (oui/non)");
            String rep = scanReponse.nextLine();
            if (rep.equals("oui")) {
                int[] dim = j.demanderDimension();
                int nbrMines = j.demanderNbMines();
                int minMax = dim[0] * dim[1] - 1;
                if (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                    while (nbrMines <= 0 || nbrMines >= dim[0] * dim[1]) {
                        System.out.println("Il vous faut au moins une mine pour commencer le jeu et au maximum " + minMax + " mines.");
                        nbrMines = j.demanderNbMines();
                    }
                }
                Plateau ne = new Plateau(dim[0], dim[1], nbrMines);
                this.p = ne;
                p.afficheCourant();
                System.out.println();
                jouer();
            }
        }
    }

}
