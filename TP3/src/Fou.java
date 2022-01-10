public class Fou extends Piece{

    public Fou(boolean color) {
        super(color, "Fou");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        if(d.typeDeplacement()!='d')
            return false;
        return super.estValide(d, p);
    }
}
