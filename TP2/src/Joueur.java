import java.util.Scanner;

public class Joueur {
    String nom;
    Scanner scanReponse;

    public Joueur() {
        this.nom = "Anonyme";
        this.scanReponse = new Scanner(System.in);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void finish() {
        scanReponse.close();
    }

    private String demanderStr(String q) {
        System.out.println(q);
        String rep = scanReponse.nextLine();
        return rep;
    }

    private int demanderInt(String q) {
        System.out.println(q);
        int i = scanReponse.nextInt();
        return i;
    }

    public boolean veutJouer() {
        System.out.println("Voulez vous jouer ? (oui/non)");
        String rep = scanReponse.nextLine();
        return rep.equals("oui");
    }

    public String demanderNom() {
        String nvnom = demanderStr("Quel est votre nom ?");
        return this.nom = nvnom;
    }

    public int[] demanderDimension() {
        System.out.println("Quelle est la taille de votre terrain ? (mettre (4) pour avoir un carré de 4x4 cases par exemple ) ");
        int i = scanReponse.nextInt();
        int[] dim = {i, i};
        return dim;
    }

    public int demanderNbMines() {
        return (demanderInt("Combien de mines voulez vous placer ?"));
    }

    public char demanderAction() {
        String c = scanReponse.nextLine();
        if (c.equals("r") || c.equals("R"))
            return 'r';
        if (c.equals("d") || c.equals("D"))
            return 'd';
        return 0;
    }

    public int[] demanderCoordonnes() {
        String cor = demanderStr("Donner vos coordonnées sous la forme (A3),(D5), par exemple :");
        int[] tab = new int[2];
        tab[1] = Character.getNumericValue(cor.charAt(1));
        char c = cor.charAt(0);
        tab[0] = (int) c % 32;
        return tab;
    }
}
