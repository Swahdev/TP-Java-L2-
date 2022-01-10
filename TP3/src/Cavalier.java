public class Cavalier extends Piece{

    public Cavalier(boolean color) {
        super(color, "Cavalier");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {
        if(d.typeDeplacement()!='c')
            return false;
        return super.estValide(d, p);
    }
}
