public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 8, 2, 4);
        Carre c = new Carre(5, 2, 3);
        Ellipse e = new Ellipse(6, 3, 9, 1);
        Circle ci = new Circle(7, 6, 5);
        Triangle t = new Triangle(9, 8, 3, 4);

        r.affiche();
        c.affiche();
        e.affiche();
        ci.affiche();
        t.affiche();

        System.out.println();
        System.out.println("deformation du rectangle");
        Rectangle re = r.deformation(1.5, 2);
        re.affiche();

        System.out.println();
        System.out.println("deplacement du triangle");
        t.déplacement(5, -2);
        t.affiche();

        System.out.println();
        System.out.println("distance entre le cercle et l'ellipse");
        System.out.println(ci.estDistantDe(e));

        System.out.println();
        System.out.println("calcul de la surface du carre");
        System.out.println(c.surface());

        System.out.println();
        int[] tab = {3, 6, 1, 2};
        TabEntiersTriable t2 = new TabEntiersTriable(tab);
        Triable.triBulles(t2);
        System.out.println(t2);

        System.out.println();
        String[] m = {"Alexis", "Isabelle", "Nata", "Julien","Amelie"};
        Dictionnaire d = new Dictionnaire(m);
        Triable.triBulles(d);
        System.out.println(d);

        System.out.println();
        String[] binaire = {"1111", "0000", "1010", "0101"};
        TriBinaire b = new TriBinaire(binaire);
        Triable.triBulles(b);
        System.out.println(b);
    }
}
