public class Mkdir extends CommandeShell {

    public Mkdir(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }

    @Override
    public Dossier executer() {
        String nom = parametre[0];
        Dossier d = new Dossier(null);
        Entree e = new Entree(courant, nom, d);
        return d;
    }

    public static void aide() {
        System.out.println("mkdir <foldername>");
    }

}
