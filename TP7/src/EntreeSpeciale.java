public class EntreeSpeciale extends Entree {
    public EntreeSpeciale(Dossier p, String n, Element e) {
        super(p, n, e);
    }

    public void remplacer() {
        System.out.println("Erreur on ne peut pas remplacer une entrée spéciale");
    }

    public void supprimer() {
        System.out.println("On ne peut pas supprimer une entrée speciale");
    }

}
