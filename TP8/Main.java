import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnableToDeleteFileException {
        Stringtransformation addBlah = (String s) -> (s + ".blah");
        String test = "Test";
        //System.out.println(addBlah.transf(test));

        Arbre h = new Arbre("/Users/charleschikhani/IdeaProjects/TP8/src/racine");
        //h.map(addBlah);
        //h.traverser(".txt");
        h.supprimer(".txt");
        h.afficher();
    }
}
