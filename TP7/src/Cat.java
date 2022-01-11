public class Cat extends CommandeShell implements Affichable{
    public Cat(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }

    @Override
    public void afficher() {
        if (acceder(parametre[0], false).getElement() instanceof FichierTexte) {
            ((FichierTexte) acceder(parametre[0], false).getElement()).afficher();
        } else if (acceder(parametre[0], false).getElement() instanceof Dossier)
            ((Dossier) acceder(parametre[0], false).getElement()).afficher();
    }



    @Override
    public Dossier executer() {
        Entree e = acceder(parametre[0], false);
        if (parametre.length != 1) {
            System.out.println("Erreur");
            return courant;
        } else if (e != null && e.getElement() instanceof Affichable) {
            afficher();
        } else
            erreurParam();
        return courant;
    }

    public static void aide() {
        System.out.println("cat <name>");
    }

}
