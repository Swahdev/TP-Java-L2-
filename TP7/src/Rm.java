public class Rm extends CommandeShell {
    public Rm(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }

    @Override
    public Dossier executer() {
        Entree e = acceder(parametre[0], false);
        if (e!=null && parametre.length==1){
            if (e.getElement() instanceof Dossier && e.getElement() instanceof FichierTexte){
                e.supprimer();
            }
        }else{
            erreurParam();
        }

        return courant;
    }

    public static void aide() {
        System.out.println("rm <name>");
    }
}
