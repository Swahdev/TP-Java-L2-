import java.util.Random;

public class Personnage {
    String nom;
    Informations etatInitial;
    Informations etatActuel;

    public Personnage(String nom, Informations etatActuel, Informations etatInitial) {
        this.nom = nom;
        this.etatActuel = etatActuel;
        this.etatInitial = etatInitial;
    }

    @Override
    public String toString() {
        return "Personnage{" + "nom='" + nom + '\'' + ", etatInitial=" + etatInitial + ", etatActuel=" + etatActuel
                + '}';
    }

    public boolean estVivant() {
        return this.etatActuel.getVitalite() > 0;
    }

    public void rebirth() {
        this.etatActuel = etatInitial;
    }

    public String getNom() {
        return nom;
    }

    public void attaque(Personnage def) {
        Random rd = new Random();
        int i = Math.abs(this.etatActuel.getForce() - def.etatActuel.getForce());
        int n = rd.nextInt(i) + 1;
        int vie;
        int agil = def.etatActuel.getAgilite();
        int pourcen = 0;
        if (etatActuel.getAgilite() > def.etatActuel.getAgilite()) {
            if (def.etatActuel.getVitalite() - n < 0) {
                def.etatActuel.setVitalite(0);
                vie = 0;
            } else {
                vie = def.etatActuel.getVitalite() - n;
                def.etatActuel.setVitalite(vie);
            }
            System.out.println(" a  perdu " + (n) + " de points de vie ");

        } else {
            pourcen = ((def.etatActuel.getAgilite()) / 3);
            if (def.etatActuel.getVitalite() - (n / 2) < 0) {
                def.etatActuel.setVitalite(0);
                vie = 0;
            } else {
                vie = def.etatActuel.getVitalite() - (n / 2);
                def.etatActuel.setVitalite(vie);

            }
            if (def.etatActuel.getAgilite() - pourcen < 0) {
                def.etatActuel.setAgilite(0);
                agil = 0;
            } else {
                agil = def.etatActuel.getAgilite() - pourcen;
                def.etatActuel.setAgilite(agil);
            }
            System.out.print(" a  perdu " + (n / 2) + " de points de vie ");
            System.out.println("et a perdu " + pourcen + " points d'agilité");
        }
        System.out.println(" et a " + vie + " points de vie et a " + agil + " point d'agilité");

    }

    public void lutteRecursive(Personnage def) {
        if (this.etatActuel.getVitalite() <= 0)
            System.out.println(def.getNom() + " a gagné !");
        else if (def.etatActuel.getVitalite() <= 0)
            System.out.println(this.getNom() + " a gagné !");
        else {
            System.out.print(def.getNom());
            this.attaque(def);
            if (def.etatActuel.getVitalite() <= 0) {
                this.lutteRecursive(def);

            } else {
                System.out.print(this.getNom());
                def.attaque(this);
                this.lutteRecursive(def);
            }

        }

    }

    public void lutteIterative(Personnage def) {
        while (this.etatActuel.getVitalite() >= 0 && def.etatActuel.getVitalite() >= 0) {
            System.out.print(def.getNom());
            this.attaque(def);
            if (def.etatActuel.getVitalite() <= 0) {
                break;
            } else {
                System.out.print(this.getNom());
                def.attaque(this);
            }
        }
        if (this.etatActuel.getVitalite() <= 0)
            System.out.println(def.getNom() + " a gagné !");
        else
            System.out.println(this.getNom() + " a gagné !");
    }
}