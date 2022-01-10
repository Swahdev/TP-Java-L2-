public class Livre extends Media {
    private final String auteur;
    private final int nb_pages;

    public Livre(String auteur, int nb_pages, String titre) {
        super(titre);
        this.auteur = auteur;
        this.nb_pages = nb_pages;
    }

    public int getNb_pages() {
        return nb_pages;
    }

    public String getAuteur() {
        return auteur;
    }

    public String toString() {
        return "C'est un livre portant le numéro " + this.getId() + " ayant pour titre " + this.getTitre() + " de " + this.getAuteur() + " " + "avec " + this.getNb_pages() + " nombres de pages.";

    }

}
