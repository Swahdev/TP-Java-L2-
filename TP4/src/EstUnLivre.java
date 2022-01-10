public class EstUnLivre extends Predicat {

    @Override
    boolean estVrai(Media m){
        return m.ordreMedia() == 1;

    }
}