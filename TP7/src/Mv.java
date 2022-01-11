

public class Mv extends CommandeShell {
    public Mv(Dossier racine, Dossier courant, String[] parametre) {
        super(racine, courant, parametre);
    }


    @Override
    public Dossier executer() {
        Entree src = acceder(parametre[0], false);
        Entree dst = acceder(parametre[1], false);
        if (src != null && dst != null)
            if (src.getElement() instanceof Dossier)
                if (dst.getElement() instanceof Dossier) {
                    Dossier s = (Dossier) src.getElement();
                    Dossier d = (Dossier) dst.getElement();
                    if (d.estEnfant(s))
                        System.out.println("Pas possible de déplacer un dossier dans lui-même.");
                    else
                        d.getEntree(src.getNom(), true).remplacer(src.getElement());
                    src.supprimer();
                }
        return courant;
    }

    public static void aide() {
        System.out.println("mv <src> <dst>");
    }

}
