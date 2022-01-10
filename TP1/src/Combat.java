public class Combat {
    public static void main(String[] args) {
        Informations p1 = new Informations(25, 30, 11);
        Informations p2 = new Informations(15, 10, 20);
        Personnage chevalier = new Personnage("Chevalier", p1, p1);
        Personnage gobelin = new Personnage("Gobelin", p2, p2);
        //chevalier.lutteIterative(gobelin);
        gobelin.lutteRecursive(chevalier);
    }
}
