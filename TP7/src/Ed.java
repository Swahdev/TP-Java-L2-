import java.util.Scanner;

public class Ed extends CommandeShell implements Editable {

    private Scanner sc;
    private boolean echo;

    public Ed(Dossier racine, Dossier courant, String[] parametre, Scanner sc, boolean echo) {
        super(racine, courant, parametre);
        editer(sc, echo);
    }

    @Override
    public Dossier executer() {
        Entree e = acceder(parametre[0],false);
        if(e != null)
            if(e.getElement() instanceof FichierTexte)
            {
                ((FichierTexte)e.getElement()).editer(sc, echo);
            }
        if(parametre.length != 1)
            erreurParam();
        return courant;
    }

    @Override
    public void editer(Scanner sc, boolean echo) {
        String s = sc.next();
        Entree e = acceder(s, echo);
        if (e.getElement() instanceof FichierTexte) {
            ((FichierTexte) e.getElement()).editer(sc, echo);
        }
    }

    public static void aide() {
        System.out.println("ed <filename>");
    }

}
