import java.util.LinkedList;

public class Entree {

    private Element element;
    private String nom;
    private Dossier parent;

    public Entree(Dossier p, String n, Element e) {
        this.element = e;
        this.nom = n;
        this.parent = p;
    }

    public String getNom() {
        return nom;
    }

    public Element getElement() {
        return element;
    }


    @Override
    public String toString() {
        if (element == null) return nom + "(entrée vide)";
        return nom + "(" + element.getType() + ")";
    }

    public void supprimer() {
        parent.getContenu().remove(this);
    }

    public void remplacer(Element e) {

        if (e instanceof Dossier) {
            Dossier d = (Dossier) e;
            d.setParent(this.parent);
            e = d;
        } else if (e != null) {
            this.element = e;
        }

    }
}
