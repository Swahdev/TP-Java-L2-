import java.util.ArrayList;
import java.util.LinkedList;

public class Mediatheque {
    private final LinkedList<Media> baseDeDonees;

    public Mediatheque() {
        this.baseDeDonees = new LinkedList<>();
    }

    public void ajouter(Media doc) {
        if (baseDeDonees.size() == 0)
            baseDeDonees.add(doc);
        else {
            int i = 0;
            while (i < baseDeDonees.size() && baseDeDonees.get(i).plusPetit(doc)) {
                i++;
            }
            baseDeDonees.add(i, doc);
        }


    }

    public void tousLesDictionnaires() {
        int i = 0;
        while (i < this.baseDeDonees.size()) {
            System.out.println(this.baseDeDonees.get(i).toString());
            i++;
        }
    }

    ArrayList<Media> recherche(Predicat p){
        ArrayList<Media> liste =new ArrayList<>();
        for (Media baseDeDonee : this.baseDeDonees) {
            if (p.estVrai(baseDeDonee)) {
                liste.add(baseDeDonee);
            }
        }
        return liste;
    }


    public static void main(String[] args) {

        Mediatheque m1 = new Mediatheque();
        Dictionnaire dictio = new Dictionnaire("Francais", 4, "Larousse");
        Livre livre1 = new Livre("Baudelaire ", 288, "Les Fleurs du mal");
        Livre livre2 = new Livre("Zola ", 591, "Germinal");
        BandeDessinee tintin = new BandeDessinee("Herge", 120, "Tintin on a marché sur la lune");
        BandeDessinee tintin2 = new BandeDessinee("Herge", 110, "Tintin au tibet");
        DictionnaireBilingue dico1 = new DictionnaireBilingue("Francais", "Anglais", 4, "Haraps");
        Livre livre3=new Livre("Balzac",306,"sEugénie Grandet");
        Livre livre4=new Livre("ha",400,"Balzaccc");
        EstUnLivre l1=new EstUnLivre();
        TitreCommencePar l2=new TitreCommencePar('S');
        Et l3=new Et(l1,l2);
        TitreEstAPeuPres t1=new TitreEstAPeuPres("Balzac",3);
        SousChaineParticuliaire t2=new SousChaineParticuliaire("nal");

        m1.ajouter(tintin2);
        m1.ajouter(dictio);
        m1.ajouter(livre2);
        m1.ajouter(tintin);
        m1.ajouter(livre1);
        m1.ajouter(dico1);

        //m1.tousLesDictionnaires();
        //System.out.println(l3.estVrai(livre3));
        //System.out.println(t1.estVrai(livre4));
        System.out.println(t2.estVrai(livre2));
    }
}
