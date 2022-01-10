public class Media {
    private String titre;
    private static int num_courant = 0;
    private int id;

    public Media(String titre) {
        this.titre = titre;
        this.id = num_courant;
        num_courant++;
    }

    public String getTitre() {
        return titre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Media{" +
                "titre='" + titre + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean plusPetit(Media doc) {
        if (doc.ordreMedia()==this.ordreMedia()) {
            return this.getId() < doc.getId();
        }else return doc.ordreMedia() > this.ordreMedia();
    }

    public int ordreMedia(){
        if(this instanceof Livre) {
            return 1;
        }else if(this instanceof BandeDessinee){
            return 2;
        }else if(this instanceof Dictionnaire){
            return 3;
        }else
            return 4;

    }


}
