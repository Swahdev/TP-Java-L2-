public class Ls extends CommandeShell {

    public Ls(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }

    @Override
    public Dossier executer() {
        if (parametre.length == 0) {
            courant.getContenu();
        } else if (acceder(parametre[0], false).getElement() instanceof Dossier) {
            Entree e = acceder(parametre[0], false);
            for (Entree entree : ((Dossier) e.getElement()).getContenu()) {
                System.out.println(entree.toString());
            }
        } else if (acceder(parametre[0], false).getElement() instanceof FichierTexte) {
            Entree e = acceder(parametre[0], false);
            System.out.println(e.getNom());
        }

        return null;
    }

    public static void aide() {
        System.out.println("ls [<name>]");
    }

}
