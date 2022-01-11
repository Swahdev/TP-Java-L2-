import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arbre {
    private Noeud racine;

    public Arbre(String chemin) throws FileNotFoundException {
        racine = new Noeud(new File(chemin));
    }

    public class Noeud {
        private String nom;
        private int taille;
        private boolean repertoire;
        private ArrayList<Noeud> fils;

        public Noeud(File fichier) throws FileNotFoundException {
            if (fichier.exists()) {
                this.nom = fichier.getName();
                this.taille = (int) fichier.length();
                if (fichier.isDirectory()) {
                    this.repertoire = true;
                    File[] f = fichier.listFiles();
                    if (f.length != 0) {
                        this.fils = new ArrayList<Noeud>();
                        for (int i = 0; i < f.length; i++) {
                            fils.add(new Noeud(f[i]));
                        }
                    }
                }
            } else {
                throw new FileNotFoundException();
            }
        }

        public void afficher(int decalage) {
            System.out.print(" ".repeat(decalage));
            System.out.println(this.nom + "  [" + taille + "]");
            if (this.fils != null) {
                for (int i = fils.size() - 1; i >= 0; i--) {
                    fils.get(i).afficher(decalage + 2);
                }
            }
        }

        public void map(Stringtransformation t) {
            if (!this.repertoire) {
                this.nom = t.transf(nom);
            } else {
                fils.forEach((e) -> {
                    e.map(t);
                });
            }
        }

        public void traverser(String extension) {
            if (this.nom.endsWith(extension)) {
                System.out.println(this.nom + "  [" + taille + "]");
            }
            if (fils != null) {
                for (int i = fils.size() - 1; i >= 0; i--) {
                    fils.get(i).traverser(extension);
                }
            }
        }

        public boolean supprimer(String extension) throws UnableToDeleteFileException {
            boolean b = false;
            if (this.repertoire) {
                for (int i = 0; i < fils.size(); i++) {
                    if (fils.get(i).repertoire) {
                        b = fils.get(i).supprimer(extension) || b;
                    }
                    if (!fils.get(i).repertoire && fils.get(i).nom.endsWith(extension)) {
                        fils.remove(i);
                        b = true;
                    }
                }
            }
            return b;
        }
    }

    public void afficher() {
        racine.afficher(0);
    }

    public void map(Stringtransformation t) {
        racine.map(t);
    }

    public void traverser(String extension) {
        racine.traverser(extension);
    }

    public void supprimer(String extension) throws UnableToDeleteFileException {
        if (!racine.supprimer(extension)) {
            throw new UnableToDeleteFileException();
        }
    }
}
