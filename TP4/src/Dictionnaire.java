public class Dictionnaire extends Media {
    private final String langue;
    private final int nbTomes;

    public Dictionnaire(String langue, int nbTomes, String titre) {
        super(titre);
        this.nbTomes = nbTomes;
        this.langue = langue;
    }


    public String getLangue() {
        return langue;
    }

    public int getNbTomes() {
        return nbTomes;
    }

    public String toString() {
        return "C'est un dictionaire portant le numéro " + this.getId() + " ayant pour titre " + this.getTitre() + " de langue " + this.getLangue() + " " + "avec " + this.getNbTomes() + " nombres de tomes.";

    }

}
