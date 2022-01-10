import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class FormateurJoli {

    private int max = 0;
    private LinkedList<Paragraphe> texte;
    private Scanner sc;

    public FormateurJoli(String filename) {
        this.max = 0;
        sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ouverture du Fichier");
            e.printStackTrace();
            System.exit(1);
        }
        texte = new LinkedList<Paragraphe>();
    }

    public void setMax(int max) {
        this.max = max;
    }
}
