import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Formateur {
    private LinkedList<Paragraphe> texte;
    private Scanner sc;

    public Formateur(String filename) {
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
    private Paragraphe readParagraphe(){
        Paragraphe p=new Paragraphe();
        String s=sc.next();
        Scanner s1=new Scanner(s);
        s1.useDelimiter("\\s+");
        while (s1.hasNext()){

            p.addChaine(new Ligne());
        }
        p.remove();
        return p;
    }

    public void read(){
        sc.useDelimiter("\\n\\\\s*\\n");
        while (sc.hasNext()){
            Paragraphe p=readParagraphe();
            texte.add(p);
        }
    }
    public void print() {
        for (Paragraphe p : texte) {
            System.out.println(p);
            System.out.println();
        }
    }
}
