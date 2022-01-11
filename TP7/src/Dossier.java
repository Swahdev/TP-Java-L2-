import java.util.LinkedList;

public class Dossier extends Element implements Affichable {
    private LinkedList<Entree> contenu;
    private Dossier parent;

    public Dossier(Dossier parent) {
        this.parent = parent;
        this.contenu = new LinkedList<Entree>();
        contenu.add(new EntreeSpeciale(this, ".", this));
        if (parent != null)
            contenu.add(new EntreeSpeciale(this, "..", this));
    }

    public Dossier getParent() {
        return parent;
    }

    public void setParent(Dossier parent) {
        this.parent = parent;
    }

    public void setContenu(LinkedList<Entree> contenu) {
        this.contenu = contenu;
    }

    public LinkedList<Entree> getContenu() {
        return contenu;
    }

    public Entree getEntree(String nom, boolean creer) {
        if (!creer) {
            for (Entree entree : this.contenu) {
                if (entree.getNom().equals(nom)) {
                    return entree;
                }
            }
        } else {
            Entree e = new Entree(null, nom, this);
            this.contenu.addLast(e);
            return e;
        }
        return null;
    }

    @Override
    public void afficher() {
        for (Entree entree : this.contenu) {
            System.out.println(entree.toString());
        }
    }

    @Override
    public String getType() {
        return "Dossier";
    }

    public boolean estEnfant(Dossier d) {
        Dossier tmp = this.parent;
        while (tmp != null) {
            if (tmp.equals(d))
                tmp = tmp.parent;
        }
        return false;
    }

}
