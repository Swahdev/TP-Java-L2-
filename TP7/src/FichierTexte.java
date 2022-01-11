import java.util.Scanner;

public class FichierTexte extends Element implements Affichable, Editable {
    private String contenu;

    public FichierTexte(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String getType() {
        return "Fichier Texte";
    }


    @Override
    public void afficher() {
        System.out.println(contenu);
    }

    @Override
    public void editer(Scanner sc, boolean echo) {
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("."))
                return;
            else {
                if (echo) {
                    contenu += s + "\n";
                    System.out.println(s);
                } else
                    contenu += s;
            }
        }
    }

}
