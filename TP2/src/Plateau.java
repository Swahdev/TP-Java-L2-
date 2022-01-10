import java.util.Random;

public class Plateau {
    int hauteur;
    int largeur;
    int nbMines;
    int nbDrapeaux;
    private boolean[][] mines;
    private int[][] etats;
    private int[][] adja;

    public Plateau(int ha, int la, int mi) {
        this.hauteur = ha;
        this.largeur = la;
        this.nbMines = mi;
        this.nbDrapeaux = 0;
        this.mines = new boolean[ha + 2][la + 2];
        this.etats = new int[ha + 2][la + 2];
        this.adja = new int[ha + 2][la + 2];
        ajouteMinesAlea();
        calculAdjacence();
    }

    private void ajouteMinesAlea() {
        int i = 0;
        Random rd = new Random();
        while (i < nbMines) {
            int x = rd.nextInt(this.largeur) + 1;
            int y = rd.nextInt(this.hauteur) + 1;
            if (!mines[x][y]) {
                i++;
                mines[x][y] = true;
            }
        }

    }

    private void calculAdjacence() {
        int cmp;
        for (int i = 1; i <= this.largeur; i++) {
            for (int y = 1; y <= this.hauteur; y++) {
                cmp = 0;
                if (!mines[i][y]) {
                    if (mines[i + 1][y])
                        cmp++;
                    if (mines[i - 1][y])
                        cmp++;
                    if (mines[i][y + 1])
                        cmp++;
                    if (mines[i][y - 1])
                        cmp++;
                    if (mines[i - 1][y - 1])
                        cmp++;
                    if (mines[i + 1][y + 1])
                        cmp++;
                    if (mines[i + 1][y - 1])
                        cmp++;
                    if (mines[i - 1][y + 1])
                        cmp++;
                    adja[i][y] = cmp;
                }

            }
        }
    }

    public void afficheTout() {
        String chaine = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print("  ");
        for (int h = 1; h <= largeur; h++) {
            System.out.print("  " + h);
        }
        System.out.println();
        System.out.print("---");
        for (int t = 1; t <= largeur; t++) {
            System.out.print("---");
        }
        for (int i = 1; i <= largeur; i++) {
            System.out.println();
            System.out.print(chaine.charAt(i - 1) + "| ");
            for (int j = 1; j <= hauteur; j++) {
                if (mines[i][j])
                    System.out.print(" * ");
                else
                    System.out.print(" " + adja[i][j] + " ");
            }
        }
    }

    public void revelerCase(int x, int y) {
        if (etats[x][y] == 1)
            System.out.println("Vous ne pouvez pas la révéler, il y a un drapeau sur la case");
        else if (etats[x][y] == 2)
            System.out.println("la case est  déja  revelé");
        else {
            etats[x][y] = 2;
            if (adja[x][y] == 0) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (x + i > 0 && y + j > 0 && x + i < x && y + j < y) {
                            if (etats[x + i][y + j] != 2)
                                revelerCase(x + i, y + j);
                        }
                    }
                }
            }
        }
    }

    public void drapeauCase(int x, int y) {
        if (etats[x][y] == 0) {
            etats[x][y] = 1;
            nbDrapeaux++;
            System.out.println("le drapeau a été placé");
        } else if (etats[x][y] == 1) {
            etats[x][y] = 0;
            System.out.println("Le drapeau a été retiré");
            nbDrapeaux--;
        } else
            System.out.println("La case est déja révélée, vous ne pouvez pas poser des drapeux dessus ");
    }

    public void afficheCourant() {
        System.out.println("***************************");
        System.out.println("*   Mines   /   Drapeaux  *");
        System.out.println("*    " + this.nbMines + "      /     " + this.nbDrapeaux + "       *");
        System.out.println("***************************");
        String chaine = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.print("  ");
        for (int h = 1; h <= largeur; h++) {
            System.out.print("  " + h);
        }
        System.out.println();
        System.out.print("---");
        for (int t = 1; t <= largeur; t++) {
            System.out.print("---");
        }
        for (int i = 1; i <= largeur; i++) {
            System.out.println();
            System.out.print(chaine.charAt(i - 1) + "| ");
            for (int j = 1; j <= hauteur; j++) {
                if (etats[i][j] == 0)
                    System.out.print(" . ");
                else if (etats[i][j] == 1)
                    System.out.print(" ? ");
                else if (mines[i][j])
                    System.out.print(" * ");
                else
                    System.out.print(" " + adja[i][j] + " ");
            }
        }
    }

    public boolean jeuPerdu(int x, int y) {
        if (mines[x][y])
            return true;
        return false;
    }

    public boolean jeuGagne() {
        for (int i = 1; i <= largeur; i++) {
            for (int j = 1; j <= hauteur; j++) {
                if (!mines[i][j] && etats[i][j] == 0)
                    return false;

            }
        }
        return true;
    }

}
