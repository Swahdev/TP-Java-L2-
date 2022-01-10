public class Pion extends Piece {
    public Pion(boolean color) {
        super(color, "Pion");
    }

    @Override
    public boolean estValide(Deplacement d, Plateau p) {

        if(!((d.typeDeplacement()=='v' || d.typeDeplacement() == 'd') && (d.dist()==1 || d.dist()==2)))
            return false;
        return super.estValide(d, p);
    }
}
