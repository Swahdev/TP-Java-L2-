public class BandeDessinee extends Media {
    private String dessinateur;
    private int nbPages;


    public BandeDessinee(String dessinateur, int nbPages, String titre) {
        super(titre);
        this.dessinateur = dessinateur;
        this.nbPages = nbPages;
    }

    public String getDessinateur() {
        return this.dessinateur;
    }


    public int getNbPages() {
        return nbPages;
    }

    public String toString() {
        return "La bande dessinée portant le numéros " + this.getId() + " ayant pour titre " + this.getTitre() + " du dessinateur " + this.getDessinateur() + " avec " + getNbPages() + " nombres de pages";
    }

}
