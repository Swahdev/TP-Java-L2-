public class Cd extends CommandeShell {
    public Cd(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }

    @Override
    public Dossier executer() {
        if (parametre.length == 0) {
            return racine;
        } else if (parametre.length == 1) {
            Entree e = acceder(parametre[0], false);
            if (e!=null) {
                if (e.getElement() instanceof Dossier)
                    return (Dossier) e.getElement();
                else
                    erreurParam();
            }
        }
        return courant;
    }

    public static void aide() {
        System.out.println("cd [<foldername>]");
    }

}
