public class SousChaineParticuliaire extends Predicat {

    private final String sousChaine;

    public SousChaineParticuliaire(String sousChaine) {
        this.sousChaine = sousChaine;
    }

    public boolean isSubstring(String s2) {
        int M = sousChaine.length();
        int N = s2.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (s2.charAt(i + j) != sousChaine.charAt(j)) {
                    break;
                }
            }

            if (j == M) {
                return true;
            }
        }

        return false;
    }

    public boolean estVrai(Media m) {
        return this.isSubstring(m.getTitre());
    }
}