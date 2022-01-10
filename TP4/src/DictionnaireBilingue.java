public class DictionnaireBilingue extends Media {
    private String langue;
    private String langue2;
    private int nbTomes;

    public DictionnaireBilingue(String langue, String langue2, int nbTomes, String titre) {
        super(titre);
        this.langue = langue;
        this.langue2 = langue2;
        this.nbTomes = nbTomes;
    }


    public String getLangue() {
        return this.langue;
    }

    public String getLangue2() {
        return this.langue2;
    }

    public int getNbTomes() {
        return this.nbTomes;
    }


    public String toString() {
        return "C'est un dictionaire portant le numéro " + this.getId() + " ayant pour titre " + this.getTitre() + " de langues " + this.getLangue() + " " + this.getLangue2() + " avec " + this.getNbTomes() + " nombres de tomes.";

    }
}
