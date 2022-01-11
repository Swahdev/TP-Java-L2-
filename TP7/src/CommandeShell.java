import java.util.Scanner;

public abstract class CommandeShell {
    protected Dossier racine;
    protected Dossier courant;
    protected String[] parametre;

    public CommandeShell(Dossier racine, Dossier courant, String[] parametre) {
        this.courant = courant;
        this.racine = racine;
        this.parametre = parametre;
    }

    public abstract Dossier executer();

    public static void aide() {
        return;
    }

    protected static void erreurParam() {
        System.out.println("Pas un bon nombre de paramètres.");
        aide();
    }

    protected Entree acceder(String chemin, boolean creer) {
        Scanner sc = new Scanner(chemin);
        sc.useDelimiter("/");
        Entree nouvelleEntree = null;

        if (chemin.charAt(0) == '/') {
            Dossier tmp = racine;

            while (sc.hasNext()) {

                nouvelleEntree = tmp.getEntree(sc.next(), false);
                if (nouvelleEntree.getElement() instanceof Dossier)
                    tmp = (Dossier) nouvelleEntree.getElement();
                else {
                    System.out.println("Erreur");
                    return null;
                }
            }
            if (creer) {
                Entree entreeRetour = tmp.getEntree(nouvelleEntree.getNom(), true);
                return entreeRetour;
            } else
                return tmp.getEntree(nouvelleEntree.getNom(), creer);


        } else {
            Dossier tmp = courant;
            while (sc.hasNext()) {

                nouvelleEntree = tmp.getEntree(sc.next(), false);
                if (nouvelleEntree != null && nouvelleEntree.getElement() instanceof Dossier)
                    tmp = (Dossier) nouvelleEntree.getElement();
                else {
                    System.out.println("Erreur. Le dossier n'existe pas.");
                    return null;
                }
            }
            if (creer) {
                Entree entreeRetour = tmp.getEntree(nouvelleEntree.getNom(), true);
                return entreeRetour;
            } else {
                return tmp.getEntree(nouvelleEntree.getNom(), creer);

            }

        }

    }
}
