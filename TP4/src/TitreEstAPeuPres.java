public class TitreEstAPeuPres extends Predicat {
    private final String titre;
    private final int distance;

    public TitreEstAPeuPres(String titre, int distance) {
        this.titre = titre;
        this.distance = distance;
    }

    public boolean isSubs(String a, String b) {
        int j = 0;
        for (int i = 0; i < a.length() && j < b.length(); i++) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
        }
        return (j == b.length());
    }

    public boolean estVrai(Media m) {
        String t1 = m.getTitre();
        if (Math.abs(t1.length() - titre.length()) <= distance) {
            return (this.isSubs(t1, titre) || this.isSubs(titre, t1));
        }
        return false;
    }
}
